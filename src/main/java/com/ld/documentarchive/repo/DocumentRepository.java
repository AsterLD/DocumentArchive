package com.ld.documentarchive.repo;

import com.ld.documentarchive.entity.Document;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;


public interface DocumentRepository extends SolrCrudRepository<Document, String> {

    public List<Document> findAll();
    public List<Document> findByTagListIn(List<String> tagList);
    public void deleteById(String id);
}
