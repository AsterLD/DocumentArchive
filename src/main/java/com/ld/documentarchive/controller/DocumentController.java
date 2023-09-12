package com.ld.documentarchive.controller;

import com.ld.documentarchive.dto.DocumentDto;
import com.ld.documentarchive.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;


    @PostMapping(value = "/document")
    public DocumentDto createDocument(@RequestBody DocumentDto documentDto) {
        return documentService.createDocument(documentDto);
    }

    @GetMapping("/document/{documentId}")
    public DocumentDto readDocumentById(@PathVariable("documentId") String documentId) {
        return documentService.readDocumentById(documentId);
    }

    @GetMapping("/document/all")
    public List<DocumentDto> readAllDocuments() {
        return documentService.readAllDocuments();
    }

    @PutMapping(value = "/item/{documentId}/update")
    public DocumentDto updateDocumentById(@PathVariable("documentId") String documentId, @RequestBody DocumentDto documentDto) {
        return documentService.updateDocumentById(documentId, documentDto);
    }

    @DeleteMapping("/item/{documentId}/delete")
    public String deleteDocumentById(@PathVariable("userId") String documentId) {
        return documentService.deleteDocumentById(documentId);
    }

}
