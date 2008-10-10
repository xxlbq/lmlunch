package com.livedoor.flow_manager.user.dao.inf;

import java.util.List;

import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.user.beans.User;

public interface IUser {

	
	
	/**
	 * @param s 
	 *
	 *	add a new Source
	 */
	void addUser(User user);

	/**
	 * @param s
	 * 
	 * 	update a new User
	 */
	void updateUser(User user);

	/**
	 * @param s
	 * 
	 * 	delete a new User
	 */
	void deleteUser(User user);

	/**
	 * @param s
	 * 
	 * 	update a User set deleteFlag = 1 in database
	 */
	void deleteUserByDeleteFlag(User user);
	
	
	/**
	 * @return List<User>
	 * 
	 * get all User list 
	 */
	List<User> queryAllUser();
	
//	/**
//	 * Pagination
//	 * @param fromNumber
//	 * @param fetch
//	 * @return
//	 * 
//	 * 
//	 */
//	List<User> queryPageUser(int begin,int fetch );
	
	List<User> queryAllUser(Page page);

	/**
	 * @param UserId
	 * @return
	 * 
	 * get User by given User id
	 */
	User getUserByUserId(Integer UserId);
	
	/**
	 * @param UserName
	 * @return
	 * 
	 * query User by given User name
	 */
	List<User> getUserByUserName(String UserName);
	
}
