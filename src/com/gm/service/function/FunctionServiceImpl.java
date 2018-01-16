package com.gm.service.function;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gm.dao.function.FunctionMapper;
import com.gm.pojo.Authority;
import com.gm.pojo.Function;

@Service
public class FunctionServiceImpl implements FunctionService {
	
	@Resource
	private FunctionMapper mapper;
	@Override
	public List<Function> getMainFunctionList(Authority authority)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getMainFunctionList(authority);
	}

	@Override
	public List<Function> getSubFunctionList(Function function)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSubFunctionList(function);
	}

	@Override
	public List<Function> getSubFuncList(Function function) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSubFuncList(function);
	}

	@Override
	public List<Function> getFunctionListByRoleId(Authority authority)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getFunctionListByRoleId(authority);
	}

}
