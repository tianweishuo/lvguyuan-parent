package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbBrand;

import java.util.List;

public interface TbBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbBrand record);

    int insertSelective(TbBrand record);

    TbBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbBrand record);

    int updateByPrimaryKey(TbBrand record);

    List<TbBrand> findAll(TbBrand tbBrand);
}