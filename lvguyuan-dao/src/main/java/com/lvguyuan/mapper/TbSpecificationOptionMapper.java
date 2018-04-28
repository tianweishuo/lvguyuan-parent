package com.lvguyuan.mapper;

import com.lvguyuan.pojo.TbSpecificationOption;

import java.util.List;

public interface TbSpecificationOptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbSpecificationOption record);

    int insertSelective(TbSpecificationOption record);

    TbSpecificationOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSpecificationOption record);

    int updateByPrimaryKey(TbSpecificationOption record);

    List<TbSpecificationOption> findAllByspecId(Long specId);

    int deleteBySpecId(Long specId);
}