package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.EmployeeDocument;
import com.germs.germs_auth.service.EmployeeDocumentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/employees/documents")
public class EmployeeDocumentController {

    private final EmployeeDocumentService documentService;

    public EmployeeDocumentController(EmployeeDocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public EmployeeDocument uploadDocument(
            @RequestParam Long employeeId,
            @RequestParam String documentType,
            @RequestParam MultipartFile file
    ) throws Exception {

        return documentService.uploadDocument(employeeId, documentType, file);
    }
}
