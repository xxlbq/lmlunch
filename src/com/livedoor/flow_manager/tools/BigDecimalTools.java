package com.livedoor.flow_manager.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTools {

	private static final RoundingMode r1 = RoundingMode.DOWN;
	
	public static BigDecimal roundingDownToInt(BigDecimal value){
		return value.setScale(0,r1);
	}
}
