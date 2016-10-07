package com.bang.mall.dao;

import java.util.List;

import com.bang.mall.domain.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer idd);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer idd);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    List<Orders> selectByUserKey(Orders id);
    
    int deleteByOrderKey(Orders orders);
    
    int updateByOrderKeySelective(Orders record);
    
    Orders selectByOrderKey(Integer id);
    
    List<Orders> selectAllOrders(Orders record);
}