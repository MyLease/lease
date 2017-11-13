package com.mcmc.dao;

import com.mcmc.common.entity.Credit;
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
public class CreditDao {
    @RequestMapping("/addCredit")
    public void addCredit(Credit credits) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String id=credits.getId();
        String userId=credits.getUserId();
        int credit=credits.getCredit();

        String sql="INSERT INTO credit (id, user_id, credit) VALUES (?, ?, ?)";
        Object[] params={id, userId, credit};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);
    }
    @RequestMapping("/updateCreditByUserId")
    public void updateCreditByUserId(Credit credits) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String id=credits.getId();
        String userId=credits.getUserId();
        int credit=credits.getCredit();

        String sql="UPDATE credit SET credit=? where user_id=?";
        Object[] params={credit, userId};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);

    }
    @RequestMapping("/selectCredit")
    public List<Credit> selectCredit(String userId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="SELECT *  FROM credit WHERE user_id=?";

        RowMapper<Credit> rowMapper=new BeanPropertyRowMapper<Credit>(Credit.class);
        List<Credit> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,userId);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/deleteCreditByUserId")
    public void deleteCreditByUserId(String userId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="delete from credit where user_id=?";

        int count= jdbcTemplate.update(sql, userId);
        System.out.println(count);
    }
}
