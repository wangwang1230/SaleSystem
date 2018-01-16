package com.gm.service.uploadtemp;

import java.util.List;

import com.gm.pojo.UploadTemp;
/**
 * UploadTempService
 * @author bdqn_hl
 * @date 2014-3-1
 */
public interface UploadTempService {
	/**
	 * getList
	 * @param uploadTemp
	 * @return
	 * @throws Exception
	 */
	public List<UploadTemp> getList(UploadTemp uploadTemp) throws Exception;
	/**
	 * add
	 * @param uploadTemp
	 * @return
	 * @throws Exception
	 */
	public int add(UploadTemp uploadTemp) throws Exception;
	/**
	 * delete
	 * @param uploadTemp
	 * @return
	 * @throws Exception
	 */
	public int delete(UploadTemp uploadTemp) throws Exception;
}
