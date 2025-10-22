package com.smartresumebuilder.service;

import com.smartresumebuilder.dto.DashboardDTO;
import com.smartresumebuilder.repository.FormRepository;
import com.smartresumebuilder.repository.ResumeRepository;
import com.smartresumebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final UserRepository userRepository;
    private final FormRepository formRepository;
    private final ResumeRepository resumeRepository;

    public DashboardDTO getDashboardStats() {
        long totalUsers = userRepository.count();
        long totalFormsSubmitted = formRepository.count();
        long totalResumes = resumeRepository.count();

        // Aggregate counts across all forms
        long totalProjects = formRepository.findAll().stream()
                .mapToLong(f -> f.getProjectDetails() != null ? f.getProjectDetails().size() : 0)
                .sum();

        long totalExperiences = formRepository.findAll().stream()
                .mapToLong(f -> f.getExperienceDetails() != null ? f.getExperienceDetails().size() : 0)
                .sum();

        long totalSkills = formRepository.findAll().stream()
                .mapToLong(f -> f.getSkillDetails() != null ? f.getSkillDetails().size() : 0)
                .sum();

        long totalCertifications = formRepository.findAll().stream()
                .mapToLong(f -> f.getCertificationDetails() != null ? f.getCertificationDetails().size() : 0)
                .sum();

        return DashboardDTO.builder()
        		    .totalUsers(totalUsers)
                .totalResumes(totalResumes)
                .totalFormsSubmitted(totalFormsSubmitted)
                .totalProjects(totalProjects)
                .totalExperiences(totalExperiences)
                .totalSkills(totalSkills)
                .totalCertifications(totalCertifications)
                .build();
    }
}
