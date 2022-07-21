package com.trainee.traineeproject.controller;

import com.trainee.traineeproject.utils.ThreadHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVImportController {

    private final ThreadHandler threadHandler;

    public CSVImportController(ThreadHandler threadHandler) {
        this.threadHandler = threadHandler;
    }

    @GetMapping("/startImport")
    public ResponseEntity<String> startImport() {
        threadHandler.run();
        return ResponseEntity.ok("Import finished");
    }
}
