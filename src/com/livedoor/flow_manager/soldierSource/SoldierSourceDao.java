package com.livedoor.flow_manager.soldierSource;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.livedoor.flow_manager.enums.ApproveEnum;
import com.livedoor.flow_manager.generic.dao.GenericDAOHibernateImpl;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.user.beans.User;
import com.lm.common.util.obj.ObjectCommonUtil;

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

	public void deleteSoldierSourceByDeleteFlag(String sid){

		SoldierSource s = getSoldierSourceBySoldierSourceId(sid);
		s.setActiveFlag(0);
		update(s);		//HibernateTemplate().update()
	}
	
	public SoldierSource getSoldierSourceBySoldierSourceId(String sid) {
		return (SoldierSource)get(SoldierSource.class, sid);	//HibernateTemplate().get()
	}

	public void updateSoldierSource(SoldierSource s) {
		update(s);		//HibernateTemplate().update()	
	}
	
	public void queryAndUpdateSoldierSourceApprove(String id, Integer approve, User user){
		SoldierSource ss = getSoldierSourceBySoldierSourceId(id);
		ss.setApproved(approve);
		ss.setUpdateDate(new Date());
		ss.setUpdateStaffId(user.getUserDisplayName());
		updateSoldierSource(ss);
	}
	
	
	public void queryAndUpdateSoldierSource(String id, Integer kingdomId, Integer soldierId, BigDecimal soldierCount, User user){
		SoldierSource entity = getSoldierSourceBySoldierSourceId(id);
		
		Kingdom k = new Kingdom();
		k.setKingdomId(kingdomId);
		entity.setKingdom(k);
		
		Soldier s = new Soldier();
		s.setSoldierId(soldierId);
		entity.setSoldier(s);
		
		entity.setSourceSoliderCount(soldierCount);
		entity.setUpdateDate(new Date());
		entity.setUpdateStaffId(user.getUserDisplayName());
		updateSoldierSource(entity);
	}
	
	public List<SoldierSource> getSoldierSourceBySoldierSourceName(String SoldierSourceName) {
		String hql = "from SoldierSource as s where s.solderName like ? and s.activeFlag <> 1";
		return query(hql, "%" + SoldierSourceName + "%");
	}


	public List<SoldierSource> queryAllSoldierSource() {
		return query("from SoldierSource as s where s.activeFlag = 1");
	}

	/**
	 * 兵力分总数
	 * @param date
	 * @return
	 */
	public List queryTotalSoldierSourcePoint(String date,Integer kingdomId){
		return (List)this.querySQL(getHibernateTemplate(), "SELECT SUM(T.SP) TOTAL FROM ( " +
				"SELECT C.KINGDOM_ID,C.SOURCE_SOLDIER_ID,SUM(C.SOURCE_SOLDIER_COUNT),SUM(C.SOURCE_SOLDIER_COUNT)*S.SOLDIER_POINT SP FROM T_SOLDIER_SOURCE C LEFT JOIN T_SOLDIER S ON C.SOURCE_SOLDIER_ID = S.SOLDIER_ID " +
				"WHERE  C.SOURCE_DATE = '"+date+"' AND C.APPROVED = "+ApproveEnum.APPROVED.getValue()+"   AND C.KINGDOM_ID = "+kingdomId+" GROUP BY C.KINGDOM_ID,C.SOURCE_SOLDIER_ID ) AS T ");
	}
	
	public List<Object[]> querySoldierSourceGroupbySoldierId(String date,Integer kingdomId){
		return (List<Object[]>)this.querySQL(getHibernateTemplate(), 
				"SELECT C.KINGDOM_ID, K.KINGDOM_NAME,C.SOURCE_SOLDIER_ID,S.SOLDIER_NAME,SUM(C.SOURCE_SOLDIER_COUNT),SUM(C.SOURCE_SOLDIER_COUNT)*S.SOLDIER_POINT SP FROM T_SOLDIER_SOURCE C LEFT JOIN T_SOLDIER S ON C.SOURCE_SOLDIER_ID = S.SOLDIER_ID " +
				" LEFT JOIN T_KINGDOM K ON C.KINGDOM_ID = K.KINGDOM_ID " +
				"WHERE  C.SOURCE_DATE = '"+date+"' AND C.APPROVED = "+ApproveEnum.APPROVED.getValue()+" AND C.KINGDOM_ID = "+kingdomId+" GROUP BY C.KINGDOM_ID,C.SOURCE_SOLDIER_ID ");
	}
	
	public List queryTotalSoldierSource(Integer kingdomId,String date){
		return (List)this.querySQL(getHibernateTemplate(), 
        "SELECT "+
        "    C.KINGDOM_ID,"+
        "    K.KINGDOM_NAME,"+
        "   C.SOURCE_DATE ,"+
        "   U.USER_DISPLAY_NAME,"+
        "   C.USER_ID,"+
        "   C.SOURCE_SOLDIER_ID,"+
        "   SUM(C.SOURCE_SOLDIER_COUNT) SSC,"+
        "   SUM(C.SOURCE_SOLDIER_COUNT)*S.SOLDIER_POINT SP "+ 
        "FROM "+
        "   T_SOLDIER_SOURCE C "+ 
        "LEFT JOIN "+
        "    T_SOLDIER S "+ 
        "       ON S.SOLDIER_ID =  C.SOURCE_SOLDIER_ID "+ 
        "LEFT JOIN "+
        "   T_KINGDOM K "+
        "   	ON K.KINGDOM_ID = C.KINGDOM_ID "+ 
        "LEFT JOIN "+
        "   T_USER U "+
        "   	ON U.USER_ID = C.USER_ID "+ 
        "WHERE "+
        "   C.SOURCE_DATE = '"+date+"' "+ 
        "   AND C.KINGDOM_ID="+kingdomId+ " "+
        "   AND C.APPROVED = "+ApproveEnum.APPROVED.getValue()+" " +
        "GROUP BY "+
        "   C.KINGDOM_ID,"+
        "   C.USER_ID,"+
        "   C.SOURCE_SOLDIER_ID ");
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

	
	public List queryAllSoldierSourceDate() {
		return query("SELECT DISTINCT(s.sourceDate) from SoldierSource as s where s.activeFlag = 1 ORDER BY s.sourceDate DESC LIMIT 24");
	}
}
