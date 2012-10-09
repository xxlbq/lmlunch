package com.livedoor.flow_manager.user.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;

import com.livedoor.flow_manager.tools.CollectionTools;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.dao.imp.UserDao;

import com.livedoor.flow_manager.user.exception.UserExcption;

//public class SourceService implements ISourceService{
public class UserService implements IUserService{
	
	private final static Logger log = Logger.getLogger(UserService.class);
	
	private UserDao userDao;

	public void setUserDao(UserDao UserDao) {
		this.userDao = UserDao;
	}



	/*================= service ==========================*/
	///////////////////////////////////////////
	//		Spring Rollback Transactions Methods ---> SETUP IN XML
	///////////////////////////////////////////
	public void addUser(User user){
			
		try {
			userDao.save(user);
			
//			UserDao.insertMany();	//test custom Exception
//			UserDao.testRuntimeException();//test runtime exception
			
///////////////////////////////////////////			
//			UserDao.testOtherCheckedException();//test CheckedException
//		} catch (OtherCheckedException oe){
//			throw oe;
///////////////////////////////////////////			
			
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In addUser() method ]++++++",e);
			throw new UserExcption(1000,"addUser() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%%[Other Exception In  addUser() method ]%%%%%%%",e);
			throw new UserExcption(9999,"addUser() error! :"+e.getMessage());
		}
	}
	
	public void updateUser(User user) {
		try {
			userDao.update(user);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In updateUser() method ]++++++",e);
			throw new UserExcption(1001,"updateUser() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%%[Other Exception In  updateUser() method ]%%%%%%%",e);
			throw new UserExcption(9999,"updateUser() error! :"+e.getMessage());
		}		
	}
	
	
	public void deleteUser(User user) {
		try {
			userDao.delete(user);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In deleteUser() method ]++++++",e);
			throw new UserExcption(1002,"deleteUser() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  deleteUser() method ]%%%%%%%",e);
			throw new UserExcption(9999,"deleteUser() error! :"+e.getMessage());
		}			
	}
	
	public void deleteUserByDeleteFlag(User user) {
		user.setDeletedFlag(1);
		updateUser(user);		
	}
	
	public void deleteUserByDeleteFlag(int UserId){

		User user = getUserByUserId(UserId);
		user.setDeletedFlag(1);
		updateUser(user);		
	}
	
	
	///////////////////////////////////////////
	//		Spring ReadOnly Transactions Methods   ---> SETUP IN XML
	///////////////////////////////////////////
	
	public User getUserByUserId(Integer UserId) {
		
		User s = null;
		try {
			s = (User)userDao.get(User.class, UserId);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getUserByUserId(Integer UserId) method ]++++++",e);
			throw new UserExcption(1003,"getUserByUserId(Integer UserId) error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getUserByUserId(Integer UserId) method ]%%%%%%%",e);
			throw new UserExcption(9999,"getUserByUserId(Integer UserId) error! :"+e.getMessage());
		}
		return s;	
	}
	
	public User getUserByNameAndPwd(String name,String pwd) {
		
		User s = null;
		try {
			s = getUniqueUserByNamePwd(name, pwd);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getUserByUserId(Integer UserId) method ]++++++",e);
			throw new UserExcption(1003,"getUserByUserId(Integer UserId) error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getUserByUserId(Integer UserId) method ]%%%%%%%",e);
			throw new UserExcption(9999,"getUserByUserId(Integer UserId) error! :"+e.getMessage());
		}
		return s;	
	}
	
	public User getUniqueUserByNamePwd(String name, String pwd) {
		
		return (getUserList(name,pwd).size() > 0 ?
				getUserList(name,pwd).get(0) : null);
	}



	private List<User> getUserList(String username, String pwd) {
		List<User> sList = null;
		try {
			sList = userDao.getUserByNamePwd(username,pwd);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getUserByUserName method ]++++++",e);
			throw new UserExcption(1004,"getUserByUserName() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getUserByUserName method ]%%%%%%%",e);
			throw new UserExcption(9999,"getUserByUserName() error! :"+e.getMessage());
		}
		return sList;
	}



	@SuppressWarnings("unchecked")
	public List<User> getUserByUserName(String UserName) {
		List<User> sList = null;
		try {
			sList = userDao.getUserByUserName(UserName);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getUserByUserName method ]++++++",e);
			throw new UserExcption(1004,"getUserByUserName() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getUserByUserName method ]%%%%%%%",e);
			throw new UserExcption(9999,"getUserByUserName() error! :"+e.getMessage());
		}
		return sList;
	}
	
	public User getUniqueUserByUserName(String userName) {
		
		return (getUserByUserName(userName).size() > 0 ? getUserByUserName(userName).get(0) : null);
	}
	
	public User getUniqueUserByUserDisplayName(String userDisplayName) {
		
		return  CollectionTools.isEmpty(userDao.getUserByUserDisplayName(userDisplayName))? 
				null : userDao.getUserByUserDisplayName(userDisplayName).get(0);
	}
	
	public List<User> getUserListByCriteriaQueryUser(final User User)
	throws UserExcption {
		
		List<User> sList = null;
		try {
			sList = userDao.getUserListByCriteriaQueryUser(User);
			
		}catch (IllegalAccessException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s) error! :"+e.getMessage());
		}catch (InstantiationException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s) error! :"+e.getMessage());
		
		}catch (InvocationTargetException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s) error! :"+e.getMessage());
		
		}catch (NoSuchMethodException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s) error! :"+e.getMessage());
		
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getUserListByCriteriaQueryUser(User s) method ]++++++",e);
			throw new UserExcption(1004,"getUserListByCriteriaQueryUser(User s) error! :"+e.getMessage());
			
		}catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getUserListByCriteriaQueryUser method ]%%%%%%%",e);
			throw new UserExcption(9999,"getUserListByCriteriaQueryUser(User s)  error! :"+e.getMessage());
		}
		
		return sList;
	}
	
	public List<User> getUserListByCriteriaQueryUser(final User User,final Page page)
	throws UserExcption {
		
		List<User> sList = null;
		try {
			sList = userDao.getUserListByCriteriaQueryUser(User,page);
			
		}catch (IllegalAccessException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s,Page page) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s,Page page) error! :"+e.getMessage());
		}catch (InstantiationException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s,Page page) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s,Page page) error! :"+e.getMessage());
		
		}catch (InvocationTargetException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s,Page page) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s,Page page) error! :"+e.getMessage());
		
		}catch (NoSuchMethodException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getUserListByCriteriaQueryUser(User s,Page page) method ]++++++",e);
			throw new UserExcption(1005,"getUserListByCriteriaQueryUser(User s,Page page) error! :"+e.getMessage());
		
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getUserListByCriteriaQueryUser(User s,Page page) method ]++++++",e);
			throw new UserExcption(1004,"getUserListByCriteriaQueryUser(User s,Page page) error! :"+e.getMessage());
			
		}catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getUserListByCriteriaQueryUser(User s,Page page) method ]%%%%%%%",e);
			throw new UserExcption(9999,"getUserListByCriteriaQueryUser(User s,Page page)  error! :"+e.getMessage());
		}
		
		return sList;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<User> queryAllUser() {
		
		List<User> sList = null;
		try {
			sList= userDao.queryAllUser();
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In queryAllUser() method ]++++++",he);
			throw new UserExcption(1004,"queryAllUser() error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In queryAllUser() method ]++++++",e);
			throw new UserExcption(9999,"queryAllUser() error! :"+e.getMessage());
		}
		return sList;
		
	}
	
	public List<User> queryAllUser(final Page page) {
		
		List<User> sList = null;
		try {
			sList= userDao.queryAllUser(page);
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In queryAllUser(final Page page) method ]++++++",he);
			throw new UserExcption(1004,"queryAllUser(final Page page) error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In queryAllUser(final Page page) method ]++++++",e);
			throw new UserExcption(9999,"queryAllUser(final Page page) error! :"+e.getMessage());
		}
		return sList;
	}

	
	
	public int getUserCount() throws HibernateException {
		
		int count = -1 ;
		
		try {
			count= userDao.getUserCount();
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In getUserCount() method ]++++++",he);
			throw new UserExcption(1005,"getUserCount() error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getUserCount() method ]++++++",e);
			throw new UserExcption(9999,"getUserCount() error! :"+e.getMessage());
		}

        return count;
    }
	
	public int getUserCount(final User User) throws HibernateException {
		
		int count = -1 ;
		
		try {
			count= userDao.getUserCount(User);
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In getUserCount(User) method ]++++++",he);
			throw new UserExcption(1005,"getUserCount(User) error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getUserCount(User) method ]++++++",e);
			throw new UserExcption(9999,"getUserCount(User) error! :"+e.getMessage());
		}

        return count;
    }

	public Integer queryMaxRegIp(String ip){
		
		return userDao.queryMaxRegIp(ip);
	}


	
	///////////////////////////////////////////
	//		Get PageTemplate
	///////////////////////////////////////////
	
	
	
	/*================= Test Area========================*/
//	
//	/**
//	 * Test Tran
//	 * 
//	 * @throws UserExcption
//	 */
//	public void addTestInsert1() throws UserExcption{
//		
//		try {
//			UserJdbcDao.save("insert into t_User VALUES ('100','springtest',null,null,3,'2006-11-19 18:16:52',3,'2006-11-19 18:16:52',0,'test');");
//			//--
//			UserDao.insertMany();
//		} catch (DataAccessException e) {
//			System.out.println("++++++++++@_@+++++++++");
//			e.printStackTrace();
//			throw new UserExcption(100,"insertMany2 error! :"+e.getMessage());
//		}catch (Exception e){
//			System.out.println("%%%% not customer exception%%%%%");
//		}
//		
//	}

}
