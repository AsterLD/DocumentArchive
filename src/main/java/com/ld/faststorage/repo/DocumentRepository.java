package com.ld.faststorage.repo;

import com.ld.faststorage.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;


public interface DocumentRepository extends SolrCrudRepository<Document, String> {

    public Page<Document> findAll(Pageable pageable);
    public Page<Document> findByTagListIn(List<String> tagList, Pageable pageable);
    public void deleteById(String id);
}
