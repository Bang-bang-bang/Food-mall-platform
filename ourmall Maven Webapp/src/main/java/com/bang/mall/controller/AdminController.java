package com.bang.mall.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bang.mall.commons.JsonResult;
import com.bang.mall.domain.Admin;
import com.bang.mall.domain.DetailPic;
import com.bang.mall.domain.Goods;
import com.bang.mall.domain.Orders;
import com.bang.mall.domain.PicAddress;
import com.bang.mall.service.AdminServiceI;
import com.bang.mall.service.GoodsServiceI;
import com.bang.mall.service.OrderServiceI;

/**
 * 
 * @author lilingyong
 * @deprecated 本类全为json数据返回 若改字符串返回，则需在构造方法参数中加HttpServletRequest request 方法体中加
 *             request.setAttribute("key", Object);
 *
 */

@Controller
@RequestMapping("/adminController")
public class AdminController extends BaseController<Orders> {
	@Autowired
	private OrderServiceI orderServiceI;
	@Autowired
	private GoodsServiceI goodsServiceI;
	@Autowired
	private AdminServiceI adminServiceI;

	/**
	 * 显示订单列表
	 * 
	 * @param stateInteger
	 *            不取值 ，显示所有订单 
	 *            1、stateInteger为1时，显示已完成订单
	 *            2、stateInteger为2时，显示已取消订单 
	 *            3、stateInteger为3时，显示待付款订单
	 *            4、stateInteger为4时，显示待发货订单
	 * @return
	 */
	@RequestMapping(value = "/showAllOrder")
	public @ResponseBody JsonResult showAllOrders(Orders orders) {
		JsonResult jsonResult = new JsonResult(
				orderServiceI.selectAllOrders(orders));
		return jsonResult;
	}

	/**
	 * 显示指定订单信息
	 * 
	 * @param id
	 *            :订单表主键id
	 * @return
	 */
	@RequestMapping(value = "/showOrderByPrimaryKey")
	public @ResponseBody JsonResult showOrder(Integer id) {
		JsonResult jsonResult = new JsonResult(orderServiceI.showOrderByid(id));
		return jsonResult;
	}

	/**
	 * 修改指定订单信息
	 * 
	 * @param recname
	 *            :收件人姓名
	 * @param recphone
	 *            :收件人电话
	 * @param recaddress
	 *            :收件人地址
	 * @param goodsTotalprice
	 *            :总价格
	 * @param orderState
	 *            :订单状态
	 * @return
	 */
	@RequestMapping(value = "/updateByPrimaryKeySelective")
	public @ResponseBody JsonResult updateByPrimaryKeySelective(Orders orders) {
		JsonResult jsonResult = new JsonResult(
				orderServiceI.updateByPrimaryKeySelective(orders));
		return jsonResult;
	}

	/**
	 * 通过传入商品list修改商品库存
	 * 
	 * @param goodslList
	 *            :商品列表名
	 * @param goodsid
	 *            :商品id
	 * @param goodsTotal
	 *            :商品库存
	 * @return
	 */
	@RequestMapping(value = "/updateGoodsNumbers")
	public @ResponseBody JsonResult updateGoodsNumbers(List<Goods> goodslList) {
		List<Goods> mGoodsList = new ArrayList<Goods>();
		JSONArray jsonArray = JSONArray.fromObject(goodslList);
		if (goodslList != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Goods goods = new Goods();
				goods.setGoodsid(jsonObject.getInt("goodsid"));
				goods.setGoodsTotal(jsonObject.getInt("goodsTotal"));
				mGoodsList.add(goods);
			}
		}
		goodsServiceI.updateGoods(mGoodsList);
		JsonResult jsonResult = new JsonResult(mGoodsList);
		return jsonResult;
	}

	/**
	 * 修改商品信息
	 * 
	 * @param goodsName
	 *            :商品名称
	 * @param goodsClass
	 *            ：商品类别
	 * @param goodsBornPlace
	 *            :商品原产地
	 * @param goodsBornTime
	 *            :生产日期以及有效期
	 * @param goodsPrice
	 *            :商品价格
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping(value = "/updateGoodsMsg", method = RequestMethod.POST)
	public @ResponseBody JsonResult updateGoodsMsg(
			Goods goods,
			@RequestParam(value = "file", required = false) MultipartFile[] file,
			@RequestParam(value = "file1", required = false) MultipartFile[] file1,
			HttpServletRequest request) throws IllegalStateException,
			IOException {

		// 获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext()
				.getRealPath("");
		String path = "";
		List<String> listImagePath = new ArrayList<String>();
		goodsServiceI.insertGoods(goods);
		List<Goods> lGoods = goodsServiceI.showOrSortGoods(goods);
		for (MultipartFile mf : file) {
			if (!mf.isEmpty()) {
				goodsServiceI.deletePicAddress(goods.getGoodsid());
				PicAddress picAddress = new PicAddress();
				picAddress.setPicaddid(lGoods.get(0).getGoodsid());
				// 生成uuid作为文件名称
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				// 获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType = mf.getContentType();
				// 获得文件后缀名称
				String imageName = contentType.substring(contentType
						.indexOf("/") + 1);
				path = "/images/goods_images/" + uuid + "." + imageName;
				mf.transferTo(new File(pathRoot + path));
				String pString = "http://localhost:8080/ourmall/images/goods_images/"
						+ uuid + "." + imageName;
				picAddress.setAddress(pString);
				goodsServiceI.insertGoodsPicAddress(picAddress);
				listImagePath.add(pString);
			}
		}
		for (MultipartFile mf : file1) {
			if (!mf.isEmpty()) {
				goodsServiceI.deleteDetailPicAddress(goods.getGoodsid());
				DetailPic detailPic = new DetailPic();
				detailPic.setPicdtid(lGoods.get(0).getGoodsid());
				// 生成uuid作为文件名称
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				// 获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType = mf.getContentType();
				// 获得文件后缀名称
				String imageName = contentType.substring(contentType
						.indexOf("/") + 1);
				path = "/images/goods_images/" + uuid + "." + imageName;
				mf.transferTo(new File(pathRoot + path));
				String pString = "http://localhost:8080/ourmall/images/goods_images/"
						+ uuid + "." + imageName;
				detailPic.setAddress(pString);
				goodsServiceI.insertGoodsDetailPic(detailPic);
				listImagePath.add(pString);
			}
		}
		JsonResult jsonResult = new JsonResult(goodsServiceI.updateGoods(goods));
		return jsonResult;
	}

	/**
	 * 添加管理员
	 * 
	 * @param username
	 *            :用户名
	 * @param password
	 *            ：密码
	 * @param sex
	 *            ：性别
	 * @param phone
	 *            ：电话
	 */
	@RequestMapping(value = "/addAdmin")
	public @ResponseBody JsonResult addAdmin(Admin admin, HttpSession session) {
		return new JsonResult(adminServiceI.insertAdmin(admin));
	}

	/**
	 * 修改管理员信息
	 * 
	 * @param username
	 *            ：用户名
	 * @param password
	 *            ：密码
	 * @param sex
	 *            ：性别
	 * @param phone
	 *            ：电话
	 *
	 */
	@RequestMapping(value = "/updateAdmin")
	public @ResponseBody JsonResult updateAdmin(Admin admin) {
		return new JsonResult(adminServiceI.updateAdmin(admin));
	}

	/**
	 * 显示管理员信息
	 * 
	 */
	@RequestMapping(value = "/listAdmin")
	public @ResponseBody JsonResult listAdmin() {
		return new JsonResult(adminServiceI.showAdmins());
	}

	/**
	 * 显示指定管理员信息
	 * 
	 * @param id
	 *            ：用户表id
	 */
	@RequestMapping(value = "/showAdmin")
	public @ResponseBody JsonResult showAdmin(Integer id) {
		return new JsonResult(adminServiceI.showAdmin(id));
	}

	/**
	 * 管理员登录
	 * 
	 * @param username
	 *            ：用户名
	 * @param password
	 *            ：密码
	 */
	@RequestMapping(value = "/adminLogin")
	public @ResponseBody JsonResult adminLogin(Admin admin) {
		return new JsonResult(adminServiceI.adminLogin(admin));
	}
}
