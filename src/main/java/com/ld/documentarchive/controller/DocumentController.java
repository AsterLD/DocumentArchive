package com.ld.documentarchive.controller;

import com.ld.documentarchive.dto.DocumentDto;
import com.ld.documentarchive.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;


    @PostMapping(value = "/document")
    public DocumentDto createDocument(@RequestBody DocumentDto documentDto) {
        return documentService.createDocument(documentDto);
    }

}
