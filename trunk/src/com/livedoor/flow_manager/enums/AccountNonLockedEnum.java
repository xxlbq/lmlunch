package com.livedoor.flow_manager.enums;

public enum AccountNonLockedEnum {
	AccountLocked(0),AccountNonLocked(1);
	
	private int value;

	private AccountNonLockedEnum(int v) {
		this.value = v;
	}
	public int getValue(){
		return this.value;
	}
	
	
	
}
