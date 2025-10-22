package com.smartresumebuilder.repository;

import com.smartresumebuilder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);  // Find user by email for login

    boolean existsByEmail(String email);       // Check if email is already registered
}
