package com.ld.faststorage.service;

import com.ld.faststorage.dto.ReturnableDocumentDTO;
import com.ld.faststorage.dto.SavableDocumentDTO;

import java.util.List;

public interface DocumentService {

    ReturnableDocumentDTO createDocument(SavableDocumentDTO savableDocumentDTO);

    List<ReturnableDocumentDTO> readAllDocuments(Integer page, Integer pageSize);

    List<ReturnableDocumentDTO> readAllDocumentsByTags(List<String> tagList, Integer page, Integer pageSize);

    ReturnableDocumentDTO readDocumentById(String documentId);

    ReturnableDocumentDTO updateDocumentById(String documentId,SavableDocumentDTO savableDocumentDTO);

    String deleteDocumentById(String documentId);

}
