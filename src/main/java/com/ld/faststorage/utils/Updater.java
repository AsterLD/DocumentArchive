package com.ld.faststorage.utils;

import com.ld.faststorage.dto.DocumentDto;
import com.ld.faststorage.entity.Document;

import java.util.Objects;

public class Updater {

    public static void UpdateDocumentFromDto(Document document, DocumentDto documentDto) {
        if (Objects.nonNull(documentDto)) {
            if (Objects.nonNull(documentDto.getName())) {
                document.setName(documentDto.getName());
            } if (Objects.nonNull(documentDto.getDocumentType())) {
                document.setDocumentType(documentDto.getDocumentType());
            } if (Objects.nonNull(documentDto.getDescription())) {
                document.setDescription(documentDto.getDescription());
            } if (!documentDto.getTagList().isEmpty()) {
                document.getTagList().addAll(documentDto.getTagList());
            }
        }
    }
}
