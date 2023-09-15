package com.ld.faststorage.controller;

import com.ld.faststorage.dto.DocumentDto;
import com.ld.faststorage.service.DocumentService;
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
    public List<DocumentDto> readAllDocuments(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "sortBy", defaultValue = "documentName") String sortBy) {
        return documentService.readAllDocuments(page, pageSize, sortBy);
    }

    @GetMapping("/document/search")
    public List<DocumentDto> readAllDocumentsByTags(@RequestParam List<String> tagList,
                                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = "documentName") String sortBy) {
        return documentService.readAllDocumentsByTags(tagList, page, pageSize, sortBy);
    }

    @PutMapping(value = "/item/{documentId}/update")
    public DocumentDto updateDocumentById(@PathVariable("documentId") String documentId, @RequestBody DocumentDto documentDto) {
        return documentService.updateDocumentById(documentId, documentDto);
    }

    @DeleteMapping("/item/delete")
    public String deleteDocumentById(@RequestParam(value = "documentId") String documentId) {
        return documentService.deleteDocumentById(documentId);
    }

}
