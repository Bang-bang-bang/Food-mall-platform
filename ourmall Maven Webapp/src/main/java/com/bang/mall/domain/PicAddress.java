package com.bang.mall.domain;

public class PicAddress {
    private Integer id;

    private Integer picaddid;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPicaddid() {
        return picaddid;
    }

    public void setPicaddid(Integer picaddid) {
        this.picaddid = picaddid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}