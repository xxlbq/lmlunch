package com.livedoor.flow_manager.soldierSource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.exception.SourceException;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.lm.common.util.obj.ObjectCommonUtil;

public class SoldierSourceService implements ISoldierSourceService{

	private final static Logger log = Logger.getLogger(SoldierSourceService.class);
	
	private SoldierSourceDao soldierSourceDao;

	public void setSoldierSourceDao(SoldierSourceDao SoldierSourceDao) {
		this.soldierSourceDao = SoldierSourceDao;
	}
	

	
	
	public void addSoldierSource(SoldierSource s) throws Exception {
		try {
			soldierSourceDao.save(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteSoldierSource(SoldierSource s) throws Exception {
		try {
			soldierSourceDao.delete(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteSoldierSourceByDeleteFlag(SoldierSource s) throws Exception {
		s.setActiveFlag(0);
		updateSoldierSource(s);
	}

	public void deleteSoldierSourceByDeleteFlag(int sid) throws Exception {
		SoldierSource s = getSoldierSourceBySoldierSourceId(sid);
		s.setActiveFlag(0);
		updateSoldierSource(s);
	}

	public SoldierSource getSoldierSourceBySoldierSourceId(Integer sid) throws Exception {
		SoldierSource s = null;
		try {
			s = (SoldierSource)soldierSourceDao.get(SoldierSource.class, sid);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return s;	
	}

	public List<SoldierSource> getSoldierSourceBySoldierSourceName(String sname) throws Exception {
		List<SoldierSource> sList = null;
		try {
			sList = soldierSourceDao.getSoldierSourceBySoldierSourceName(sname);
		}  catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public int getSoldierSourceCount() throws Exception {
		
		int count = -1 ;
		try {
			count= soldierSourceDao.getSoldierSourceCount();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
        return count;
	}

	public int getSoldierSourceCount(final SoldierSource soldierSource) throws HibernateException {
		
		int count = -1 ;
		
		try {
			count= soldierSourceDao.getSoldierSourceCount(soldierSource);
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In getSourceCount(source) method ]++++++",he);
			throw new SourceException(1005,"getSourceCount(source) error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getSourceCount(source) method ]++++++",e);
			throw new SourceException(9999,"getSourceCount(source) error! :"+e.getMessage());
		}

        return count;
    }
	
	public List<SoldierSource> getSourceListByCriteriaQuerySource(final SoldierSource soldierSource,final Page page)
	throws SourceException {
		
		List<SoldierSource> sList = null;
		try {
			sList = soldierSourceDao.getSourceListByCriteriaQuerySource(soldierSource,page);
			
		
		}catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getSourceListByCriteriaQuerySource(Source s,Page page) method ]%%%%%%%",e);
			throw new SourceException(9999,"getSourceListByCriteriaQuerySource(Source s,Page page)  error! :"+e.getMessage());
		}
		
		return sList;
	}
	

	
	
	public List<SoldierSource> getFoodListByCriteriaQueryFood(SoldierSource f, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SoldierSource> getFoodListByCriteriaQueryFood(SoldierSource f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> getGroupsByFood(SoldierSource f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SoldierSource> queryAllSoldierSource() throws Exception {
		List<SoldierSource> sList = null;
		try {
			sList= soldierSourceDao.queryAllSoldierSource();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

//	public List<SoldierSource> queryAllSoldierSource(final Page page) throws Exception {
//		List<SoldierSource> sList = null;
//		try {
//			sList= soldierSourceDao.queryAllSoldierSources(page);
//			
//		} catch (Exception e) {
//			log.error("",e);
//			throw new Exception("",e);
//		}
//		return sList;
//	}

	public void updateSoldierSource(SoldierSource f) throws Exception {
		try {
			soldierSourceDao.update(f);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);		}	
	}

	
}
