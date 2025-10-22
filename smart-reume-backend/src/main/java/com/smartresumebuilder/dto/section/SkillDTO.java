package com.smartresumebuilder.dto.section;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillDTO {
    private String skillName;
    private String proficiency;
}
