package com.smartresumebuilder.model.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceDetail {

    private String companyName;
    private String role;
    private String duration;

    @Column(length = 1000)
    private String description;
}
