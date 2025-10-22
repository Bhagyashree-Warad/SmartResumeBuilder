package com.smartresumebuilder.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.smartresumebuilder.model.Resume;
import com.smartresumebuilder.model.Form;
import com.smartresumebuilder.model.embeddables.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
public class PdfService {

    public ByteArrayInputStream generateResumePdf(Resume resume) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Fonts
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            Form form = resume.getForm();

            // ===== Header =====
            if (resume.getUser() != null) {
                Paragraph header = new Paragraph(
                        resume.getUser().getFirstName() + " " + resume.getUser().getLastName(),
                        titleFont
                );
                header.setAlignment(Element.ALIGN_CENTER);
                document.add(header);

                if (resume.getUser().getEmail() != null)
                    document.add(new Paragraph("Email: " + resume.getUser().getEmail(), normalFont));

                document.add(Chunk.NEWLINE);
            }

            if (form != null) {

                // ===== LinkedIn & GitHub =====
                if (form.getLinkedinUrl() != null)
                    document.add(new Paragraph("LinkedIn: " + form.getLinkedinUrl(), normalFont));
                if (form.getGithubUrl() != null)
                    document.add(new Paragraph("GitHub: " + form.getGithubUrl(), normalFont));
                document.add(Chunk.NEWLINE);

                // ===== Objective =====
                if (form.getObjective() != null) {
                    document.add(new Paragraph("Objective", subFont));
                    document.add(new Paragraph(form.getObjective(), normalFont));
                    document.add(Chunk.NEWLINE);
                }

                // ===== Education =====
                if (form.getEducationDetails() != null && !form.getEducationDetails().isEmpty()) {
                    document.add(new Paragraph("Education", subFont));
                    for (EducationDetail edu : form.getEducationDetails()) {
                        document.add(new Paragraph(
                                edu.getEducationType() + " - " + edu.getBoardOrUniversity() +
                                        " (" + edu.getYearOfPassing() + "), " + edu.getPercentageOrCGPA() + "%, Type: " + edu.getEducationType(),
                                normalFont
                        ));
                    }
                    document.add(Chunk.NEWLINE);
                }

                // ===== Experience =====
                if (form.getExperienceDetails() != null && !form.getExperienceDetails().isEmpty()) {
                    document.add(new Paragraph("Experience", subFont));
                    for (ExperienceDetail exp : form.getExperienceDetails()) {
                        document.add(new Paragraph(
                                exp.getCompanyName() + " - " + exp.getRole() + " (" + exp.getDuration() + ")",
                                normalFont
                        ));
                        document.add(new Paragraph(exp.getDescription(), normalFont));
                    }
                    document.add(Chunk.NEWLINE);
                }

                // ===== Projects =====
                if (form.getProjectDetails() != null && !form.getProjectDetails().isEmpty()) {
                    document.add(new Paragraph("Projects", subFont));
                    for (ProjectDetail p : form.getProjectDetails()) {
                        document.add(new Paragraph(
                                p.getProjectTitle() + " - " + p.getTechnologiesUsed() +
                                        (p.getProjectLink() != null ? " (" + p.getProjectLink() + ")" : ""),
                                normalFont
                        ));
                        document.add(new Paragraph(p.getDescription(), normalFont));
                    }
                    document.add(Chunk.NEWLINE);
                }

                // ===== Skills =====
                if (form.getSkillDetails() != null && !form.getSkillDetails().isEmpty()) {
                    document.add(new Paragraph("Skills", subFont));
                    String skills = form.getSkillDetails().stream()
                            .map(s -> s.getSkillName())
                            .collect(java.util.stream.Collectors.joining(", "));
                    document.add(new Paragraph(skills, normalFont));
                    document.add(Chunk.NEWLINE);
                }
                // ===== Certifications =====
                if (form.getCertificationDetails() != null && !form.getCertificationDetails().isEmpty()) {
                    document.add(new Paragraph("Certifications", subFont));
                    for (CertificationDetail c : form.getCertificationDetails()) {
                        document.add(new Paragraph(
                                c.getCertificationName() + " - " + c.getIssuedBy() +
                                        (c.getIssueDate() != null ? " (" + c.getIssueDate() + ")" : "") +
                                        (c.getCertificateLink() != null ? ", " + c.getCertificateLink() : ""),
                                normalFont
                        ));
                    }
                    document.add(Chunk.NEWLINE);
                }

                // ===== Declaration =====
                DeclarationDetail declaration = form.getDeclaration();
                if (declaration != null) {
                    document.add(new Paragraph("Declaration", subFont));
                    document.add(new Paragraph(declaration.getDeclarationText(), normalFont));
                    document.add(Chunk.NEWLINE);
                }
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
