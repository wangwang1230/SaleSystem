package com.gm.service.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gm.dao.role.RoleMapper;
import com.gm.dao.user.UserMapper;
import com.gm.pojo.Role;
import com.gm.pojo.User;
@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper mapper;
	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<Role> getRoleList() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getRoleList();
	}

	@Override
	public Role getRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getRole(role);
	}

	@Override
	public Role getRoleR(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getRoleR(role);
	}

	@Override
	public int addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addRole(role);
	}

	@Override
	public int modifyRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.modifyRole(role);
	}

	@Override
	public int deleteRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteRole(role);
	}

	@Override
	public List<Role> getRoleIdAndNameList() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getRoleIdAndNameList();
	}

	@Override
	public boolean gm_modifyRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		mapper.modifyRole(role);
		int roleId = role.getId();
		String roleName = role.getRoleName();
		User user = new User();
		user.setRoleId(roleId);
		user.setRoleName(roleName);
		if(roleName != null && !"".equals(roleName)){
			userMapper.modifyUserRole(user);
		}
		return true;
	}

}
