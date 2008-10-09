package com.livedoor.flow_manager.user.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.livedoor.flow_manager.generic.dao.GenericDAOHibernateImpl;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.dao.inf.IUser;
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

public class UserDao extends GenericDAOHibernateImpl implements IUser {
	
	private final static Logger log = Logger.getLogger(UserDao.class);

	public void addUser(User user) {
		save(user);	//HibernateTemplate().save()
	}

	public void updateUser(User user) {
		update(user);		//HibernateTemplate().update()
	}
	
	public void deleteUser(User user) {
		delete(user);		//	HibernateTemplate().delete()
	}
	
	
	public void deleteUserByDeleteFlag(User user) {
		user.setDeletedFlag(1);
		update(user);		//HibernateTemplate().update()
	}
	

	public void deleteUserByDeleteFlag(int userId){

		User user = getUserByUserId(userId);
		user.setDeletedFlag(1);
		update(user);		//HibernateTemplate().update()
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> queryAllUser() {
		return query("from com.livedoor.flow_manager.user.beans.User user where user.deletedFlag <> 1");
	}
	
	@SuppressWarnings("unchecked")
	public List<User> queryAllUser(final Page page) {

		return (List<User>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from com.livedoor.flow_manager.user.beans.User user " +
			        			" where user.deletedFlag <> 1";	
			        	Query query = session.createQuery(querySentence);
			    		query	.setFirstResult(page.getBeginIndex()-1)
			    				.setMaxResults(page.getPageSize())
			    				//此处使用User的cache
//			    				.setCacheable(true)
//			    				.setCacheRegion("com.livedoor.flow_manager.Users.beans.User")
			    				//
			    				;
			    		return query.list();
			        }
			    }
			,true);		
	
	}

	
	public User getUserByUserId(Integer userId) {
		return (User)get(User.class, userId);	//HibernateTemplate().get()
	}

	
	@SuppressWarnings("unchecked")
	public List<User> getUserByUserName(String userName) {
		String hql = "from com.livedoor.flow_manager.user.beans.User as user where user.userName like ? and user.deletedFlag <> 1";
		return query(hql, "%" + userName + "%");
		
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserByNamePwd(String userName,String password) {
		String hql = "from com.livedoor.flow_manager.user.beans.User as user where user.userName = ? and user.userPassword = ? and user.deletedFlag <> 1";
		return query(hql, new String[]{userName,password});
		
	}

	

	/**
	 * @param user
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	
//	public List<User> getUserListByCriteriaQueryUser(User User)
//			throws IllegalAccessException, InstantiationException,
//			InvocationTargetException, NoSuchMethodException {
//
//		Session session = getHibernateTemplate().getSessionFactory()
//				.openSession();
//
//		Criteria cr = session.createCriteria(User.class);
//
//		if ( !UtilValidate.isEmpty(User) ) buildCriteriaFromUserObject(cr,User);
//
//		List<User> UserList = cr.list();
//
//		session.close();
//
//		return UserList;
//	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> getUserListByCriteriaQueryUser(final User user)
			throws IllegalAccessException, InstantiationException,
			InvocationTargetException, NoSuchMethodException {

		if(ObjectCommonUtil.isEmpty(user)) return new ArrayList<User>();
		
		return (List<User>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session)  {
			        	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
			        	Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			        	if( ! buildCriteriaFromUserObject(criteria, user))
			        		return new ArrayList<User>();
			        	
			    		return criteria.list();
			        }
			    }
		,true);	
	}
	

	@SuppressWarnings("unchecked")
	public List<User> getUserListByCriteriaQueryUser(final User user,final Page page)
			throws IllegalAccessException, InstantiationException,
			InvocationTargetException, NoSuchMethodException {

		if(ObjectCommonUtil.isEmpty(user)) 		return new ArrayList<User>();
		if(ObjectCommonUtil.isEmpty(page)) 		return new ArrayList<User>();
		
		return (List<User>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session)  {
			        	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
			        	Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			        	if( ! buildCriteriaFromUserObject(criteria, user))
			        		return new ArrayList<User>();
			        	
			        	criteria.setFirstResult(page.getBeginIndex()-1);
			        	criteria.setMaxResults(page.getPageSize());
			    		return criteria.list();
			        }
			    }
		,true);	
	}
	

	
	
	
//	@SuppressWarnings("unchecked")
//	public UserPageInfoBean 
//		getUserPageInfoBeanByCriteriaQueryUser(User User,int pageNo) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException
//			{
//
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		// Criteria cr = session.createCriteria(User.class);
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
//		
//		Criteria cr = detachedCriteria.getExecutableCriteria(session);
//		
//		if(! buildCriteriaFromUserObject(cr,User))
//			return new UserPageInfoBean();
//		
//		
//		int totalCount = ((Integer) cr.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//		
//		cr.setProjection( null );
//		
//		cr.setFirstResult( ( pageNo - 1 ) * PageConstant.User_PAGE_SIZE )
//			.setMaxResults( PageConstant.User_PAGE_SIZE );
//
//		List<User> UserList = cr.list();
//
//		UserPageInfoBean returnSP = UserPageInfoBean
//						.buildUserPageInfoBeanInstance(
//								totalCount, 
//								PageConstant.User_PAGE_SIZE,
//								pageNo,
//								UserList);
//		
//		session.close();
//
//		return returnSP;
//	}
	
	/**
	 * @param cr
	 * @param user
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private boolean buildCriteriaFromUserObject(Criteria cr,User user){
		try{
			if ( ObjectCommonUtil.isNotEmpty(user) ){
				
				if (StringCommonUtil.isNotEmpty(user.getUserName()))
					cr.add(Restrictions.like("userName", "%" + user.getUserName()+ "%"));
		
				if (StringCommonUtil.isNotEmpty(user.getUserDesc()))
					cr.add(Restrictions.like("userDesc", "%" + user.getUserDesc()+ "%"));
		
				if (ObjectCommonUtil.isNotEmpty(user.getInputUserId()))
					cr.add(Restrictions.eq("inputUserId", user.getInputUserId()));
	
				
				
				if (ObjectCommonUtil.isNotEmpty(user.getInputDatetime())) {
					Calendar end = (Calendar) BeanUtils.cloneBean(user.getInputDatetime());
					end.add(Calendar.DAY_OF_MONTH, 1);
					cr.add(Restrictions.between("inputDatetime", user.getInputDatetime(), end));
				}
		
				if (ObjectCommonUtil.isNotEmpty(user.getUpdateDatetime())) {
					Calendar end = (Calendar) BeanUtils.cloneBean(user.getUpdateDatetime());
					end.add(Calendar.DAY_OF_MONTH, 1);
					cr.add(Restrictions.between("updateDatetime", user.getUpdateDatetime(), end));
				}
			}
			
			cr.add(Restrictions.ne("deletedFlag", 1));
			
		}catch(Exception e){
			log.error("buildCriteriaFromUserObject() error ! ",e);
			return false;
		}
		
		return true;
	}

	
	
//	public List<User> queryAllUser(Page page) {
//		
////		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		List<User> UserList = getSession()
//							.createQuery("from com.livedoor.flow_manager.Users.beans.User s where s.deletedFlag <> 1")
//							.setFirstResult(page.getBeginIndex()-1)
//							.setMaxResults(page.getPageSize())
//							.setCacheable(true)
////							.setCacheRegion("com.livedoor.flow_manager.common.cacheTemplate")
//							.list();
//
////		session.close();
//
//		return UserList;
//	}
	
	
	public int getUserCount() throws HibernateException {
//        List countTemp;
//        String querySentence = 
//        	"SELECT count(*) FROM com.livedoor.flow_manager.Users.beans.User s where s.deletedFlag <> 1";
//        countTemp = query(querySentence);
//        return 	(countTemp.size() > 0 ? ((Long)countTemp.get(0)).intValue() : 0 );
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		
		return queryRowCount(detachedCriteria);
    }
	
	public int getUserCount(final User User) throws HibernateException {
	
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromUserObject(criteria, User);
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);
  }
	
	
	
	/**
	 * Test Transaction
	 * 
	 * @throws DataAccessException
	 */
//	public void insertMany() throws DataAccessException {
//		try {
//
//			// User s1 = new User();
//			//		
//			// User insertAndUpdateUser = new User();
//			// insertAndUpdateUser.setId(3);
//			//		
//			// // s1.setUserId(1000);//����
//			// s1.setUserName("1000s");
//			// s1.setDeletedFlag(0);
//			// s1.setInputeDatetime(Calendar.getInstance());
//			// s1.setUpdateDatetime(Calendar.getInstance());
//			// s1.setInputUser(insertAndUpdateUser);
//			// s1.setUpdateUser(insertAndUpdateUser);
//			// save(s1);
//			// =========================================================
//			User s2 = new User();
//
//			// User insertAndUpdateUser2 = new User();
//			// insertAndUpdateUser2.setId(3);
//
//			// s2.setUserId(1000);//����
//			s2.setUserName("2000s");
//			s2.setDeletedFlag(0);
//			s2.setInputeDatetime(Calendar.getInstance());
//			s2.setUpdateDatetime(Calendar.getInstance());
//			// s2.getInputUser().getUserName().replace("a", "z");
//			// s1.setInputUser(insertAndUpdateUser2);
//			// s1.setUpdateUser(insertAndUpdateUser2);
//			save(s2);
//
//		} catch (Exception e) {
//			log.error("<<<<<<< UserDao.insertMany() exception ! then throw new UserException ! >>>>>>>>"); 
//			throw new UserExcption(e.getMessage());
//		}
//
//	}
//	
//	public void testRuntimeException(){
//		int a=1,b=0;
//		int c = a/b;
//	}
//	
//	public void testOtherCheckedException() throws OtherCheckedException{
//		throw new OtherCheckedException();
//	}
}
