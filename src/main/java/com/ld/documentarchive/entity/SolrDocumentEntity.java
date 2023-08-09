package com.ld.documentarchive.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@NoArgsConstructor
@FieldNameConstants
@SolrDocument(collection = "document-archive")
public class SolrDocumentEntity {

    @Id
    @Field
    @Indexed
    private String id;

    @Field
    @Indexed(required = true)
    private String documentType;

}
