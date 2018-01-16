package com.gm.dao.datadictionary;

import java.util.List;

import com.gm.pojo.DataDictionary;
import com.gm.pojo.User;

/**
 * DataDictionaryMapper

 */
public interface DataDictionaryMapper {
	
	
	/**
	 * getDataDictionaries
	 * @return dataDictionary
	 */
	public List<DataDictionary> getDataDictionaries(DataDictionary dataDictionary) throws Exception;
	
	
}
