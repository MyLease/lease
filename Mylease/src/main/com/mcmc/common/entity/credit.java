package main.com.mcmc.common.entity;

/**
 * Created by sunlei on 2017/9/2.
 * 信誉度实体类
 */

public class credit {
    private String id;
    private String userId;
    private int credit;

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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

}
