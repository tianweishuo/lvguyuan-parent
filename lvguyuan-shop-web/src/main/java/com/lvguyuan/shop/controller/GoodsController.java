package com.lvguyuan.shop.controller;

import com.lvguyuan.pojogrop.Goods;
import com.lvguyuan.sellergoods.service.GoodsService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Created By Kinsey
 * Date: 2018/5/2
 * Time: 20:53
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/add")
    public Result add(@RequestBody Goods goods){
        try {
            goodsService.add(goods);
        }catch (Exception e){
            return new Result(false,e.getMessage());
        }
        return new Result(true,"保存成功!");
    }


}
