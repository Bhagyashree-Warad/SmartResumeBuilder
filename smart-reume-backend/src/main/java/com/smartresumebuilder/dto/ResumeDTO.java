package com.smartresumebuilder.dto;

import com.smartresumebuilder.model.embeddables.EducationDetail;
import com.smartresumebuilder.model.embeddables.ExperienceDetail;
import com.smartresumebuilder.model.embeddables.ProjectDetail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    private String email;

    private String phone;
    private String linkedinUrl;
    private String githubUrl;
    private String objective;

    private List<EducationDetail> educationList;
    private List<ExperienceDetail> experienceList;
    private List<ProjectDetail> projectList;

    private List<String> skills;
    private List<String> certifications;
    private List<String> achievements;

    private String declaration;
}
