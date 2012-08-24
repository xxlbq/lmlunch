package com.livedoor.flow_manager.soldier;

import java.util.List;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.tools.lbq.Page;

public class SoldierService implements ISoldierService{

	private final static Logger log = Logger.getLogger(SoldierService.class);
	
	private SoldierDao soldierDao;

	public void setSoldierDao(SoldierDao soldierDao) {
		this.soldierDao = soldierDao;
	}
	

	
	
	public void addSoldier(Soldier s) throws Exception {
		try {
			soldierDao.save(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteSoldier(Soldier s) throws Exception {
		try {
			soldierDao.delete(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteSoldierByDeleteFlag(Soldier s) throws Exception {
		s.setActiveFlag(0);
		updateSoldier(s);
	}

	public void deleteSoldierByDeleteFlag(int sid) throws Exception {
		Soldier s = getSoldierBySoldierId(sid);
		s.setActiveFlag(0);
		updateSoldier(s);
	}

	public Soldier getSoldierBySoldierId(Integer sid) throws Exception {
		Soldier s = null;
		try {
			s = (Soldier)soldierDao.get(Soldier.class, sid);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return s;	
	}

	public List<Soldier> getSoldierBySoldierName(String sname) throws Exception {
		List<Soldier> sList = null;
		try {
			sList = soldierDao.getSoldierBySoldierName(sname);
		}  catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public int getSoldierCount() throws Exception {
		
		int count = -1 ;
		try {
			count= soldierDao.getSoldierCount();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
        return count;
	}

	public List<Soldier> getFoodListByCriteriaQueryFood(Soldier f, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Soldier> getFoodListByCriteriaQueryFood(Soldier f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> getGroupsByFood(Soldier f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Soldier> queryAllSoldier() throws Exception {
		List<Soldier> sList = null;
		try {
			sList= soldierDao.queryAllSoldier();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public List<Soldier> queryAllSoldier(final Page page) throws Exception {
		List<Soldier> sList = null;
		try {
			sList= soldierDao.queryAllSoldiers(page);
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public void updateSoldier(Soldier f) throws Exception {
		try {
			soldierDao.update(f);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);		}	
	}

	
}
