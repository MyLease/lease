package com.mcmc.dao;

import com.mcmc.common.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangyongkang on 2017/11/13.
 */
@Repository
public class ShoppingCartDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<ShoppingCart> getGoodsByUserId(String userId){
        String sql="SELECT goods_id FROM shopping_cart WHERE user_id=?";
        RowMapper<ShoppingCart> rowMapper = new BeanPropertyRowMapper<ShoppingCart>(ShoppingCart.class);
        List<ShoppingCart> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper,userId);

        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }
}
