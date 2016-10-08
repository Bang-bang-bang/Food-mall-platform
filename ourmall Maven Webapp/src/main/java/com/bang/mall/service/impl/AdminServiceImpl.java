package com.bang.mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bang.mall.dao.AdminMapper;
import com.bang.mall.domain.Admin;
import com.bang.mall.service.AdminServiceI;

@Service
public class AdminServiceImpl implements AdminServiceI {
	@Autowired
	private AdminMapper adminMapper;

	public Admin insertAdmin(Admin admin) {
		admin.setCreateTime(new Date());
		admin.setPower(2);
		if (adminMapper.selectIsExistAdmin(admin).size() > 0) {
			admin.setMsg("用户已存在");
		} else {
			adminMapper.insertSelective(admin);
			admin.setMsg("添加成功");
		}
		return admin;
	}

	public int updateAdmin(Admin admin) {

		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	public List<Admin> showAdmins() {

		return adminMapper.selectAdmin();
	}

	public Admin showAdmin(Integer id) {

		return adminMapper.selectByPrimaryKey(id);
	}

	public Admin adminLogin(Admin admin) {
		if (adminMapper.selectIsEmplyAdmin(admin).size() > 0) {
			admin.setMsg("登录成功");
		} else {
			admin.setMsg("登录失败");
		}
		return admin;
	}

}
