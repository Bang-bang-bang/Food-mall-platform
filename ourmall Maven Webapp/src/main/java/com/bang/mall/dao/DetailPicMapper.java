package com.bang.mall.dao;

import java.util.List;

import com.bang.mall.domain.DetailPic;

public interface DetailPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DetailPic record);

    int insertSelective(DetailPic record);

    DetailPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DetailPic record);

    int updateByPrimaryKey(DetailPic record);
    
    List<DetailPic> selectByGoodsKey(Integer id);
    
    int deleteByGoodsKey(Integer id);
}