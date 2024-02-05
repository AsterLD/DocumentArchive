package com.ld.faststorage.utils;

import com.ld.faststorage.dto.ReturnableDocumentDTO;
import com.ld.faststorage.dto.SavableDocumentDTO;
import com.ld.faststorage.entity.DocumentFile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentMapper {

    ReturnableDocumentDTO toReturnableDTO(DocumentFile source);

    DocumentFile toDocument(SavableDocumentDTO source);
}
