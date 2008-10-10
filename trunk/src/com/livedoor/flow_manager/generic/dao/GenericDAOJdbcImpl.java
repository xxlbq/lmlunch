package com.livedoor.flow_manager.generic.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GenericDAOJdbcImpl extends JdbcDaoSupport implements IGenericDAO{

	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public Object get(Class entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List query(String hql, Object paramObj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List query(String hql, Object[] paramObjs) {
		// TODO Auto-generated method stub
		return null;
	}

	public List query(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryByCriteria(DetachedCriteria detachedCriteria, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public int queryRowCount(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Serializable save(Object entity) {
//		getJdbcTemplate().execute("insert into t_source VALUES ('100','springtest',null,null,3,'2006-11-19 18:16:52',3,'2006-11-19 18:16:52',0,'test');");
		return null;
	}
	
	public void save(String sql){
		getJdbcTemplate().execute(sql);
	}
	
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}
	
	

}
