package com.ld.faststorage.entity;





import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@Data
@Document(indexName = "document_files")
public class DocumentFile {

    @Id
    @Field
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Keyword, name = "documentType")
    private String documentType;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field
    private Set<String> tagList;

}
