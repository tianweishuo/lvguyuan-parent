package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbSeller;

public interface TbSellerMapper {
    int deleteByPrimaryKey(String sellerId);

    int insert(TbSeller record);

    int insertSelective(TbSeller record);

    TbSeller selectByPrimaryKey(String sellerId);

    int updateByPrimaryKeySelective(TbSeller record);

    int updateByPrimaryKey(TbSeller record);
}