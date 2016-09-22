package com.bang.mall.dao;

import com.bang.mall.domain.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer idd);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer idd);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}