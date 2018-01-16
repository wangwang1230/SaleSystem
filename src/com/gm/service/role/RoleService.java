package com.gm.service.role;

import java.util.List;

import com.gm.pojo.Role;

public interface RoleService {
	/**
	 * 获取角色列表
	 * @return
	 * @throws Exception
	 */
	public List<Role> getRoleList() throws Exception;

	public Role getRole(Role role) throws Exception;
	
	public Role getRoleR(Role role) throws Exception;
	
	public int addRole(Role role) throws Exception;

	public int modifyRole(Role role) throws Exception;
	
	public int deleteRole(Role role) throws Exception;
	
	public List<Role> getRoleIdAndNameList() throws Exception;

	public boolean gm_modifyRole(Role role) throws Exception;
}
	