package com.smartresumebuilder.dto.section;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO {
    private String projectTitle;
    private String description;
    private String technologiesUsed;
    private String projectLink;
}
