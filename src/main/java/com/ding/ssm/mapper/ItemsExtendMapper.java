package com.ding.ssm.mapper;

import com.ding.ssm.pojo.base.Items;
import com.ding.ssm.pojo.extend.ItemsExtend;
import com.ding.ssm.pojo.query.ItemsQueryVo;

import java.util.List;

public interface ItemsExtendMapper {
    public List<ItemsExtend> selectItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    //根据id查询商品信息
    public Items selectItemById(Integer id) throws  Exception;
    //修改商品信息
    public void updateItemById(ItemsExtend itemsExtend) throws  Exception;
    //批量删除商品
    public void deleteItems(Integer[] items_id) throws  Exception;
}
