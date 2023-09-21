package com.ld.faststorage.utils;

import com.ld.faststorage.dto.ReturnableDocumentDTO;
import com.ld.faststorage.dto.SavableDocumentDTO;
import com.ld.faststorage.entity.Document;
import org.modelmapper.ModelMapper;

public class Mapper {

    public static ReturnableDocumentDTO mapDocumentToReturnableDTO(Document document) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(document, ReturnableDocumentDTO.class);
    }

    public static Document mapSavableDTOToDocument(SavableDocumentDTO savableDocumentDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(savableDocumentDTO, Document.class);
    }
}
