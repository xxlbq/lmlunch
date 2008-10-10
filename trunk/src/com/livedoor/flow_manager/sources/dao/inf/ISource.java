package com.livedoor.flow_manager.sources.dao.inf;

import java.util.List;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.tools.lbq.Page;

public interface ISource {

	
	
	/**
	 * @param s 
	 *
	 *	add a new Source
	 */
	void addSource(Source s);

	/**
	 * @param s
	 * 
	 * 	update a new Source
	 */
	void updateSource(Source s);

	/**
	 * @param s
	 * 
	 * 	delete a new Source
	 */
	void deleteSource(Source s);

	/**
	 * @param s
	 * 
	 * 	update a Source set deleteFlag = 1 in database
	 */
	void deleteSourceByDeleteFlag(Source s);
	
	
	/**
	 * @return List<Source>
	 * 
	 * get all source list 
	 */
	List<Source> queryAllSource();
	
//	/**
//	 * Pagination
//	 * @param fromNumber
//	 * @param fetch
//	 * @return
//	 * 
//	 * 
//	 */
//	List<Source> queryPageSource(int begin,int fetch );
	
	List<Source> queryAllSource(Page page);

	/**
	 * @param sourceId
	 * @return
	 * 
	 * get source by given source id
	 */
	Source getSourceBySourceId(Integer sourceId);
	
	/**
	 * @param sourceName
	 * @return
	 * 
	 * query source by given source name
	 */
	List<Source> getSourceBySourceName(String sourceName);

	
	
	/**
	 * @param source
	 * @return
	 * 
	 * many-to-many mapping the group table
	 * 		the parameter source<Source> must be got with .get() or .load() method
	 */
	List<Group> getGroupsBySource(Source source);
	
}
