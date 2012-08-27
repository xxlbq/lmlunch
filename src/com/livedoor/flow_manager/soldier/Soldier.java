package com.livedoor.flow_manager.soldier;

import java.math.BigDecimal;
import java.util.Date;

public class Soldier {
	
	Integer soldierId;
	String soldierName;
	BigDecimal soldierPoint;
	String inputStaffId;
	String updateStaffId;
	Date inputDate;
	Date updateDate;
	
	int activeFlag;

	
	
	


	public Soldier() {
		super();
	}

	public Soldier(Integer soldierId) {
		super();
		this.soldierId = soldierId;
	}



	public Integer getSoldierId() {
		return soldierId;
	}

	public void setSoldierId(Integer soldierId) {
		this.soldierId = soldierId;
	}

	public String getSoldierName() {
		return soldierName;
	}

	public void setSoldierName(String soldierName) {
		this.soldierName = soldierName;
	}

	public BigDecimal getSoldierPoint() {
		return soldierPoint;
	}

	public void setSoldierPoint(BigDecimal soldierPoint) {
		this.soldierPoint = soldierPoint;
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
