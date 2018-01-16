package com.gm.service.authority;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gm.dao.authority.AuthorityMapper;
import com.gm.dao.function.FunctionMapper;
import com.gm.pojo.Authority;
import com.gm.pojo.Function;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Resource
	private AuthorityMapper mapper;
	@Resource
	private FunctionMapper functionMapper;
	@Override
	public List<Authority> getList(Authority authority) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getList(authority);
	}

	@Override
	public Authority getAuthority(Authority authority) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAuthority(authority);
	}

	@Override
	public int addAuthority(Authority authority) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addAuthority(authority);
	}

	@Override
	public int modifyAuthority(Authority authority) throws Exception {
		// TODO Auto-generated method stub
		return mapper.modifyAuthority(authority);
	}

	@Override
	public int deleteAuthority(Authority authority) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteAuthority(authority);
	}

	@Override
	public boolean gm_addAuthority(String[] ids, String createdBy)
			throws Exception {
		// TODO Auto-generated method stub
		Authority authority = new Authority();
		authority.setRoleId(Integer.parseInt(ids[0]));
		//删除角色下的功能
		mapper.deleteAuthority(authority);
		//重新增加授权
		String idsSql = "";
		for(int i = 1;i<ids.length;i++){
			idsSql += Integer.parseInt(ids[i])+",";
		}
		if(idsSql != null && idsSql.contains(",")){
			idsSql = idsSql.substring(0,idsSql.lastIndexOf(","));
			List<Function> fList = functionMapper.getFunctionListByIn(idsSql);
			if(fList != null && fList.size()>0){
				for(Function function : fList){
					authority.setFunctionId(function.getId());
					authority.setCreatedBy(createdBy);
					authority.setCreationTime(new Date());
					//增加权限
					mapper.addAuthority(authority);
				}
				
			}
		}
		
		return true;
	}

}
