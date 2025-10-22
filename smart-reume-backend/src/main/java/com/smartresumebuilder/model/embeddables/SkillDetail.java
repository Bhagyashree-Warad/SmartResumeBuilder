package com.smartresumebuilder.model.embeddables;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillDetail {
    private String skillName;
    private String proficiency; // Beginner, Intermediate, Expert, etc.
}
