package com.monchisfrozenfood.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "document_types")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id")
    private Long documentTypeId;

    @Column(name = "document_type_acronym", nullable = false)
    private String documentTypeAcronym;

    @Column(name = "document_type_description", nullable = false)
    private String documentTypeDescription;

    public DocumentType() {
    }

    public DocumentType(Long documentTypeId, String documentTypeAcronym, String documentTypeDescription) {
        this.documentTypeId = documentTypeId;
        this.documentTypeAcronym = documentTypeAcronym;
        this.documentTypeDescription = documentTypeDescription;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public String getDocumentTypeAcronym() {
        return documentTypeAcronym;
    }

    public String getDocumentTypeDescription() {
        return documentTypeDescription;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public void setDocumentTypeAcronym(String documentTypeAcronym) {
        this.documentTypeAcronym = documentTypeAcronym;
    }

    public void setDocumentTypeDescription(String documentTypeDescription) {
        this.documentTypeDescription = documentTypeDescription;
    }
}
