package com.lvguyuan.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.lvguyuan.mapper.TbItemCatMapper;
import com.lvguyuan.pojo.TbItemCat;
import com.lvguyuan.sellergoods.service.ItemCatService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类
 * Date: 2018/5/2
 * Time: 15:24
 */
@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<TbItemCat> findAll() {
        return null;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    /**
     * 条件分页
     * @param itemCat
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(TbItemCat itemCat, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return null;
    }

    /**
     * 新增
     * @param itemCat
     */
    @Override
    public void add(TbItemCat itemCat) {
        itemCatMapper.insert(itemCat);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @Override
    public TbItemCat findOne(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新
     * @param itemCat
     */
    @Override
    public void update(TbItemCat itemCat) {
        itemCatMapper.updateByPrimaryKeySelective(itemCat);
    }

    /**
     * 删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            itemCatMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 通过parentid查询
     * @param parentId
     * @return
     */
    @Override
    public List<TbItemCat> findByParentId(Long parentId) {
        return itemCatMapper.findByParentId(parentId);
    }
}
