package com.ld.documentarchive.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DocumentDto {

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("description")
    private String description;

}
