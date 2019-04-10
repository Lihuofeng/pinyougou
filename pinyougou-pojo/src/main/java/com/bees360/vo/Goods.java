package com.bees360.vo;

import java.io.Serializable;
import java.util.List;

import com.bees360.pojo.TbGoods;
import com.bees360.pojo.TbGoodsDesc;
import com.bees360.pojo.TbItem;

public class Goods implements Serializable {
	private TbGoods goods; // 商品SPU基本信息
	private TbGoodsDesc goodsDesc;// 商品SPU扩展信息
	private List<TbItem> itemList;// 商品SKU列表

	public TbGoods getGoods() {
		return goods;
	}

	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}

	public TbGoodsDesc getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(TbGoodsDesc goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public List<TbItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<TbItem> itemList) {
		this.itemList = itemList;
	}

}
