package com.lvguyuan.sellergoods.service;


import com.lvguyuan.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

public interface BrandService {

    /**
     * 查询全部
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum,int pageSize);

    /**
     * 分页条件查询
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);

    /**
     * 增加
     * @param tbBrand
     */
    void add(TbBrand tbBrand);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    TbBrand findOne(Long id);

    /**
     * 修改
     * @param tbBrand
     */
    void update(TbBrand tbBrand);

    /**
     * 批量删除
     * @param ids
     */
    void delete(Long[] ids);
}
