package com.ding.ssm.service.impl;

import com.ding.ssm.mapper.ItemsCustomMapper;
import com.ding.ssm.pojo.Items;
import com.ding.ssm.pojo.ItemsCustom;
import com.ding.ssm.pojo.ItemsQueryVo;
import com.ding.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsCustomMapper itemsCustomMapper;
    //查询商品列表
    @Override
    public List<ItemsCustom> selectItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

        return itemsCustomMapper.selectItemsList(itemsQueryVo);
    }
    //根据id查询商品信息
    @Override
    public ItemsCustom selectItemById(Integer id) throws Exception {
        Items items = itemsCustomMapper.selectItemById(id);
        //业务处理
        //......
        //
        //将items的内容拷贝到items扩展类中
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }
    //更新商品信息
    /**
     * id:修改的商品的id
     * itemsCustom：修改的商品信息
     */
    @Override
    public void updateItemById(Integer id,ItemsCustom itemsCustom) throws Exception {
        //添加关键参数校验
        //id不能为空，为空时抛出异常
        itemsCustom.setId(id);
        itemsCustom.setId(id);
        itemsCustomMapper.updateItemById(itemsCustom);
    }
}
