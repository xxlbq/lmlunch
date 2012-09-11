package com.livedoor.flow_manager.kingdom;

import java.util.Date;

public class Kingdom {
	
	Integer kingdomId;
	String kingdomName;
	String inputStaffId;
	String updateStaffId;
	Date inputDate;
	Date updateDate;
	
	int activeFlag;

	
	
	


	public Kingdom() {
		super();
	}

	public Kingdom(Integer kingdomId) {
		super();
		this.kingdomId = kingdomId;
	}



	public Kingdom(Integer kingdomId, String kingdomName) {
		super();
		this.kingdomId = kingdomId;
		this.kingdomName = kingdomName;
	}

	public Integer getKingdomId() {
		return kingdomId;
	}

	public void setKingdomId(Integer kingdomId) {
		this.kingdomId = kingdomId;
	}

	public String getKingdomName() {
		return kingdomName;
	}

	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}

	public String getInputStaffId() {
		return inputStaffId;
	}

	public void setInputStaffId(String inputStaffId) {
		this.inputStaffId = inputStaffId;
	}

	public String getUpdateStaffId() {
		return updateStaffId;
	}

	public void setUpdateStaffId(String updateStaffId) {
		this.updateStaffId = updateStaffId;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	
	
}
