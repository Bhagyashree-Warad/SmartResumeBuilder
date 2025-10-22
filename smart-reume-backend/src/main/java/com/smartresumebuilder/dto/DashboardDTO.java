package com.smartresumebuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for dashboard statistics or summaries
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardDTO {
	private Long totalUsers;
    private Long totalResumes;           // Total resumes created by the user
    private Long totalFormsSubmitted;    // Total forms submitted
    private Long totalProjects;          // Total projects across all forms
    private Long totalExperiences;       // Total experiences across all forms
    private Long totalSkills;            // Total skills listed
    private Long totalCertifications;    // Total certifications listed
}
