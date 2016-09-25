package com.bang.mall.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bang.mall.commons.Encode;
import com.bang.mall.commons.JsonResult;
import com.bang.mall.domain.Users;
import com.bang.mall.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController<Users> {
	@Autowired
	private UserServiceI userServiceI;

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login")
	public @ResponseBody JsonResult userLogin(Users users,
			HttpSession httpSession) {
		Users users1 = new Users();
		users.setPassword(Encode.getEncode("MD5", users.getPassword()));
		users1 = userServiceI.userLogin(users);
		JsonResult jsonResult = new JsonResult(users1);
		httpSession.setAttribute("user", users);
		return jsonResult;
	}

	/**
	 * 用户注册
	 */
	@RequestMapping(value = "/register")
	public @ResponseBody JsonResult userRegister(Users users) {
		Users users2 = new Users();
		users.setCreateTime(new Date());
		users.setPassword(Encode.getEncode("MD5", users.getPassword()));
		users2 = userServiceI.userRegister(users);
		JsonResult jsonResult = new JsonResult(users2);
		return jsonResult;
	}

	/**
	 * 修改用户信息
	 * 
	 */
	@RequestMapping(value = "/updatemsg")
	public @ResponseBody JsonResult userUpdate(Users users) {
		userServiceI.updaUserPass(users);
		users.setMsg("修改成功");
		JsonResult jsonResult = new JsonResult(users);
		return jsonResult;
	}

	/**
	 * 修改用户密码
	 */
	@RequestMapping(value = "/updatepass")
	public @ResponseBody JsonResult userUpdatepass(Users user, String newpass) {
		Users tUsers = userServiceI.getUserMsg(user.getUserid());
		if (tUsers.getPassword().equals(user.getPassword())) {
			tUsers.setPassword(newpass);
			userServiceI.updaUserPass(tUsers);
			tUsers.setMsg("修改密码成功");
		} else {
			tUsers.setMsg("旧密码错误");
		}
		JsonResult jsonResult = new JsonResult(tUsers);
		return jsonResult;
	}
}
