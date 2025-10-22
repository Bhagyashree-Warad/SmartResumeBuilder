package com.smartresumebuilder.controller;

import com.smartresumebuilder.dto.AuthRequest;
import com.smartresumebuilder.dto.AuthResponse;
import com.smartresumebuilder.dto.RegisterRequest;
import com.smartresumebuilder.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Optional: Invalidate JWT token if you implement token blacklist
        return ResponseEntity.ok("Logout successful");
    }
}
