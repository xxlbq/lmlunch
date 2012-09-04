package com.livedoor.flow_manager.soldierSource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
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
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

public class SoldierSourceDao extends GenericDAOHibernateImpl{

	private final static Logger log = Logger.getLogger(SoldierSourceDao.class);
	
	public void addSoldierSource(SoldierSource f) {
		save(f);
	}

	public void deleteSoldierSource(SoldierSource f) {
		delete(f);		//	HibernateTemplate().delete()		
	}

	public void deleteSoldierSourceByDeleteFlag(SoldierSource s) {
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()		
	}

	public void deleteSoldierSourceByDeleteFlag(int sid){

		SoldierSource s = getSoldierSourceBySoldierSourceId(sid);
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()
	}
	
	public SoldierSource getSoldierSourceBySoldierSourceId(Integer sid) {
		return (SoldierSource)get(SoldierSource.class, sid);	//HibernateTemplate().get()
	}

	public List<SoldierSource> getSoldierSourceBySoldierSourceName(String SoldierSourceName) {
		String hql = "from SoldierSource as s where s.solderName like ? and s.activeFlag <> 1";
		return query(hql, "%" + SoldierSourceName + "%");
	}


	public List<SoldierSource> queryAllSoldierSource() {
		return query("from SoldierSource as s where s.activeFlag = 1");
	}

	
	public List<SoldierSource> queryAllSoldierSources(final Page page) {

		return (List<SoldierSource>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from SoldierSource s " +
			        			" where s.activeFlag = 1";	
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

	public void updateSoldierSource(SoldierSource s) {
		update(s);		//HibernateTemplate().update()	
	}
	
	public int getSoldierSourceCount() throws HibernateException {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SoldierSource.class);
		
		return queryRowCount(detachedCriteria);
	}

	
	private boolean buildCriteriaFromSoldierSourceObject(Criteria cr,SoldierSource s){
		try{
		if ( !ObjectCommonUtil.isEmpty(s) ){
			
			if (ObjectCommonUtil.isNotEmpty(s.getUser()) && ObjectCommonUtil.isNotEmpty(s.getUser().getUserId()) && s.getUser().getUserId() > 0 ){
				cr.add(Restrictions.eq("user.userId", s.getUser().getUserId()));
			}
			
			if(ObjectCommonUtil.isNotEmpty(s.getKingdom().getKingdomId()) && s.getKingdom().getKingdomId() > 0){
				cr.add(Restrictions.eq("kingdom.kingdomId", s.getKingdom().getKingdomId()));
			}
			
			if(ObjectCommonUtil.isNotEmpty(s.getSoldier().getSoldierId()) && s.getSoldier().getSoldierId() > 0){
				cr.add(Restrictions.eq("soldier.soldierId", s.getSoldier().getSoldierId()));
			}
			
			if(StringUtils.isNotEmpty(s.getSourceDate())){
				cr.add(Restrictions.eq("sourceDate", s.getSourceDate()));
			}
			
			if(ObjectCommonUtil.isNotEmpty(s.getApproved()) && s.getApproved() >=0 ){
				cr.add(Restrictions.eq("approved", s.getApproved()));
			}
			
//			if (StringCommonUtil.isNotEmpty(s.getSolderName())){
//				cr.add(Restrictions.like("SoldierSourceName", "%" + s.getSolderName()+ "%"));
//			}
			
//			if(ObjectCommonUtil.isNotEmpty(s.getSoldierSourcePoint())){
//				cr.add(Restrictions.eq("SoldierSourcePrice", s.getSoldierSourcePoint()));
//			}
	
//			if (!UtilValidate.isEmpty(SoldierSource.getSourceDesc()))
//	
//				cr.add(Restrictions.like("sourceDesc", "%" + SoldierSource.getSourceDesc()+ "%"));
//	
//			if (!UtilValidate.isEmpty(SoldierSource.getInputUserId()))
//	
//				cr.add(Restrictions.eq("inputUser", SoldierSource.getInputUser()));
//			
//			if (!UtilValidate.isEmpty(SoldierSource.getUpdateUserId()))
//	
//				cr.add(Restrictions.eq("updateUser", SoldierSource.getUpdateUser()));
//			
//			
//			if (ObjectCommonUtil.isNotEmpty(s.getInputDate())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(s.getInputDate());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("inputDate", s.getInputDate(), end));
//			}
//	
//			if (!UtilValidate.isEmpty(SoldierSource.getUpdateDatetime())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(SoldierSource.getUpdateDatetime());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("updateDatetime", SoldierSource.getUpdateDatetime(), end));
//			}
		}
		
		cr.add(Restrictions.eq("activeFlag", 1));
		
		
		
		}catch(Exception e){
			log.error("buildCriteriaFromSourceObject() error ! ",e);
			return false;
		}
		
		return true;
		
	}

	
	
	public int getSoldierSourceCount(final SoldierSource s) throws HibernateException {
		
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SoldierSource.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromSoldierSourceObject(criteria, s);
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);
	}

	public List<SoldierSource> getSourceListByCriteriaQuerySource(final SoldierSource soldierSource,
			final Page page) throws IllegalAccessException,
			InstantiationException, InvocationTargetException,
			NoSuchMethodException {

		if (ObjectCommonUtil.isEmpty(soldierSource))
			return new ArrayList<SoldierSource>();
		if (ObjectCommonUtil.isEmpty(page))
			return new ArrayList<SoldierSource>();

		return (List<SoldierSource>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SoldierSource.class);
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						if (!buildCriteriaFromSoldierSourceObject(criteria, soldierSource))
							return new ArrayList<Source>();

						criteria.setFirstResult(page.getBeginIndex() - 1);
						criteria.setMaxResults(page.getPageSize());
						return criteria.list();
					}
				}, true);
	}

}
