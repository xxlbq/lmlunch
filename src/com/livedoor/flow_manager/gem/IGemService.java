package com.livedoor.flow_manager.gem;

import java.util.List;

import com.livedoor.flow_manager.tools.lbq.Page;

public interface IGemService {

	void addGem(Gem s) throws Exception;

	void updateGem(Gem f) throws Exception;

	List<Gem> queryAllGem(Page page) throws Exception;

	List<Gem> queryAllGem() throws Exception;

	int getGemCount() throws Exception;

	List<Gem> getGemByGemName(String sname) throws Exception;

	Gem getGemByGemId(Integer sid) throws Exception;

	void deleteGemByDeleteFlag(int sid) throws Exception;

	void deleteGemByDeleteFlag(Gem s) throws Exception;

	void deleteGem(Gem s) throws Exception;

}
