package com.livedoor.flow_manager.gemSource;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.exception.SourceException;
import com.livedoor.flow_manager.tools.lbq.Page;

public class GemSourceService implements IGemSourceService{

	private final static Logger LOGGER = Logger.getLogger(GemSourceService.class);
	
	private GemSourceDao GemSourceDao;

	public void setGemSourceDao(GemSourceDao GemSourceDao) {
		this.GemSourceDao = GemSourceDao;
	}
	

	
	
	public void addGemSource(GemSource s) throws Exception {
		try {
			GemSourceDao.addGemSource(s);
		} catch (Exception e){
			LOGGER.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteGemSource(GemSource s) throws Exception {
		try {
			GemSourceDao.delete(s);
		} catch (Exception e){
			LOGGER.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteGemSourceByDeleteFlag(GemSource s) throws Exception {
		s.setActiveFlag(0);
		updateGemSource(s);
	}

	public void deleteGemSourceByDeleteFlag(int sid) throws Exception {
		GemSource s = getGemSourceByGemSourceId(sid);
		s.setActiveFlag(0);
		updateGemSource(s);
	}

	public GemSource getGemSourceByGemSourceId(Integer sid) throws Exception {
		GemSource s = null;
		try {
			s = (GemSource)GemSourceDao.get(GemSource.class, sid);
		} catch (Exception e){
			LOGGER.error("",e);
			throw new Exception("",e);
		}
		return s;	
	}

	public List<GemSource> getGemSourceByGemSourceName(String sname) throws Exception {
		List<GemSource> sList = null;
		try {
			sList = GemSourceDao.getGemSourceByGemSourceName(sname);
		}  catch (Exception e){
			LOGGER.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public int getGemSourceCount() throws Exception {
		
		int count = -1 ;
		try {
			count= GemSourceDao.getGemSourceCount();
			
		} catch (Exception e) {
			LOGGER.error("",e);
			throw new Exception("",e);
		}
        return count;
	}

	public int getGemSourceCount(final GemSource GemSource) throws HibernateException {
		
		int count = -1 ;
		
		try {
			count= GemSourceDao.getGemSourceCount(GemSource);
			
		} catch (Exception e) {
			LOGGER.error("+++@_@+++[ Other Exception In getSourceCount(source) method ]++++++",e);
			throw new SourceException(9999,"getSourceCount(source) error! :"+e.getMessage());
		}
		LOGGER.info("getGemSourceCount :"+count);
        return count;
    }
	
	public List<GemSource> getSourceListByCriteriaQuerySource(final GemSource GemSource,final Page page)
	throws SourceException {
		
		List<GemSource> sList = null;
		try {
			sList = GemSourceDao.getSourceListByCriteriaQuerySource(GemSource,page);
			
		
		}catch (Exception e){
			LOGGER.error("%%%@_@%%%[Other Exception In  getSourceListByCriteriaQuerySource(Source s,Page page) method ]%%%%%%%",e);
			throw new SourceException(9999,"getSourceListByCriteriaQuerySource(Source s,Page page)  error! :"+e.getMessage());
		}
		
		return sList;
	}
	

	
	
	public List<GemSource> getFoodListByCriteriaQueryFood(GemSource f, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GemSource> getFoodListByCriteriaQueryFood(GemSource f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> getGroupsByFood(GemSource f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GemSource> queryAllGemSource() throws Exception {
		List<GemSource> sList = null;
		try {
			sList= GemSourceDao.queryAllGemSource();
			
		} catch (Exception e) {
			LOGGER.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

//	public List<GemSource> queryAllGemSource(final Page page) throws Exception {
//		List<GemSource> sList = null;
//		try {
//			sList= GemSourceDao.queryAllGemSources(page);
//			
//		} catch (Exception e) {
//			log.error("",e);
//			throw new Exception("",e);
//		}
//		return sList;
//	}

	public void updateGemSource(GemSource f) throws Exception {
		try {
			GemSourceDao.update(f);
		} catch (Exception e){
			LOGGER.error("",e);
			throw new Exception("",e);		}	
	}




	@Override
	public boolean queryUniqueGemSourceAlready(GemSource gs) throws Exception {
		List<GemSource> gsList = GemSourceDao.getSourceListByCriteriaQuerySource(gs);
		return (gsList == null || gsList.size() >=1 ) ? true:false;
	}

	public List queryAllGemSourceDate() {
		return GemSourceDao.queryAllGemSourceDate();
	}
	

	public List<GemSource> getSourceListByCriteriaQuerySource(final GemSource GemSource)
	throws SourceException {
		
		List<GemSource> sList = null;
		try {
			sList = GemSourceDao.getSourceListByCriteriaQuerySource(GemSource);
			
		}catch (Exception e){
			LOGGER.error("%%%@_@%%%[Other Exception In  getSourceListByCriteriaQuerySource(Source s,Page page) method ]%%%%%%%",e);
			throw new SourceException(9999,"getSourceListByCriteriaQuerySource(Source s,Page page)  error! :"+e.getMessage());
		}
		
		return sList;
	}

	
}
