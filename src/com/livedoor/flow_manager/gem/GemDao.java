package com.livedoor.flow_manager.gem;

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

public class GemDao extends GenericDAOHibernateImpl{

	private final static Logger log = Logger.getLogger(GemDao.class);
	
	public void addGem(Gem f) {
		save(f);
	}

	public void deleteGem(Gem f) {
		delete(f);		//	HibernateTemplate().delete()		
	}

	public void deleteGemByDeleteFlag(Gem s) {
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()		
	}

	public void deleteGemByDeleteFlag(int sid){

		Gem s = getGemByGemId(sid);
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()
	}
	
	public Gem getGemByGemId(Integer sid) {
		return (Gem)get(Gem.class, sid);	//HibernateTemplate().get()
	}

	public List<Gem> getGemByGemName(String GemName) {
		String hql = "from Gem as s where s.solderName like ? and s.activeFlag <> 1";
		return query(hql, "%" + GemName + "%");
	}


	public List<Gem> queryAllGem() {
		return query("from Gem as s where s.activeFlag = 1");
	}

	public List<Gem> queryAllGems(final Page page) {

		return (List<Gem>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from Gem s " +
			        			" where s.activeFlag = 1";	
			        	Query query = session.createQuery(querySentence);
			    		query	.setFirstResult(page.getBeginIndex()-1)
			    				.setMaxResults(page.getPageSize())
			    				//æ­¤å?ä½¿ç?Source??ache
//			    				.setCacheable(true)
//			    				.setCacheRegion("com.livedoor.flow_manager.sources.beans.Source")
			    				//
			    				;
			    		return query.list();
			        }
			    }
			,true);
	}

	public void updateGem(Gem s) {
		update(s);		//HibernateTemplate().update()	
	}
	
	public int getGemCount() throws HibernateException {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Gem.class);
		
		return queryRowCount(detachedCriteria);
	}
	
	
	public int getGemCount(final Gem s) throws HibernateException {
		
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Gem.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromGemObject(criteria, s);
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);
	}
	
	private boolean buildCriteriaFromGemObject(Criteria cr,Gem s){
		try{
		if ( !ObjectCommonUtil.isEmpty(s) ){
			
//			if (StringCommonUtil.isNotEmpty(s.getGemName())){
//				cr.add(Restrictions.like("GemName", "%" + s.getGemName()+ "%"));
//			}
//			
//			if(ObjectCommonUtil.isNotEmpty(s.getGemPoint())){
//				cr.add(Restrictions.eq("GemPrice", s.getGemPoint()));
//			}
	
//			if (!UtilValidate.isEmpty(Gem.getSourceDesc()))
//	
//				cr.add(Restrictions.like("sourceDesc", "%" + Gem.getSourceDesc()+ "%"));
//	
//			if (!UtilValidate.isEmpty(Gem.getInputUserId()))
//	
//				cr.add(Restrictions.eq("inputUser", Gem.getInputUser()));
//			
//			if (!UtilValidate.isEmpty(Gem.getUpdateUserId()))
//	
//				cr.add(Restrictions.eq("updateUser", Gem.getUpdateUser()));
//			
//			
			if (ObjectCommonUtil.isNotEmpty(s.getInputDate())) {
	
				Calendar end = (Calendar) BeanUtils.cloneBean(s.getInputDate());
	
				end.add(Calendar.DAY_OF_MONTH, 1);
	
				cr.add(Restrictions.between("inputDate", s.getInputDate(), end));
			}
//	
//			if (!UtilValidate.isEmpty(Gem.getUpdateDatetime())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(Gem.getUpdateDatetime());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("updateDatetime", Gem.getUpdateDatetime(), end));
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
