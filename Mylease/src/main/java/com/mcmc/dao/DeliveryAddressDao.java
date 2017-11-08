package com.mcmc.dao;

import com.mcmc.common.entity.DeliveryAddress;
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
public class DeliveryAddressDao {
    @RequestMapping("/addDeliveryAddress")
    public void addDeliveryAddress(DeliveryAddress deliveryAddress) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
/**
        String id=deliveryAddress.getId();
        String userId=deliveryAddress.getUserId();
        String deliveryAddress=deliveryAddress.getDeliveryAddress();
 **/
        String id="1";
        String userId="1";
        String deliverAddress="山东省潍坊市坊子区凤凰街办盛世虞河湾";

        String sql="INSERT INTO delivery_address (id, user_id, delivery_address) VALUES (?, ?, ?)";
        Object[] params={id, userId, deliverAddress};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);

    }
    @RequestMapping("/updateDeliveryAddress")
    public void updateDeliveryAddress(DeliveryAddress deliveryAddress) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
/**
        String id=deliveryAddress.getId();
        String userId=deliveryAddress.getUserId();
        String deliveryAddress=deliveryAddress.getDeliveryAddress();
 **/
        String id="1";
        String userId="2";
        String deliverAddress="潍坊市坊子区凤凰街办盛世虞河湾";

        String sql="UPDATE delivery_address SET user_id=?, delivery_address=? where id=?";
        Object[] params={userId, deliverAddress, id};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);
    }
    @RequestMapping("/selectDeliveryAddress")
    public List<DeliveryAddress> selectDeliveryAddress(String userId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="SELECT * FROM delivery_address WHERE user_id=?";

        RowMapper<DeliveryAddress> rowMapper=new BeanPropertyRowMapper<DeliveryAddress>(DeliveryAddress.class);
        List<DeliveryAddress> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,"2");
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/deleteDeliveryAddress")
    public void deleteDeliveryAddress(String id) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="DELETE FROM delivery_address WHERE id=?";
        id="2";

        int count=jdbcTemplate.update(sql,id);
        System.out.println(count);
    }
}
