package com.bang.mall.dao;

import com.bang.mall.domain.UserGoods;

public interface UserGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGoods record);

    int insertSelective(UserGoods record);

    UserGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGoods record);

    int updateByPrimaryKey(UserGoods record);
}