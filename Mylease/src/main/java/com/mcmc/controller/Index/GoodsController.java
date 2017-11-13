package com.mcmc.controller.Index;

import com.mcmc.common.entity.Goods;
import com.mcmc.service.goods.GoodsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    @RequestMapping("/selectGoodsByUserId")
    public JSONObject selectGoodsByUserId(Goods goods, HttpSession session){
        List<Goods> list = goodsService.selectGoodsByUserId("1");
        JSONObject json = new JSONObject();
        json.put("This user's goods:", list);
        return json;
    }

    @RequestMapping("/selectAllLeaseGoods")
    public JSONObject selectAllLeaseGoods(){
        List<Goods> list=goodsService.sellectAllLeaseGoods();
        JSONObject json = new JSONObject();
        json.put("allGoods", list);
        return json;
    }
}
