package com.mcmc.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcmc.search.dao.SearchDao;
import com.mcmc.search.pojo.Goods;
import com.mcmc.search.pojo.SearchResult;

/**
 * 商品搜索的dao层
 */
@Repository
public class SearchDaoImpl implements SearchDao {

//	@Autowired
//	private HttpSolrClient solrServer;
	String URL="http://115.159.144.182:8080/solr/mycore2";
	HttpSolrClient server = new HttpSolrClient(URL);

	public SearchResult search(SolrQuery query) throws Exception {
		//返回值对象
		SearchResult result = new SearchResult();
		//根据查询条件查询索引库
		QueryResponse queryResponse = server.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		//取查询结果总数量
		result.setRecordCount(solrDocumentList.getNumFound());
		//商品列表
		List<Goods> goodsList = new ArrayList<Goods>();
		//取高亮显示
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		//取商品列表
		for (SolrDocument solrDocument : solrDocumentList) {
			//创建一商品对象
			Goods goods = new Goods();
			goods.setId((String) solrDocument.get("id"));
			//取高亮显示的结果
			List<String> list = highlighting.get(solrDocument.get("id")).get("goods_name");
			String title = "";
			if (list != null && list.size()>0) {
				title = list.get(0);
			} else {
				title = (String) solrDocument.get("goods_name");
			}
			goods.setGoodsName(title);
			goods.setGoodsImg((String) solrDocument.get("item_image"));
			goods.setGoodsPrice((String) solrDocument.get("goods_price"));
			goods.setGoodsDealType((String) solrDocument.get("goods_deal_type"));
			goods.setGoodsInfo((String) solrDocument.get("goods_info"));
            goods.setGoodsDeposit((String) solrDocument.get("goods_deposit"));
			//添加的商品列表
			goodsList.add(goods);
		}
		result.setGoodsList(goodsList);
		return result;
	}

}
