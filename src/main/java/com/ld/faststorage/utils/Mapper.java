package com.ld.faststorage.utils;

import com.ld.faststorage.dto.DocumentDTO;
import com.ld.faststorage.entity.Document;
import org.modelmapper.ModelMapper;

public class Mapper {

    public static DocumentDTO mapDocumentToDocumentDTO(Document document) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(document, DocumentDTO.class);
    }

    public static Document mapDocumentDTOToDocument(DocumentDTO documentDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(documentDTO, Document.class);
    }
}
