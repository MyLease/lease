package com.mcmc.dao.goods;

import com.mcmc.common.entity.Goods;
import com.mcmc.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sunlei on 2017/10/26.
 * 商品的Dao层方法
 */
@Repository

public class GoodsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有==租赁商品
     * @return
     */

    public List<Goods> selectAllLeaseGoods() {
        String sql = "SELECT * FROM goods WHERE goods.goods_deal_type = '1' AND goods.can_show = '1' ORDER BY goods.business_num ASC LIMIT 0,10";
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<Goods>(Goods.class);
        List<Goods> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }

    /**
     * 根据查询条件查询商品列表
     * @param goodsName
     * @param goodsDealType
     * @param goodsType
     * @param lowPrice
     * @param highPrice
     * @return
     */
    public List<Goods> selectWithCondition(String goodsName, String goodsDealType, String goodsType, double lowPrice, double highPrice) {


        String sql = "SELECT * FROM `goods` WHERE `can_show` = 1";

        if(goodsName.equals("")) {
            goodsName = null;
        }
        if(goodsType.equals("")) {
            goodsType = null;
        }

        if(!(goodsName == null && goodsDealType == null && goodsType == null && lowPrice <= 0.0 &&highPrice <= 0.0)) {

            if(goodsName != null) {
                sql += " AND `goods_name` LIKE '%" + goodsName + "%'";
            }
            if(!goodsDealType.equals("-1")) {
                sql += " AND `goods_deal_type` = '" + goodsDealType + "'";
            }
            if(goodsType != null) {
                sql += " AND `goods_type` LIKE '%" + goodsType + "%'";
            }
            if(highPrice > 0.0 && lowPrice >= 0.0 && highPrice > lowPrice) {
                sql += " AND `goods_price` BETWEEN " + lowPrice + " AND " + highPrice;
            }
        }

        sql += " ORDER BY goods.business_num ASC";
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<Goods>(Goods.class);
        List<Goods> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


}
