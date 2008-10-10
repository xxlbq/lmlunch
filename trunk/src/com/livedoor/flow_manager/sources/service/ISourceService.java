package com.livedoor.flow_manager.sources.service;

import java.util.List;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.tools.lbq.Page;

public interface ISourceService {

	/*================= service ==========================*/
	///////////////////////////////////////////
	//		Spring Rollback Transactions Methods ---> SETUP IN XML
	///////////////////////////////////////////
	public void addSource(Source s);
	
	public void updateSource(Source s);
	
	
	public void deleteSource(Source s);
	
	public void deleteSourceByDeleteFlag(Source s);
	
	public void deleteSourceByDeleteFlag(int sourceId);
	
	
	///////////////////////////////////////////
	//		Spring ReadOnly Transactions Methods   ---> SETUP IN XML
	///////////////////////////////////////////
	
	public Source getSourceBySourceId(Integer sourceId);
	
	@SuppressWarnings("unchecked")
	public List<Source> getSourceBySourceName(String sourceName);
	
	public List<Source> getSourceListByCriteriaQuerySource(final Source source);
	
	public List<Source> getSourceListByCriteriaQuerySource(final Source source,final Page page);
	

	@SuppressWarnings("unchecked")
	public List<Source> queryAllSource();
	
	public List<Source> queryAllSource(final Page page);

	public int getSourceCount();
	
	public int getSourceCount(final Source source);
	///////////////////////////////////////////
	//		Get Mapping Collection Method  ---> Mapping in hibernate XML
	///////////////////////////////////////////
	
	public List<Group> getGroupsBySource(Source source);

	
}
