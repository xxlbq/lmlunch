package com.livedoor.flow_manager.group_source.dao.inf;

import java.util.List;

import com.livedoor.flow_manager.group_source.beans.GroupSource;

public interface IGroupSource {
	
	/**
	 * @param groupSourceId
	 * @return groupSourceId GroupSource
	 */
	GroupSource getGroupSourceByGroupSourceId(Integer groupSourceId);

	/**
	 * @param s���GroupSource
	 */
	void addGroupSource(GroupSource s);

	/**
	 * @param s
	 */
	void updateGroupSource(GroupSource s);

	/**
	 * @param s
	 *
	 */
	void deleteGroupSource(GroupSource s);
	
	/**
	 * @param s
	 *GroupSource(DeleteFlag)
	 */
	void deleteGroupSourceByDeleteFlag(GroupSource s);

	/**
	 * @return
	 *GroupSource 
	 */
	List<GroupSource> queryAllGroupSource();
	
}
