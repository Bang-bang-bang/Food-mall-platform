package com.bang.mall.domain;

import java.util.Date;

public class ReceiveMsg {
    private Integer id;//收件人信息表id

    private Integer userid;//用户id

    private String name;//收件人姓名

    private String address;//收件人地址

    private String phone;//收件人电话

    private Date createTime;//收件人信息创建时间

    private String school;//收件人学校

    private String msg1;//默认收件人判断

    private String msg2;//备用字段
    
    private Integer mainAddress;//设置为默认地址

    public Integer getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(Integer mainAddress) {
		this.mainAddress = mainAddress;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1 == null ? null : msg1.trim();
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2 == null ? null : msg2.trim();
    }
}