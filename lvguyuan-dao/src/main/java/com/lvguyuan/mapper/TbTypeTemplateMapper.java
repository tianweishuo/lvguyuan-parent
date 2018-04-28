package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbTypeTemplate;

import java.util.List;

public interface TbTypeTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbTypeTemplate record);

    int insertSelective(TbTypeTemplate record);

    TbTypeTemplate selectByPrimaryKey(Long id);

    List<TbTypeTemplate> findAll(TbTypeTemplate tbTypeTemplate);

    int updateByPrimaryKeySelective(TbTypeTemplate record);

    int updateByPrimaryKey(TbTypeTemplate record);
}