package com.livedoor.flow_manager.user.service;

import java.util.List;

import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.user.beans.User;

public interface IUserService {
	

	/*================= service ==========================*/
	///////////////////////////////////////////
	//		Spring Rollback Transactions Methods ---> SETUP IN XML
	///////////////////////////////////////////
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public void deleteUserByDeleteFlag(User user);
	
	public void deleteUserByDeleteFlag(int userId);
	
	
	///////////////////////////////////////////
	//		Spring ReadOnly Transactions Methods   ---> SETUP IN XML
	///////////////////////////////////////////
	
	public User getUserByUserId(Integer userId);
	
	@SuppressWarnings("unchecked")
	public List<User> getUserByUserName(String userName);
	
	public List<User> getUserListByCriteriaQueryUser(final User user);
	
	public List<User> getUserListByCriteriaQueryUser(final User user,final Page page);
	

	@SuppressWarnings("unchecked")
	public List<User> queryAllUser();
	
	public List<User> queryAllUser(final Page page);

	public int getUserCount();
	
	public int getUserCount(final User user);

	public User getUniqueUserByUserName(String userName);
	
//	public User getUserByIdAndPwd(String id,String pwd);
	public User getUserByNameAndPwd(String name,String pwd);

	public Integer queryMaxRegIp(String regIp);

	public User getUniqueUserByUserDisplayName(String string);
}
