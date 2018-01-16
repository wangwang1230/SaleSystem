package com.gm.dao.affiche;

import java.util.List;

import com.gm.pojo.Affiche;

public interface AfficheMapper {
	//按发表时间降序查询公告列表
	public List<Affiche> getList(Affiche affiche) throws Exception;
	//按发表时间降序查询公告列表（带分页）
	public List<Affiche> getAfficheList(Affiche affiche) throws Exception;
	//通过ID查找公告
	public Affiche getAffiche(Affiche affiche) throws Exception;
	//添加公告
	public int addAffiche(Affiche affiche) throws Exception;
	//修改公告
	public int modifyAffiche(Affiche affiche) throws Exception;
	//删除公告
	public int deleteAffiche(Affiche affiche) throws Exception;
	//查询公告数量
	public int count() throws Exception;
	//查询在有效期内的公告数量
	public int portalCount() throws Exception;
	//查询在有效期内的公告列表(按发表时间降序带分页)
	public List<Affiche> getPortalAfficheList(Affiche affiche) throws Exception;





}
