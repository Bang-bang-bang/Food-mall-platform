package com.bang.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController<E> {
	@ModelAttribute  
	public void init(HttpServletRequest request,HttpServletResponse response,Model model){
		//验证用户是否有权限访问
	}
}
