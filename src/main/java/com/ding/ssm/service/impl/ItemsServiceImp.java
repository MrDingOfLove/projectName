package com.ding.ssm.service.impl;

import com.ding.ssm.mapper.ItemsExtendMapper;
import com.ding.ssm.pojo.base.Items;
import com.ding.ssm.pojo.extend.ItemsExtend;
import com.ding.ssm.pojo.query.ItemsQueryVo;
import com.ding.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImp implements com.ding.ssm.service.ItemsService {
    @Autowired
    private ItemsExtendMapper itemsExtendMapper;
    //查询商品列表
    @Override
    public List<ItemsExtend> selectItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

        return itemsExtendMapper.selectItemsList(itemsQueryVo);
    }
    //根据id查询商品信息
    @Override
    public ItemsExtend selectItemById(Integer id) throws Exception {
        Items items = itemsExtendMapper.selectItemById(id);
        //业务处理
        //......
        //
        //将items的内容拷贝到items扩展类中
        ItemsExtend itemsExtend = new ItemsExtend();
        BeanUtils.copyProperties(items, itemsExtend);
        return itemsExtend;
    }
    //更新商品信息
    /**
     * id:修改的商品的id
     * itemsExtend：修改的商品信息
     */
    @Override
    public void updateItemById(Integer id,ItemsExtend itemsExtend) throws Exception {
        //添加关键参数校验
        //id不能为空，抛出异常
        itemsExtend.setId(id);
        itemsExtendMapper.updateItemById(itemsExtend);
    }
    //批量删除商品
    public void deleteItems(Integer[] items_id) throws  Exception{
        itemsExtendMapper.deleteItems(items_id);
    };
}
