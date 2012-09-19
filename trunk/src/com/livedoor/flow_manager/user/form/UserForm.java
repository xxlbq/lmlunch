package com.livedoor.flow_manager.user.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm{
/**
	 * 
	 */
	private static final long serialVersionUID = 3005917123633130114L;

	//	 primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userName;
	private java.lang.String userPassword;
	private String userPassword2; 
	private java.lang.String userRole;
	private java.lang.String userDisplayName;
	private java.lang.String userRegIp;
	private java.lang.String userLastLoginIp;
	
	private java.lang.String userPhoto;
	private java.lang.String userEmail;
	private java.lang.String userMsn;
	private java.lang.String userSkype;
	private java.lang.Integer inputUserId;
	private java.util.Date inputDatetime;
	private java.lang.Integer updateUserId;
	private java.util.Date updateDatetime;
	private java.lang.Integer deletedFlag;
	private java.lang.String userDesc;
	
	
	
	
	public java.lang.String getUserRegIp() {
		return userRegIp;
	}
	public void setUserRegIp(java.lang.String userRegIp) {
		this.userRegIp = userRegIp;
	}
	public java.lang.String getUserLastLoginIp() {
		return userLastLoginIp;
	}
	public void setUserLastLoginIp(java.lang.String userLastLoginIp) {
		this.userLastLoginIp = userLastLoginIp;
	}
	public String getUserPassword2() {
		return userPassword2;
	}
	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}
	public java.lang.String getUserDisplayName() {
		return userDisplayName;
	}
	public void setUserDisplayName(java.lang.String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	public java.lang.Integer getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(java.lang.Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.util.Date getInputDatetime() {
		return inputDatetime;
	}
	public void setInputDatetime(java.util.Date inputDatetime) {
		this.inputDatetime = inputDatetime;
	}
	public java.lang.Integer getInputUserId() {
		return inputUserId;
	}
	public void setInputUserId(java.lang.Integer inputUserId) {
		this.inputUserId = inputUserId;
	}
	public java.util.Date getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(java.util.Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	public java.lang.Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public java.lang.String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(java.lang.String userDesc) {
		this.userDesc = userDesc;
	}
	public java.lang.String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(java.lang.String userEmail) {
		this.userEmail = userEmail;
	}
	public java.lang.String getUserMsn() {
		return userMsn;
	}
	public void setUserMsn(java.lang.String userMsn) {
		this.userMsn = userMsn;
	}
	public java.lang.String getUserName() {
		return userName;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	public java.lang.String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(java.lang.String userPassword) {
		this.userPassword = userPassword;
	}
	public java.lang.String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(java.lang.String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public java.lang.String getUserRole() {
		return userRole;
	}
	public void setUserRole(java.lang.String userRole) {
		this.userRole = userRole;
	}
	public java.lang.String getUserSkype() {
		return userSkype;
	}
	public void setUserSkype(java.lang.String userSkype) {
		this.userSkype = userSkype;
	}
	
	
}
