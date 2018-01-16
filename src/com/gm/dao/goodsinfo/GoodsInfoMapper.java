package com.gm.dao.goodsinfo;

import java.util.List;

import com.gm.pojo.GoodsInfo;

public interface GoodsInfoMapper {
	//根据条件查找商品数量
	public int count(GoodsInfo goodsInfo);
	//获取商品列表
	public List<GoodsInfo> getGoodsInfoList(GoodsInfo goodsInfo);
	//添加商品
	public int addGoodsInfo(GoodsInfo goodsInfo);
	//通过ID查找商品
	public GoodsInfo getGoodsInfoById(GoodsInfo goodsInfo);
	//修改商品
	public int modifyGoodsInfo(GoodsInfo goodsInfo);
}
