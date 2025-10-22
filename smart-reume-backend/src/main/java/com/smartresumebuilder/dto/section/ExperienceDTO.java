package com.smartresumebuilder.dto.section;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceDTO {
    private String companyName;
    private String role;
    private String duration;
    private String description;
}
