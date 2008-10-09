package com.livedoor.flow_manager.sources.junit;

import com.livedoor.flow_manager.tools.DateUtil;

import junit.framework.TestCase;

public class TestDate extends TestCase {

	public void testIsNumericDate1(){
		
		assertEquals(false,  DateUtil.isNumericDateIfExist(null));
		
	}
	
	public void testIsNumericDate2(){
		
		assertEquals(true,  DateUtil.isNumericDateIfExist("20001111"));;
		
	}
}
