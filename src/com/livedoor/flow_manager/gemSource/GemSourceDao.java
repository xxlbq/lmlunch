package com.livedoor.flow_manager.gemSource;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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
import com.livedoor.flow_manager.soldierSource.SoldierSource;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

public class GemSourceDao extends GenericDAOHibernateImpl{

	private final static Logger log = Logger.getLogger(GemSourceDao.class);
	
	public void addGemSource(GemSource f) {
		save(f);
	}

	public void deleteGemSource(GemSource f) {
		delete(f);		//	HibernateTemplate().delete()		
	}

	public void deleteGemSourceByDeleteFlag(GemSource s) {
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()		
	}

	public void deleteGemSourceByDeleteFlag(int sid){

		GemSource s = getGemSourceByGemSourceId(sid);
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()
	}
	
	public GemSource getGemSourceByGemSourceId(Integer sid) {
		return (GemSource)get(GemSource.class, sid);	//HibernateTemplate().get()
	}

	public List<GemSource> getGemSourceByGemSourceName(String GemSourceName) {
		String hql = "from GemSource as s where s.solderName like ? and s.activeFlag <> 1";
		return query(hql, "%" + GemSourceName + "%");
	}

	public List<GemSource> queryAllGemSource() {
		return query("from GemSource as s where s.activeFlag = 1");
	}

	/**
	 * @param date
	 * @return
	 */
	public List queryTotalGemSourcePoint(String date){
		return (List)this.querySQL(getHibernateTemplate(), "SELECT X.KINGDOM_ID,K.KINGDOM_NAME ,X.GEM_ID ,X.SC ,X.GP,X.SOURCE_GEM_DATE FROM ("+
				"SELECT S.KINGDOM_ID,S.GEM_ID,SUM(S.SOURCE_GEM_COUNT) SC,SUM(S.SOURCE_GEM_COUNT)* G.GEM_POINT GP ,S.SOURCE_GEM_DATE FROM T_GEM_SOURCE S LEFT JOIN T_GEM G ON S.GEM_ID=G.GEM_ID " +
				"WHERE S.SOURCE_GEM_DATE = '"+date+"' GROUP BY S.KINGDOM_ID,S.GEM_ID "
				+") AS X LEFT JOIN T_KINGDOM K ON K.KINGDOM_ID =  X.KINGDOM_ID ");
	}
	
	
	public List queryTotalGemSourcePointSum(String date,Integer kingdomId){
		return (List)this.querySQL(getHibernateTemplate(), "SELECT SUM(T.GP) TOTAL FROM (" +
				"SELECT S.KINGDOM_ID,S.GEM_ID,SUM(S.SOURCE_GEM_COUNT),SUM(S.SOURCE_GEM_COUNT)* G.GEM_POINT GP FROM T_GEM_SOURCE S LEFT JOIN T_GEM G ON S.GEM_ID=G.GEM_ID " +
				"WHERE S.SOURCE_GEM_DATE = '"+date+"' AND S.KINGDOM_ID = "+kingdomId+" GROUP BY S.KINGDOM_ID,S.GEM_ID) AS T ");
	}
	
	/**
	 * @param date
	 * @return
	 */
//	public List queryTotalGemSource(String date){
//		return (List)this.querySQL(getHibernateTemplate(), 
//				"SELECT S.KINGDOM_ID,S.GEM_ID,SUM(S.SOURCE_GEM_COUNT),SUM(S.SOURCE_GEM_COUNT)* G.GEM_POINT GP FROM T_GEM_SOURCE S LEFT JOIN T_GEM G ON S.GEM_ID=G.GEM_ID " +
//				"WHERE S.SOURCE_GEM_DATE = '"+date+"' GROUP BY S.KINGDOM_ID,S.GEM_ID ");
//	}
	/**
	 * List<Object[]>
	 * 
	 * Object[] --> String
	 * 
	 * @return
	 */
	public List queryAllGemSourceDate() {
		return query("SELECT DISTINCT(s.sourceGemDate) from GemSource as s where s.activeFlag = 1 ORDER BY s.sourceGemDate DESC LIMIT 24");
	}
	
//	public List queryOneWeekGemSource(String date){
//		return query("SELECT SUM(s.sourceGemCount) from GemSource as s where s.activeFlag = 1 AND s.sourceGemDate='"+date+"' GROUP BY s.gem.gemId ");
//	}
	
	
	public List<GemSource> queryAllGemSources(final Page page) {

		return (List<GemSource>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from GemSource s " +
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

	public void updateGemSource(GemSource s) {
		update(s);		//HibernateTemplate().update()	
	}
	
	public int getGemSourceCount() throws HibernateException {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GemSource.class);
		
		return queryRowCount(detachedCriteria);
	}

	
	private boolean buildCriteriaFromGemSourceObject(Criteria cr,GemSource s){
		try{
		if ( !ObjectCommonUtil.isEmpty(s) ){
			
			if (ObjectCommonUtil.isNotEmpty(s.getKingdom()) &&  ObjectCommonUtil.isNotEmpty(s.getKingdom().getKingdomId()) && s.getKingdom().getKingdomId() > 0 ){
				cr.add(Restrictions.eq("kingdom.kingdomId", s.getKingdom().getKingdomId()));
			}
			
			if(ObjectCommonUtil.isNotEmpty(s.getGem()) && ObjectCommonUtil.isNotEmpty(s.getGem().getGemId()) && s.getGem().getGemId() > 0){
				cr.add(Restrictions.eq("gem.gemId", s.getGem().getGemId()));
			}
			
			if(ObjectCommonUtil.isNotEmpty(s.getSourceGemDate())){
				cr.add(Restrictions.eq("sourceGemDate", s.getSourceGemDate()));
			}
//			
//			if(StringUtils.isNotEmpty(s.getSourceDate())){
//				cr.add(Restrictions.eq("sourceDate", s.getSourceDate()));
//			}
//			
//			if(ObjectCommonUtil.isNotEmpty(s.getApproved()) && s.getApproved() >=0 ){
//				cr.add(Restrictions.eq("approved", s.getApproved()));
//			}
			
//			if (StringCommonUtil.isNotEmpty(s.getSolderName())){
//				cr.add(Restrictions.like("GemSourceName", "%" + s.getSolderName()+ "%"));
//			}
			
//			if(ObjectCommonUtil.isNotEmpty(s.getGemSourcePoint())){
//				cr.add(Restrictions.eq("GemSourcePrice", s.getGemSourcePoint()));
//			}
	
//			if (!UtilValidate.isEmpty(GemSource.getSourceDesc()))
//	
//				cr.add(Restrictions.like("sourceDesc", "%" + GemSource.getSourceDesc()+ "%"));
//	
//			if (!UtilValidate.isEmpty(GemSource.getInputUserId()))
//	
//				cr.add(Restrictions.eq("inputUser", GemSource.getInputUser()));
//			
//			if (!UtilValidate.isEmpty(GemSource.getUpdateUserId()))
//	
//				cr.add(Restrictions.eq("updateUser", GemSource.getUpdateUser()));
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
//			if (!UtilValidate.isEmpty(GemSource.getUpdateDatetime())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(GemSource.getUpdateDatetime());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("updateDatetime", GemSource.getUpdateDatetime(), end));
//			}
		}
		
		cr.add(Restrictions.eq("activeFlag", 1));
		
		
		
		}catch(Exception e){
			log.error("buildCriteriaFromSourceObject() error ! ",e);
			return false;
		}
		
		return true;
		
	}

	
	
	public int getGemSourceCount(final GemSource s) throws HibernateException {
		
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GemSource.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromGemSourceObject(criteria, s);
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);
	}

	public List<GemSource> getSourceListByCriteriaQuerySource(final GemSource GemSource,
			final Page page) throws IllegalAccessException,
			InstantiationException, InvocationTargetException,
			NoSuchMethodException {

		if (ObjectCommonUtil.isEmpty(GemSource))
			return new ArrayList<GemSource>();
		if (ObjectCommonUtil.isEmpty(page))
			return new ArrayList<GemSource>();

		return (List<GemSource>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GemSource.class);
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						if (!buildCriteriaFromGemSourceObject(criteria, GemSource))
							return new ArrayList<Source>();

						criteria.setFirstResult(page.getBeginIndex() - 1);
						criteria.setMaxResults(page.getPageSize());
						return criteria.list();
					}
				}, true);
	}

	public List<GemSource> getSourceListByCriteriaQuerySource(final GemSource GemSource) throws Exception {

		if (ObjectCommonUtil.isEmpty(GemSource))
			return new ArrayList<GemSource>();

		return (List<GemSource>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GemSource.class);
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						if (!buildCriteriaFromGemSourceObject(criteria, GemSource))
							return new ArrayList<Source>();
						return criteria.list();
					}
				}, true);
	}
	
	
	
}
