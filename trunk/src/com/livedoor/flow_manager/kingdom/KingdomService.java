package com.livedoor.flow_manager.kingdom;

import java.util.List;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.tools.lbq.Page;

public class KingdomService implements IKingdomService{

	private final static Logger log = Logger.getLogger(KingdomService.class);
	
	private KingdomDao KingdomDao;

	public void setKingdomDao(KingdomDao KingdomDao) {
		this.KingdomDao = KingdomDao;
	}
	

	
	
	public void addKingdom(Kingdom s) throws Exception {
		try {
			KingdomDao.save(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteKingdom(Kingdom s) throws Exception {
		try {
			KingdomDao.delete(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteKingdomByDeleteFlag(Kingdom s) throws Exception {
		s.setActiveFlag(0);
		updateKingdom(s);
	}

	public void deleteKingdomByDeleteFlag(int sid) throws Exception {
		Kingdom s = getKingdomByKingdomId(sid);
		s.setActiveFlag(0);
		updateKingdom(s);
	}

	public Kingdom getKingdomByKingdomId(Integer sid) throws Exception {
		Kingdom s = null;
		try {
			s = (Kingdom)KingdomDao.get(Kingdom.class, sid);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return s;	
	}

	public List<Kingdom> getKingdomByKingdomName(String sname) throws Exception {
		List<Kingdom> sList = null;
		try {
			sList = KingdomDao.getKingdomByKingdomName(sname);
		}  catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public int getKingdomCount() throws Exception {
		
		int count = -1 ;
		try {
			count= KingdomDao.getKingdomCount();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
        return count;
	}

	public List<Kingdom> getFoodListByCriteriaQueryFood(Kingdom f, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Kingdom> getFoodListByCriteriaQueryFood(Kingdom f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> getGroupsByFood(Kingdom f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Kingdom> queryAllKingdom() throws Exception {
		List<Kingdom> sList = null;
		try {
			sList= KingdomDao.queryAllKingdom();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public List<Kingdom> queryAllKingdom(final Page page) throws Exception {
		List<Kingdom> sList = null;
		try {
			sList= KingdomDao.queryAllKingdoms(page);
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public void updateKingdom(Kingdom f) throws Exception {
		try {
			KingdomDao.update(f);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);		}	
	}

	
}
