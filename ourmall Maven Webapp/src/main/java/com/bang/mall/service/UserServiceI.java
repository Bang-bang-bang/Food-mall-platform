package com.bang.mall.service;

import java.util.List;

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
}
