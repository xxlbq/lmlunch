package com.livedoor.flow_manager.soldier;

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
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

public class SoldierDao extends GenericDAOHibernateImpl{

	private final static Logger log = Logger.getLogger(SoldierDao.class);
	
	public void addSoldier(Soldier f) {
		save(f);
	}

	public void deleteSoldier(Soldier f) {
		delete(f);		//	HibernateTemplate().delete()		
	}

	public void deleteSoldierByDeleteFlag(Soldier s) {
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()		
	}

	public void deleteSoldierByDeleteFlag(int sid){

		Soldier s = getSoldierBySoldierId(sid);
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()
	}
	
	public Soldier getSoldierBySoldierId(Integer sid) {
		return (Soldier)get(Soldier.class, sid);	//HibernateTemplate().get()
	}

	public List<Soldier> getSoldierBySoldierName(String soldierName) {
		String hql = "from Soldier as s where s.solderName like ? and s.activeFlag <> 1";
		return query(hql, "%" + soldierName + "%");
	}


	public List<Soldier> queryAllSoldier() {
		return query("from Soldier as s where s.activeFlag = 1");
	}

	public List<Soldier> queryAllSoldiers(final Page page) {

		return (List<Soldier>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from Soldier s " +
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

	public void updateSoldier(Soldier s) {
		update(s);		//HibernateTemplate().update()	
	}
	
	public int getSoldierCount() throws HibernateException {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Soldier.class);
		
		return queryRowCount(detachedCriteria);
	}
	
	
	public int getSoldierCount(final Soldier s) throws HibernateException {
		
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Soldier.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromSoldierObject(criteria, s);
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);
	}
	
	private boolean buildCriteriaFromSoldierObject(Criteria cr,Soldier s){
		try{
		if ( !ObjectCommonUtil.isEmpty(s) ){
			
			if (StringCommonUtil.isNotEmpty(s.getSoldierName())){
				cr.add(Restrictions.like("SoldierName", "%" + s.getSoldierName()+ "%"));
			}
			
			if(ObjectCommonUtil.isNotEmpty(s.getSoldierPoint())){
				cr.add(Restrictions.eq("SoldierPrice", s.getSoldierPoint()));
			}
	
//			if (!UtilValidate.isEmpty(Soldier.getSourceDesc()))
//	
//				cr.add(Restrictions.like("sourceDesc", "%" + Soldier.getSourceDesc()+ "%"));
//	
//			if (!UtilValidate.isEmpty(Soldier.getInputUserId()))
//	
//				cr.add(Restrictions.eq("inputUser", Soldier.getInputUser()));
//			
//			if (!UtilValidate.isEmpty(Soldier.getUpdateUserId()))
//	
//				cr.add(Restrictions.eq("updateUser", Soldier.getUpdateUser()));
//			
//			
			if (ObjectCommonUtil.isNotEmpty(s.getInputDate())) {
	
				Calendar end = (Calendar) BeanUtils.cloneBean(s.getInputDate());
	
				end.add(Calendar.DAY_OF_MONTH, 1);
	
				cr.add(Restrictions.between("inputDate", s.getInputDate(), end));
			}
//	
//			if (!UtilValidate.isEmpty(Soldier.getUpdateDatetime())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(Soldier.getUpdateDatetime());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("updateDatetime", Soldier.getUpdateDatetime(), end));
//			}
		}
		
		cr.add(Restrictions.eq("activeFlag", 1));
		
		
		
		}catch(Exception e){
			log.error("buildCriteriaFromSourceObject() error ! ",e);
			return false;
		}
		
		return true;
		
	}
}
