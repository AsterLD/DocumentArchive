package com.ld.documentarchive.service.impl;

import com.ld.documentarchive.dto.DocumentDto;
import com.ld.documentarchive.entity.Document;
import com.ld.documentarchive.repo.DocumentRepository;
import com.ld.documentarchive.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public DocumentDto createDocument(DocumentDto documentDto) {
        ModelMapper modelMapper = new ModelMapper();
        documentRepository.save(modelMapper.map(documentDto, Document.class), Duration.ZERO);
        return documentDto;
    }

    @Override
    public DocumentDto readDocumentById(String documentId) {
        ModelMapper modelMapper = new ModelMapper();
        Document document = documentRepository.findById(documentId);
        return modelMapper.map(document, DocumentDto.class);
    }

    @Override
    public DocumentDto updateDocumentById(String documentId, DocumentDto documentDto) {
        ModelMapper modelMapper = new ModelMapper();
        Document document = documentRepository.findById(documentId);
        document.setDocumentType(documentDto.getDocumentType());
        documentRepository.save(document, Duration.ZERO);
        return modelMapper.map(document,DocumentDto.class);
    }

    @Override
    public String deleteDocumentById(String documentId) {
        Document document = documentRepository.findById(documentId);
        documentRepository.deleteById(documentId);
        return documentId;
    }
}
