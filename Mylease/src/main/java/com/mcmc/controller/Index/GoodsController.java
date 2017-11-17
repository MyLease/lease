package com.mcmc.controller.Index;

import com.mcmc.common.entity.Goods;
import com.mcmc.service.goods.GoodsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
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
    @ResponseBody
    @RequestMapping("/selectAllLeaseGoods")
    public JSONObject selectAllLeaseGoods(HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        List<Goods> list=goodsService.sellectAllLeaseGoods();
        JSONObject json = new JSONObject();
        json.put("allGoods", list);
        return json;
    }

    @ResponseBody
    @RequestMapping("/selectGoodsByUserId")
    public JSONObject selectGoodsByUserId(Goods goods, HttpSession session, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");

        List<Goods> list = goodsService.selectGoodsByUserId("1");
        JSONObject json = new JSONObject();
        json.put("This user's goods:", list);
        return json;
    }



    @RequestMapping("selectGoods")
    @ResponseBody
    public JSONArray selectByCondition(@RequestParam(value = "goodsName", required = false, defaultValue = "") String goodsName,
                                       @RequestParam(value = "dealType", required = false, defaultValue = "-1" ) String goodsDealType,
                                       @RequestParam(value = "goodsType", required = false, defaultValue = "") String goodsType,
                                       @RequestParam(value = "lowPrice", required = false, defaultValue = "-1") double lowPrice,
                                       @RequestParam(value = "highPrice", required = false, defaultValue = "-1") double highPrice,
                                       HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("goodsName = " + goodsName);
        JSONArray  jsonArray = new JSONArray();

        List<Goods> goodsList = goodsService.selectWithCondition(goodsName, goodsDealType, goodsType, lowPrice, highPrice);
        for(Goods good : goodsList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("good", good);
            jsonArray.add(jsonObject);
        }
        return jsonArray;

    }

}
