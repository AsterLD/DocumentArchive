package com.ld.faststorage.service.impl;

import com.ld.faststorage.dto.DocumentDTO;
import com.ld.faststorage.entity.Document;
import com.ld.faststorage.exception.DocumentException;
import com.ld.faststorage.repo.DocumentRepository;
import com.ld.faststorage.service.DocumentService;
import com.ld.faststorage.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.ld.faststorage.utils.Updater.UpdateDocumentFromDTO;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private final DocumentRepository documentRepository;

    @Override
    public DocumentDTO createDocument(DocumentDTO documentDTO) {
        documentRepository.save(Mapper.mapDocumentDTOToDocument(documentDTO), Duration.ZERO);
        return documentDTO;
    }

    @Override
    public List<DocumentDTO> readAllDocuments(Integer page, Integer pageSize) {
        List<Document> documentList = documentRepository.findAll(PageRequest.of(page -1, pageSize)).getContent();
        return documentList.stream().map(Mapper::mapDocumentToDocumentDTO).collect(Collectors.toList());
    }

    @Override
    public List<DocumentDTO> readAllDocumentsByTags(List<String> tagList, Integer page, Integer pageSize) {
        List<Document> documentList = documentRepository.findByTagListIn(tagList, PageRequest.of(page -1, pageSize)).getContent();
        return documentList.stream().map(Mapper::mapDocumentToDocumentDTO).collect(Collectors.toList());
    }

    @Override
    public DocumentDTO readDocumentById(String documentId) {
        Document document = documentRepository.findById(documentId).orElseThrow();
        return Mapper.mapDocumentToDocumentDTO(document);
    }

    @Override
    public DocumentDTO updateDocumentById(String documentId, DocumentDTO documentDTO) {
        Document document = documentRepository.findById(documentId).orElseThrow();
        UpdateDocumentFromDTO(document, documentDTO);
        documentRepository.save(document, Duration.ZERO);
        return Mapper.mapDocumentToDocumentDTO(document);
    }

    @Override
    public String deleteDocumentById(String documentId) {
        if (documentRepository.existsById(documentId)) {
            documentRepository.deleteById(documentId);
            return documentId;
        } else {
            throw new DocumentException("Document not found.");
        }
    }
}
