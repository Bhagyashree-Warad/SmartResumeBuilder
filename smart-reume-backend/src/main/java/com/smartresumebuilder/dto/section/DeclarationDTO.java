package com.smartresumebuilder.dto.section;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeclarationDTO {
    private String declarationText;
    private String place;
    private String date;
    private String signatureName;
}
