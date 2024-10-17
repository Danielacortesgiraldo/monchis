package com.monchisfrozenfood.services;

import com.monchisfrozenfood.controller.request.DocumentTypeRequest;
import com.monchisfrozenfood.controller.request.UserRequest;
import com.monchisfrozenfood.controller.response.DocumentTypeResponse;
import com.monchisfrozenfood.entitys.DocumentType;
import com.monchisfrozenfood.entitys.User;
import com.monchisfrozenfood.entitys.repository.DocumentTypeRepository;
import com.monchisfrozenfood.services.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final DocumentTypeRepository documentTypeRepository;

    @Override
    public List<DocumentType> getDocumentTypesList() {
        return documentTypeRepository.listDocumentType();
    }

    @Override
    public void deleteDocumentTypeById(Long documentTypeId) {
        documentTypeRepository.deleteById(documentTypeId);
    }

    @Override
    public DocumentTypeResponse searchDocumentType(Long documentTypeId) {
        DocumentType documentType = documentTypeRepository.searchDocumentType(documentTypeId);

        return Objects.nonNull(documentType)
                ? buildDocumentTypeResponse(documentType)
                : DocumentTypeResponse.builder()
                .build();
    }

    @Override
    public void saveDocumentType(DocumentTypeRequest documentTypeRequest) {
        if(Objects.nonNull(documentTypeRequest)) {
            DocumentType documentType = buildDocumentTypeEntity(documentTypeRequest);
            documentTypeRepository.save(documentType);
        }
    }

    @Override
    public void updateDocumentType(DocumentTypeRequest documentTypeRequest) {
        if(Objects.nonNull(documentTypeRequest)) {
            Optional<DocumentType> documentType = documentTypeRepository.findById(documentTypeRequest.getDocumentTypeId());

            if (documentType.isPresent()) {
                DocumentType updatedDocumentType = buildDocumentTypeEntity(documentTypeRequest);
                documentTypeRepository.save(updatedDocumentType);
            }
        }
    }

    private static DocumentTypeResponse buildDocumentTypeResponse(DocumentType documentType) {
        return DocumentTypeResponse.builder()
                .documentTypeId(documentType.getDocumentTypeId())
                .documentTypeAcronym(documentType.getDocumentTypeAcronym())
                .documentTypeDescription(documentType.getDocumentTypeDescription())
                .build();
    }

    private static DocumentType buildDocumentTypeEntity(DocumentTypeRequest documentTypeRequest) {
        return DocumentType.builder()
                .documentTypeId(documentTypeRequest.getDocumentTypeId())
                .documentTypeAcronym(documentTypeRequest.getDocumentTypeAcronym())
                .documentTypeDescription(documentTypeRequest.getDocumentTypeDescription())
                .build();
    }
}
