package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbProvinces;

public interface TbProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbProvinces record);

    int insertSelective(TbProvinces record);

    TbProvinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbProvinces record);

    int updateByPrimaryKey(TbProvinces record);
}