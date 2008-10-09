package com.livedoor.flow_manager.sources.junit;

import java.util.Calendar;

import junit.framework.TestCase;

import com.livedoor.flow_manager.tools.GetDate;

public class TestCalendarConvertOthers extends TestCase {
	
	private Calendar cal;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		cal = Calendar.getInstance();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetyyyymmddStringFromCalendarObject(){
		
		assertEquals("20060910", GetDate.getyyyymmddStringFromCalendarObject(cal));
	}
}
