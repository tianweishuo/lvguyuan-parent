package com.lvguyuan.sellergoods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lvguyuan.mapper.TbBrandMapper;
import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.sellergoods.service.BrandService;
import entity.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService{

    private static Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private TbBrandMapper brandMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<TbBrand> findAll() {
        logger.info("传入{}信息","被调用");
        List<TbBrand> list = brandMapper.findAll(null);
        return list;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.findAll(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 分页条件查询
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.findAll(tbBrand);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 增加
     * @param tbBrand
     */
    @Transactional
    @Override
    public void add(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新数据
     * @param tbBrand
     */
    @Override
    public void update(TbBrand tbBrand) {
        brandMapper.updateByPrimaryKey(tbBrand);
    }

    /**
     * 删除或批量
     * @param ids
     */
    @Transactional
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }
    }
}
