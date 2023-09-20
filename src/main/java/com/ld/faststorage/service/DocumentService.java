package com.ld.faststorage.service;

import com.ld.faststorage.dto.DocumentDTO;

import java.util.List;

public interface DocumentService {

    DocumentDTO createDocument(DocumentDTO documentDTO);

    List<DocumentDTO> readAllDocuments(Integer page, Integer pageSize);

    List<DocumentDTO> readAllDocumentsByTags(List<String> tagList, Integer page, Integer pageSize);

    DocumentDTO readDocumentById(String documentId);

    DocumentDTO updateDocumentById(String documentId, DocumentDTO documentDTO);

    String deleteDocumentById(String documentId);

}
