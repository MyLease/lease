package com.mcmc.dao;

import com.mcmc.common.entity.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangyongkang on 2017/11/5.
 */
@Controller
public class OrderDao {
    @RequestMapping("/addOrder")
    public void addOrder(Order order)throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
/**
        String id=order.getId();
        String goodsId=order.getGoodsId();
        String userId=order.getUserId();
        int orderTimeLimit=order.getOrderTimeLimit();//交易时间限制
        String feightType=order.getFeightType();//运费支付类型 租方付、物品拥有者、面对面
        String orderType=order.getOrderType();//交易方式
 **/
        String id="2";
        String goodsId="2";
        String userId="3";
        int orderTimeLimit=33;//交易时间限制
        String feightType="2";//运费支付类型 租方付、物品拥有者、面对面
        String orderType="1";//交易方式
//order表名改为orders，order不能作为表名！！！
        String sql="INSERT INTO orders (id, goods_id, user_id, order_time_limit, feight_type, order_type) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params={id, goodsId, userId, orderTimeLimit, feightType, orderType};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);

    }
    @RequestMapping("/updateOrder")
    public void updateOrder(Order order) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        /**
         String id=order.getId();
         String goodsId=order.getGoodsId();
         String userId=order.getUserId();
         int orderTimeLimit=order.getOrderTimeLimit();//交易时间限制
         String feightType=order.getFeightType();//运费支付类型 租方付、物品拥有者、面对面
         String orderType=order.getOrderType();//交易方式
         **/
        String id="2";
        String goodsId="2";
        String userId="3";
        int orderTimeLimit=32;//交易时间限制
        String feightType="1";//运费支付类型 租方付、物品拥有者、面对面
        String orderType="2";//交易方式
//order表名改为orders，order不能作为表名！！！
        String sql="UPDATE orders SET goods_id=?, user_id=?, order_time_limit=?, feight_type=?, order_type=? where id=?";
        Object[] params={goodsId, userId, orderTimeLimit, feightType, orderType, id};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);
    }
    @RequestMapping("/selectOrderByGoodsId")
    public List<Order> selectOrderByGoodsId(String goodsId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="SELECT *  FROM orders WHERE goods_id=?";

        RowMapper<Order> rowMapper=new BeanPropertyRowMapper<Order>(Order.class);
        List<Order> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,goodsId);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/deleteOrderByGoodsId")
    public void deleteOrderByGoodsId(String goodsId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="delete from orders where goods_id=?";
        goodsId="1";
        //String id=user.getId();

        int count= jdbcTemplate.update(sql, goodsId);
        System.out.println(count);
    }
}
