package com.mcmc.dao;

import com.mcmc.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunlei on 2017/10/12.
 * 学生
 */
@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User selectOneStudent(String userName, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        Object[] args = {userName, password};
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, rowMapper, args);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }

    public List<User> selectAllUser(){
        String sql = "SELECT * FROM user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;

    }


}
