package com.livedoor.flow_manager.enums;

public enum CredentialsNonExpiredEnum {
	NonExpired(1), Expired(0);
	
	private int value;

	private CredentialsNonExpiredEnum(int v) {
		this.value = v;
	}
	public int getValue(){
		return this.value;
	}
	
	
}
