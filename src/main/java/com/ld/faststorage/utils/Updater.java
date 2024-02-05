package com.ld.faststorage.utils;

import com.ld.faststorage.dto.SavableDocumentDTO;
import com.ld.faststorage.entity.DocumentFile;

import java.util.Objects;

public class Updater {

    public static void UpdateDocumentFromDTO(DocumentFile documentFIle, SavableDocumentDTO savableDocumentDTO) {
        if (Objects.nonNull(savableDocumentDTO)) {
            if (Objects.nonNull(savableDocumentDTO.getName())) {
                documentFIle.setName(savableDocumentDTO.getName());
            } if (Objects.nonNull(savableDocumentDTO.getDocumentType())) {
                documentFIle.setDocumentType(savableDocumentDTO.getDocumentType());
            } if (Objects.nonNull(savableDocumentDTO.getDescription())) {
                documentFIle.setDescription(savableDocumentDTO.getDescription());
            } if (!savableDocumentDTO.getTagList().isEmpty()) {
                documentFIle.getTagList().addAll(savableDocumentDTO.getTagList());
            }
        }
    }
}
