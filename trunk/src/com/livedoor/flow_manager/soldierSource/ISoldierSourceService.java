package com.livedoor.flow_manager.soldierSource;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;

import com.livedoor.flow_manager.sources.exception.SourceException;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.user.beans.User;

public interface ISoldierSourceService {

	void addSoldierSource(SoldierSource s) throws Exception;

	SoldierSource getSoldierSourceBySoldierSourceId(String sid)
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

	List<Object[]> getKingdomSoldierSourceCountOfWeek(Integer kingdomId,
			String date);

	BigDecimal queryTotalSoldierSourcePoint(String date, Integer kingdomId);

	void updateSoldierSourceApprove(String id, Integer approve, User user);

	List queryAllSoldierSourceDate();



}
