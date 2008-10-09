package com.livedoor.flow_manager.roleAction.beans;

import java.util.Calendar;

public class RoleAction implements java.io.Serializable{
	
	private String menuSeq;
	private String roleActionUrl;
	private String roleActionName;
	private int displayOrder;
	private String parentMenuSeq;
	private String updateStaffId;
	private String inputStaffId;
	private Integer activeFlag;
	private Calendar inputDate;
	private Calendar updateDate;

	public RoleAction() {
		// TODO Auto-generated constructor stub
	}

	public RoleAction(String menuSeq, String roleActionUrl,
			String roleActionName, int displayOrder) {
		this.menuSeq = menuSeq;
		this.roleActionUrl = roleActionUrl;
		this.roleActionName = roleActionName;
		this.displayOrder = displayOrder;
	}

	public String getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(String menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getRoleActionUrl() {
		return roleActionUrl;
	}

	public void setRoleActionUrl(String roleActionUrl) {
		this.roleActionUrl = roleActionUrl;
	}

	public String getRoleActionName() {
		return roleActionName;
	}

	public void setRoleActionName(String roleActionName) {
		this.roleActionName = roleActionName;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getParentMenuSeq() {
		return parentMenuSeq;
	}

	public void setParentMenuSeq(String parentMenuSeq) {
		this.parentMenuSeq = parentMenuSeq;
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
