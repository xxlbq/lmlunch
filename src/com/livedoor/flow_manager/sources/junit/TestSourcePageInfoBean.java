package com.livedoor.flow_manager.sources.junit;

import com.livedoor.flow_manager.sources.beans.SourcePageInfoBean;

import junit.framework.TestCase;

public class TestSourcePageInfoBean extends TestCase {
	
	SourcePageInfoBean sp;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		//getSourcePageInfoBeanInstance(recordCount, pageSize, pageNo)
		sp = SourcePageInfoBean.getSourcePageInfoBeanInstance(23, 10, 3);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPageCount() throws Exception {
		
		assertEquals(sp.getPageCount(), 3);
	}
	
	public void testThePageBeginNo() throws Exception {
		assertEquals(sp.getCurrentPageRecordBeginNo(), 21);
	}
	
	public void testThePageEndNo() throws Exception {
		assertEquals(sp.getCurrentPageRecordEndNo(), 23);
	}
}
