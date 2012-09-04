package com.livedoor.flow_manager.enums;

public enum GemEnum {
	GEM_FUZAI(1),
	GEM_JIFENG(2),
	GEM_FANGYU(3),
	GEM_BENLEI(4),
	GEM_XIULUO(5);

	
	private int value;

	private GemEnum(int v) {
		this.value = v;
	}
	public int getValue(){
		return this.value;
	}
}
