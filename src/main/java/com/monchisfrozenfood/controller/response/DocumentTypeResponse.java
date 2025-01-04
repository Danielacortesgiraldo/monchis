package com.monchisfrozenfood.controller.response;

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
