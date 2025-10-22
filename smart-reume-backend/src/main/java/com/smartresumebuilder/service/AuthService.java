package com.smartresumebuilder.service;

import com.smartresumebuilder.config.JwtUtil;
import com.smartresumebuilder.dto.AuthRequest;
import com.smartresumebuilder.dto.AuthResponse;
import com.smartresumebuilder.dto.RegisterRequest;
import com.smartresumebuilder.model.User;
import com.smartresumebuilder.model.enums.UserType;
import com.smartresumebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final Set<String> invalidatedTokens = new HashSet<>();

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new AuthResponse(null, "Email is already registered");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserType(UserType.STUDENT);
        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, "Registration successful");
    }

    public AuthResponse login(AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            String token = jwtUtil.generateToken(user.getEmail());
            return new AuthResponse(token, "Login successful");
        } catch (Exception e) {
            return new AuthResponse(null, "Invalid credentials");
        }
    }

    public AuthResponse logout(String token) {
        if (token != null && !token.isEmpty()) {
            invalidatedTokens.add(token);
            return new AuthResponse(null, "Logout successful");
        }
        return new AuthResponse(null, "No token provided for logout");
    }

    public boolean isTokenInvalidated(String token) {
        return invalidatedTokens.contains(token);
    }
}
