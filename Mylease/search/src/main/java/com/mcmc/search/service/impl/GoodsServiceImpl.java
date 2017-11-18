package com.mcmc.search.service.impl;

import java.util.List;


import com.mcmc.search.dao.GoodsDao;
import com.mcmc.search.utils.ExceptionUtil;
import com.mcmc.search.utils.LeaseResult;


import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcmc.search.pojo.Goods;
import com.mcmc.search.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;

//	@Autowired
//	private SolrClient SolrClient;
	String URL="http://115.159.144.182:8080/solr/mycore2";
	HttpSolrClient server = new HttpSolrClient(URL);
	public LeaseResult importAllGoods() {
		try {
			//查询商品列表
			List<Goods> list = goodsDao.selectAllGoods();

			//list.get(1).getGoodsInfo();
			//把商品信息写入索引库
			for (Goods goods : list) {
				//创建一个SolrInputDocument对象
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", goods.getId());
				document.addField("goods_name", goods.getGoodsName());
				document.addField("goods_info", goods.getGoodsInfo());
				document.addField("goods_img",goods.getGoodsImg());
				document.addField("goods_deal_type", goods.getGoodsDealType());
				document.addField("goods_price", goods.getGoodsPrice());

				//写入索引库
				server.add(document);


			}

			//提交修改
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return LeaseResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return LeaseResult.ok();
	}

}
