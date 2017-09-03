package main.com.mcmc.common.entity;

/**
 * Created by sunlei on 2017/9/2.
 * 商品的实体类
 */
public class goods {
    private String id;
    private String userId;
    private String goodsName;
    private String goodsInfo;
    private String goodsImg;
    private String goodsDealType;//商品交易类型 租、换、买、捐、送
    private String goodsType;
    private String goodsPrice;
    private String goodsDeposit;//商品押金
    private int businessNum;//交易成功量
    private String canShow;//是否被展示

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsDealType() {
        return goodsDealType;
    }

    public void setGoodsDealType(String goodsDealType) {
        this.goodsDealType = goodsDealType;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDeposit() {
        return goodsDeposit;
    }

    public void setGoodsDeposit(String goodsDeposit) {
        this.goodsDeposit = goodsDeposit;
    }

    public int getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(int businessNum) {
        this.businessNum = businessNum;
    }

    public String getCanShow() {
        return canShow;
    }

    public void setCanShow(String canShow) {
        this.canShow = canShow;
    }
}

