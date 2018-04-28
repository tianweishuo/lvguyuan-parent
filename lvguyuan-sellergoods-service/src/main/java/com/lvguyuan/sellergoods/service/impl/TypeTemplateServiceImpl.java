package com.lvguyuan.sellergoods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lvguyuan.mapper.TbTypeTemplateMapper;
import com.lvguyuan.pojo.TbTypeTemplate;
import com.lvguyuan.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 模板管理实现类
 * Date: 2018/4/25
 * Time: 15:09
 */
@Service("typeTemplateService")
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

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

    @Override
    public void add(TbTypeTemplate tbTypeTemplate) {
        
    }

    @Override
    public void update(TbTypeTemplate tbTypeTemplate) {

    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbTypeTemplate tbTypeTemplate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbTypeTemplate> list = (Page<TbTypeTemplate>)typeTemplateMapper.findAll(tbTypeTemplate);
        return new PageResult(list.getTotal(),list.getResult());
    }
}
