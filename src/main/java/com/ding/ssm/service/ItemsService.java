package com.ding.ssm.service;

import com.ding.ssm.pojo.Items;
import com.ding.ssm.pojo.ItemsCustom;
import com.ding.ssm.pojo.ItemsQueryVo;

import java.util.List;

/**
 * 商品管理Service
 */
public interface ItemsService {
    //商品按名字模糊查询
    public List<ItemsCustom> selectItemsList(ItemsQueryVo itemsQueryVo) throws  Exception;
    //根据id查询商品信息
    public ItemsCustom selectItemById(Integer id) throws  Exception;
    //修改商品信息
    public void updateItemById(Integer id,ItemsCustom itemsCustom) throws  Exception;
}
