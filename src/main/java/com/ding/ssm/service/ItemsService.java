package com.ding.ssm.service;

import com.ding.ssm.pojo.extend.ItemsExtend;
import com.ding.ssm.pojo.query.ItemsQueryVo;

import java.util.List;

/**
 * 商品管理Service
 */
public interface ItemsService {
    //商品按名字模糊查询
    public List<ItemsExtend> selectItemsList(ItemsQueryVo itemsQueryVo) throws  Exception;
    //根据id查询商品信息
    public ItemsExtend selectItemById(Integer id) throws  Exception;
    //修改商品信息
    public void updateItemById(Integer id,ItemsExtend itemsExtend) throws  Exception;
    //批量删除商品
    public void deleteItems(Integer[] items_id) throws  Exception;
}
