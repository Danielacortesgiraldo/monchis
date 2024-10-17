package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    @Query(value = "SELECT * FROM document_types", nativeQuery = true)
    List<DocumentType> listDocumentType();

    @Query(value = "SELECT * FROM document_types WHERE document_type_id = :documentTypeId", nativeQuery = true)
    DocumentType searchDocumentType(@Param("documentTypeId") Long documentTypeId);
}
