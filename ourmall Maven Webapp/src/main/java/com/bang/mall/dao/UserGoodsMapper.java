package com.bang.mall.dao;

import java.util.List;

import com.bang.mall.domain.Orders;
import com.bang.mall.domain.UserGoods;

public interface UserGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGoods record);

    int insertSelective(UserGoods record);

    UserGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGoods record);

    int updateByPrimaryKey(UserGoods record);
    
    List<UserGoods> selectByUserOrOrderKey(UserGoods record);
    
    List<UserGoods> selectByUserKey(Integer id);
    
    int deleteByOrderKey(Orders record);
    
    UserGoods selectByUserAndGoodKey(UserGoods record);
    
    
}