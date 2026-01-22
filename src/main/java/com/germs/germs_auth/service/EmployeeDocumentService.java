package com.germs.germs_auth.service;

import com.germs.germs_auth.config.FileStorageConfig;
import com.germs.germs_auth.entity.Employee;
import com.germs.germs_auth.entity.EmployeeDocument;
import com.germs.germs_auth.repository.EmployeeDocumentRepository;
import com.germs.germs_auth.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class EmployeeDocumentService {

    private final EmployeeDocumentRepository documentRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeDocumentService(EmployeeDocumentRepository documentRepository,
                                   EmployeeRepository employeeRepository) {
        this.documentRepository = documentRepository;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDocument uploadDocument(Long employeeId,
                                           String documentType,
                                           MultipartFile file) throws IOException {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Files.createDirectories(FileStorageConfig.UPLOAD_DIR);

        String fileName = employeeId + "_" + documentType + "_" + file.getOriginalFilename();
        Path filePath = FileStorageConfig.UPLOAD_DIR.resolve(fileName);

        Files.write(filePath, file.getBytes());

        EmployeeDocument document = new EmployeeDocument();
        document.setEmployee(employee);
        document.setDocumentType(documentType);
        document.setFileName(fileName);
        document.setFilePath(filePath.toString());

        return documentRepository.save(document);
    }
}

