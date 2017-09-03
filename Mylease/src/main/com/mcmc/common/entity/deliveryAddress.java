package main.com.mcmc.common.entity;

/**
 * Created by sunlei on 2017/9/2.
 * 收货地址的实体类
 */
public class deliveryAddress {
    private String id;
    private String userId;
    private String deliveryAddress;

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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
