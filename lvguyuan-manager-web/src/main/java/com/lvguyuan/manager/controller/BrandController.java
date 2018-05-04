package com.lvguyuan.manager.controller;

import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.aspectj.weaver.ast.Literal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Resource
    private BrandService brandService;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(TbBrand brand,int page,int rows){
        return brandService.findPage(page,rows);
    }

    /**
     * 添加
     * @param tbBrand
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand){
        try{
            brandService.add(tbBrand);
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
    public TbBrand findeOne(Long id){
        return brandService.findOne(id);
    }

    /**
     * 更新
     * @param tbBrand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        try{
            brandService.update(tbBrand);
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
            brandService.delete(ids);
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
    public PageResult sarch(@RequestBody TbBrand brand,int page,int rows){
        return brandService.findPage(brand,page,rows);
    }

    /**
     * 返回下拉列表
     * @return
     */
    @RequestMapping("/selectOptionList")
    private List<Map> selectOptionList(){
        List<Map> list = brandService.selectOptionList();
        return list;
    }
}
