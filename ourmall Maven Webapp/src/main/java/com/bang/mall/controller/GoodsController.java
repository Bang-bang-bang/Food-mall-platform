package com.bang.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bang.mall.commons.JsonResult;
import com.bang.mall.domain.Goods;
import com.bang.mall.service.GoodsServiceI;

@Controller
@RequestMapping("/goodsController")
public class GoodsController extends BaseController<Goods> {
	@Autowired
	private GoodsServiceI goodsServiceI;
	/**
	 * 
	 * goodsName 模糊查询条件
	 * priceInteger 按价格排序 1：降序  2：升序
	 * sellInteger  按购买人数排序 1:降序 2：升序
	 * sellInteger 和 priceInteger 不能同时赋值
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping(value="/showAllGoods")
	public @ResponseBody JsonResult showAllGoods(Goods goods){
		System.out.println(goods.getGoodsName());
		JsonResult jsonResult = new JsonResult(goodsServiceI.showOrSortGoods(goods));
		return jsonResult;
	}

}
