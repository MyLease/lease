package com.mcmc.dao;

import com.mcmc.common.entity.Image;
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
public class ImageDao {
    @RequestMapping("/addImage")
    public void addImage(Image image) throws SQLException {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
/**
        String id=image.getId();
        String goodsId=image.getGoodsId();
        String goodsCommentId=image.getGoodsCommentId();//对应评论id
        String dynamicId=image.getDynamicId();//对应动态id
        String imgPath=image.getImgPath();//照片路径
 **/
        String id="2";
        String goodsId="2";
        String goodsCommentId="3";//对应评论id
        String dynamicId="4";//对应动态id
        String imgPath="D:\\Baofeng\\PhoneAssistant\\bfwebcore";//照片路径

        String sql="INSERT INTO image (id, goods_id, goods_comment_id, dynamic_id, img_path) VALUES (?, ?, ?, ?, ?)";
        Object[] params={id, goodsId, goodsCommentId, dynamicId, imgPath};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);

    }
    @RequestMapping("/updateImage")
    public void updateImage(Image image) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        /**
         String id=image.getId();
         String goodsId=image.getGoodsId();
         String goodsCommentId=image.getGoodsCommentId();//对应评论id
         String dynamicId=image.getDynamicId();//对应动态id
         String imgPath=image.getImgPath();//照片路径
         **/

        String id="2";
        String goodsId="22";
        String goodsCommentId="33";//对应评论id
        String dynamicId="44";//对应动态id
        String imgPath="kgh;agh;jgh;kgjh;gh;s";//照片路径

        String sql="UPDATE image SET goods_id=?, goods_comment_id=?, dynamic_id=?, img_path=? where id=?";
        Object[] params={goodsId, goodsCommentId, dynamicId, imgPath, id};
        int count= jdbcTemplate.update(sql, params);
        System.out.println(count);

    }
    @RequestMapping("/selectImageById")
    public List<Image> selectImageById(String id) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="SELECT *  FROM image WHERE id=?";

        RowMapper<Image> rowMapper=new BeanPropertyRowMapper<Image>(Image.class);
        List<Image> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,id);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/selectImageByGoodsId")
    public List<Image> selectImageByGoodsId(String goodsId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="SELECT *  FROM image WHERE goods_id=?";

        RowMapper<Image> rowMapper=new BeanPropertyRowMapper<Image>(Image.class);
        List<Image> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,goodsId);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/selectImageByGoodsCommentId")
    public List<Image> selectImageByGoodsCommentId(String goodsCommentId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="SELECT *  FROM image WHERE goods_comment_id=?";

        RowMapper<Image> rowMapper=new BeanPropertyRowMapper<Image>(Image.class);
        List<Image> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,goodsCommentId);
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/selectImageByDynamicId")
    public List<Image> selectImageByDynamicId(String dynamicId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="SELECT *  FROM image WHERE dynamic_id=?";

        RowMapper<Image> rowMapper=new BeanPropertyRowMapper<Image>(Image.class);
        List<Image> list = null;
        try{
            list = jdbcTemplate.query(sql,rowMapper,"44");
            System.out.println(list);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Select Failed ");
        }
        return list;
    }
    @RequestMapping("/deleteImageById")
    public void deleteImageById(String id) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="delete from image where id=?";
        id="2";
        //String id=user.getId();

        int count= jdbcTemplate.update(sql, id);
        System.out.println(count);
    }
    @RequestMapping("/deleteImageByGoodsId")
    public void deleteImageByGoodsId(String goodsId) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql = "delete from image where goods_id=?";
        goodsId = "2";
        //String id=user.getId();

        int count = jdbcTemplate.update(sql, goodsId);
        System.out.println(count);
    }
    @RequestMapping("/deleteImageByGoodsCommentId")
    public void deleteImageByGoodsCommentId(String goodsCommentId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="delete from image where goods_comment_id=?";
        goodsCommentId="2";
        //String id=user.getId();

        int count= jdbcTemplate.update(sql, goodsCommentId);
        System.out.println(count);
    }
    @RequestMapping("/deleteImageByDynamicId")
    public void deleteImageByDynamicId(String dynamicId) throws SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql="delete from image where dynamic_id=?";
        dynamicId="2";
        //String id=user.getId();

        int count= jdbcTemplate.update(sql, dynamicId);
        System.out.println(count);
    }
}
