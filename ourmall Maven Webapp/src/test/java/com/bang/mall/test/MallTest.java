package com.bang.mall.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bang.mall.service.UserServiceI;

public class MallTest {
	private ApplicationContext ac;
	private UserServiceI userServiceI;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml",
				"spring-mybatis.xml" });
		userServiceI = (UserServiceI) ac.getBean("userBean");
	}

	@Test
	public void MyTest() {
		System.out.println(8888);
		System.out.println(userServiceI.getUser(1).getSchool());
	}
}
