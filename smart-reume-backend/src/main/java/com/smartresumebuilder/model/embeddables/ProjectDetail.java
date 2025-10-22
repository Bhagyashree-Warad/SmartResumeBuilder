package com.smartresumebuilder.model.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetail {

    private String projectTitle;

    @Column(length = 1000)
    private String description;

    private String technologiesUsed;
    private String projectLink;
}
