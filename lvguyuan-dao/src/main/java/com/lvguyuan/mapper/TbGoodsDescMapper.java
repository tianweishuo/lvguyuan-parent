package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbGoodsDesc;

public interface TbGoodsDescMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(TbGoodsDesc record);

    int insertSelective(TbGoodsDesc record);

    TbGoodsDesc selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(TbGoodsDesc record);

    int updateByPrimaryKey(TbGoodsDesc record);
}