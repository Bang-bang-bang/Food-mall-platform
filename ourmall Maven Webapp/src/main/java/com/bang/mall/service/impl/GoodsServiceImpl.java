package com.bang.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.commons.MallStatus;
import com.bang.mall.dao.DetailPicMapper;
import com.bang.mall.dao.GoodsMapper;
import com.bang.mall.dao.OrdersMapper;
import com.bang.mall.dao.PicAddressMapper;
import com.bang.mall.domain.DetailPic;
import com.bang.mall.domain.Goods;
import com.bang.mall.domain.Orders;
import com.bang.mall.domain.PicAddress;
import com.bang.mall.service.GoodsServiceI;

@Service("goodsBean")
public class GoodsServiceImpl implements GoodsServiceI {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private PicAddressMapper picAddressMapper;
	@Autowired
	private DetailPicMapper detailPicMapper;

	public List<Goods> getHotGoods() {

		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getNewGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public Goods showGoods(Integer goodsid) {
		Goods mGoods = goodsMapper.selectByPrimaryKey(goodsid);
		List<DetailPic> mDetailPics = detailPicMapper.selectByGoodsKey(goodsid);
		List<PicAddress> mAddresses = picAddressMapper
				.selectByGoodsKey(goodsid);
		mGoods.setmAddresses(mAddresses);
		mGoods.setmDetailPics(mDetailPics);
		return mGoods;
	}

	public int delGoods(Integer goodsid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Goods> getSelectGoods(String goodsname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescSelGoods(String goodsname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescPriceGoods(String goodsname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescSelGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> getDescPriceGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 全部商品或搜索
	 */
	public List<Goods> showOrSortGoods(Goods goods) {
		List<Goods> mGoods = goodsMapper.selectByGoodsPropertyOrSort(goods);
		for (int i = 0; i < mGoods.size(); i++) {
			List<DetailPic> mDetailPics = detailPicMapper
					.selectByGoodsKey(mGoods.get(i).getGoodsid());
			List<PicAddress> mAddresses = picAddressMapper
					.selectByGoodsKey(mGoods.get(i).getGoodsid());
			mGoods.get(i).setmDetailPics(mDetailPics);
			mGoods.get(i).setmAddresses(mAddresses);
		}
		return mGoods;
	}

	/**
	 * 分类查看所有商品
	 */
	public List<Goods> showClassOrSortGoods(Goods goods) {
		List<Goods> mGoods = goodsMapper.selectByGoodsClassOrSort(goods);
		for (int i = 0; i < mGoods.size(); i++) {
			List<DetailPic> mDetailPics = detailPicMapper
					.selectByGoodsKey(mGoods.get(i).getGoodsid());
			List<PicAddress> mAddresses = picAddressMapper
					.selectByGoodsKey(mGoods.get(i).getGoodsid());
			mGoods.get(i).setmDetailPics(mDetailPics);
			mGoods.get(i).setmAddresses(mAddresses);
		}
		return mGoods;
	}

	/**
	 * 添加商品
	 */
	public int insertGoods(Goods goods) {
		return goodsMapper.insertSelective(goods);
	}

	/**
	 * 添加商品图片信息
	 */
	public int insertGoodsPicAddress(PicAddress picAddress) {
		return picAddressMapper.insertSelective(picAddress);
	}

	/**
	 * 添加商品详情图片信息
	 */
	public int insertGoodsDetailPic(DetailPic detailPic) {
		return detailPicMapper.insertSelective(detailPic);
	}

	/**
	 * 修改所有商品信息
	 */
	public int updateGoods(List<Goods> goods) {
		if (goods != null) {
			for (int i = 0; i < goods.size(); i++) {
				goodsMapper.updateByPrimaryKeySelective(goods.get(i));
			}
		}
		return 1;
	}

	/**
	 * 修改单个商品信息
	 */
	public int updateGoods(Goods goods) {
		
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}

	/**
	 * 删除详细信息图片地址
	 */
	public int deleteDetailPicAddress(Integer id) {
		
		return detailPicMapper.deleteByGoodsKey(id);
	}

	/**
	 * 删除图片地址
	 */
	public int deletePicAddress(Integer id) {
		
		return picAddressMapper.deleteByGoodsKey(id);
	}

}
