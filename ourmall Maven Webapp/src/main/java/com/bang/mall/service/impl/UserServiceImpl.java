package com.bang.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.dao.OrdersMapper;
import com.bang.mall.dao.ReceiveMsgMapper;
import com.bang.mall.dao.UserGoodsMapper;
import com.bang.mall.dao.UsersMapper;
import com.bang.mall.domain.Orders;
import com.bang.mall.domain.ReceiveMsg;
import com.bang.mall.domain.UserGoods;
import com.bang.mall.domain.Users;
import com.bang.mall.service.UserServiceI;

@Service("userBean")
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private ReceiveMsgMapper receiveMsgMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private UserGoodsMapper userGoodsMapper;

	/**
	 * 用户登录判断
	 * 
	 */
	public Users userLogin(Users user) {
		Users mUsers = new Users();
		List<Users> users = usersMapper.userLogin(user);
		System.out.println("gg");
		String message = "";
		if (users.size() <= 0) {
			message = "登录失败";
			mUsers.setMsg(message);
		} else {
			message = "登录成功";
			mUsers = users.get(0);
			mUsers.setMsg(message);
		}
		return mUsers;
	}

	/**
	 * 用户注册
	 * 
	 */
	public Users userRegister(Users users) {
		if (usersMapper.selectIsExistUsers(users).size() > 0) {
			users.setMsg("用户已存在");
		} else {
			usersMapper.insert(users);
			users.setMsg("注册成功");
		}
		return users;
	}

	/**
	 * 修改用户信息
	 */
	public Users updaUsers(Users users) {
		usersMapper.updateByPrimaryKeySelective(users);
		return users;
	}

	/**
	 * 通过用户ID查询用户信息
	 */
	public Users getUserMsg(Integer userid) {
		UserGoods userGoods = new UserGoods();
		userGoods.setUsergoods3(userid);
		Orders orders = new Orders();
		orders.setUserid(userid);
		userGoodsMapper.selectByUserOrOrderKey(userGoods);
		List<ReceiveMsg> mReceiveMsgs = receiveMsgMapper
				.selectByUserKey(userid);
		List<Orders> mOrders = ordersMapper.selectByUserKey(orders);
		Users mUsers = usersMapper.selectByPrimaryKey(userid);
		mUsers.setmReceiveMsgs(mReceiveMsgs);
		mUsers.setmOrders(mOrders);
		return mUsers;
	}

	/**
	 * 修改密码
	 */
	public void updaUserPass(Users user) {
		usersMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 查询所有用户信息
	 */
	public List<Users> getAllUsers() {
		return usersMapper.selectUsers();
	}

	/**
	 * 修改用户地址信息
	 */
	public ReceiveMsg updateReceiveMsg(ReceiveMsg receiveMsg) {
		if (receiveMsg.getMainAddress() == 1) {
			List<ReceiveMsg> receiveMsgs = receiveMsgMapper
					.selectByUserKey(receiveMsg.getUserid());
			for (int i = 0; i < receiveMsgs.size(); i++) {
				System.out.println(receiveMsgs.size());
				System.out.println(receiveMsgs.get(i).getMainAddress());
				if (receiveMsgs.get(i).getMainAddress() == 1) {
					System.out.println("************"
							+ receiveMsgs.get(i).getId());
					ReceiveMsg receiveMsg2 = new ReceiveMsg();
					receiveMsg2.setId(receiveMsgs.get(i).getId());
					receiveMsg2.setMainAddress(0);
					receiveMsgMapper.updateByPrimaryKeySelective(receiveMsg2);
				} else {
					System.out.println("gg");
				}
			}
			receiveMsgMapper.updateByPrimaryKeySelective(receiveMsg);
		} else {
			receiveMsgMapper.updateByPrimaryKeySelective(receiveMsg);
		}

		return receiveMsg;
	}

	/**
	 * 通过地址表id删除地址信息
	 */
	public ReceiveMsg delReceiveMsg(ReceiveMsg receiveMsg) {
		receiveMsgMapper.deleteByPrimaryKey(receiveMsg.getId());
		return receiveMsg;
	}

	/**
	 * 通过用户id新增地址
	 */
	public ReceiveMsg addReceiveMsg(ReceiveMsg receiveMsg) {

		if (receiveMsg.getMainAddress() == 1) {
			List<ReceiveMsg> receiveMsgs = receiveMsgMapper
					.selectByUserKey(receiveMsg.getUserid());
			for (int i = 0; i < receiveMsgs.size(); i++) {
				System.out.println(receiveMsgs.size());
				System.out.println(receiveMsgs.get(i).getMainAddress());
				if (receiveMsgs.get(i).getMainAddress() == 1) {
					System.out.println("************"
							+ receiveMsgs.get(i).getId());
					ReceiveMsg receiveMsg2 = new ReceiveMsg();
					receiveMsg2.setId(receiveMsgs.get(i).getId());
					receiveMsg2.setMainAddress(0);
					receiveMsgMapper.updateByPrimaryKeySelective(receiveMsg2);
				} else {
					System.out.println("gg");
				}
			}
			receiveMsgMapper.insertSelective(receiveMsg);
		} else {
			receiveMsgMapper.insertSelective(receiveMsg);
		}
		return receiveMsg;
	}

	/**
	 * 通过用户id查询地址
	 */
	public ReceiveMsg showReceiveMsg(ReceiveMsg receiveMsg) {

		return receiveMsgMapper.selectByPrimaryKey(receiveMsg.getId());
	}

}
