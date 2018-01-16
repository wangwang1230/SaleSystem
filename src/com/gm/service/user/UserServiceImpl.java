package com.gm.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gm.dao.user.UserMapper;
import com.gm.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getLoginUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getLoginUser(user);
	}

	@Override
	public int loginCodeIsExit(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.loginCodeIsExit(user);
	}

	@Override
	public int modifyUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.modifyUser(user);
	}

	@Override
	public int count(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.count(user);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserList(user);
	}

	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	public User getUserById(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserById(user);
	}

	public int delUserPic(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.delUserPic(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(user);
	}

	@Override
	public List<User> getUserListBySearch(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserListBySearch(user);
	}

}
