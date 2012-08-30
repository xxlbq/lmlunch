package com.livedoor.flow_manager.enums;

public enum AccountNonExpiredEnum {
	
	AccountExpired(0),AccountNonExpired(1);
	
	private int value;

	private AccountNonExpiredEnum(int v) {
		this.value = v;
	}
	public int getValue(){
		return this.value;
	}
	
	
}
