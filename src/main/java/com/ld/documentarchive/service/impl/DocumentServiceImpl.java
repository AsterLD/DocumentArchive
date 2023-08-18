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
        return null;
    }

    @Override
    public DocumentDto updateDocumentById(String documentId, DocumentDto documentDto) {
        return null;
    }

    @Override
    public String deleteDocumentById(String documentId) {
        return null;
    }
}
