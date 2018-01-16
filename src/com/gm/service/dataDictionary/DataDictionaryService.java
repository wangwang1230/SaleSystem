package com.gm.service.dataDictionary;

import java.util.List;

import com.gm.pojo.DataDictionary;

/**
 * DataDictionaryService

 */
public interface DataDictionaryService {
	/**
	 * getDataDictionaries
	 * @return dataDictionary
	 */
	public List<DataDictionary> getDataDictionaries(DataDictionary dataDictionary) throws Exception;
	
}
