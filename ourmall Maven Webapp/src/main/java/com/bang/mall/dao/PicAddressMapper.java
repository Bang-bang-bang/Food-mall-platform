package com.bang.mall.dao;

import java.util.List;

import com.bang.mall.domain.PicAddress;

public interface PicAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PicAddress record);

    int insertSelective(PicAddress record);

    PicAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PicAddress record);

    int updateByPrimaryKey(PicAddress record);
    
    List<PicAddress> selectByGoodsKey(Integer id);
}