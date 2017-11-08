package com.mcmc.dao;

import com.mcmc.common.entity.GoodsComment;
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
 * Created by wangyongkang on 2017/11/3.
 */
//2017-11-03 20:22:07
@Controller
public class GoodsCommentDao {
    @RequestMapping("/addGoodsComment")
    public void addGoodsComment(GoodsComment goodsComment) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String id=goodsComment.getId();
        String userId=goodsComment.getUserId();
        String goodsId=goodsComment.getGoodsId();
        String content=goodsComment.getContent();
        String time=goodsComment.getTime();
        /**
        String id="1";
        String userId="2";
        String goodsId="3";
        String content="fjdslgfkhsd发撒fda";
        String time="2017-11-03 20:22:07";
**/
        String sql="INSERT INTO goods_comment (id, user_id, goods_id, content, time) VALUES (?, ?, ?, ?, ?)";
        Object[] params={id, userId, goodsId, content, time};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);

    }
    @RequestMapping("/selectByUserId")
    public List<GoodsComment> selectByUserId(String userId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="select * from goods_comment WHERE user_id=?";

        RowMapper<GoodsComment> rowMapper=new BeanPropertyRowMapper<GoodsComment>(GoodsComment.class);
        List<GoodsComment> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,userId);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/selectByGoodsId")
    public List<GoodsComment> selectByGoodsId(String goodsId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="select * from goods_comment WHERE goods_id=?";
        //goodsId="3";

        RowMapper<GoodsComment> rowMapper=new BeanPropertyRowMapper<GoodsComment>(GoodsComment.class);
        List<GoodsComment> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,goodsId);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/deleteCommentById")
    public void deleteCommentById(String id) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="delete from goods_comment where id=?";
        //id="2";

        int count= jdbcTemplate.update(sql, id);
        System.out.println(count);
    }
}
