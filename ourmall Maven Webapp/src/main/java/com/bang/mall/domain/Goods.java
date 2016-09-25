package com.bang.mall.domain;

import java.util.Date;

public class Goods {
	private Integer goodsid;// 商品id

	private String goodsName;// 商品名字

	private Integer goodsTotal;// 商品库存数量

	private String goodsDetals;// 商品详情

	private Integer goodsSell;// 商品销售量

	private Date createTime;// 商品上架时间

	private Float goodsPrice;// 商品价格

	private Integer goodsUsers;// 商品被购买的用户数

	private String goodsState;// 商品的状态

	private String goods1;// 备用属性

	private String goods2;// 备用属性

	private String msg;// 与数据库表无关
	
	private Integer priceInteger;//价格排序判断
	
	private Integer sellInteger;//销量排序判断

	public Integer getPriceInteger() {
		return priceInteger;
	}

	public void setPriceInteger(Integer priceInteger) {
		this.priceInteger = priceInteger;
	}

	public Integer getSellInteger() {
		return sellInteger;
	}

	public void setSellInteger(Integer sellInteger) {
		this.sellInteger = sellInteger;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public Integer getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(Integer goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public String getGoodsDetals() {
		return goodsDetals;
	}

	public void setGoodsDetals(String goodsDetals) {
		this.goodsDetals = goodsDetals == null ? null : goodsDetals.trim();
	}

	public Integer getGoodsSell() {
		return goodsSell;
	}

	public void setGoodsSell(Integer goodsSell) {
		this.goodsSell = goodsSell;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsUsers() {
		return goodsUsers;
	}

	public void setGoodsUsers(Integer goodsUsers) {
		this.goodsUsers = goodsUsers;
	}

	public String getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(String goodsState) {
		this.goodsState = goodsState == null ? null : goodsState.trim();
	}

	public String getGoods1() {
		return goods1;
	}

	public void setGoods1(String goods1) {
		this.goods1 = goods1 == null ? null : goods1.trim();
	}

	public String getGoods2() {
		return goods2;
	}

	public void setGoods2(String goods2) {
		this.goods2 = goods2 == null ? null : goods2.trim();
	}
}