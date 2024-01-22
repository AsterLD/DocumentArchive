package com.ld.faststorage.controller;

import com.ld.faststorage.dto.ReturnableDocumentDTO;
import com.ld.faststorage.dto.SavableDocumentDTO;
import com.ld.faststorage.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping(value = "/document")
    public ReturnableDocumentDTO createDocument(@RequestBody SavableDocumentDTO savableDocumentDTO) {
        return documentService.createDocument(savableDocumentDTO);
    }

    @GetMapping("/document/{documentId}")
    public ReturnableDocumentDTO readDocumentById(@PathVariable("documentId") String documentId) {
        return documentService.readDocumentById(documentId);
    }

    @GetMapping("/document/all")
    public List<ReturnableDocumentDTO> readAllDocuments(
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return documentService.readAllDocuments(page, pageSize);
    }

    @GetMapping("/document/search")
    public List<ReturnableDocumentDTO> readAllDocumentsByTags(
                                            @RequestParam List<String> tagList,
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return documentService.readAllDocumentsByTags(tagList, page, pageSize);
    }

    @PutMapping(value = "/item/{documentId}/update")
    public ReturnableDocumentDTO updateDocumentById(@PathVariable("documentId") String documentId,
                                                    @RequestBody SavableDocumentDTO savableDocumentDTO) {
        return documentService.updateDocumentById(documentId, savableDocumentDTO);
    }

    @DeleteMapping("/item/delete")
    public String deleteDocumentById(@RequestParam(value = "documentId") String documentId) {
        return documentService.deleteDocumentById(documentId);
    }

}
