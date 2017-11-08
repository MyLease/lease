package com.mcmc.controller.Index;

import com.mcmc.common.entity.Goods;
import com.mcmc.dao.goods.GoodsDao;
import com.mcmc.service.goods.GoodsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sunlei on 2017/10/26.
 * 前台首页的控制层
 */
@Controller
@RequestMapping("/GoodsController")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     *查询所有==租赁商品，返回json
     * @return
     */
    //@RequestMapping("/selectAllLeaseGoods")
    @ResponseBody
    /**
    public List<Goods> selectAllLeaseGoods(){
        List<Goods> list = goodsService.sellectAllLeaseGoods();
        return list;
    }
     **/
    @RequestMapping("/selectAllLeaseGoods")
    public JSONObject selectAllLeaseGoods(){
        List<Goods> list=goodsService.sellectAllLeaseGoods();
        JSONObject json = new JSONObject();
        json.put("allGoods", list);
        return json;
    }
}
