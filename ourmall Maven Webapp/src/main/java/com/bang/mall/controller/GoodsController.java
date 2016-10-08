package com.bang.mall.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bang.mall.commons.JsonResult;
import com.bang.mall.domain.DetailPic;
import com.bang.mall.domain.Goods;
import com.bang.mall.domain.IndexItem;
import com.bang.mall.domain.PicAddress;
import com.bang.mall.service.GoodsServiceI;

/**
 * 
 * @author lilingyong
 * @deprecated 本类全为json数据返回 若改字符串返回，则需在构造方法参数中加HttpServletRequest request 方法体中加
 *             request.setAttribute("key", Object);
 *
 */

@Controller
@RequestMapping("/goodsController")
public class GoodsController extends BaseController<Goods> {
	@Autowired
	private GoodsServiceI goodsServiceI;

	/**
	 * 首页商品展示
	 */
	@RequestMapping(value = "/showIndex")
	public @ResponseBody JsonResult showIndex(Goods goods) {
		IndexItem indexItem = new IndexItem();
		Goods goods3 = new Goods();
		goods3.setSellInteger(1);
		indexItem.setmNewGoods(goodsServiceI.showOrSortGoods(goods));
		indexItem.setmSellGoods(goodsServiceI.showOrSortGoods(goods3));
		JsonResult jsonResult = new JsonResult(indexItem);
		return jsonResult;
	}

	/**
	 * showAllGoods 全部商品搜索、排序均可实现 需要参数如下：
	 * 
	 * @param goodsName
	 *            模糊查询条件
	 * @param priceInteger
	 *            按价格排序 1：降序 2：升序
	 * @param sellInteger
	 *            按购买人数排序 1:降序 2：升序 sellInteger 和 priceInteger 不能同时赋值
	 *            无参数赋值默认最新发布靠前
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping(value = "/showAllGoods")
	public @ResponseBody JsonResult showAllGoods(Goods goods) {
		System.out.println(goods.getGoodsName());
		JsonResult jsonResult = new JsonResult(
				goodsServiceI.showOrSortGoods(goods));
		return jsonResult;
	}

	/**
	 * showDetail 通过商品id查询商品详细信息 需要参数goodsid
	 */
	@RequestMapping(value = "/showDetailGoods")
	public @ResponseBody JsonResult showDetailGoods(Goods goods) {
		Goods goods2 = goodsServiceI.showGoods(goods.getGoodsid());
		JsonResult jsonResult = new JsonResult(goods2);
		return jsonResult;
	}

	/**
	 * 按分类显示
	 * 
	 * @param goodsClass
	 *            ：商品类别
	 * @param priceInteger
	 *            按价格排序 1：降序 2：升序
	 * @param sellInteger
	 *            按购买人数排序 1:降序 2：升序
	 */
	@RequestMapping(value = "/showAllGoodsByClass")
	public @ResponseBody JsonResult showAllGoodsByClass(Goods goods) {
		JsonResult jsonResult = new JsonResult(
				goodsServiceI.showClassOrSortGoods(goods));
		return jsonResult;
	}

	/**
	 * 
	 * @param goods
	 * @param goodsName
	 *            :商品名
	 * @param goodsTotal
	 *            :库存数量
	 * @param goodsDetals
	 *            ：商品详情（文字）
	 * @param goodsClass
	 *            ：商品类别
	 * @param goodsBornPlace
	 *            ：商品原产地
	 * @param goodsPrice
	 *            ：商品售价
	 * @param goodsBornTime
	 *            ：商品有效期
	 * @param file
	 *            商品图片文件
	 * @param file1
	 *            商品图片详情文件
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	private String fildUpload(
			Goods goods,
			@RequestParam(value = "file", required = false) MultipartFile[] file,
			@RequestParam(value = "file1", required = false) MultipartFile[] file1,
			HttpServletRequest request) throws Exception {
		// 获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext()
				.getRealPath("");
		String path = "";
		List<String> listImagePath = new ArrayList<String>();
		goodsServiceI.insertGoods(goods);
		List<Goods> lGoods = goodsServiceI.showOrSortGoods(goods);
		for (MultipartFile mf : file) {
			if (!mf.isEmpty()) {
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
		System.out.println(path);
		request.setAttribute("imagesPathList", listImagePath);
		return "goods_upload";
	}
}
