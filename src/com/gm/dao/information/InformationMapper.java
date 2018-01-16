package com.gm.dao.information;

import java.util.List;

import com.gm.pojo.Information;

public interface InformationMapper {
	/**
	 * getList
	 * 通过创建时间降序查找咨询列表
	 * @param information
	 * @return
	 * @throws Exception
	 */
	public List<Information> getList(Information information) throws Exception;
	/**
	 * getInformationList
	 * 根据条件查找咨询列表带分页
	 * @param information
	 * @return
	 * @throws Exception
	 */
	public List<Information> getInformationList(Information information) throws Exception;
	/**
	 * getInformation
	 * 通过ID查找咨询
	 * @param information
	 * @return
	 * @throws Exception
	 */
	public Information getInformation(Information information) throws Exception;
	/**
	 * addInformation
	 * @param information
	 * @return
	 * @throws Exception
	 */
	public int addInformation(Information information) throws Exception;
	/**
	 * modifyInformation
	 * @param information
	 * @return
	 * @throws Exception
	 */
	public int modifyInformation(Information information) throws Exception;
	/**
	 * modifyInformationFileInfo
	 * 修改咨询内容
	 * @param information
	 * @return
	 * @throws Exception
	 */
	public int modifyInformationFileInfo(Information information) throws Exception;
	/**
	 * deleteAffiche
	 * @param affiche
	 * @return
	 * @throws Exception
	 */
	public int deleteInformation(Information information) throws Exception;
	/**
	 * count
	 * @return
	 * @throws Exception
	 */
	public int count(Information information) throws Exception;
}
