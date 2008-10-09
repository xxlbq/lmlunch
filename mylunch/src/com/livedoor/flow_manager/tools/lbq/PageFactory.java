package com.livedoor.flow_manager.tools.lbq;

import com.livedoor.flow_manager.IConstant.PageConstant;


public class PageFactory {
	
	public final static int DEFAULT_PAGESIZE = PageConstant.SOURCE_PAGE_SIZE;

	
    public static Page createPage(Page page, int recordsCount){
        return createPage(page.getPageSize(), page.getCurrentPageNumber(), recordsCount);
    }

    
    public static Page createPage(int pageSize, int currentPageNumber, int recordsCount){
    	
    	pageSize = checkPageSize(pageSize);
    	recordsCount = checkRecordsCount(recordsCount);
    	int pageCount = getPageCount(pageSize, recordsCount);
    	
    	currentPageNumber = checkCurrentPageNumber(currentPageNumber,pageCount);
        int beginIndex = getBeginIndex(pageSize, currentPageNumber);
        int endIndex = getEndIndex(pageSize,currentPageNumber,recordsCount);
        
        boolean hasNextPage = hasNextPage(currentPageNumber, pageCount);
        boolean hasPrePage = hasPrePage(currentPageNumber);
        
        
        
        return new Page(hasPrePage, hasNextPage,  
        		pageSize, pageCount, 
        		currentPageNumber, beginIndex,
        		endIndex,recordsCount);
    }
    

	private static int getEndIndex(int pageSize, int currentPageNumber, int recordsCount) {
    	
    	return currentPageNumber * pageSize > recordsCount 
    				? recordsCount 
    				: currentPageNumber * pageSize;
	}


	private static int getBeginIndex(int pageSize, int currentPageNumber){
        return currentPageNumber >=1 ? (currentPageNumber - 1) * pageSize + 1 : 0; 
    }
    
    private static int checkCurrentPageNumber(int currentPageNumber,int pageCount) {
    	return	currentPageNumber >= pageCount 
    				?  pageCount 
    				: (currentPageNumber <= 0 ? 1 : currentPageNumber);
	}

	public static int getPageCount(int pageSize, int recordsCount){
		
		if(pageSize <= 0 ) {
			pageSize = DEFAULT_PAGESIZE ;
		}
				
    	return (recordsCount % pageSize == 0) 
    				? (recordsCount / pageSize)
    				: (recordsCount / pageSize + 1);
    }
    
    
    private static int checkRecordsCount(int recordsCount) {
		return recordsCount >= 0 ? recordsCount : 0 ;
	}


	private static int checkPageSize(int pageSize) {
		return pageSize <= 0 ? DEFAULT_PAGESIZE : pageSize;
	}


	private static boolean hasPrePage(int currentPageNumber){
        return currentPageNumber > 1 ? true : false; 
    }
    
    private static boolean hasNextPage(int currentPageNumber, int pageCount){
        return currentPageNumber < pageCount  ? true : false;
    }
    
}
