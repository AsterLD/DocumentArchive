package com.ld.documentarchive.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DocumentDto {

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tag_list")
    private List<String> tagList;

}
