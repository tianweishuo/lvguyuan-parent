package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbSpecification;

import java.util.List;

public interface TbSpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbSpecification record);

    int insertSelective(TbSpecification record);

    TbSpecification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSpecification record);

    int updateByPrimaryKey(TbSpecification record);

    List<TbSpecification> findAll(TbSpecification tbSpecification);
}