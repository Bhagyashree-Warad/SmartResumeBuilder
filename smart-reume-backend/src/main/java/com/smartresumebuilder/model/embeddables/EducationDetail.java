package com.smartresumebuilder.model.embeddables;

import com.smartresumebuilder.model.enums.EducationType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationDetail {

    private String institutionName;
    private String boardOrUniversity;
    private String yearOfPassing;
    private double percentageOrCGPA;

    @Enumerated(EnumType.STRING)
    private EducationType educationType;
}
