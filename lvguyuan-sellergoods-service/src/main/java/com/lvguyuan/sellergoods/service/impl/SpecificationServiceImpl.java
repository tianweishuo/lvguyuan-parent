package com.lvguyuan.sellergoods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lvguyuan.mapper.TbSpecificationMapper;
import com.lvguyuan.mapper.TbSpecificationOptionMapper;
import com.lvguyuan.pojo.TbSpecification;
import com.lvguyuan.pojo.TbSpecificationOption;
import com.lvguyuan.pojogrop.Specification;
import com.lvguyuan.sellergoods.service.SpecificationService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 规格服务
 * Date: 2018/4/24
 * Time: 10:14
 */
@Service("specificationService")
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    /**
     * 返回全部列表
     * @return
     */
    @Override
    public List<TbSpecification> findAll() {
        return specificationMapper.findAll(null);
    }

    /**
     * 返回分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbSpecification> list =(Page<TbSpecification>)specificationMapper.findAll(null);
        return new PageResult(list.getTotal(),list.getResult());
    }

    /**
     * 增加
     * @param specification
     */
    @Transactional
    @Override
    public void add(Specification specification) {
        //获取规格
        TbSpecification tbSpecification = specification.getSpecification();
        specificationMapper.insert(tbSpecification);
        //获取规格选项集合
        List<TbSpecificationOption> list = specification.getSpecificationOptionList();
        for(TbSpecificationOption specificationOption :list){
            specificationOption.setSpecId(tbSpecification.getId());//设置规格ID
            specificationOptionMapper.insert(specificationOption);//新增规格
        }

    }

    /**
     * 修改
     * @param specification
     */
    @Transactional
    @Override
    public void update(Specification specification) {
        //修改规格表
        TbSpecification tbSpecification = specification.getSpecification();
        specificationMapper.updateByPrimaryKey(tbSpecification);
        //修改规格明细表
        List<TbSpecificationOption> tbSpecificationOptionList = specification.getSpecificationOptionList();
        //先全部删除，在新增
        specificationOptionMapper.deleteBySpecId(tbSpecification.getId());
        for(TbSpecificationOption tbSpecificationOption: tbSpecificationOptionList){
            tbSpecificationOption.setSpecId(tbSpecification.getId());
            specificationOptionMapper.insert(tbSpecificationOption);
        }
    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Specification findOne(Long id) {
        Specification specification = new Specification();
        //获取规格实体并设置转换对象
        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
        specification.setSpecification(tbSpecification);
        //规格选项列表
        List<TbSpecificationOption> tbSpecificationOptionList = specificationOptionMapper.findAllByspecId(tbSpecification.getId());
        specification.setSpecificationOptionList(tbSpecificationOptionList);
        return specification;
    }

    /**
     * 批量删除
     * @param ids
     */
    @Transactional
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            specificationMapper.deleteByPrimaryKey(id);
            specificationOptionMapper.deleteBySpecId(id);
        }
    }

    /**
     * 分页
     * @param tbSpecification
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageResult findPage(TbSpecification tbSpecification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbSpecification> list = (Page<TbSpecification>)specificationMapper.findAll(tbSpecification);
        return new PageResult(list.getTotal(),list.getResult());
    }
}
