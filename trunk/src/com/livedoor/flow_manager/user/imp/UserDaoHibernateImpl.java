package com.livedoor.flow_manager.user.imp;

import java.util.List;

import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.interfaces.GenericHibernateDao;

public class UserDaoHibernateImpl extends GenericHibernateDao<User,Integer> implements UserDao {

	public User findById(Integer id, boolean lock) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	public List findByExample(User exampleInstance) {
		// TODO Auto-generated method stub
		return super.findByExample(exampleInstance);
	}

	public User makePersistent(User entity) {
		// TODO Auto-generated method stub
		return super.makePersistent(entity);
	}

	public void makeTransient(User entity) {
		// TODO Auto-generated method stub
		super.makeTransient(entity);
		
	}

}
