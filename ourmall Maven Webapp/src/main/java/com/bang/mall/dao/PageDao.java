package com.bang.mall.dao;

import java.util.List;

public interface PageDao<E> {
	/*
	 * 获得总记录数
	 */
	public int getAllRowCount();

	// 分页查询用户订单信息
	public List<E> getAllOrder(int offset, int length);

	// 获得总记录
	public int totalCount();

	// 分页查询信息
	public List<E> queryForPage(int offset, int length, int userID);

}
