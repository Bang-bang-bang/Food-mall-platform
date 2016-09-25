package com.bang.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.commons.MallStatus;
import com.bang.mall.dao.GoodsMapper;
import com.bang.mall.domain.Goods;
import com.bang.mall.service.GoodsServiceI;

@Service("goodsBean")
public class GoodsServiceImpl implements GoodsServiceI {
	@Autowired
	private GoodsMapper goodsMapper;

	public List<Goods> getHotGoods() {

		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getNewGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public Goods showGoods(Integer goodsid) {
		return goodsMapper.selectByPrimaryKey(goodsid);
	}

	public int delGoods(Integer goodsid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Goods> getSelectGoods(String goodsname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescSelGoods(String goodsname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescPriceGoods(String goodsname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescSelGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescPriceGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> showOrSortGoods(Goods goods) {
		return goodsMapper.selectByGoodsPropertyOrSort(goods);
	}

}
