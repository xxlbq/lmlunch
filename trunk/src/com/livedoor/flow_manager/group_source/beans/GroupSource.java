package com.livedoor.flow_manager.group_source.beans;

import java.util.Calendar;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.beans.Source;

public class GroupSource {
	

	/**
	 *groupSourceId
	 */
	private Integer groupSourceId;

	/**
	 *groupId
	 */
	private Integer groupId;

	/**
	 *sourceId
	 */
	private Integer sourceId;

	/**
	 *inputUserId
	 */
	private Integer inputUserId;

	/**
	 *inputDatetime
	 */
	private Calendar inputDatetime;

	/**
	 *updateUserId
	 */
	private Integer updateUserId;

	/**
	 *updateDatetime
	 */
	private Calendar updateDatetime;

	/**
	 *deletedFlag
	 */
	private Integer deletedFlag;

	/**
	 *groupSourceDesc
	 */
	private String groupSourceDesc;
	

	public void GroupSource() {}
	
	public void GroupSource(Integer groupSourceId,
					Source source,
					Group group,
					Integer inputUserId,
					Calendar inputDatetime,
					Integer updateUserId,
					Calendar updateDatetime,
					Integer deletedFlag,
					String groupSourceDesc){
		
		this.groupSourceId = groupSourceId;
		this.inputUserId = inputUserId;
		this.inputDatetime = inputDatetime;
		this.updateUserId = updateUserId;
		this.updateDatetime = updateDatetime;
		this.deletedFlag = deletedFlag;
		this.groupSourceDesc = groupSourceDesc;
	}
	
	
	

	public Integer getGroupId() {
		return groupId;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public Integer getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupSourceDesc() {
		return groupSourceDesc;
	}

	public void setGroupSourceDesc(String groupSourceDesc) {
		this.groupSourceDesc = groupSourceDesc;
	}

	public Integer getGroupSourceId() {
		return groupSourceId;
	}

	public void setGroupSourceId(Integer groupSourceId) {
		this.groupSourceId = groupSourceId;
	}

	public Calendar getInputDatetime() {
		return inputDatetime;
	}

	public void setInputDatetime(Calendar inputDatetime) {
		this.inputDatetime = inputDatetime;
	}

	public Integer getInputUserId() {
		return inputUserId;
	}

	public void setInputUserId(Integer inputUserId) {
		this.inputUserId = inputUserId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public Calendar getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Calendar updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

}
