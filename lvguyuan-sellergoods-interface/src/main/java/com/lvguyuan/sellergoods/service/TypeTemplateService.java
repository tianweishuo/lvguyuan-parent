package com.lvguyuan.sellergoods.service;

import com.lvguyuan.pojo.TbTypeTemplate;
import entity.PageResult;

import java.util.List;

/**
 * 模板管理接口
 * Date: 2018/4/25
 * Time: 15:09
 */
public interface TypeTemplateService {

    /**
     * 返回全部列表
     * @return
     */
    List<TbTypeTemplate> findAll();

    /**
     * 返回分页列表
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加
     */
    void add(TbTypeTemplate tbTypeTemplate);

    /**
     * 修改
     */
    void update(TbTypeTemplate tbTypeTemplate);

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    TbTypeTemplate findOne(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void delete(Long [] ids);

    /**
     * 分页
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(TbTypeTemplate tbTypeTemplate, int pageNum, int pageSize);


}
