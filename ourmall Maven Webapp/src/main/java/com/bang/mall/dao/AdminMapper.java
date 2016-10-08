package com.bang.mall.dao;

import java.util.List;

import com.bang.mall.domain.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    List<Admin> selectAdmin();
    
    List<Admin> selectIsEmplyAdmin(Admin admin);
    
    List<Admin> selectIsExistAdmin(Admin admin);
}