package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbFreightTemplate;

public interface TbFreightTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbFreightTemplate record);

    int insertSelective(TbFreightTemplate record);

    TbFreightTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbFreightTemplate record);

    int updateByPrimaryKey(TbFreightTemplate record);
}