package com.bang.mall.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bang.mall.commons.MallStatus;
import com.bang.mall.domain.Goods;
import com.bang.mall.domain.Users;
import com.bang.mall.service.GoodsServiceI;
import com.bang.mall.service.UserServiceI;

public class MallTest {
	private ApplicationContext ac;
	private UserServiceI userServiceI;
	private GoodsServiceI goodsServiceI;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml",
				"spring-mybatis.xml" });
		userServiceI = (UserServiceI) ac.getBean("userBean");
		goodsServiceI = (GoodsServiceI) ac.getBean("goodsBean");
	}

	@Test
	public void MyTest() {
		Users users = new Users();
		Goods goods = new Goods();
		goods.setGoodsName("瓜");
		//goods.setSellInteger(MallStatus.PRICE_ASC);
		
		goods.setPriceInteger(MallStatus.PRICE_ASC);
		System.out.println(goodsServiceI.showOrSortGoods(goods).get(1).getGoodsName());
		
	}
}
