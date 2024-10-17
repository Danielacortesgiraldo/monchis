package com.monchisfrozenfood.controller.response;

import jakarta.persistence.Column;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeResponse {
    private Long documentTypeId;
    private String documentTypeAcronym;
    private String documentTypeDescription;
}
