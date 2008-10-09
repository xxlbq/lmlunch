package com.livedoor.flow_manager.common.entity;

public class Group {
	
	private String groupType;
	private String groupCount;
	private String groupMak;
	public Group(){}
	public Group(String type,String count,String mark){
		this.groupType = type;
		this.groupCount = count;
		this.groupMak = mark;
	}
	
	public String getGroupCount() {
		return groupCount;
	}
	public void setGroupCount(String groupCount) {
		this.groupCount = groupCount;
	}
	public String getGroupMak() {
		return groupMak;
	}
	public void setGroupMak(String groupMak) {
		this.groupMak = groupMak;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	
	

}
