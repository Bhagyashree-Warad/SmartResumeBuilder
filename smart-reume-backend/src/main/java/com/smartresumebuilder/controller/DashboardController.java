package com.smartresumebuilder.controller;

import com.smartresumebuilder.dto.DashboardDTO;
import com.smartresumebuilder.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/stats")
    public ResponseEntity<DashboardDTO> getDashboardStats() {
        DashboardDTO stats = dashboardService.getDashboardStats();
        return ResponseEntity.ok(stats);
    }
}
