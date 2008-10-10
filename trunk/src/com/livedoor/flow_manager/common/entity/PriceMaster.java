package com.livedoor.flow_manager.common.entity;

import java.util.List;

public class PriceMaster {

	private String machineType;
	private String machineCount;
	private String machineMark;
	
	private List  groupList;
	
	
	
	
	
	
	public List getGroupList() {
		return groupList;
	}
	public void setGroupList(List groupList) {
		this.groupList = groupList;
	}
	public String getMachineMark() {
		return machineMark;
	}
	public void setMachineMark(String machineMark) {
		this.machineMark = machineMark;
	}
	
	public String getMachineCount() {
		return machineCount;
	}
	public void setMachineCount(String machineCount) {
		this.machineCount = machineCount;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	
	
	
}
