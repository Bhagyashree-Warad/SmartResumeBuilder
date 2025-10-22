package com.smartresumebuilder.controller;

import com.smartresumebuilder.model.Form;
import com.smartresumebuilder.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form")
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(@RequestBody Form form) {
        formService.saveForm(form);
        return ResponseEntity.ok("Form submitted successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Form> getFormByUserId(@PathVariable Long userId) {
        Form form = formService.getFormByUserId(userId);
        return ResponseEntity.ok(form);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Form>> getAllForms() {
        return ResponseEntity.ok(formService.getAllForms());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateForm(@RequestBody Form form) {
        formService.updateForm(form);
        return ResponseEntity.ok("Form updated successfully");
    }
}
