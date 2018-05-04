package com.lvguyuan.sellergoods.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lvguyuan.mapper.TbItemCatMapper;
import com.lvguyuan.mapper.TbSpecificationOptionMapper;
import com.lvguyuan.mapper.TbTypeTemplateMapper;
import com.lvguyuan.pojo.TbItemCat;
import com.lvguyuan.pojo.TbSpecificationOption;
import com.lvguyuan.pojo.TbTypeTemplate;
import com.lvguyuan.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 模板管理实现类
 * Date: 2018/4/25
 * Time: 15:09
 */
@Service("typeTemplateService")
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;


    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<TbTypeTemplate> findAll() {
        return typeTemplateMapper.findAll(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbTypeTemplate> list = (Page<TbTypeTemplate>)typeTemplateMapper.findAll(null);
        return new PageResult(list.getTotal(),list.getResult());
    }

    /**
     * 保存
     * @param typeTemplate
     */
    @Override
    public void add(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.insert(typeTemplate);
    }

    /**
     * 修改
     * @param typeTemplate
     */
    @Transactional
    @Override
    public void update(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.updateByPrimaryKeySelective(typeTemplate);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @Override
    public TbTypeTemplate findOne(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除
     * @param ids
     */
    @Transactional
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            typeTemplateMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 分页条件查询
     * @param typeTemplate
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageResult findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbTypeTemplate> list = (Page<TbTypeTemplate>)typeTemplateMapper.findAll(typeTemplate);
        return new PageResult(list.getTotal(),list.getResult());
    }

    /**
     * 根据模板ID查询规格列表
     * @param id
     * @return
     */
    @Override
    public List<Map> findSpecList(Long id) {
        //查询模板
        TbTypeTemplate typeTemplate = typeTemplateMapper.selectByPrimaryKey(id);
        List<Map> list = JSON.parseArray(typeTemplate.getSpecIds(),Map.class);
        for(Map map:list){
            //查询规格选项列表
            List<TbSpecificationOption> options = specificationOptionMapper.findAllByspecId(new Long((Integer) map.get("id")));
            map.put("options",options);
        }
        return list;
    }

}
