package com.ld.faststorage.controller;

import com.ld.faststorage.dto.DocumentDTO;
import com.ld.faststorage.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;


    @PostMapping(value = "/document")
    public DocumentDTO createDocument(@RequestBody DocumentDTO documentDTO) {
        return documentService.createDocument(documentDTO);
    }

    @GetMapping("/document/{documentId}")
    public DocumentDTO readDocumentById(@PathVariable("documentId") String documentId) {
        return documentService.readDocumentById(documentId);
    }

    @GetMapping("/document/all")
    public List<DocumentDTO> readAllDocuments(
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return documentService.readAllDocuments(page, pageSize);
    }

    @GetMapping("/document/search")
    public List<DocumentDTO> readAllDocumentsByTags(
                                            @RequestParam List<String> tagList,
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return documentService.readAllDocumentsByTags(tagList, page, pageSize);
    }

    @PutMapping(value = "/item/{documentId}/update")
    public DocumentDTO updateDocumentById(@PathVariable("documentId") String documentId,
                                          @RequestBody DocumentDTO documentDTO) {
        return documentService.updateDocumentById(documentId, documentDTO);
    }

    @DeleteMapping("/item/delete")
    public String deleteDocumentById(@RequestParam(value = "documentId") String documentId) {
        return documentService.deleteDocumentById(documentId);
    }

}
