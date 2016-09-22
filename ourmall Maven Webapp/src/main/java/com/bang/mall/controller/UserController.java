package com.bang.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bang.mall.domain.Users;
import com.bang.mall.service.UserServiceI;
@Controller
@RequestMapping("/userController")
public class UserController {

	private UserServiceI userServiceI;

	public UserServiceI getUserServiceI() {
		return userServiceI;
	}
	@Autowired
	public void setUserServiceI(UserServiceI userServiceI) {
		this.userServiceI = userServiceI;
	}
	@RequestMapping(value="/getUser")
	public String listUser(HttpServletRequest request,Integer id) {
		Users users = userServiceI.getUser(id);
		System.out.println(id);
		System.out.println(users.getSchool());
		request.setAttribute("userlist", users);
		return "MyJsp";
	}
	
}
