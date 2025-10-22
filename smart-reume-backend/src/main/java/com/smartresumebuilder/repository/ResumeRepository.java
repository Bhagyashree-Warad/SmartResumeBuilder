package com.smartresumebuilder.repository;

import com.smartresumebuilder.model.Resume;
import com.smartresumebuilder.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Optional<Resume> findByUserId(Long userId);
    
    List<Resume> findByUser(User user);

}
