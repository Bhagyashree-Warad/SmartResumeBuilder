package com.smartresumebuilder.model;

import com.smartresumebuilder.model.embeddables.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String phone;
    private String linkedinUrl;
    private String githubUrl;
    private String objective;

    @ElementCollection
    private List<EducationDetail> educationDetails;

    @ElementCollection
    private List<ExperienceDetail> experienceDetails;

    @ElementCollection
    private List<ProjectDetail> projectDetails;

    @ElementCollection
    private List<SkillDetail> skillDetails;

    @ElementCollection
    private List<CertificationDetail> certificationDetails;

    @Embedded
    private DeclarationDetail declaration;
}
