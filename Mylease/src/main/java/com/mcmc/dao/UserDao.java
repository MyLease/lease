package com.mcmc.dao;
import com.mcmc.common.entity.User;
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
 * Created by wangyongkang on 2017/11/1.
 */
@Controller

public class UserDao {
    @RequestMapping("/insert")
    public void addNews(User user) throws SQLException {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");


        String id = user.getId();
        String userName = user.getUserName();
        String password = user.getPassword();
        String avatar = user.getAvatar();//头像
        String sex = user.getSex();
        String provinceCode = user.getProvinceCode();//用户所在省份代码
        int cityId = user.getCityId();//用户所在城市
        String email = user.getEmail();
        String telephone = user.getTelephone();
/**
        String id = "2";
        String userName = "刘旺";
        String password = "2222";
        String avatar = "333";//头像
        String sex = "1";
        String provinceCode = "22";//用户所在省份代码
        int cityId = 1;//用户所在城市
        String email = "13627227116@qq.com";
        String telephone = "18253657808";
**/
        String sql = "INSERT INTO user (id, username, password, avatar, sex, province_code, city_id, email, telephone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {id, userName, password, avatar,sex,provinceCode,cityId,email,telephone};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);
    }
    @RequestMapping("/update")
    public void update(User user){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

         String id = user.getId();
         String userName = user.getUserName();
         String password = user.getPassword();
         String avatar = user.getAvatar();//头像
         String sex = user.getSex();
         String provinceCode = user.getProvinceCode();//用户所在省份代码
         int cityId = user.getCityId();//用户所在城市
         String email = user.getEmail();
         String telephone = user.getTelephone();
         /**
        String id = "3";
        String userName = "孙hong蕾";
        String password = "222252";
        String avatar = "333";//头像
        String sex = "1";
        String provinceCode = "22";//用户所在省份代码
        int cityId = 1;//用户所在城市
        String email = "dd7227116@qq.com";
        String telephone = "18253654444";
**/
        String sql = "update user set username=?, password=?, avatar=?, sex=?,province_code=?, city_id=?, email=?, telephone=? where id=?";
        Object[] params = { userName, password, avatar,sex,provinceCode,cityId,email,telephone,id};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);

    }

    public List<User> selectUserByName(String username){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="select * from user where username=?";

        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        List<User> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,username);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }


    public List<User> selectAllUser(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="select * from user";

        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        List<User> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/delete")
    public void deleteById(String id){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="delete from user where id=?";
        //id="2";

        int count= jdbcTemplate.update(sql, id);
        System.out.println(count);


    }


}

