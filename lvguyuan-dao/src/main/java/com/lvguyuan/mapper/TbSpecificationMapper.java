package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbSpecification;

import java.util.List;
import java.util.Map;

public interface TbSpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbSpecification record);

    int insertSelective(TbSpecification record);

    TbSpecification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSpecification record);

    int updateByPrimaryKey(TbSpecification record);

    List<TbSpecification> findAll(TbSpecification tbSpecification);

    /**
     * 规格下拉列表
     * @return
     */
    List<Map> selectOptionList();
}