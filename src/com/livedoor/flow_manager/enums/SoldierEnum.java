package com.livedoor.flow_manager.enums;

public enum SoldierEnum {

	SOLDIER_QIANGDUN(1),
	SOLDIER_CHANGQIANG(2),
	SOLDIER_QIBING(3),
	SOLDIER_ZHONGJIA(4);

	
	
	private int value;

	private SoldierEnum(int v) {
		this.value = v;
	}
	public int getValue(){
		return this.value;
	}

	public static boolean isSoldier(int v){
		if(SOLDIER_QIANGDUN.value == v || SOLDIER_CHANGQIANG.value == v 
				|| SOLDIER_QIBING.value == v || SOLDIER_ZHONGJIA.value == v){
			return true;
		}
		return false;
	}
}
