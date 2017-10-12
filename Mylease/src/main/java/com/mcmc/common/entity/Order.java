package com.mcmc.common.entity;

/**
 * Created by sunlei on 2017/9/2.
 * 订单的实体类
 */
public class Order {
    private String id;
    private String goodsId;
    private String userId;
    private int orderTimeLimit;//交易时间限制
    private String feightType;//运费支付类型 租方付、物品拥有者、面对面
    private String orderType;//交易方式

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOrderTimeLimit() {
        return orderTimeLimit;
    }

    public void setOrderTimeLimit(int orderTimeLimit) {
        this.orderTimeLimit = orderTimeLimit;
    }

    public String getFeightType() {
        return feightType;
    }

    public void setFeightType(String feightType) {
        this.feightType = feightType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
