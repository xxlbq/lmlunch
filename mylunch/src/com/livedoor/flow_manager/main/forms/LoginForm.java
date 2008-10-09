package com.livedoor.flow_manager.main.forms;
		
import org.apache.struts.validator.ValidatorActionForm;

public class LoginForm extends ValidatorActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7093634654508168183L;
	private String loginID;
	private String loginPwd;
	
	
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}
