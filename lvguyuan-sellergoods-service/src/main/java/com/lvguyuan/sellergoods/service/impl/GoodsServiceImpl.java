package com.lvguyuan.sellergoods.service.impl;

import com.alibaba.fastjson.JSON;
import com.lvguyuan.mapper.*;
import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.pojo.TbItem;
import com.lvguyuan.pojo.TbItemCat;
import com.lvguyuan.pojo.TbSeller;
import com.lvguyuan.pojogrop.Goods;
import com.lvguyuan.sellergoods.service.GoodsService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品列表
 * Date: 2018/5/2
 * Time: 20:42
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper goodsMapper;

    @Autowired
    private TbGoodsDescMapper goodsDescMapper;

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Autowired
    private TbSellerMapper sellerMapper;


    @Override
    public List<Goods> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult findPage(Goods goods, int pageNum, int pageSize) {
        return null;
    }

    @Autowired
    private TbBrandMapper brandMapper;

    /**
     * 增加商品基本信息
     * @param goods
     */
    @Transactional
    @Override
    public void add(Goods goods) {
        //状态：未审核
        goods.getGoods().setAuditStatus("0");
        //插入商品基本信息
        goodsMapper.insertSelective(goods.getGoods());
        //插入扩展SPU信息表
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        goodsDescMapper.insertSelective(goods.getGoodsDesc());

        //增加商品明细
        for(TbItem item:goods.getItemList()){
            //构建标体 SPU名+规格选择值
            String title = goods.getGoods().getGoodsName();//SPU名称
            Map<String,Object> map= JSON.parseObject(item.getSpec());
            for(String key :map.keySet()){
                title = ""+map.get(key);
            }
            item.setTitle(title);

            //商品分类
            item.setCategoryid(goods.getGoods().getCategory3Id());//分类ID
            item.setCreateTime(new Date());//创建日期
            item.setUpdateTime(new Date());//更新日期
            item.setGoodsId(goods.getGoods().getId());//商品ID
            item.setSellerId(goods.getGoods().getSellerId());//商家ID

            //分类名称
            TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());
            item.setCategory(itemCat.getName());

            //品牌名称
            TbBrand brand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());
            item.setBrand(brand.getName());

            //商家名称
            TbSeller seller = sellerMapper.selectByPrimaryKey(goods.getGoods().getSellerId());
            item.setSeller(seller.getNickName());

            itemMapper.insertSelective(item);
        }

    }

    @Override
    public Goods findOne(Long id) {
        return null;
    }

    @Override
    public void update(Goods goods) {

    }

    @Override
    public void delete(Long[] ids) {

    }
}
