package com.livedoor.flow_manager.kingdom;

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

public class KingdomDao extends GenericDAOHibernateImpl{

	private final static Logger log = Logger.getLogger(KingdomDao.class);
	
	public void addKingdom(Kingdom f) {
		save(f);
	}

	public void deleteKingdom(Kingdom f) {
		delete(f);		//	HibernateTemplate().delete()		
	}

	public void deleteKingdomByDeleteFlag(Kingdom s) {
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()		
	}

	public void deleteKingdomByDeleteFlag(int sid){

		Kingdom s = getKingdomByKingdomId(sid);
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()
	}
	
	public Kingdom getKingdomByKingdomId(Integer sid) {
		return (Kingdom)get(Kingdom.class, sid);	//HibernateTemplate().get()
	}

	public List<Kingdom> getKingdomByKingdomName(String KingdomName) {
		String hql = "from Kingdom as s where s.KingdomName like ? and s.activeFlag <> 1";
		return query(hql, "%" + KingdomName + "%");
	}


	public List<Kingdom> queryAllKingdom() {
		return query("from Kingdom as s where s.activeFlag = 1");
	}

	public List<Kingdom> queryAllKingdoms(final Page page) {

		return (List<Kingdom>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from Kingdom s " +
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

	public void updateKingdom(Kingdom s) {
		update(s);		//HibernateTemplate().update()	
	}
	
	public int getKingdomCount() throws HibernateException {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kingdom.class);
		
		return queryRowCount(detachedCriteria);
	}
	
	
	public int getKingdomCount(final Kingdom s) throws HibernateException {
		
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Kingdom.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromKingdomObject(criteria, s);
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);
	}
	
	private boolean buildCriteriaFromKingdomObject(Criteria cr,Kingdom s){
		try{
		if ( !ObjectCommonUtil.isEmpty(s) ){
			
			if (StringCommonUtil.isNotEmpty(s.getKingdomName())){
				cr.add(Restrictions.like("KingdomName", "%" + s.getKingdomName()+ "%"));
			}
			
//			if(ObjectCommonUtil.isNotEmpty(s.getKingdomPoint())){
//				cr.add(Restrictions.eq("KingdomPrice", s.getKingdomPoint()));
//			}
	
//			if (!UtilValidate.isEmpty(Kingdom.getSourceDesc()))
//	
//				cr.add(Restrictions.like("sourceDesc", "%" + Kingdom.getSourceDesc()+ "%"));
//	
//			if (!UtilValidate.isEmpty(Kingdom.getInputUserId()))
//	
//				cr.add(Restrictions.eq("inputUser", Kingdom.getInputUser()));
//			
//			if (!UtilValidate.isEmpty(Kingdom.getUpdateUserId()))
//	
//				cr.add(Restrictions.eq("updateUser", Kingdom.getUpdateUser()));
//			
//			
			if (ObjectCommonUtil.isNotEmpty(s.getInputDate())) {
	
				Calendar end = (Calendar) BeanUtils.cloneBean(s.getInputDate());
	
				end.add(Calendar.DAY_OF_MONTH, 1);
	
				cr.add(Restrictions.between("inputDate", s.getInputDate(), end));
			}
//	
//			if (!UtilValidate.isEmpty(Kingdom.getUpdateDatetime())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(Kingdom.getUpdateDatetime());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("updateDatetime", Kingdom.getUpdateDatetime(), end));
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
