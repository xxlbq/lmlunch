package com.livedoor.flow_manager.user.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.interfaces.IUser;

@SuppressWarnings("unchecked")
public class UserDaoImp extends HibernateDaoSupport implements IUser {

	public void addUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);	
	}

	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		String hql = "FROM User";
		return getHibernateTemplate().find(hql);
	}
	
	public List<User> getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		userName = "%"+userName+"%";
		String hql = "FROM User u WHERE u.UserName LIKE ?";
		return  getHibernateTemplate().find(hql,userName);
	}
	public User getUserByUserId(Integer UserId) {
		// TODO Auto-generated method stub
		String hql = "FROM User u WHERE u.Id = ?";
		return  (User)getHibernateTemplate().find(hql,UserId).get(0);
	}

}
