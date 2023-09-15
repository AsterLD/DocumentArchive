package com.ld.faststorage.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DocumentDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tag_list")
    private List<String> tagList;

}
