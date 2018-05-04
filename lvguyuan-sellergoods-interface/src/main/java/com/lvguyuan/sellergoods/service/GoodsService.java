package com.lvguyuan.sellergoods.service;

import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.pojogrop.Goods;
import entity.PageResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Kinsey
 * Date: 2018/5/2
 * Time: 20:40
 */
public interface GoodsService {
    /**
     * 查询全部
     * @return
     */
    List<Goods> findAll();

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 分页条件查询
     * @param goods
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(Goods goods, int pageNum, int pageSize);

    /**
     * 增加
     * @param goods
     */
    void add(Goods goods);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Goods findOne(Long id);

    /**
     * 修改
     * @param goods
     */
    void update(Goods goods);

    /**
     * 批量删除
     * @param ids
     */
    void delete(Long[] ids);
}
