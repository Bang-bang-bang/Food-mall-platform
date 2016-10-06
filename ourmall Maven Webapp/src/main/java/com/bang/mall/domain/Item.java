package com.bang.mall.domain;

import java.util.List;

public class Item {
	private Integer usergoodid;
	private Integer userid;
	private Integer orderid;
	private float price;
	private List<UserGoodsCart> mGoodsCarts;
	private String msg;
	private Integer chiceInteger;
	private String mymGoodsCarts;
	
	public Integer getUsergoodid() {
		return usergoodid;
	}
	public void setUsergoodid(Integer usergoodid) {
		this.usergoodid = usergoodid;
	}
	public String getMymGoodsCarts() {
		return mymGoodsCarts;
	}
	public void setMymGoodsCarts(String mymGoodsCarts) {
		this.mymGoodsCarts = mymGoodsCarts;
	}
	public Integer getChiceInteger() {
		return chiceInteger;
	}
	public void setChiceInteger(Integer chiceInteger) {
		this.chiceInteger = chiceInteger;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<UserGoodsCart> getmGoodsCarts() {
		return mGoodsCarts;
	}
	public void setmGoodsCarts(List<UserGoodsCart> mGoodsCarts) {
		this.mGoodsCarts = mGoodsCarts;
	}
}
