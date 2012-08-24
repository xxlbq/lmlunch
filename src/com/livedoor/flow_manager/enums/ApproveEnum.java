package com.livedoor.flow_manager.enums;

public enum ApproveEnum {

	UNAPPROVE(0),APPROVED(1);
	
	private int value ;

	private ApproveEnum(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
}
