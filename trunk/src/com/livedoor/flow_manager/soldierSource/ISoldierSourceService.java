package com.livedoor.flow_manager.soldierSource;

import java.util.List;

import org.hibernate.HibernateException;

import com.livedoor.flow_manager.sources.exception.SourceException;
import com.livedoor.flow_manager.tools.lbq.Page;

public interface ISoldierSourceService {

	void addSoldierSource(SoldierSource s) throws Exception;

	SoldierSource getSoldierSourceBySoldierSourceId(Integer sid)
			throws Exception;

	List<SoldierSource> getSoldierSourceBySoldierSourceName(String sname)
			throws Exception;

	int getSoldierSourceCount() throws Exception;

	List<SoldierSource> queryAllSoldierSource() throws Exception;


	void updateSoldierSource(SoldierSource f) throws Exception;

	int getSoldierSourceCount(SoldierSource soldierSource)
			throws HibernateException;

	List<SoldierSource> getSourceListByCriteriaQuerySource(
			SoldierSource soldierSource, Page page) throws SourceException;



}
