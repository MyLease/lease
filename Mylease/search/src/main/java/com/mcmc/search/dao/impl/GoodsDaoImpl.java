package com.mcmc.search.dao.impl;


import com.mcmc.search.dao.GoodsDao;
import com.mcmc.search.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunlei on 2017/10/26.
 * 商品的Dao层方法
 */
@Repository

public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有==租赁商品
     * @return
     */

    public List<Goods> selectAllGoods(){
        String sql = "SELECT\n" +
                "\tgoods.goods_name,\n" +
                "\tgoods.goods_info,\n" +
                "\tgoods.goods_img,\n" +
                "\tgoods.goods_deal_type,\n" +
                "\tgoods.goods_type,\n" +
                "\tgoods.goods_price,\n" +
                "\tgoods.goods_deposit\n" +
                "FROM\n" +
                "\tgoods\n" +
                "WHERE\n" +
                "\tgoods.can_show = 1";
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
