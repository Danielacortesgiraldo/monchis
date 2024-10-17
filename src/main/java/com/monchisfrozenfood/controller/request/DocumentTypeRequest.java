package com.monchisfrozenfood.controller.request;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeRequest {
    private Long documentTypeId;
    private String documentTypeAcronym;
    private String documentTypeDescription;
}
