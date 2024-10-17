package com.monchisfrozenfood.controller;


import com.monchisfrozenfood.controller.request.DocumentTypeRequest;
import com.monchisfrozenfood.controller.response.DocumentTypeResponse;
import com.monchisfrozenfood.controller.response.UserResponse;
import com.monchisfrozenfood.entitys.DocumentType;
import com.monchisfrozenfood.services.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("documentType/v1")
@RequiredArgsConstructor
public class DocumentTypeRestController {
    private final DocumentTypeService documentTypeService;
    String message = "Operation completed successfully.";

    @GetMapping("/list")
    public ResponseEntity<List<DocumentType>> listDocumentTypeIdApi() {
        List<DocumentType> documentTypesList = documentTypeService.getDocumentTypesList();
        return new ResponseEntity<>(documentTypesList, HttpStatus.ACCEPTED);
    }

    @GetMapping("search/{documentTypeId}")
    public ResponseEntity<DocumentTypeResponse> searchDocumentTypeIdApi(@PathVariable Long documentTypeId) {
        DocumentTypeResponse documentTypeResponse = documentTypeService.searchDocumentType(documentTypeId);
        return ResponseEntity.accepted().body(documentTypeResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDocumentTypeIdApi(@RequestBody DocumentTypeRequest documentTypeRequest) {
        documentTypeService.saveDocumentType(documentTypeRequest);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDocumentTypeIdApi(@RequestBody DocumentTypeRequest documentTypeRequest) {
        documentTypeService.updateDocumentType(documentTypeRequest);
        return ResponseEntity.accepted().body(message);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDocumentTypeById(@RequestParam(name = "documentTypeId") Long documentTypeId) {
        documentTypeService.deleteDocumentTypeById(documentTypeId);
        return ResponseEntity.accepted().body(message);
    }
}
