package com.smartresumebuilder.controller;

import com.smartresumebuilder.model.Resume;
import com.smartresumebuilder.service.PdfService;
import com.smartresumebuilder.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;
    private final PdfService pdfService;

    @PostMapping("/generate/{userId}")
    public ResponseEntity<String> generateResume(@PathVariable Long userId) {
        resumeService.generateResume(userId);
        return ResponseEntity.ok("Resume generated successfully");
    }

    @GetMapping("/download/{userId}")
    public ResponseEntity<InputStreamResource> downloadResume(@PathVariable Long userId) {
        Resume resume = resumeService.getResumeByUserId(userId);
        ByteArrayInputStream bis = pdfService.generateResumePdf(resume);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=resume.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
