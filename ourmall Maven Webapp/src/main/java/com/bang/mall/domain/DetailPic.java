package com.bang.mall.domain;

public class DetailPic {
    private Integer id;//商品详情页面图片id

    private Integer picdtid;//商品id

    private String address;//图片地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPicdtid() {
        return picdtid;
    }

    public void setPicdtid(Integer picdtid) {
        this.picdtid = picdtid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}