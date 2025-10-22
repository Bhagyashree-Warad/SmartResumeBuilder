package com.smartresumebuilder.repository;

import com.smartresumebuilder.model.Form;
import com.smartresumebuilder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    boolean existsByUser(User user);           // Check if form already exists for a user
    List<Form> findByUser(User user);         // Get form data for a specific user
}
