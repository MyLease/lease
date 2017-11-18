package com.mcmc.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.mcmc.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
