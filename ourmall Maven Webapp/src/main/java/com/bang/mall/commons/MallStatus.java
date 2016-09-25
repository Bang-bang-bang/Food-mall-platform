package com.bang.mall.commons;

public class MallStatus {

	public static Integer PRICE_DESC = 1;// 价格降序
	public static Integer PRICE_ASC = 2;// 价格升序
	public static Integer SELL_DESC = 1;// 销量降序
	public static Integer SELL_ASC = 2;// 销量升序
	public static Integer getPRICE_DESC() {
		return PRICE_DESC;
	}
	public static void setPRICE_DESC(Integer pRICE_DESC) {
		PRICE_DESC = pRICE_DESC;
	}
	public static Integer getPRICE_ASC() {
		return PRICE_ASC;
	}
	public static void setPRICE_ASC(Integer pRICE_ASC) {
		PRICE_ASC = pRICE_ASC;
	}
	public static Integer getSELL_DESC() {
		return SELL_DESC;
	}
	public static void setSELL_DESC(Integer sELL_DESC) {
		SELL_DESC = sELL_DESC;
	}
	public static Integer getSELL_ASC() {
		return SELL_ASC;
	}
	public static void setSELL_ASC(Integer sELL_ASC) {
		SELL_ASC = sELL_ASC;
	}

}
