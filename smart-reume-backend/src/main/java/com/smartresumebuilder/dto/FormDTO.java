package com.smartresumebuilder.dto;

import com.smartresumebuilder.dto.section.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormDTO {

    // Basic info
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String linkedinUrl;
    private String githubUrl;

    // Resume sections
    private List<ObjectiveDTO> objectives;
    private List<EducationDTO> educationList;
    private List<ExperienceDTO> experiences;
    private List<ProjectDTO> projects;
    private List<SkillDTO> skills;
    private List<CertificationDTO> certifications;
    private List<DeclarationDTO> declarations;
}
