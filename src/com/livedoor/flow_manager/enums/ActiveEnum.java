package com.livedoor.flow_manager.enums;

public enum ActiveEnum {
	UNACTIVE(0),ACTIVE(1);
	
	private int value;

	private ActiveEnum(int v) {
		this.value = v;
	}
	public int getValue(){
		return this.value;
	}
	
	
	
}
