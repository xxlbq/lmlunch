package com.livedoor.flow_manager.soldierSource;

import java.math.BigDecimal;
import java.util.Date;

import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.user.beans.User;

public class SoldierSource{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2733546925657151179L;
	private String sourceId;
	private User user;
	private Soldier soldier;
	private int sourceSoliderCount;
	private Kingdom kingdom;
	private BigDecimal sourceSoliderSumCount;
	private Integer approved;
	private String sourceDate;
	private String inputStaffId;
	private String updateStaffId;
	private Date inputDate;
	private Date updateDate;

	private int activeFlag;



	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}

	public int getSourceSoliderCount() {
		return sourceSoliderCount;
	}

	public void setSourceSoliderCount(int sourceSoliderCount) {
		this.sourceSoliderCount = sourceSoliderCount;
	}



	public BigDecimal getSourceSoliderSumCount() {
		return sourceSoliderSumCount;
	}

	public void setSourceSoliderSumCount(BigDecimal sourceSoliderSumCount) {
		this.sourceSoliderSumCount = sourceSoliderSumCount;
	}



	public Integer getApproved() {
		return approved;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	public String getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(String sourceDate) {
		this.sourceDate = sourceDate;
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

	

	public SoldierSource() {
		super();
	}


	
	
}
