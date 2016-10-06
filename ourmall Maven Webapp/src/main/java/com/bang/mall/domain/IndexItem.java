package com.bang.mall.domain;

import java.util.List;

public class IndexItem {
	private List<Goods> mSellGoods;
	private List<Goods> mNewGoods;

	public List<Goods> getmSellGoods() {
		return mSellGoods;
	}

	public void setmSellGoods(List<Goods> mSellGoods) {
		this.mSellGoods = mSellGoods;
	}

	public List<Goods> getmNewGoods() {
		return mNewGoods;
	}

	public void setmNewGoods(List<Goods> mNewGoods) {
		this.mNewGoods = mNewGoods;
	}

}
