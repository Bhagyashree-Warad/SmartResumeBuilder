package com.smartresumebuilder.model.embeddables;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationDetail {
    private String certificationName;
    private String issuedBy;
    private String issueDate;
    private String certificateLink;
}
