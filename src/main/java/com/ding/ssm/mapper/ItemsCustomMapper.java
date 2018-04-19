package com.ding.ssm.mapper;

import com.ding.ssm.pojo.Items;
import com.ding.ssm.pojo.ItemsCustom;
import com.ding.ssm.pojo.ItemsQueryVo;

import java.util.List;

public interface ItemsCustomMapper {
    public List<ItemsCustom> selectItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    //根据id查询商品信息
    public ItemsCustom selectItemById(Integer id) throws  Exception;
    //修改商品信息
    public void updateItemById(ItemsCustom itemsCustom) throws  Exception;
}
