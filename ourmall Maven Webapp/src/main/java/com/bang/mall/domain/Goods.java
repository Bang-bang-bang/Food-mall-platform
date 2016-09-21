package com.bang.mall.domain;

import java.util.Date;

public class Goods {
    private Integer goodsid;

    private String goodsName;

    private Integer goodsTotal;

    private String goodsDetals;

    private Integer goodsSell;

    private Date create;

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

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}