package main.com.mcmc.common.entity;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Created by sunlei on 2017/9/2.
 * 图片库的实体类
 */
public class image {
    private String id;
    private String goodsId;
    private String goodsCommentId;//对应评论id，目前有问题，请及时修改
    private String dynamicId;//对应的动态id
    private String imgPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCommentId() {
        return goodsCommentId;
    }

    public void setGoodsCommentId(String goodsCommentId) {
        this.goodsCommentId = goodsCommentId;
    }

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
