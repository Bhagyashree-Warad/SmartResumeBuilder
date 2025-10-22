package com.smartresumebuilder.dto.section;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationDTO {
    private String certificationName;
    private String issuedBy;
    private String issueDate;
    private String certificateLink;
}
