package com.ld.faststorage.utils;

import com.ld.faststorage.dto.DocumentDto;
import com.ld.faststorage.entity.Document;
import org.modelmapper.ModelMapper;

public class Mapper {

    public static DocumentDto mapDocumentToDocumentDTO(Document document) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(document, DocumentDto.class);
    }

    public static Document mapDocumentDTOToDocument(DocumentDto documentDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(documentDto, Document.class);
    }
}
