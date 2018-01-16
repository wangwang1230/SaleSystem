package com.gm.service.function;

import java.util.List;

import com.gm.pojo.Authority;
import com.gm.pojo.Function;

public interface FunctionService {
	/**
	 * getMainFunctionList
	 * @param authority
	 * @return
	 * @throws Exception
	 */
	public List<Function> getMainFunctionList(Authority authority) throws Exception;

	/**
	 * getSubFunctionList
	 * @param function
	 * @return
	 * @throws Exception
	 */
	public List<Function> getSubFunctionList(Function function) throws Exception;

	public List<Function> getSubFuncList(Function function) throws Exception;
	
	public List<Function> getFunctionListByRoleId(Authority authority) throws Exception;
}
