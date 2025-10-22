package com.smartresumebuilder.model.embeddables;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeclarationDetail {
    private String declarationText;
    private String place;
    private String date;
    private String signatureName; // Usually user full name
}
