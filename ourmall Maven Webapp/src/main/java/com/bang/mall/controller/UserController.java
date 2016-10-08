package com.bang.mall.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bang.mall.commons.Encode;
import com.bang.mall.commons.JsonResult;
import com.bang.mall.domain.Item;
import com.bang.mall.domain.Orders;
import com.bang.mall.domain.ReceiveMsg;
import com.bang.mall.domain.UserGoods;
import com.bang.mall.domain.UserGoodsCart;
import com.bang.mall.domain.Users;
import com.bang.mall.service.OrderServiceI;
import com.bang.mall.service.UserGoodsServiceI;
import com.bang.mall.service.UserServiceI;

/**
 * 
 * @author lilingyong
 * @deprecated 本类全为json数据返回 若改字符串返回，则需在构造方法参数中加HttpServletRequest request 方法体中加
 *             request.setAttribute("key", Object);
 *
 */

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController<Users> {
	@Autowired
	private UserServiceI userServiceI;
	@Autowired
	private OrderServiceI orderService;
	@Autowired
	private UserGoodsServiceI userGoodsServiceI;

	/**
	 * 用户登录
	 * 
	 * @param username
	 *            ：用户名
	 * @param password
	 *            ：密码
	 */
	@RequestMapping(value = "/login")
	public @ResponseBody JsonResult userLogin(Users users, HttpSession session) {
		Users users1 = new Users();
		users.setPassword(Encode.getEncode("MD5", users.getPassword()));
		users1 = userServiceI.userLogin(users);
		JsonResult jsonResult = new JsonResult(users1);
		session.setAttribute("user", users1);
		return jsonResult;
	}

	/**
	 * 用户注册
	 * 
	 * @param username
	 *            ：用户名
	 * @param password
	 *            ：密码
	 * @param phone
	 *            ：电话号码
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
	 * @param file
	 *            ：头像url
	 * @param sex
	 *            ：性别
	 * @param name
	 *            ：用户姓名
	 * @param school
	 *            ：学校
	 * @param phone
	 *            ：联系电话
	 */
	@RequestMapping(value = "/updatemsg")
	public @ResponseBody JsonResult userUpdate(
			Users users,
			@RequestParam(value = "file", required = false) MultipartFile[] file,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		String pathRoot = request.getSession().getServletContext()
				.getRealPath("");
		String path = "";
		List<String> listImagePath = new ArrayList<String>();
		for (MultipartFile mf : file) {
			if (!mf.isEmpty()) {
				// 生成uuid作为文件名称
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				// 获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType = mf.getContentType();
				// 获得文件后缀名称
				String imageName = contentType.substring(contentType
						.indexOf("/") + 1);
				path = "/images/users_images/" + uuid + "." + imageName;
				mf.transferTo(new File(pathRoot + path));
				String pString = "http://localhost:8080/ourmall/images/users_images/"
						+ uuid + "." + imageName;
				users.setPicurl(pString);
				listImagePath.add(pString);
			}
		}
		userServiceI.updaUserPass(users);
		users.setMsg("修改成功");
		JsonResult jsonResult = new JsonResult(users);
		return jsonResult;
	}

	/**
	 * 修改用户密码
	 * 
	 * @param password
	 *            ：旧密码
	 * @param newpass
	 *            :新密码
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
	 * 查看用户信息或收件人信息
	 * 
	 * @param userid
	 *            :用户表id
	 */
	@RequestMapping(value = "/showUserMsg")
	public @ResponseBody JsonResult showUserMsg(Users users) {

		JsonResult jsonResult = new JsonResult(userServiceI.getUserMsg(users
				.getUserid()));
		return jsonResult;
	}

	/**
	 * 查看用户订单 适用于全部订单页面userid
	 * 
	 * @param userid
	 *            :用户id
	 * @param stateInteger
	 *            ：1、显示已完成订单 2、显示未完成订单 3、显示待付款订单 4、显示待收货订单
	 */
	@RequestMapping(value = "/showUserOrder")
	public @ResponseBody JsonResult showUserOrder(Orders orders) {
		JsonResult jsonResult = new JsonResult(orderService.getOrders(orders));
		return jsonResult;
	}

	/**
	 * 实现通过订单号对订单表进行修改
	 * 
	 * @param display
	 *            =2 ：删除用户订单 传参数
	 * @param orderState
	 *            ："已完成" 确认收货 orderState:"待收货" 支付
	 * @param orderid订单号
	 * @return
	 */
	@RequestMapping(value = "/displayUserOrder")
	public @ResponseBody JsonResult displayUserOrder(Orders orders) {
		orders.setDisplay(2);
		JsonResult jsonResult = new JsonResult(orderService.deleteOrder(orders));
		return jsonResult;
	}

	/**
	 * 显示购物车商品列表
	 * 
	 * @param usergoods3
	 *            :代表用户ID
	 */
	@RequestMapping(value = "/showCart")
	public @ResponseBody JsonResult showCart(UserGoods userGoods) {
		JsonResult jsonResult = new JsonResult(
				userGoodsServiceI.showUserGoods(userGoods.getUsergoods3()));
		return jsonResult;
	}

	/**
	 * @param chiceInteger存在则生成订单
	 *            ，否则计算价格以json格式返回
	 * @param userid
	 *            :用户id
	 * @param usergoodid
	 *            用户商品id;
	 * @param List
	 *            <UserGoodCart> mGoodsCarts
	 * @param goodsid
	 *            :商品id；
	 * @param goodsnumbers
	 *            ：商品数量
	 * @param usergoodid
	 *            ：用户商品表id
	 * 
	 */
	@RequestMapping(value = "/addOrder")
	public @ResponseBody JsonResult addOrder(Item item) {
		item.setChiceInteger(1);
		List<UserGoodsCart> mGoodsCarts = new ArrayList<UserGoodsCart>();
		JSONArray jsonArray = JSONArray.fromObject(item.getMymGoodsCarts());
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonJ = jsonArray.getJSONObject(i);
			UserGoodsCart userGoodsCart = new UserGoodsCart();
			userGoodsCart.setGoodsid(jsonJ.getInt("goodsid"));
			userGoodsCart.setGoodsnumbers(jsonJ.getInt("goodsnumbers"));
			userGoodsCart.setUsergoodid(jsonJ.getInt("usergoodid"));
			mGoodsCarts.add(userGoodsCart);
		}
		System.out.println();
		item.setmGoodsCarts(mGoodsCarts);
		System.out.println(item.getmGoodsCarts().get(0).getGoodsnumbers());
		Item item2 = new Item();
		item2 = orderService.addOrder(item);
		JsonResult jsonResult = new JsonResult(item2);
		return jsonResult;
	}

	/**
	 * 显示指定订单信息
	 * 
	 * @param orderid
	 *            ：订单号
	 * @return
	 */
	@RequestMapping(value = "/showOrder")
	public @ResponseBody JsonResult showOrder(Integer orderid) {
		JsonResult jsonResult = new JsonResult(orderService.showOrder(orderid));
		return jsonResult;

	}

	/**
	 * 加入购物车
	 * 
	 * @param usergoods3
	 *            ：用户id
	 * @param goodid
	 *            ：商品id
	 */
	@RequestMapping(value = "/insertCart")
	public @ResponseBody JsonResult insertCartr(UserGoods userGoods) {
		JsonResult jsonResult = new JsonResult(
				userGoodsServiceI.insertCart(userGoods));
		return jsonResult;
	}

	/**
	 * 修改收件人地址信息
	 * 
	 * @param id
	 *            ：收件人地址表id
	 * @param userid
	 *            :用户id
	 * @param mainAddress
	 *            （必须有）：1为默认地址，0则不是
	 * 
	 * @param name
	 *            ：收件人姓名
	 * @param address
	 *            ：收件人地址
	 * @param phone
	 *            ：收件人电话
	 * @param school
	 *            ：收件人学校
	 */
	@RequestMapping(value = "/updateRecMsg")
	public @ResponseBody JsonResult updateRecMsg(ReceiveMsg receiveMsg) {
		JsonResult jsonResult = new JsonResult(
				userServiceI.updateReceiveMsg(receiveMsg));
		return jsonResult;
	}

	/**
	 * 删除收件人地址
	 * 
	 * @param id
	 *            :收件人地址表id
	 */
	@RequestMapping(value = "/delRecMsg")
	public @ResponseBody JsonResult delRecMsg(ReceiveMsg receiveMsg) {
		JsonResult jsonResult = new JsonResult(
				userServiceI.delReceiveMsg(receiveMsg));
		return jsonResult;
	}

	/**
	 * 新增收件人地址
	 * 
	 * @param mainAddress
	 *            :1则同时设为默认地址
	 * @param userid
	 *            （必须要）：用户id
	 * @param name
	 *            ：收件人姓名
	 * @param address
	 *            ：收件人地址
	 * @param phone
	 *            ：收件人电话
	 * @param school
	 *            ：收件人学校
	 */
	@RequestMapping(value = "/addRecMsg")
	public @ResponseBody JsonResult addRecMsg(ReceiveMsg receiveMsg) {
		ReceiveMsg receiveMsg2 = new ReceiveMsg();
		if (receiveMsg.getMainAddress() != null) {
			receiveMsg2 = userServiceI.addReceiveMsg(receiveMsg);
		} else {
			receiveMsg.setMainAddress(0);
			receiveMsg2 = userServiceI.addReceiveMsg(receiveMsg);
		}
		JsonResult jsonResult = new JsonResult(receiveMsg2);
		return jsonResult;
	}

	/**
	 * 修改地址（显示修改前的内容）
	 * 
	 * @param id
	 *            :收件人地址表id
	 */
	@RequestMapping(value = "/showRecMsg")
	public @ResponseBody JsonResult showRecMsg(ReceiveMsg receiveMsg) {
		JsonResult jsonResult = new JsonResult(
				userServiceI.showReceiveMsg(receiveMsg));
		return jsonResult;

	}

}
