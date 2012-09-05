package com.livedoor.flow_manager.generic.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.livedoor.flow_manager.IConstant.SystemConstants;
import com.livedoor.flow_manager.sources.enums.DeleteFlagEnum;

public class GenericDAOHibernateImpl  
	extends HibernateDaoSupport implements IGenericDAO{
	
	
	public Serializable save(Object entity) {
		return getHibernateTemplate().save(entity);
	}

	public void update(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	public Object get(Class entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id,LockMode.UPGRADE);
	}
	
	public List query(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public List query(String hql, Object paramObj) {
		return getHibernateTemplate().find(hql,paramObj);
	}
	
	public List queryUseCache(String hql, Object paramObj) {
		getHibernateTemplate().setCacheQueries(true);
		getHibernateTemplate().setQueryCacheRegion(SystemConstants.QUERY_CACHE_PREFIX + "");
		return getHibernateTemplate().find(hql,paramObj);
	}

	public List query(String hql, Object[] paramObjs) {
		return getHibernateTemplate().find(hql,paramObjs);
	}

	public List queryByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	public List queryByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria,firstResult,maxResults);
	}

	public int queryRowCount(final DetachedCriteria detachedCriteria) {
		
//		   List countTemp;
//	        String querySentence = 
//	        	"SELECT count(*) FROM com.livedoor.flow_manager.sources.beans.Source s where s.deletedFlag <> 1";
//	        countTemp = query(querySentence);
//	        return 	(countTemp.size() > 0 ? ((Long)countTemp.get(0)).intValue() : 0 );
		
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				criteria.add(Restrictions.eq("deletedFlag", DeleteFlagEnum.NOT_DELETE_ENUM.getValue()));
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);

	}
	
	/**
	 * 执行update delete
	 * @param hibernateTemplate
	 * @param sql
	 * @return
	 */
	public Object executeSQL(HibernateTemplate hibernateTemplate,String sql){

	       final String tempsql = sql;

	       return hibernateTemplate.execute(new HibernateCallback(){

	           public Object doInHibernate(Session session)throws HibernateException{

	        	   Query q = session.createSQLQuery(tempsql) ;
	        	   return q.executeUpdate();
	           }

	       });

	    }

	/**
	 * 返回记录集
	 * @param hibernateTemplate
	 * @param sql
	 * @return
	 */
	public Object querySQL(HibernateTemplate hibernateTemplate,String sql){

	       final String tempsql = sql;

	       return hibernateTemplate.execute(new HibernateCallback(){

	           public Object doInHibernate(Session session)throws HibernateException{

	        	   Query q = session.createSQLQuery(tempsql) ;
	        	   return q.list();
	           }

	       });

	    }
	
	public List queryWithHQL(HibernateTemplate hibernateTemplate,String sql){

	       final String tempsql = sql;

	       return (List)hibernateTemplate.execute(new HibernateCallback(){

	           public Object doInHibernate(Session session)throws HibernateException{

	        	   List list=session.createQuery(tempsql).list();

	               return list;


	           }

	       });

	    }
	
}
