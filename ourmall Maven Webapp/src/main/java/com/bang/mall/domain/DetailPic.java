package com.bang.mall.domain;

public class DetailPic {
    private Integer id;

    private Integer picdtid;

    private String address;

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