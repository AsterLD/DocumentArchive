package com.ld.faststorage.service;

import com.ld.faststorage.dto.DocumentDto;

import java.util.List;

public interface DocumentService {

    DocumentDto createDocument(DocumentDto documentDto);

    List<DocumentDto> readAllDocuments();

    List<DocumentDto> readAllDocumentsByTags(List<String> tagList);

    DocumentDto readDocumentById(String documentId);

    DocumentDto updateDocumentById(String documentId, DocumentDto documentDto);

    String deleteDocumentById(String documentId);

}
