package com.gm.service.dataDictionary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gm.dao.datadictionary.DataDictionaryMapper;
import com.gm.pojo.DataDictionary;
/**
 * DataDictionaryServiceImpl

 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService{
	@Resource
	private DataDictionaryMapper mapper;
	
	public List<DataDictionary> getDataDictionaries(
			DataDictionary dataDictionary) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getDataDictionaries(dataDictionary);
	}

}
