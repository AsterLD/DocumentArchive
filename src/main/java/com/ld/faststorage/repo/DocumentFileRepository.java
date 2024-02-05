package com.ld.faststorage.repo;

import com.ld.faststorage.entity.DocumentFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface DocumentFileRepository extends ElasticsearchRepository<DocumentFile, String> {

    public Page<DocumentFile> findAll(Pageable pageable);

    public Page<DocumentFile> findByTagListIn(List<String> tagList, Pageable pageable);

    public void deleteById(String id);
}
