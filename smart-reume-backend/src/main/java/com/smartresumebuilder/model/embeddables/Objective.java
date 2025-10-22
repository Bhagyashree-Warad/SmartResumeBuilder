package com.smartresumebuilder.model.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Objective {
    @Column(length = 1000)
    private String careerObjective;
}
