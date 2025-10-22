package com.smartresumebuilder.service;

import com.smartresumebuilder.exception.ResourceNotFoundException;
import com.smartresumebuilder.model.Resume;
import com.smartresumebuilder.model.Form;
import com.smartresumebuilder.model.User;
import com.smartresumebuilder.repository.ResumeRepository;
import com.smartresumebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final FormService formService;
    private final UserRepository userRepository;

    // Generate resume for a user
    public Resume generateResume(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        Form form = formService.getFormByUserId(userId);

        Resume resume = Resume.builder()
                .user(user)
                .form(form)
                .resumeTitle(user.getFirstName() + " " + user.getLastName() + " Resume")
                .build();

        return resumeRepository.save(resume);
    }

    // Fetch resume by user ID
    public Resume getResumeByUserId(Long userId) {
        return resumeRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Resume not found for user ID: " + userId));
    }
}
