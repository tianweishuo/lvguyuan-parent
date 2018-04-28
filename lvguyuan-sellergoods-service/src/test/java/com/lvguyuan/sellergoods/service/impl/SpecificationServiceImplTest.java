package com.lvguyuan.sellergoods.service.impl;

import com.lvguyuan.sellergoods.service.SpecificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA
 * Created By Kinsey
 * Date: 2018/4/24
 * Time: 21:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml"})
public class SpecificationServiceImplTest {

    @Autowired
    private SpecificationService specificationService;


    @Test
    public void findOne() {
        specificationService.findOne(37L);
    }
}