package com.mcmc.search.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Goods {

	private String id;

	private String goodsName;
	private String goodsInfo;
	private String goodsImg;
	private String goodsDealType;//商品交易类型 租、换、买、捐、送
	private String goodsType;
	private String goodsPrice;





	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getGoodsDeposit() {
		return goodsDeposit;
	}

	public void setGoodsDeposit(String goodsDeposit) {
		this.goodsDeposit = goodsDeposit;
	}

	private String goodsDeposit;



}
