package com.livedoor.flow_manager.enums;

public enum KingdomEnum {

	KINGDOM_QI(1),
	KINGDOM_CHU(2),
	KINGDOM_YAN(3),
	KINGDOM_HAN(4),
	KINGDOM_ZHAO(5),
	KINGDOM_WEI(6),
	KINGDOM_QIN(7);

	
	
	private int value;

	private KingdomEnum(int v) {
		this.value = v;
	}
	public int getValue(){
		return this.value;
	}
	
	
}
