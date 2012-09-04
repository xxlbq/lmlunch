package com.livedoor.flow_manager.IConstant;

public interface PageConstant {
	
//	int SOURCE_PAGE_SIZE = 5;
	int SOURCE_PAGE_SIZE = 20;
	
	int SOURCE_INIT_PAGE_NUMBER = 1;
	
//	int SOURCE_BEGIN_NUMBER = 0;
	
	int SOURCE_FIRST_PAGE = 1;
	
	
	
	/**
	 * request.setAttribute(PageConstant.PAGER_VIEW_KEY,valueObject);
	 * request.getAttribute(PageConstant.PAGER_VIEW_KEY);
	 */
	String PAGER_VIEW_KEY = "PAGER_VIEW_KEY";
	
	/**
	 * 
	 */
	String SOURCE_QUERY_OBJECT_KEY ="SOURCE_QUERY_OBJECT_KEY";
}
