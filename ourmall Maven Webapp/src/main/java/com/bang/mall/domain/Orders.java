package com.bang.mall.domain;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer idd;//订单表ID

    private Integer userid;//用户ID

    private Integer orderid;//订单ID

    private String orderState;//订单状态

    private Float goodsTotalprice;//订单总价格

    private Date deliveryTime;//发货时间

    private Date receivingTime;//收货时间

    private Integer display;//是否显示该订单

    private Date createTime;//订单创建时间

    private Integer cartid;//收件人信息id

    private String order1;//备用字段

    private String order2;//备用字段
    
    private Integer goodstotal;//商品的总数量
    
    private String recaddress;//收件人地址

    private String recname;//收件人名

    private String recphone;//收件人电话
    
    private Integer stateInteger;//判断对象（与数据库无关）
    
    private List<UserGoods> mUserGoodsList;//订单对应的商品表
    
    
    public List<UserGoods> getmUserGoodsList() {
		return mUserGoodsList;
	}

	public void setmUserGoodsList(List<UserGoods> mUserGoodsList) {
		this.mUserGoodsList = mUserGoodsList;
	}

	public String getRecaddress() {
		return recaddress;
	}

	public void setRecaddress(String recaddress) {
		this.recaddress = recaddress;
	}

	public String getRecname() {
		return recname;
	}

	public void setRecname(String recname) {
		this.recname = recname;
	}

	public String getRecphone() {
		return recphone;
	}

	public void setRecphone(String string) {
		this.recphone = string;
	}

	public Float getGoodsTotalprice() {
		return goodsTotalprice;
	}

	public void setGoodsTotalprice(Float goodsTotalprice) {
		this.goodsTotalprice = goodsTotalprice;
	}

	public Integer getGoodstotal() {
		return goodstotal;
	}

	public void setGoodstotal(Integer goodstotal) {
		this.goodstotal = goodstotal;
	}

	public Integer getStateInteger() {
		return stateInteger;
	}

	public void setStateInteger(Integer stateInteger) {
		this.stateInteger = stateInteger;
	}

	private List<UserGoods> mUserGoods;//商品列表

    public List<UserGoods> getmUserGoods() {
		return mUserGoods;
	}

	public void setmUserGoods(List<UserGoods> mUserGoods) {
		this.mUserGoods = mUserGoods;
	}

	public Integer getIdd() {
        return idd;
    }

    public void setIdd(Integer idd) {
        this.idd = idd;
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

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getOrder1() {
        return order1;
    }

    public void setOrder1(String order1) {
        this.order1 = order1 == null ? null : order1.trim();
    }

    public String getOrder2() {
        return order2;
    }

    public void setOrder2(String order2) {
        this.order2 = order2 == null ? null : order2.trim();
    }
}