package com.ld.faststorage.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class SavableDocumentDTO {

    @JsonIgnore
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tag_list")
    private Set<String> tagList;

}
