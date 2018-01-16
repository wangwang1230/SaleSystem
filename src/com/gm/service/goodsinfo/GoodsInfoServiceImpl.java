package com.gm.service.goodsinfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gm.dao.goodsinfo.GoodsInfoMapper;
import com.gm.pojo.GoodsInfo;
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {
	@Resource
	private GoodsInfoMapper goodsInfoMapper;
	@Override
	public int count(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.count(goodsInfo);
	}
	@Override
	public List<GoodsInfo> getGoodsInfoList(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.getGoodsInfoList(goodsInfo);
	}
	@Override
	public int addGoodsInfo(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.addGoodsInfo(goodsInfo);
	}
	@Override
	public GoodsInfo getGoodsInfoById(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.getGoodsInfoById(goodsInfo);
	}
	@Override
	public int modifyGoodsInfo(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.modifyGoodsInfo(goodsInfo);
	}

}
