package com.livedoor.flow_manager.gemSource;

import java.util.List;

import org.hibernate.HibernateException;

import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.sources.exception.SourceException;
import com.livedoor.flow_manager.tools.lbq.Page;

public interface IGemSourceService {

	void addGemSource(GemSource s) throws Exception;

	GemSource getGemSourceByGemSourceId(Integer sid)
			throws Exception;

	List<GemSource> getGemSourceByGemSourceName(String sname)
			throws Exception;

	int getGemSourceCount() throws Exception;

	List<GemSource> queryAllGemSource() throws Exception;


	void updateGemSource(GemSource f) throws Exception;

	int getGemSourceCount(GemSource GemSource)
			throws HibernateException;

	List<GemSource> getSourceListByCriteriaQuerySource(
			GemSource GemSource, Page page) throws SourceException;
	
	List<GemSource> getSourceListByCriteriaQuerySource(
			GemSource GemSource) throws SourceException;
	
	boolean queryUniqueGemSourceAlready(GemSource gs) throws Exception;

	public List queryAllGemSourceDate();

	List<Object[]> queryTotalGemSourcePoint(GemSource g) throws SourceException;

}
