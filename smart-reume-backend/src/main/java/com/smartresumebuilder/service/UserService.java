package com.smartresumebuilder.service;

import com.smartresumebuilder.exception.ResourceNotFoundException;
import com.smartresumebuilder.model.User;
import com.smartresumebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Get a single user by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update a user
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = getUserById(userId);

        // Update fields
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setUserType(updatedUser.getUserType());

        return userRepository.save(existingUser);
    }

    // Delete a user
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }
}
