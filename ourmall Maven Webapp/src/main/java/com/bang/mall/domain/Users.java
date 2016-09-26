package com.bang.mall.domain;

import java.util.Date;
import java.util.List;

public class Users {
	private Integer userid;// 用户id

	private String username;// 用户名

	private String password;// 用户密码

	private String school;// 学校

	private String sex;// 性别

	private Date createTime;// 用户创建时间

	private String phone;// 电话号码

	private String name;// 用户真实姓名

	private String picurl;// 头像URL

	private String msg;// （与数据库无关）

	private List<ReceiveMsg> mReceiveMsgs;// 收件人信息

	private List<Orders> mOrders;// 用户订单信息

	public List<ReceiveMsg> getmReceiveMsgs() {
		return mReceiveMsgs;
	}

	public void setmReceiveMsgs(List<ReceiveMsg> mReceiveMsgs) {
		this.mReceiveMsgs = mReceiveMsgs;
	}

	public List<Orders> getmOrders() {
		return mOrders;
	}

	public void setmOrders(List<Orders> mOrders) {
		this.mOrders = mOrders;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school == null ? null : school.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl == null ? null : picurl.trim();
	}
}