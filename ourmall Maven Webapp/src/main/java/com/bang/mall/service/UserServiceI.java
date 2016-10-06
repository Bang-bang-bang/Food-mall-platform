package com.bang.mall.service;

import java.util.List;

import com.bang.mall.domain.ReceiveMsg;
import com.bang.mall.domain.Users;

public interface UserServiceI {
	//登录
	public Users userLogin(Users user);
	//注册
	public Users userRegister(Users users); 
	public Users updaUsers(Users users);
	//修改用户信息
	public void updaUserPass(Users user);
	//查询用户信息
	public Users getUserMsg(Integer userid);
	//查询所有用户
	public List<Users> getAllUsers();
	//修改地址信息
	ReceiveMsg updateReceiveMsg(ReceiveMsg receiveMsg);
	//删除地址信息
	ReceiveMsg delReceiveMsg(ReceiveMsg receiveMsg);
	//增加收件人地址
	ReceiveMsg addReceiveMsg(ReceiveMsg receiveMsg);
	//通过地址表id 查询地址信息
	ReceiveMsg showReceiveMsg(ReceiveMsg receiveMsg);
}
