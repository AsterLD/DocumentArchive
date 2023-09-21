package com.ld.faststorage.service.impl;

import com.ld.faststorage.dto.ReturnableDocumentDTO;
import com.ld.faststorage.dto.SavableDocumentDTO;
import com.ld.faststorage.entity.Document;
import com.ld.faststorage.exception.DocumentException;
import com.ld.faststorage.repo.DocumentRepository;
import com.ld.faststorage.service.DocumentService;
import com.ld.faststorage.utils.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.ld.faststorage.utils.Updater.UpdateDocumentFromDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private final DocumentRepository documentRepository;

    @Override
    public ReturnableDocumentDTO createDocument(SavableDocumentDTO savableDocumentDTO) {
        Document document = documentRepository.save(Mapper.mapSavableDTOToDocument(savableDocumentDTO), Duration.ZERO);
        log.info("Saved document: " + savableDocumentDTO);
        return Mapper.mapDocumentToReturnableDTO(document);
    }

    @Override
    public List<ReturnableDocumentDTO> readAllDocuments(Integer page, Integer pageSize) {
        List<Document> documentList = documentRepository.findAll(PageRequest.of(page -1, pageSize)).getContent();
        return documentList.stream().map(Mapper::mapDocumentToReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReturnableDocumentDTO> readAllDocumentsByTags(List<String> tagList, Integer page, Integer pageSize) {
        List<Document> documentList = documentRepository.findByTagListIn(tagList, PageRequest.of(page -1, pageSize)).getContent();
        return documentList.stream().map(Mapper::mapDocumentToReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public ReturnableDocumentDTO readDocumentById(String documentId) {
        Document document = documentRepository.findById(documentId).orElseThrow();
        return Mapper.mapDocumentToReturnableDTO(document);
    }

    @Override
    public ReturnableDocumentDTO updateDocumentById(String documentId, SavableDocumentDTO savableDocumentDTO) {
        Document document = documentRepository.findById(documentId).orElseThrow();
        UpdateDocumentFromDTO(document, savableDocumentDTO);
        documentRepository.save(document, Duration.ZERO);
        log.info("Updated document id: " + documentId + " with data: " + savableDocumentDTO);
        return Mapper.mapDocumentToReturnableDTO(document);
    }

    @Override
    public String deleteDocumentById(String documentId) {
        if (documentRepository.existsById(documentId)) {
            documentRepository.deleteById(documentId);
            log.info("Deleted document id: " + documentId);
            return documentId;
        } else {
            throw new DocumentException("Document not found.");
        }
    }
}
