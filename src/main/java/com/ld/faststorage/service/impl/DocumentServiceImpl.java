package com.ld.faststorage.service.impl;

import com.ld.faststorage.dto.ReturnableDocumentDTO;
import com.ld.faststorage.dto.SavableDocumentDTO;
import com.ld.faststorage.entity.DocumentFile;
import com.ld.faststorage.exception.DocumentException;
import com.ld.faststorage.repo.DocumentFileRepository;
import com.ld.faststorage.service.DocumentService;
import com.ld.faststorage.utils.DocumentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final DocumentFileRepository documentFileRepository;

    private final DocumentMapper documentMapper;

    @Override
    public ReturnableDocumentDTO createDocument(SavableDocumentDTO savableDocumentDTO) {
        DocumentFile documentFIle = documentFileRepository.save(documentMapper.toDocument(savableDocumentDTO));
        log.info("Saved document: " + savableDocumentDTO);
        return documentMapper.toReturnableDTO(documentFIle);
    }

    @Override
    public List<ReturnableDocumentDTO> readAllDocuments(Integer page, Integer pageSize) {
        List<DocumentFile> documentFileList = documentFileRepository.findAll(PageRequest.of(page - 1, pageSize)).getContent();
        return documentFileList.stream().map(documentMapper::toReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReturnableDocumentDTO> readAllDocumentsByTags(List<String> tagList, Integer page, Integer pageSize) {
        List<DocumentFile> documentFileList = documentFileRepository.findByTagListIn(tagList, PageRequest.of(page - 1, pageSize)).getContent();
        return documentFileList.stream().map(documentMapper::toReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public ReturnableDocumentDTO readDocumentById(String documentId) {
        DocumentFile documentFIle = documentFileRepository.findById(documentId).orElseThrow();
        return documentMapper.toReturnableDTO(documentFIle);
    }

    @Override
    public ReturnableDocumentDTO updateDocumentById(String documentId, SavableDocumentDTO savableDocumentDTO) {
        DocumentFile documentFIle = documentFileRepository.findById(documentId).orElseThrow();
        UpdateDocumentFromDTO(documentFIle, savableDocumentDTO);
        documentFileRepository.save(documentFIle);
        log.info("Updated document id: " + documentId + " with data: " + savableDocumentDTO);
        return documentMapper.toReturnableDTO(documentFIle);
    }

    @Override
    public String deleteDocumentById(String documentId) {
        if (documentFileRepository.existsById(documentId)) {
            documentFileRepository.deleteById(documentId);
            log.info("Deleted document id: " + documentId);
            return documentId;
        } else {
            throw new DocumentException("Document not found.");
        }
    }
}
