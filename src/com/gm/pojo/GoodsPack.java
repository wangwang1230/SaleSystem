package com.gm.pojo;

import java.util.Date;

public class GoodsPack extends Base {
	private String goodsPackName;//套餐名称
	private String goodsPackCode;//套餐编码
	private Integer typeId;//套餐类型ID
	private String typeName;//套餐类型Name
	private double totalPrice;//套餐总价（系统生成，保存时根据相关商品的优惠价*数量计算生成）
	private Integer state;//状态（1、上架2、下架）
	private String note;//备注说明
	private Integer num;//库存数量
	private String createBy;//创建人
	private Date createTime;//创建时间
	private Date lastUpdateTime;//最后更新时间
	public String getGoodsPackName() {
		return goodsPackName;
	}
	public void setGoodsPackName(String goodsPackName) {
		this.goodsPackName = goodsPackName;
	}
	public String getGoodsPackCode() {
		return goodsPackCode;
	}
	public void setGoodsPackCode(String goodsPackCode) {
		this.goodsPackCode = goodsPackCode;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}
