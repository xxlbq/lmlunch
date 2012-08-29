package com.livedoor.flow_manager.enums;

public enum IdKeyEnum {
	LOGIN_IN_ID("LGIN"),OTHER_ID("OTHE");
	
	
	private String value;

	private IdKeyEnum(String v) {
		this.value = v;
	}
	public String getValue(){
		return this.value;
	}
	
}
