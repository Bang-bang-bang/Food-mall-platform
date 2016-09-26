package com.bang.mall.dao;

import java.util.List;

import com.bang.mall.domain.ReceiveMsg;

public interface ReceiveMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveMsg record);

    int insertSelective(ReceiveMsg record);

    ReceiveMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceiveMsg record);

    int updateByPrimaryKey(ReceiveMsg record);
    
    List<ReceiveMsg> selectByUserKey(Integer id);
}