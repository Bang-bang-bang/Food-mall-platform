package com.bang.mall.service;

import java.util.List;

import com.bang.mall.domain.Admin;

public interface AdminServiceI {

	Admin insertAdmin(Admin admin);
	
	int updateAdmin(Admin admin);
	
	List<Admin> showAdmins();
	
	Admin showAdmin(Integer id);
	
	Admin adminLogin(Admin admin);
	
}
