package com.smartresumebuilder.dto.section;

import com.smartresumebuilder.model.enums.EducationType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationDTO {
    private String institutionName;
    private String boardOrUniversity;
    private String yearOfPassing;
    private double percentageOrCGPA;
    private EducationType educationType;
}
