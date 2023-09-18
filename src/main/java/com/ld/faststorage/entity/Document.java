package com.ld.faststorage.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Set;

@Data
@NoArgsConstructor
@FieldNameConstants
@SolrDocument(collection = "document-archive")
public class Document {

    @Id
    @Field
    @Indexed
    private String id;

    @Field
    @Indexed
    private String name;

    @Field
    @Indexed(required = true)
    private String documentType;

    @Field
    private String description;

    @Field
    private Set<String> tagList;

}
