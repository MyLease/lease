package com.mcmc.search.controller;

import com.mcmc.search.utils.LeaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.mcmc.search.service.GoodsService;

/**
 * 索引库维护
 */
@Controller
@RequestMapping("/manager")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

	/**
	 * 导入商品数据到索引库
	 */
	@RequestMapping("/importAll")
	@ResponseBody
	public LeaseResult importAllGoods() {
		LeaseResult result = goodsService.importAllGoods();
		return result;
	}
}
