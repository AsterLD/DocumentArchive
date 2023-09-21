package com.ld.faststorage.utils;

import com.ld.faststorage.dto.SavableDocumentDTO;
import com.ld.faststorage.entity.Document;

import java.util.Objects;

public class Updater {

    public static void UpdateDocumentFromDTO(Document document, SavableDocumentDTO savableDocumentDTO) {
        if (Objects.nonNull(savableDocumentDTO)) {
            if (Objects.nonNull(savableDocumentDTO.getName())) {
                document.setName(savableDocumentDTO.getName());
            } if (Objects.nonNull(savableDocumentDTO.getDocumentType())) {
                document.setDocumentType(savableDocumentDTO.getDocumentType());
            } if (Objects.nonNull(savableDocumentDTO.getDescription())) {
                document.setDescription(savableDocumentDTO.getDescription());
            } if (!savableDocumentDTO.getTagList().isEmpty()) {
                document.getTagList().addAll(savableDocumentDTO.getTagList());
            }
        }
    }
}
