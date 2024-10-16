package com.monchisfrozenfood.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String userName;
    private String userLastName;
    private DocumentTypeResponse documentTypeResponse;
    private String userDocument;
    private String userEmail;
}
