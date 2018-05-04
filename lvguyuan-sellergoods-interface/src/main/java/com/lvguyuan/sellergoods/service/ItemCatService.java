package com.lvguyuan.sellergoods.service;

import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.pojo.TbItemCat;
import entity.PageResult;

import java.util.List;

/**
 * 商品分类
 * Date: 2018/5/2
 * Time: 15:22
 */
public interface ItemCatService {
    /**
     * 查询全部
     * @return
     */
    List<TbItemCat> findAll();

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 分页条件查询
     * @param itemCat
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(TbItemCat itemCat,int pageNum,int pageSize);

    /**
     * 增加
     * @param itemCat
     */
    void add(TbItemCat itemCat);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    TbItemCat findOne(Long id);

    /**
     * 修改
     * @param itemCat
     */
    void update(TbItemCat itemCat);

    /**
     * 批量删除
     * @param ids
     */
    void delete(Long[] ids);

    List<TbItemCat> findByParentId(Long parentId);
}
