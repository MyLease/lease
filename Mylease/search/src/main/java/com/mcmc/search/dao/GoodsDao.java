package com.mcmc.search.dao;

import com.mcmc.search.pojo.Goods;
import com.mcmc.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

import java.util.List;

public interface GoodsDao {

	List<Goods> selectAllGoods() throws Exception;
}
