package com.livedoor.flow_manager.generic.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IGenericDAO {
	
	Serializable save(Object entity);
	void update(Object entity);
	void delete(Object entity);
	List query(String hql);
	List query(String hql,Object paramObj);
	List query(String hql,Object[] paramObjs);
	List queryByCriteria(DetachedCriteria detachedCriteria);
	List queryByCriteria(DetachedCriteria detachedCriteria, int firstResult, int maxResults);
	int  queryRowCount(DetachedCriteria detachedCriteria);
	
	Object get(Class entityClass,Serializable id);
	
}
