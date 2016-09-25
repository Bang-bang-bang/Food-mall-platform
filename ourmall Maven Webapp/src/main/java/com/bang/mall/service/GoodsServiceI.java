package com.bang.mall.service;

import java.util.List;

import com.bang.mall.domain.Goods;

public interface GoodsServiceI {
	// 查询热卖商品
	List<Goods> getHotGoods();

	// 查询新品商品
	List<Goods> getNewGoods();
	
	/**
	 * 
	 * @param goodsid
	 * @return
	 */
	List<Goods> showOrSortGoods(Goods goods);

	// 查询单个商品详细信息
	Goods showGoods(Integer goodsid);

	// 通过id删除商品信息
	int delGoods(Integer goodsid);

	// 通过商品名模糊查询商品列表
	List<Goods> getSelectGoods(String goodsname);

	// 模糊查询并按销量排序由高到低排序
	List<Goods> getDescSelGoods(String goodsname);

	// 模糊查询并按价格由排序由低到高排序
	List<Goods> getDescPriceGoods(String goodsname);

	// 按销量排序由高到低排序
	List<Goods> getDescSelGoods();

	// 按价格由排序由低到高排序
	List<Goods> getDescPriceGoods();
	
	
}
