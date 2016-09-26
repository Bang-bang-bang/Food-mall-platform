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
	 * 用户登录 参数username：用户名 password：密码
	 */
	@RequestMapping(value = "/login")
	public @ResponseBody JsonResult userLogin(Users users) {
		Users users1 = new Users();
		users.setPassword(Encode.getEncode("MD5", users.getPassword()));
		users1 = userServiceI.userLogin(users);
		JsonResult jsonResult = new JsonResult(users1);
		return jsonResult;
	}

	/**
	 * 用户注册 参数username：用户名 password：密码 phone：电话号码
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
	 * 修改用户信息 参数picurl：头像url(尚未完成) sex：性别 name：用户姓名 school：学校 phone：联系电话
	 */
	@RequestMapping(value = "/updatemsg")
	public @ResponseBody JsonResult userUpdate(Users users) {
		userServiceI.updaUserPass(users);
		users.setMsg("修改成功");
		JsonResult jsonResult = new JsonResult(users);
		return jsonResult;
	}

	/**
	 * 修改用户密码 参数password：旧密码 newpass:新密码
	 */
	@RequestMapping(value = "/updatepass")
	public @ResponseBody JsonResult userUpdatepass(Users user, String newpass) {
		Users tUsers = userServiceI.getUserMsg(user.getUserid());
		if (tUsers.getPassword().equals(
				Encode.getEncode("MD5", user.getPassword()))) {
			tUsers.setPassword(Encode.getEncode("MD5", newpass));
			userServiceI.updaUserPass(tUsers);
			tUsers.setMsg("修改密码成功");
		} else {
			tUsers.setMsg("旧密码错误");
		}
		JsonResult jsonResult = new JsonResult(tUsers);
		return jsonResult;
	}

	/**
	 * 查看用户信息或收件人信息或订单信息
	 * 
	 */
	@RequestMapping(value = "/showUserMsg")
	public @ResponseBody JsonResult showUserMsg(Users users) {

		JsonResult jsonResult = new JsonResult(userServiceI.getUserMsg(users
				.getUserid()));
		return jsonResult;

	}
}
