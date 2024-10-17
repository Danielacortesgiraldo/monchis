package com.monchisfrozenfood.services.service;

import com.monchisfrozenfood.controller.request.DocumentTypeRequest;
import com.monchisfrozenfood.controller.response.DocumentTypeResponse;
import com.monchisfrozenfood.entitys.DocumentType;

import java.util.List;

public interface DocumentTypeService {
    List<DocumentType> getDocumentTypesList();
    void deleteDocumentTypeById(Long documentTypeId);
    DocumentTypeResponse searchDocumentType(Long documentTypeId);
    void saveDocumentType(DocumentTypeRequest documentTypeRequest);
    void updateDocumentType(DocumentTypeRequest documentTypeRequest);
}
