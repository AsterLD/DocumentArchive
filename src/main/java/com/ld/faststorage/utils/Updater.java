package com.ld.faststorage.utils;

import com.ld.faststorage.dto.DocumentDTO;
import com.ld.faststorage.entity.Document;

import java.util.Objects;

public class Updater {

    public static void UpdateDocumentFromDTO(Document document, DocumentDTO documentDTO) {
        if (Objects.nonNull(documentDTO)) {
            if (Objects.nonNull(documentDTO.getName())) {
                document.setName(documentDTO.getName());
            } if (Objects.nonNull(documentDTO.getDocumentType())) {
                document.setDocumentType(documentDTO.getDocumentType());
            } if (Objects.nonNull(documentDTO.getDescription())) {
                document.setDescription(documentDTO.getDescription());
            } if (!documentDTO.getTagList().isEmpty()) {
                document.getTagList().addAll(documentDTO.getTagList());
            }
        }
    }
}
