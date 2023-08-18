package com.ld.documentarchive.service;

import com.ld.documentarchive.dto.DocumentDto;

public interface DocumentService {

    DocumentDto createDocument(DocumentDto documentDto);

    DocumentDto readDocumentById(String documentId);

    DocumentDto updateDocumentById(String documentId, DocumentDto documentDto);

    String deleteDocumentById(String documentId);

}
