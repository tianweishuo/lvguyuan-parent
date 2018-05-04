package com.lvguyuan.shop.controller;

import com.lvguyuan.pojo.TbItemCat;
import com.lvguyuan.sellergoods.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Kinsey
 * Date: 2018/5/3
 * Time: 17:11
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Resource
    private ItemCatService itemCatService;


    /**
     * 根据上级ID查询列表
     * @param parentId
     * @return
     */
    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Long parentId){
        return itemCatService.findByParentId(parentId);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbItemCat findeOne(Long id){
        return itemCatService.findOne(id);
    }


}
