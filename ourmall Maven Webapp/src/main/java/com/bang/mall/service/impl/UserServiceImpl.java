package com.bang.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.dao.UsersMapper;
import com.bang.mall.domain.Users;
import com.bang.mall.service.UserServiceI;
@Service("userBean")
public class UserServiceImpl implements UserServiceI {
	private UsersMapper usersMapper;
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}
	@Autowired
	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}
	public Users getUser(Integer userID) {
		
		return usersMapper.selectByPrimaryKey(userID);
	}
	
}
