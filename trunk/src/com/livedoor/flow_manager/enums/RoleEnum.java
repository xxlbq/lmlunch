package com.livedoor.flow_manager.enums;

public enum RoleEnum {
	
	GOD(0),ADMIN(1),MEMBER(2),UNREGISTERED(3),UNKNOWN(4);
	
	private int value ;

	private RoleEnum(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	
}
