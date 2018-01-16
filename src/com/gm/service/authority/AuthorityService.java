package com.gm.service.authority;

import java.util.List;

import com.gm.pojo.Authority;

public interface AuthorityService {
public List<Authority> getList(Authority authority) throws Exception;
	
	public Authority getAuthority(Authority authority) throws Exception;
	
	public int addAuthority(Authority authority) throws Exception;
	
	public int modifyAuthority(Authority authority) throws Exception;
	
	public int deleteAuthority(Authority authority) throws Exception;
	
	public boolean gm_addAuthority(String[] ids,String createdBy) throws Exception;
}
