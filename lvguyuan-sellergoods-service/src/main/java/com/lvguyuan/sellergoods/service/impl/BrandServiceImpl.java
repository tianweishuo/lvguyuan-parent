package com.lvguyuan.sellergoods.service.impl;

import com.lvguyuan.mapper.TbBrandMapper;
import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.sellergoods.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService{

    private static Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        logger.info("传入{}信息","被调用");
        List<TbBrand> list = tbBrandMapper.selectByExample(null);
        return list;
    }
}
