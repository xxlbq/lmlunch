package com.livedoor.flow_manager.soldier;

import java.util.List;

import com.livedoor.flow_manager.tools.lbq.Page;

public interface ISoldierService {

	void updateSoldier(Soldier f) throws Exception;

	List<Soldier> queryAllSoldier(Page page) throws Exception;

	List<Soldier> queryAllSoldier() throws Exception;

	int getSoldierCount() throws Exception;

	List<Soldier> getSoldierBySoldierName(String sname) throws Exception;

	Soldier getSoldierBySoldierId(Integer sid) throws Exception;

	void deleteSoldierByDeleteFlag(int sid) throws Exception;

	void deleteSoldierByDeleteFlag(Soldier s) throws Exception;

	void deleteSoldier(Soldier s) throws Exception;

	void addSoldier(Soldier s) throws Exception;

}
