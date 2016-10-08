package com.bang.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.dao.GoodsMapper;
import com.bang.mall.dao.PicAddressMapper;
import com.bang.mall.dao.UserGoodsMapper;
import com.bang.mall.domain.Goods;
import com.bang.mall.domain.PicAddress;
import com.bang.mall.domain.UserGoods;
import com.bang.mall.service.UserGoodsServiceI;

@Service("userGoodsBean")
public class UserGoodsServiceImpl implements UserGoodsServiceI {
	@Autowired
	private UserGoodsMapper userGoodsMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private PicAddressMapper picAddressMapper;

	public List<UserGoods> showUserGoods(Integer userid) {
		return userGoodsMapper.selectByUserKey(userid);
	}

	/**
	 * 加入购物车 购物车存在该商品则数量加1 价格也加 否则新加入购物中
	 */
	public UserGoods insertCart(UserGoods userGoods) {
		Goods goods = new Goods();
		goods = goodsMapper.selectByPrimaryKey(userGoods.getGoodid());
		userGoods.setGoodsName(goods.getGoodsName());
		UserGoods userGoods2 = userGoodsMapper
				.selectByUserAndGoodKey(userGoods);
		System.out.println("******" + userGoods.getUsergoods3());
		System.out.println("******" + userGoods.getGoodid());
		if (userGoods2 != null) {
			userGoods.setId(userGoods2.getId());
			userGoods.setGoodsNumber(userGoods2.getGoodsNumber() + 1);
			userGoods.setGoodsPrice(userGoods2.getGoodsPrice()
					+ goods.getGoodsPrice());
			userGoodsMapper.updateByPrimaryKeySelective(userGoods);
		} else {
			userGoods.setGoodsNumber(1);
			List<PicAddress> mPicAddresses = picAddressMapper
					.selectByGoodsKey(userGoods.getGoodid());
			userGoods.setUsergoods1(mPicAddresses.get(0).getAddress());
			userGoods.setGoodsPrice(goods.getGoodsPrice());
			userGoodsMapper.insertSelective(userGoods);
		}
		return userGoods;
	}

}
