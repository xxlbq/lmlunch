package com.livedoor.flow_manager.gem;

import java.util.List;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.tools.lbq.Page;

public class GemService implements IGemService{

	private final static Logger log = Logger.getLogger(GemService.class);
	
	private GemDao gemDao;

	public void setGemDao(GemDao GemDao) {
		this.gemDao = GemDao;
	}
	

	
	
	public void addGem(Gem s) throws Exception {
		try {
			gemDao.save(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteGem(Gem s) throws Exception {
		try {
			gemDao.delete(s);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}	
	}

	public void deleteGemByDeleteFlag(Gem s) throws Exception {
		s.setActiveFlag(0);
		updateGem(s);
	}

	public void deleteGemByDeleteFlag(int sid) throws Exception {
		Gem s = getGemByGemId(sid);
		s.setActiveFlag(0);
		updateGem(s);
	}

	public Gem getGemByGemId(Integer sid) throws Exception {
		Gem s = null;
		try {
			s = (Gem)gemDao.get(Gem.class, sid);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return s;	
	}

	public List<Gem> getGemByGemName(String sname) throws Exception {
		List<Gem> sList = null;
		try {
			sList = gemDao.getGemByGemName(sname);
		}  catch (Exception e){
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public int getGemCount() throws Exception {
		
		int count = -1 ;
		try {
			count= gemDao.getGemCount();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
        return count;
	}

	public List<Gem> getFoodListByCriteriaQueryFood(Gem f, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Gem> getFoodListByCriteriaQueryFood(Gem f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> getGroupsByFood(Gem f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Gem> queryAllGem() throws Exception {
		List<Gem> sList = null;
		try {
			sList= gemDao.queryAllGem();
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public List<Gem> queryAllGem(final Page page) throws Exception {
		List<Gem> sList = null;
		try {
			sList= gemDao.queryAllGems(page);
			
		} catch (Exception e) {
			log.error("",e);
			throw new Exception("",e);
		}
		return sList;
	}

	public void updateGem(Gem f) throws Exception {
		try {
			gemDao.update(f);
		} catch (Exception e){
			log.error("",e);
			throw new Exception("",e);		}	
	}

	
}
