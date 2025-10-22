package com.smartresumebuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartResumeBuilderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartResumeBuilderApplication.class, args);
        System.out.println("✅ Smart Resume Builder Backend is running...");
    }
}
