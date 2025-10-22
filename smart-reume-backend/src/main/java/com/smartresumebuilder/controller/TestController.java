package com.smartresumebuilder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // ---------------- Simple Health Check ----------------
    @GetMapping
    public String healthCheck() {
        return "🚀 SmartResumeBuilder Backend is running!";
    }

    // ---------------- Browser-friendly hello ----------------
    @GetMapping("/hello")
    public String hello() {
        return "Hello! SmartResumeBuilder is active!";
    }

    // ---------------- Sample JSON response ----------------
    @GetMapping("/json")
    public TestResponse jsonTest() {
        return new TestResponse("success", 200, "JSON response working!");
    }

    // ---------------- Nested static class for JSON response ----------------
    public static class TestResponse {
        private String status;
        private int code;
        private String message;

        public TestResponse(String status, int code, String message) {
            this.status = status;
            this.code = code;
            this.message = message;
        }

        // Getters and setters
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public int getCode() { return code; }
        public void setCode(int code) { this.code = code; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}
