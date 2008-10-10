package com.livedoor.flow_manager.user.interfaces;

import java.util.List;

import com.livedoor.flow_manager.user.beans.User;

public interface IUser {

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	List<User> queryAllUser();
	
	List<User> getUserByUserName(String userName);
	
	User getUserByUserId(Integer userId);

}