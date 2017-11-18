package com.mcmc.search.controller;

import com.mcmc.search.utils.ExceptionUtil;
import com.mcmc.search.utils.LeaseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mcmc.search.pojo.SearchResult;
import com.mcmc.search.service.SearchService;

/**
 * 商品查询的Controller
 */
@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public LeaseResult search(@RequestParam("q")String queryString,
                              @RequestParam(defaultValue="1")Integer page,
                              @RequestParam(defaultValue="60")Integer rows) {
		//查询条件不能为空
		if (StringUtils.isBlank(queryString)) {
			return LeaseResult.build(400, "查询条件不能为空");
		}
		SearchResult searchResult = null;
		try {
			queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			searchResult = searchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return LeaseResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return LeaseResult.ok(searchResult);

	}

}
