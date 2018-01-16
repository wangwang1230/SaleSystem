package com.gm.dao.authority;
/**
 * 权限
 */
import java.util.List;

import com.gm.pojo.Authority;

public interface AuthorityMapper {
	public List<Authority> getList(Authority authority) throws Exception;
	
	public Authority getAuthority(Authority authority) throws Exception;
	
	public int addAuthority(Authority authority) throws Exception;
	
	public int modifyAuthority(Authority authority) throws Exception;
	
	public int deleteAuthority(Authority authority) throws Exception;
}
