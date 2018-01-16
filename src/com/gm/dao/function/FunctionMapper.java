package com.gm.dao.function;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gm.pojo.Authority;
import com.gm.pojo.Function;
/**
 * 功能
 * @author Administrator
 *
 */
public interface FunctionMapper {
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
	
	public List<Function> getFunctionListByIn(@Param(value="sqlStr") String sqlStr) throws Exception;
	
	public List<Function> getFunctionListByRoleId(Authority authority) throws Exception;
}
