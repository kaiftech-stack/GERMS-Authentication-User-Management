package com.germs.germs_auth.config;

import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class FileStorageConfig {

    public static final Path UPLOAD_DIR =
            Paths.get("uploads/employee-documents");
}

