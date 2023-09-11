package com.ld.documentarchive.repo;

import com.ld.documentarchive.entity.Document;
import org.springframework.data.solr.repository.SolrCrudRepository;


public interface DocumentRepository extends SolrCrudRepository<Document, String> {

    public void deleteById(String id);
}
