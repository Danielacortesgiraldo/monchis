package com.monchisfrozenfood.entitys;

import jakarta.persistence.*;
import lombok.*;

/* persistence */
@Entity
@Table(name = "users")
/* lombok */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User { /* Objeto de Java */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_last_name", nullable = false)
    private String userLastName;

    @Column(name = "user_document", nullable = false)
    private String userDocument;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "fk_document_type_id", referencedColumnName = "document_type_id", nullable = false)
    private DocumentType fkDocumentTypeId;
}
