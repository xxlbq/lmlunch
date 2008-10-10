package com.livedoor.flow_manager.sources.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
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
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.livedoor.flow_manager.generic.dao.GenericDAOHibernateImpl;
import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.dao.inf.ISource;
import com.livedoor.flow_manager.sources.exception.OtherCheckedException;
import com.livedoor.flow_manager.sources.exception.SourceException;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

public class SourceDAO extends GenericDAOHibernateImpl implements ISource {
	
	private final static Logger log = Logger.getLogger(SourceDAO.class);

	public void addSource(Source s) {
		save(s);	//HibernateTemplate().save()
	}

	public void updateSource(Source s) {
		update(s);		//HibernateTemplate().update()
	}
	
	public void deleteSource(Source s) {
		delete(s);		//	HibernateTemplate().delete()
	}
	
	
	public void deleteSourceByDeleteFlag(Source s) {
		s.setDeletedFlag(1);
		update(s);		//HibernateTemplate().update()
	}
	

	public void deleteSourceByDeleteFlag(int sourceId){

		Source source = getSourceBySourceId(sourceId);
		source.setDeletedFlag(1);
		update(source);		//HibernateTemplate().update()
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Source> queryAllSource() {
		return query("from com.livedoor.flow_manager.sources.beans.Source s where s.deletedFlag <> 1");
	}
	
	@SuppressWarnings("unchecked")
	public List<Source> queryAllSource(final Page page) {

		return (List<Source>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from com.livedoor.flow_manager.sources.beans.Source s " +
			        			" where s.deletedFlag <> 1";	
			        	Query query = session.createQuery(querySentence);
			    		query	.setFirstResult(page.getBeginIndex()-1)
			    				.setMaxResults(page.getPageSize())
			    				//此处使用Source的cache
//			    				.setCacheable(true)
//			    				.setCacheRegion("com.livedoor.flow_manager.sources.beans.Source")
			    				//
			    				;
			    		return query.list();
			        }
			    }
			,true);		
	
	}

	
	public Source getSourceBySourceId(Integer sourceId) {
		return (Source)get(Source.class, sourceId);	//HibernateTemplate().get()
	}

	
	@SuppressWarnings("unchecked")
	public List<Source> getSourceBySourceName(String sourceName) {
		String hql = "from com.livedoor.flow_manager.sources.beans.Source as s where s.sourceName like ? and s.deletedFlag <> 1";
		return query(hql, "%" + sourceName + "%");
	}


	/**
	 * @param source
	 * @return
	 * 
	 * many-to-many mapping the group table
	 * 		the parameter source<Source> must be got with .get() or .load() method
	 */

//	@SuppressWarnings("unchecked")
	public List<Group> getGroupsBySource(Source source) {

		List<Group> groupList = new ArrayList<Group>();
		Iterator<Group> it = source.getGroupSet().iterator();

		while (it.hasNext()) {
			Group g = it.next();
			groupList.add(g);
		}
		return groupList;
	}


	/**
	 * @param source
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	
//	public List<Source> getSourceListByCriteriaQuerySource(Source source)
//			throws IllegalAccessException, InstantiationException,
//			InvocationTargetException, NoSuchMethodException {
//
//		Session session = getHibernateTemplate().getSessionFactory()
//				.openSession();
//
//		Criteria cr = session.createCriteria(Source.class);
//
//		if ( !UtilValidate.isEmpty(source) ) buildCriteriaFromSourceObject(cr,source);
//
//		List<Source> sourceList = cr.list();
//
//		session.close();
//
//		return sourceList;
//	}
	
	
	@SuppressWarnings("unchecked")
	public List<Source> getSourceListByCriteriaQuerySource(final Source source)
			throws IllegalAccessException, InstantiationException,
			InvocationTargetException, NoSuchMethodException {

		if(ObjectCommonUtil.isEmpty(source)) return new ArrayList<Source>();
		
		return (List<Source>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session)  {
			        	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Source.class);
			        	Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			        	if( ! buildCriteriaFromSourceObject(criteria, source))
			        		return new ArrayList<Source>();
			        	
			    		return criteria.list();
			        }
			    }
		,true);	
	}
	

	@SuppressWarnings("unchecked")
	public List<Source> getSourceListByCriteriaQuerySource(final Source source,final Page page)
			throws IllegalAccessException, InstantiationException,
			InvocationTargetException, NoSuchMethodException {

		if(ObjectCommonUtil.isEmpty(source)) 	return new ArrayList<Source>();
		if(ObjectCommonUtil.isEmpty(page)) 		return new ArrayList<Source>();
		
		return (List<Source>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session)  {
			        	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Source.class);
			        	Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			        	if( ! buildCriteriaFromSourceObject(criteria, source))
			        		return new ArrayList<Source>();
			        	
			        	criteria.setFirstResult(page.getBeginIndex()-1);
			        	criteria.setMaxResults(page.getPageSize());
			    		return criteria.list();
			        }
			    }
		,true);	
	}
	

	
	
	
//	@SuppressWarnings("unchecked")
//	public SourcePageInfoBean 
//		getSourcePageInfoBeanByCriteriaQuerySource(Source source,int pageNo) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException
//			{
//
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		// Criteria cr = session.createCriteria(Source.class);
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Source.class);
//		
//		Criteria cr = detachedCriteria.getExecutableCriteria(session);
//		
//		if(! buildCriteriaFromSourceObject(cr,source))
//			return new SourcePageInfoBean();
//		
//		
//		int totalCount = ((Integer) cr.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//		
//		cr.setProjection( null );
//		
//		cr.setFirstResult( ( pageNo - 1 ) * PageConstant.SOURCE_PAGE_SIZE )
//			.setMaxResults( PageConstant.SOURCE_PAGE_SIZE );
//
//		List<Source> sourceList = cr.list();
//
//		SourcePageInfoBean returnSP = SourcePageInfoBean
//						.buildSourcePageInfoBeanInstance(
//								totalCount, 
//								PageConstant.SOURCE_PAGE_SIZE,
//								pageNo,
//								sourceList);
//		
//		session.close();
//
//		return returnSP;
//	}
	
	/**
	 * @param cr
	 * @param source
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private boolean buildCriteriaFromSourceObject(Criteria cr,Source source){
		try{
		if ( ObjectCommonUtil.isNotEmpty(source) ){
			
			if (StringCommonUtil.isNotEmpty(source.getSourceName()))
	
				cr.add(Restrictions.like("sourceName", "%" + source.getSourceName()+ "%"));
	
//			if (!UtilValidate.isEmpty(source.getSourceDesc()))
//	
//				cr.add(Restrictions.like("sourceDesc", "%" + source.getSourceDesc()+ "%"));
//
			if (ObjectCommonUtil.isNotEmpty(source.getFood())
					&& ObjectCommonUtil.isNotEmpty(source.getFood().getFoodId()) && source.getFood().getFoodId()>0)
				
				cr.add(Restrictions.eq("food", source.getFood()));
			
			if (ObjectCommonUtil.isNotEmpty(source.getInputUserId()))
	
				cr.add(Restrictions.eq("inputUser", source.getInputUser()));
			
			if (ObjectCommonUtil.isNotEmpty(source.getUpdateUserId()))
	
				cr.add(Restrictions.eq("updateUser", source.getUpdateUser()));
			
			
			if (ObjectCommonUtil.isNotEmpty(source.getInputeDatetime())) {
	
				Calendar end = (Calendar) BeanUtils.cloneBean(source.getInputeDatetime());
	
				end.add(Calendar.DAY_OF_MONTH, 1);
	
				cr.add(Restrictions.between("inputeDatetime", source.getInputeDatetime(), end));
			}
	
			if (ObjectCommonUtil.isNotEmpty(source.getUpdateDatetime())) {
	
				Calendar end = (Calendar) BeanUtils.cloneBean(source.getUpdateDatetime());
	
				end.add(Calendar.DAY_OF_MONTH, 1);
	
				cr.add(Restrictions.between("updateDatetime", source.getUpdateDatetime(), end));
			}
		}
		
		cr.add(Restrictions.ne("deletedFlag", 1));
		
		
		
		}catch(Exception e){
			log.error("buildCriteriaFromSourceObject() error ! ",e);
			return false;
		}
		
		return true;
		
	}

	
	
//	public List<Source> queryAllSource(Page page) {
//		
////		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		List<Source> sourceList = getSession()
//							.createQuery("from com.livedoor.flow_manager.sources.beans.Source s where s.deletedFlag <> 1")
//							.setFirstResult(page.getBeginIndex()-1)
//							.setMaxResults(page.getPageSize())
//							.setCacheable(true)
////							.setCacheRegion("com.livedoor.flow_manager.common.cacheTemplate")
//							.list();
//
////		session.close();
//
//		return sourceList;
//	}
	
	
	public int getSourceCount() throws HibernateException {
//        List countTemp;
//        String querySentence = 
//        	"SELECT count(*) FROM com.livedoor.flow_manager.sources.beans.Source s where s.deletedFlag <> 1";
//        countTemp = query(querySentence);
//        return 	(countTemp.size() > 0 ? ((Long)countTemp.get(0)).intValue() : 0 );
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Source.class);
		
		return queryRowCount(detachedCriteria);
    }
	
	public int getSourceCount(final Source source) throws HibernateException {
	
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Source.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromSourceObject(criteria, source);
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
	public void insertMany() throws DataAccessException {
		try {

			// Source s1 = new Source();
			//		
			// User insertAndUpdateUser = new User();
			// insertAndUpdateUser.setId(3);
			//		
			// // s1.setSourceId(1000);//����
			// s1.setSourceName("1000s");
			// s1.setDeletedFlag(0);
			// s1.setInputeDatetime(Calendar.getInstance());
			// s1.setUpdateDatetime(Calendar.getInstance());
			// s1.setInputUser(insertAndUpdateUser);
			// s1.setUpdateUser(insertAndUpdateUser);
			// save(s1);
			// =========================================================
			Source s2 = new Source();

			// User insertAndUpdateUser2 = new User();
			// insertAndUpdateUser2.setId(3);

			// s2.setSourceId(1000);//����
			s2.setSourceName("2000s");
			s2.setDeletedFlag(0);
			s2.setInputDatetime(Calendar.getInstance());
			s2.setUpdateDatetime(Calendar.getInstance());
			// s2.getInputUser().getUserName().replace("a", "z");
			// s1.setInputUser(insertAndUpdateUser2);
			// s1.setUpdateUser(insertAndUpdateUser2);
			save(s2);

		} catch (Exception e) {
			log.error("<<<<<<< SourceDao.insertMany() exception ! then throw new SourceException ! >>>>>>>>"); 
			throw new SourceException(e.getMessage());
		}

	}
	
//	public void testRuntimeException(){
//		int a=1,b=0;
//		int c = a/b;
//	}
	
	public void testOtherCheckedException() throws OtherCheckedException{
		throw new OtherCheckedException();
	}
}
