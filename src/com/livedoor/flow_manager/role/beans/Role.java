package com.livedoor.flow_manager.role.beans;

import java.io.Serializable;


public class Role implements Serializable{

	private Integer roleId;
	
	private String roleName;
	
	private java.util.Calendar inputDate ;

	private java.util.Calendar updateDate ;

	private Integer deletedFlag ;

	public Integer getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}




	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public java.util.Calendar getInputDate() {
		return inputDate;
	}

	public void setInputDate(java.util.Calendar inputDate) {
		this.inputDate = inputDate;
	}

	public java.util.Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Calendar updateDate) {
		this.updateDate = updateDate;
	}

	

	
	
	
}
