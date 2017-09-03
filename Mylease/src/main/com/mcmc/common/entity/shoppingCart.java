package main.com.mcmc.common.entity;

/**
 * Created by sunlei on 2017/9/2.
 * 购物车的实体类
 */
public class shoppingCart {
    private String id;
    private String userId;
    private String goodsId;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
