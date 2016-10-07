package com.bang.mall.service;

import java.util.List;

import com.bang.mall.domain.Item;
import com.bang.mall.domain.Orders;

public interface OrderServiceI {

	List<Orders> selectAllOrder(Orders orders);
	List<Orders> getOrders(Orders orders);
	Orders deleteOrder(Orders orders);
	Item addOrder(Item item);
	Orders showOrder(Integer orderid);
	List<Orders> selectAllOrders(Orders orders);
	Orders showOrderByid(Integer idd);
	int updateByPrimaryKeySelective(Orders orders);
}
