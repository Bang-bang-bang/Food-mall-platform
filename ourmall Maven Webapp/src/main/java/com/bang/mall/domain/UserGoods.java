package com.bang.mall.domain;

public class UserGoods {
	private Integer id;// 用户商品表id

	private Integer orderid;// 用户订单id

	private String goodsName;// 商品名

	private Integer goodsNumber;// 商品数量

	private Float goodsPrice;// 商品价格

	private String usergoods1;// 显示在订单的图片

	private String usergoods2;// 备用字段

	private Integer usergoods3;// 用户ID

	private Integer goodid;// 商品ID

	private Integer ifcart;//判断是否在购物车

	private Integer usergoods4;//  商品id


	public Float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	

	public String getUsergoods1() {
		return usergoods1;
	}

	public void setUsergoods1(String usergoods1) {
		this.usergoods1 = usergoods1 == null ? null : usergoods1.trim();
	}

	public String getUsergoods2() {
		return usergoods2;
	}

	public void setUsergoods2(String usergoods2) {
		this.usergoods2 = usergoods2 == null ? null : usergoods2.trim();
	}

	public Integer getUsergoods3() {
		return usergoods3;
	}

	public void setUsergoods3(Integer usergoods3) {
		this.usergoods3 = usergoods3;
	}

	public Integer getGoodid() {
		return goodid;
	}

	public void setGoodid(Integer goodid) {
		this.goodid = goodid;
	}

	public Integer getIfcart() {
		return ifcart;
	}

	public void setIfcart(Integer ifcart) {
		this.ifcart = ifcart;
	}

	public Integer getUsergoods4() {
		return usergoods4;
	}

	public void setUsergoods4(Integer usergoods4) {
		this.usergoods4 = usergoods4;
	}
}