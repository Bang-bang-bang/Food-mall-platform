package com.bang.mall.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.dao.GoodsMapper;
import com.bang.mall.dao.OrdersMapper;
import com.bang.mall.dao.ReceiveMsgMapper;
import com.bang.mall.dao.UserGoodsMapper;
import com.bang.mall.domain.Goods;
import com.bang.mall.domain.Item;
import com.bang.mall.domain.Orders;
import com.bang.mall.domain.ReceiveMsg;
import com.bang.mall.domain.UserGoods;
import com.bang.mall.service.OrderServiceI;

@Service("orderBean")
public class OrderService implements OrderServiceI {
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private UserGoodsMapper userGoodsMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private ReceiveMsgMapper receiveMsgMapper;

	public List<Orders> selectAllOrder(Orders orders) {
		// userGoodsMapper.selectByUserOrOrderKey(orders);
		// ordersMapper.selectByUserKey(orders.getUserid());
		return null;
	}

	/**
	 * 通过用户id查询用户所有订单
	 * 
	 */
	public List<Orders> getOrders(Orders order) {
		// Orders orders = new Orders();
		UserGoods userGoods = new UserGoods();
		// userGoods.setUsergoods3(order.getUserid());
		List<Orders> mList = ordersMapper.selectByUserKey(order);
		List<Orders> nOrders = new ArrayList<Orders>();
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i).getOrderid() != null) {
				userGoods.setOrderid(mList.get(i).getOrderid());
				int mUserGoods = userGoodsMapper.selectByUserOrOrderKey(
						userGoods).size();
				mList.get(i).setmUserGoods(
						userGoodsMapper.selectByUserOrOrderKey(userGoods));
				mList.get(i).setGoodstotal(mUserGoods);

			}
		}
		return mList;
	}

	/**
	 * 通过orderid对订单表进行数据修改
	 */
	public Orders deleteOrder(Orders orders) {
		ordersMapper.updateByOrderKeySelective(orders);
		return orders;
	}

	/**
	 * 购物车的商品计算价格和是否生成订单
	 */
	public Item addOrder(Item item) {
		Calendar calendar = Calendar.getInstance();
		Integer orderid = (int) calendar.getTime().getTime();
		float price = 0;
		Integer totalInteger = 0;
		for (int i = 0; i < item.getmGoodsCarts().size(); i++) {
			totalInteger = totalInteger
					+ item.getmGoodsCarts().get(i).getGoodsnumbers();
			Goods goods = goodsMapper.selectByPrimaryKey(item.getmGoodsCarts()
					.get(i).getGoodsid());
			UserGoods userGoods = new UserGoods();
			userGoods.setGoodsNumber(item.getmGoodsCarts().get(i)
					.getGoodsnumbers());
			userGoods.setGoodsName(goods.getGoodsName());
			userGoods.setGoodsPrice(goods.getGoodsPrice()
					* item.getmGoodsCarts().get(i).getGoodsnumbers());
			userGoods.setGoodid(goods.getGoodsid());
			userGoods.setUsergoods3(item.getUserid());
			userGoods.setId(item.getmGoodsCarts().get(i).getUsergoodid());
			price = price + userGoods.getGoodsNumber() * goods.getGoodsPrice();
			if (item.getChiceInteger() != null) {
				userGoods.setOrderid(orderid);
			}
			userGoodsMapper.updateByPrimaryKeySelective(userGoods);
		}
		if (item.getChiceInteger() != null) {
			ReceiveMsg receiveMsg = new ReceiveMsg();
			receiveMsg.setUserid(item.getUserid());
			receiveMsg = receiveMsgMapper
					.selectByUserAndGetAddressKey(receiveMsg);
			System.out.println(receiveMsg.getAddress());
			Orders orders = new Orders();
			orders.setUserid(item.getUserid());
			orders.setOrderid(orderid);
			orders.setCreateTime(new Date());
			orders.setGoodsTotalprice(price);
			orders.setGoodstotal(totalInteger);
			orders.setOrderState("待付款");
			orders.setRecaddress(receiveMsg.getAddress());
			orders.setRecname(receiveMsg.getName());
			orders.setRecphone(receiveMsg.getPhone());
			ordersMapper.insertSelective(orders);
		}
		item.setPrice(price);
		return item;
	}

	public Orders showOrder(Integer orderid) {
		Orders orders = new Orders();
		UserGoods userGoods = new UserGoods();
		orders = ordersMapper.selectByOrderKey(orderid);
		userGoods.setOrderid(orderid);
		orders.setmUserGoodsList(userGoodsMapper
				.selectByUserOrOrderKey(userGoods));
		return orders;
	}

	/**
	 * 查询所有订单
	 */
	public List<Orders> selectAllOrders(Orders orders) {
		return ordersMapper.selectAllOrders(orders);
	}

	/**
	 * 查询制定订单
	 */
	public Orders showOrderByid(Integer idd) {
		return ordersMapper.selectByPrimaryKey(idd);
	}

	/**
	 * 修改订单
	 */
	public int updateByPrimaryKeySelective(Orders orders) {	
		return ordersMapper.updateByPrimaryKeySelective(orders);
	}

}
