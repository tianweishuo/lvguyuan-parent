package com.lvguyuan.manager.controller;

import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.sellergoods.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private static Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Resource
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){


        return brandService.findAll();
    }



}
