package com.livedoor.flow_manager.sources.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.dao.imp.SourceDAO;
import com.livedoor.flow_manager.sources.dao.imp.SourceJdbcDAO;
import com.livedoor.flow_manager.sources.exception.SourceException;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.lm.common.util.obj.ObjectCommonUtil;

public class SourceService implements ISourceService{
//public class SourceService {
	
	private final static Logger log = Logger.getLogger(SourceService.class);
	
	private SourceDAO sourceDao;
	private SourceJdbcDAO sourceJdbcDao;
	
//	public SourceDAO getSourceDao() {
//		return sourceDao;
//	}

	public void setSourceDao(SourceDAO sourceDao) {
		this.sourceDao = sourceDao;
	}
	
	
	
	public void setSourceJdbcDao(SourceJdbcDAO sourceJdbcDao) {
		this.sourceJdbcDao = sourceJdbcDao;
	}



	/*================= service ==========================*/
	///////////////////////////////////////////
	//		Spring Rollback Transactions Methods ---> SETUP IN XML
	///////////////////////////////////////////
	public void addSource(Source s) {
			
		try {
			s.setSourceFoodSum(s.getSourceFoodPrice().multiply(new BigDecimal(s.getSourceFoodCount())) );
			sourceDao.save(s);
			
//			sourceDao.insertMany();	//test custom Exception
//			sourceDao.testRuntimeException();//test runtime exception
			
///////////////////////////////////////////			
//			sourceDao.testOtherCheckedException();//test CheckedException
//		} catch (OtherCheckedException oe){
//			throw oe;
///////////////////////////////////////////			
			
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In addSource() method ]++++++",e);
			throw new SourceException(1000,"addSource() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%%[Other Exception In  addSource() method ]%%%%%%%",e);
			throw new SourceException(9999,"addSource() error! :"+e.getMessage());
		}
	}
	
	public void updateSource(Source s) {
		try {
			sourceDao.update(s);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In updateSource() method ]++++++",e);
			throw new SourceException(1001,"updateSource() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%%[Other Exception In  updateSource() method ]%%%%%%%",e);
			throw new SourceException(9999,"updateSource() error! :"+e.getMessage());
		}		
	}
	
	
	public void deleteSource(Source s) {
		try {
			sourceDao.delete(s);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In deleteSource() method ]++++++",e);
			throw new SourceException(1002,"deleteSource() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  deleteSource() method ]%%%%%%%",e);
			throw new SourceException(9999,"deleteSource() error! :"+e.getMessage());
		}			
	}
	
	public void deleteSourceByDeleteFlag(Source s) {
		s.setDeletedFlag(1);
		updateSource(s);		
	}
	
	public void deleteSourceByDeleteFlag(int sourceId){

		Source source = getSourceBySourceId(sourceId);
		source.setDeletedFlag(1);
		updateSource(source);		
	}
	
	
	///////////////////////////////////////////
	//		Spring ReadOnly Transactions Methods   ---> SETUP IN XML
	///////////////////////////////////////////
	
	public Source getSourceBySourceId(Integer sourceId) {
		
		if(ObjectCommonUtil.isEmpty(sourceId)) return null;
		
		Source s = null;
		try {
			s = (Source)sourceDao.get(Source.class, sourceId);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getSourceBySourceId(Integer sourceId) method ]++++++",e);
			throw new SourceException(1003,"getSourceBySourceId(Integer sourceId) error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getSourceBySourceId(Integer sourceId) method ]%%%%%%%",e);
			throw new SourceException(9999,"getSourceBySourceId(Integer sourceId) error! :"+e.getMessage());
		}
		return s;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Source> getSourceBySourceName(String sourceName) {
		List<Source> sList = null;
		try {
			sList = sourceDao.getSourceBySourceName(sourceName);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getSourceBySourceName method ]++++++",e);
			throw new SourceException(1004,"getSourceBySourceName() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getSourceBySourceName method ]%%%%%%%",e);
			throw new SourceException(9999,"getSourceBySourceName() error! :"+e.getMessage());
		}
		return sList;
	}
	
	public List<Source> getSourceListByCriteriaQuerySource(final Source source)
	throws SourceException {
		
		List<Source> sList = null;
		try {
			sList = sourceDao.getSourceListByCriteriaQuerySource(source);
			
		}catch (IllegalAccessException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s) error! :"+e.getMessage());
		}catch (InstantiationException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s) error! :"+e.getMessage());
		
		}catch (InvocationTargetException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s) error! :"+e.getMessage());
		
		}catch (NoSuchMethodException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s) error! :"+e.getMessage());
		
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getSourceListByCriteriaQuerySource(Source s) method ]++++++",e);
			throw new SourceException(1004,"getSourceListByCriteriaQuerySource(Source s) error! :"+e.getMessage());
			
		}catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getSourceListByCriteriaQuerySource method ]%%%%%%%",e);
			throw new SourceException(9999,"getSourceListByCriteriaQuerySource(Source s)  error! :"+e.getMessage());
		}
		
		return sList;
	}
	
	public List<Source> getSourceListByCriteriaQuerySource(final Source source,final Page page)
	throws SourceException {
		
		List<Source> sList = null;
		try {
			sList = sourceDao.getSourceListByCriteriaQuerySource(source,page);
			
		}catch (IllegalAccessException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s,Page page) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s,Page page) error! :"+e.getMessage());
		}catch (InstantiationException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s,Page page) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s,Page page) error! :"+e.getMessage());
		
		}catch (InvocationTargetException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s,Page page) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s,Page page) error! :"+e.getMessage());
		
		}catch (NoSuchMethodException e) {
			log.error("Maybe Hibernate Criteria Or Others Error !");
			log.error("+++@_@+++[ IllegalAccessException In getSourceListByCriteriaQuerySource(Source s,Page page) method ]++++++",e);
			throw new SourceException(1005,"getSourceListByCriteriaQuerySource(Source s,Page page) error! :"+e.getMessage());
		
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getSourceListByCriteriaQuerySource(Source s,Page page) method ]++++++",e);
			throw new SourceException(1004,"getSourceListByCriteriaQuerySource(Source s,Page page) error! :"+e.getMessage());
			
		}catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getSourceListByCriteriaQuerySource(Source s,Page page) method ]%%%%%%%",e);
			throw new SourceException(9999,"getSourceListByCriteriaQuerySource(Source s,Page page)  error! :"+e.getMessage());
		}
		
		return sList;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Source> queryAllSource() {
		
		List<Source> sList = null;
		try {
			sList= sourceDao.queryAllSource();
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In queryAllSource() method ]++++++",he);
			throw new SourceException(1004,"queryAllSource() error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In queryAllSource() method ]++++++",e);
			throw new SourceException(9999,"queryAllSource() error! :"+e.getMessage());
		}
		return sList;
		
	}
	
	public List<Source> queryAllSource(final Page page) {
		
		List<Source> sList = null;
		try {
			sList= sourceDao.queryAllSource(page);
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In queryAllSource(final Page page) method ]++++++",he);
			throw new SourceException(1004,"queryAllSource(final Page page) error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In queryAllSource(final Page page) method ]++++++",e);
			throw new SourceException(9999,"queryAllSource(final Page page) error! :"+e.getMessage());
		}
		return sList;
	}

	public int getSourceCount() throws HibernateException {
		
		int count = -1 ;
		
		try {
			count= sourceDao.getSourceCount();
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In getSourceCount() method ]++++++",he);
			throw new SourceException(1005,"getSourceCount() error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getSourceCount() method ]++++++",e);
			throw new SourceException(9999,"getSourceCount() error! :"+e.getMessage());
		}

        return count;
    }
	
	public int getSourceCount(final Source source) throws HibernateException {
		
		int count = -1 ;
		
		try {
			count= sourceDao.getSourceCount(source);
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In getSourceCount(source) method ]++++++",he);
			throw new SourceException(1005,"getSourceCount(source) error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getSourceCount(source) method ]++++++",e);
			throw new SourceException(9999,"getSourceCount(source) error! :"+e.getMessage());
		}

        return count;
    }
	///////////////////////////////////////////
	//		Get Mapping Collection Method  ---> Mapping in hibernate XML
	///////////////////////////////////////////
	
	
	public List<Group> getGroupsBySource(Source source) {
		
		List<Group> groupList = null;
		try {
			groupList = sourceDao.getGroupsBySource(source);
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getGroupsBySource(source) method ]++++++",e);
			throw new SourceException(9999,"getGroupsBySource(source) error! :"+e.getMessage());
		}
		
		
		return groupList;
	}
	
	///////////////////////////////////////////
	//		Get PageTemplate
	///////////////////////////////////////////
	
	
	
	/*================= Test Area========================*/
	
	/**
	 * Test Tran
	 * 
	 * @throws SourceException
	 */
	public void addTestInsert1() throws SourceException{
		
		try {
			sourceJdbcDao.save("insert into t_source VALUES ('100','springtest',null,null,3,'2006-11-19 18:16:52',3,'2006-11-19 18:16:52',0,'test');");
			//--
			sourceDao.insertMany();
		} catch (DataAccessException e) {
//			System.out.println("++++++++++@_@+++++++++");
			e.printStackTrace();
			throw new SourceException(100,"insertMany2 error! :"+e.getMessage());
		}catch (Exception e){
//			System.out.println("%%%% not customer exception%%%%%");
		}
		
	}

}
