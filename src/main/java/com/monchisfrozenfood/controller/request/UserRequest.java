package com.monchisfrozenfood.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long userId;
    private String userName;
    private String userLastName;
    private String userDocument;
    private String userEmail;
    private String password;
    private Long fkDocumentTypeId;
}
