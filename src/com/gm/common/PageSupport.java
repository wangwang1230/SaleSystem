﻿package com.gm.common;

import java.util.ArrayList;
import java.util.List;
/**
 * 分页功能类
 * @author Administrator
 *
 */
public class PageSupport {
	private Integer totalCount = 0;//总记录数
	private Integer pageCount=0;//总页数
	private Integer pageSize = 2;//每页显示记录数
	private Integer page = 1;//当前页
	private Integer num = 3;//当前页之前和之后显示的页数个数 
	private List items = new ArrayList();//当前页记录内容集合
	
	/**
	 * 计算总页数
	 * @param totalCount
	 */
	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			if(this.totalCount % this.pageSize == 0){
				this.pageCount  = totalCount/pageSize;
			}else if(this.totalCount % this.pageSize > 0){
				this.pageCount  = totalCount/pageSize + 1;
			}else{
				this.pageCount = 0;
			}
			
		}
		
	}
	/**
	 * 获取总记录数
	 * @return
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	
	/**
	 * 获取每页显示记录数
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页显示记录数
	 * @param pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 得到当前页数
	 * @return
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 设置当前页数
	 * @param page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	
	/**
	 * 获取当前页之前或之后显示的页数个数
	 * @return
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 设置当前页之前或之后显示的页数个数
	 * @param num
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * 获取当前页记录内容集合
	 * @return
	 */
	public List getItems() {
		return items;
	}

	/**
	 * 设置当前页记录内容集合
	 * @param items
	 */
	public void setItems(List items) {
		this.items = items;
	}


	/**
	 * 得到总页数
	 * @return
	 */
	public Integer getPageCount() {
		return pageCount;
	}
	/**
	 * 获取前一页
	 * @return
	 */
	public Integer getPrev(){
		return page-1;
	}
	
	/**
	 * 获取后一页
	 * @return
	 */
	public Integer getNext(){
		return page+1;
	}
	
	/**
	 * 获取最后一页
	 * @return
	 */
	public Integer getLast(){
		return pageCount;
	}
	
	/**
	 * 判断是否有前一页
	 * @return
	 */
	public boolean getIsPrev(){
		if(page>1){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否有后一页
	 * @return
	 */
	public boolean getIsNext(){
		
		if(pageCount!=null && page<pageCount){
			return true;
		}
		return false;
	}
	
	/**
	 * 当前页的前num条页 假设当前页是 6 共有11页 如：1 2 3 4 5
	 * @return
	 */
	public List<Integer> getPrevPages() {
		List<Integer> list = new ArrayList<Integer>();
		Integer _frontStart = 1;
		
		if (page > num) {
			_frontStart = page - num;
		}
		
		
		for (Integer i=_frontStart; i<page; i++) {
			list.add(i);
		}
		
		return list;
	}
	
	/**
	 * 当前页的后num条页 假设当前页是 6 共有11页 如：7 8 9 10 11
	 * @return
	 */
	public List<Integer> getNextPages() {
		List<Integer> list = new ArrayList<Integer>();
		Integer _endCount = num;
			if(pageCount!=null){
			if (num < pageCount && (page+num)<pageCount) {
				_endCount = page+_endCount;
			}else{
				_endCount=pageCount;
			}
			
			for (Integer i=page+1;i<=_endCount; i++) {
				list.add(i);
		    }
		}
		return list;
	}


	
}
