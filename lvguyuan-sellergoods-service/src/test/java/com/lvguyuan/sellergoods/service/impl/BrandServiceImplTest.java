package com.lvguyuan.sellergoods.service.impl;

import com.alibaba.fastjson.JSON;
import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.sellergoods.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA
 * Created By Kinsey
 * Date: 2018/4/23
 * Time: 12:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml"})
public class BrandServiceImplTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void findAll() {
    }

    @Test
    public void findPage() {
        TbBrand tbBrand = new TbBrand();
        tbBrand.setName("华为");
        System.out.print(JSON.toJSON(brandService.findPage(tbBrand,1,20)));
    }

    @Test
    public void add() {
        TbBrand tbBrand = new TbBrand();
        tbBrand.setName("1");
        tbBrand.setFirstChar("2");
        brandService.add(tbBrand);
    }

    @Test
    public void findOne() {
        TbBrand tbBrand = brandService.findOne(1l);
        System.out.print(JSON.toJSON(tbBrand));
    }

    @Test
    public void update() {
    }
}