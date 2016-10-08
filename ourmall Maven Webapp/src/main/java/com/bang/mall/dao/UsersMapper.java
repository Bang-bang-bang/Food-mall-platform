package com.bang.mall.dao;

import java.util.List;

import com.bang.mall.domain.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    List<Users> userLogin(Users user);
    
    List<Users> selectUsers();
    
    Users checkPassword(Users userid);
    
    List<Users> selectIsExistUsers(Users users);
}