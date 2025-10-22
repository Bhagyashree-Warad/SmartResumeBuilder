package com.smartresumebuilder.service;

import com.smartresumebuilder.exception.ResourceNotFoundException;
import com.smartresumebuilder.model.Form;
import com.smartresumebuilder.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;

    public Form saveForm(Form form) {
        return formRepository.save(form);
    }

    public Form getFormByUserId(Long userId) {
        return formRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found for user id: " + userId));
    }

    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    public Form updateForm(Form form) {
        if (!formRepository.existsById(form.getId())) {
            throw new ResourceNotFoundException("Form not found with id: " + form.getId());
        }
        return formRepository.save(form);
    }
}
