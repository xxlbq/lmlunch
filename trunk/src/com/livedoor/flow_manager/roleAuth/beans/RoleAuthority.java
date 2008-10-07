package com.livedoor.flow_manager.roleAuth.beans;

import java.util.Calendar;



public class RoleAuthority implements java.io.Serializable{
	
	private RoleAuthorityId id;
	

	private Integer selectedFlag;
	private String updateStaffId;
	private String inputStaffId;
	private Integer activeFlag;
	private Calendar inputDate;
	private Calendar updateDate;

	
	
	
	
	public RoleAuthority() {
		
	}
	
	public RoleAuthority(RoleAuthorityId id) {
		this.id = id;
	}
	

	
	

	public RoleAuthorityId getId() {
		return id;
	}
	public void setId(RoleAuthorityId id) {
		this.id = id;
	}
	public Integer getSelectedFlag() {
		return selectedFlag;
	}
	public void setSelectedFlag(Integer selectedFlag) {
		this.selectedFlag = selectedFlag;
	}
	public String getUpdateStaffId() {
		return updateStaffId;
	}
	public void setUpdateStaffId(String updateStaffId) {
		this.updateStaffId = updateStaffId;
	}
	public String getInputStaffId() {
		return inputStaffId;
	}
	public void setInputStaffId(String inputStaffId) {
		this.inputStaffId = inputStaffId;
	}
	public Integer getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Calendar getInputDate() {
		return inputDate;
	}
	public void setInputDate(Calendar inputDate) {
		this.inputDate = inputDate;
	}
	public Calendar getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
}
