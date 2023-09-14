package com.ld.faststorage.service.impl;

import com.ld.faststorage.dto.DocumentDto;
import com.ld.faststorage.entity.Document;
import com.ld.faststorage.exception.DocumentException;
import com.ld.faststorage.repo.DocumentRepository;
import com.ld.faststorage.service.DocumentService;
import com.ld.faststorage.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private final DocumentRepository documentRepository;

    @Override
    public DocumentDto createDocument(DocumentDto documentDto) {
        documentRepository.save(Mapper.mapDocumentDTOToDocument(documentDto), Duration.ZERO);
        return documentDto;
    }

    @Override
    public List<DocumentDto> readAllDocuments() {
        List<Document> documentList = documentRepository.findAll();
        return documentList.stream().map(Mapper::mapDocumentToDocumentDTO).collect(Collectors.toList());
    }

    @Override
    public List<DocumentDto> readAllDocumentsByTags(List<String> tagList) {
        List<Document> documentList = documentRepository.findByTagListIn(tagList);
        return documentList.stream().map(Mapper::mapDocumentToDocumentDTO).collect(Collectors.toList());
    }

    @Override
    public DocumentDto readDocumentById(String documentId) {
        Document document = documentRepository.findById(documentId).orElseThrow();
        return Mapper.mapDocumentToDocumentDTO(document);
    }

    @Override
    public DocumentDto updateDocumentById(String documentId, DocumentDto documentDto) {
        Document document = documentRepository.findById(documentId).orElseThrow();
        document.setDocumentType(documentDto.getDocumentType());
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
