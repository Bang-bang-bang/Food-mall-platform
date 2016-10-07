package com.bang.mall.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController<E> {
	@ModelAttribute  
	public void init(HttpServletRequest request,HttpSession session, HttpServletResponse response,Model model){
		//验证用户是否有权限访问
		response.setCharacterEncoding("utf-8");

		try {
			request.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
