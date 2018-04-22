package com.ding.ssm.pojo.query;

import com.ding.ssm.pojo.base.Items;
import com.ding.ssm.pojo.extend.ItemsExtend;

import java.util.List;

/**
 * 商品包装对象
 */
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private ItemsExtend itemsExtend;

	private List<ItemsExtend> itemsList;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsExtend getItemsExtend() {
		return itemsExtend;
	}

	public void setItemsExtend(ItemsExtend itemsExtend) {
		this.itemsExtend = itemsExtend;
	}

	public List<ItemsExtend> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsExtend> itemsList) {
		this.itemsList = itemsList;
	}
}
