package com.bang.mall.test;

import java.util.Calendar;

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
		Calendar calendar = Calendar.getInstance();
		Integer orderid =  (int) calendar.getTime().getTime();
		System.out.println(orderid);
		
	}
}
