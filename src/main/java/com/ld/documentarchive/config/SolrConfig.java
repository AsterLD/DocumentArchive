package com.ld.documentarchive.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories("com.ld.documentarchive.entity")
public class SolrConfig {

    @Value("${spring.data.solr.host}")
    private String solrHost;

    @Value("${spring.data.solr.core}")
    private String solrCoreName;

    @Bean
    public SolrClient solrClient() {
        return new Http2SolrClient.Builder(solrHost + solrCoreName).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
