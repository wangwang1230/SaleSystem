package com.gm.service.uploadtemp;

import java.util.List;

import javax.annotation.Resource;

import com.gm.dao.uploadtemp.UploadTempMapper;
import com.gm.pojo.UploadTemp;
import org.springframework.stereotype.Service;
/**
 * UploadServiceImpl
 * @author bdqn_hl
 * @date 2014-3-1
 */
@Service
public class UploadTempServiceImpl implements UploadTempService {

	@Resource
	private UploadTempMapper mapper;
	public List<UploadTemp> getList(UploadTemp uploadTemp) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getList(uploadTemp);
	}

	public int add(UploadTemp uploadTemp) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(uploadTemp);
	}

	public int delete(UploadTemp uploadTemp) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(uploadTemp);
	}

}
