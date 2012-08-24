package com.livedoor.flow_manager.kingdom;

import java.util.List;

import com.livedoor.flow_manager.tools.lbq.Page;

public interface IKingdomService {

	void updateKingdom(Kingdom f) throws Exception;

	List<Kingdom> queryAllKingdom(Page page) throws Exception;

	List<Kingdom> queryAllKingdom() throws Exception;

	int getKingdomCount() throws Exception;

	List<Kingdom> getKingdomByKingdomName(String sname) throws Exception;

	Kingdom getKingdomByKingdomId(Integer sid) throws Exception;

	void deleteKingdomByDeleteFlag(int sid) throws Exception;

	void deleteKingdomByDeleteFlag(Kingdom s) throws Exception;

	void deleteKingdom(Kingdom s) throws Exception;

	void addKingdom(Kingdom s) throws Exception;

}
