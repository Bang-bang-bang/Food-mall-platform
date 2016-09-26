package com.bang.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.dao.OrdersMapper;
import com.bang.mall.dao.ReceiveMsgMapper;
import com.bang.mall.dao.UsersMapper;
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
		int i = usersMapper.insert(users);
		String message = "";
		if (i < 0) {
			message = "注册失败";
			users.setMsg(message);
		} else {
			message = "注册成功！插入表第" + i + "列";
			users.setMsg(message);
		}
		return users;
	}

	/**
	 * 修改用户信息
	 */
	public Users updaUsers(Users users) {
		int i = usersMapper.updateByPrimaryKeySelective(users);
		return users;
	}

	/**
	 * 通过用户ID查询用户信息
	 */
	public Users getUserMsg(Integer userid) {
		Users mUsers=usersMapper.selectByPrimaryKey(userid);
		mUsers.setmReceiveMsgs(receiveMsgMapper.selectByUserKey(userid));
		
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

}
