package com.ld.documentarchive.service;

import com.ld.documentarchive.dto.DocumentDto;

import java.util.List;

public interface DocumentService {

    DocumentDto createDocument(DocumentDto documentDto);

    List<DocumentDto> readAllDocuments();

    DocumentDto readDocumentById(String documentId);

    DocumentDto updateDocumentById(String documentId, DocumentDto documentDto);

    String deleteDocumentById(String documentId);

}
