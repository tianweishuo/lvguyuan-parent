package com.lvguyuan.manager.controller;

import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.pojo.TbItemCat;
import com.lvguyuan.sellergoods.service.BrandService;
import com.lvguyuan.sellergoods.service.ItemCatService;
import entity.PageResult;
import entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类
 * Date: 2018/5/2
 * Time: 15:33
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Resource
    private ItemCatService itemCatService;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbItemCat> findAll(){
        return itemCatService.findAll();
    }

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(TbBrand brand, int page, int rows){
        return itemCatService.findPage(page,rows);
    }

    /**
     * 添加
     * @param itemCat
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbItemCat itemCat){
        try{
            itemCatService.add(itemCat);
            return new Result(true,"保存成功!");
        }catch (Exception e){
            logger.info(e.getMessage());
            System.out.print(e.getMessage());
            return new Result(false,"保存失败!");
        }
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

    /**
     * 更新
     * @param itemCat
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbItemCat itemCat){
        try{
            itemCatService.update(itemCat);
            return new Result(true,"更新成功!");
        }catch (Exception e){
            return new Result(false,"更新失败!");
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try{
            itemCatService.delete(ids);
            return new Result(true,"删除成功!");
        }catch (Exception e){
            return new Result(false,"删除失败!");
        }

    }

    /**
     * 条件分页查询
     * @return
     */
    @RequestMapping("/sarch")
    public PageResult sarch(@RequestBody TbItemCat itemCat,int page,int rows){
        return itemCatService.findPage(itemCat,page,rows);
    }

    /**
     * 根据上级ID查询列表
     * @param parentId
     * @return
     */
    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Long parentId){
        return itemCatService.findByParentId(parentId);
    }

}
