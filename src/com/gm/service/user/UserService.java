package com.gm.service.user;

import java.util.List;

import com.gm.pojo.User;

public interface UserService {
	/**
	 * getLoginUser
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user)throws Exception;
	
	/**
	 * loginCodeIsExit
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int loginCodeIsExit(User user)throws Exception;
	
	/**
	 * modifyUser
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modifyUser(User user)throws Exception;
	
	/**
	 * count
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int count(User user) throws Exception;
	
	/**
	 * getUserList
	 * @return
	 */
	public List<User> getUserList(User user) throws Exception;
	
	
	/**
	 * addUser
	 * @param user
	 * @return
	 */
	public int addUser(User user) throws Exception;
	
	
	/**
	 * delUserPic
	 * @param user
	 * @return
	 */
	public int delUserPic(User user) throws Exception;
	
	/**
	 * deleteUser
	 * @param user
	 * @return
	 */
	public int deleteUser(User user) throws Exception;
	
	/**
	 * getUserById
	 * @param user
	 * @return
	 */
	public User getUserById(User user) throws Exception;

	public List<User> getUserListBySearch(User user) throws Exception;
}
