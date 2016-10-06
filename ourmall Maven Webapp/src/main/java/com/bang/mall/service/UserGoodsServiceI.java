package com.bang.mall.service;

import java.util.List;

import com.bang.mall.domain.UserGoods;

public interface UserGoodsServiceI {
	List<UserGoods> showUserGoods(Integer userid);
	UserGoods insertCart(UserGoods userGoods);
}
