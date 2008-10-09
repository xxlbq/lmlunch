package com.livedoor.flow_manager.tools.lbq;

public class Page implements IPage {
    
	public final static int DEFAULT_PAGESIZE = 10;
	public final static int DEFAULT_MAX_INDEX_PAGES = 10;
	public final static int DEFAULT_SKIP_PAGES = 10;
	
	
	/** the number of records in page */
    private int pageSize;
    /** the number of current page */
    private int currentPageNumber;
    /** the recordCount number */
    private int recordsCount;
    
    
	
/*    these fields depends on 
    [pageSize,recordsCount,currentPageNumber]*/
    
    /** the page has previous page */
    private boolean hasPrePage;
    
    /** the page has next page */
    private boolean hasNextPage;
      
    /** the pageCount number */
    private int pageCount;
     
    /** the begin index of the records by the current page */
    private int beginIndex;
    
    /** the end index of the records by the current page */
    private int endIndex;
    
    
    //these fields is other optionals
    
    private int maxIndexPages;
    
    private int skipPages;
    
    /** The default constructor */
    public Page(){}
    
    /**
     * suggest this constructor of personal
     * other field depends on three field of 
     * [pageSize,recordsCount,currentPageNumber]
     * 
     * if pagesize <= 0             then pagesize = DEFAULT_PAGESIZE
     * if recordsCount < 0          then recordsCount = 0                  
     * if currentPageNumber > pageCount then currentPageNumber = pageCount
     * if currentPageNumber < 1         then currentPageNumber = 1
     * 
     * 
     * @param pageSize
     * @param recordsCount
     * @param currentPageNumber
     */
    public Page(int pageSize,int recordsCount,int currentPageNumber){
    	// check pageSize,recordsCount
    	this.pageSize 		= checkPageSize(pageSize);
    	this.recordsCount 	= checkRecordsCount(recordsCount);
    	// in order to check currentPageNumber
    	this.pageCount      = calcPageCount(this.pageSize,this.recordsCount);
    	// check currentPageNumber
    	this.currentPageNumber = 
    		checkCurrentPageNumber(currentPageNumber,this.pageCount);
    	// 
    	this.hasPrePage     = hasPrePage(this.currentPageNumber);
    	//
    	this.hasNextPage    = hasNextPage (this.currentPageNumber,this.pageCount);
    	//
    	this.beginIndex     = 
    		calcBeginIndex(this.pageSize, this.currentPageNumber);
    	//
    	this.endIndex       = 
    		calcEndIndex(this.pageSize, this.currentPageNumber, this.recordsCount);
    	
    	this.maxIndexPages 	= DEFAULT_MAX_INDEX_PAGES;
    	this.skipPages 		= DEFAULT_SKIP_PAGES;
    	
    }
    
    /** The full constructor , not suggest*/
    public Page(boolean hasPrePage, boolean hasNextPage,  
            	 int pageSize, int pageCount, 
            	 int currentPageNumber, int beginIndex,
            	 int endIndex, int recordsCount) {
    	
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.currentPageNumber = currentPageNumber;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.recordsCount = recordsCount;

        this.maxIndexPages 	= DEFAULT_MAX_INDEX_PAGES;
        this.skipPages 		= DEFAULT_SKIP_PAGES;
    }

    /**
     * @return 
     * Returns the beginIndex.
     */
    public int getBeginIndex() {
        return beginIndex;
    }
    
    /**
     * @param beginIndex 
     * The beginIndex to set.
     */
    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }
    
    /**
     * @return 
     * Returns the currentPage.
     */
    public int getCurrentPageNumber() {
        return currentPageNumber;
    }
    
    /**
     * @param currentPage 
     * The currentPage to set.
     */
    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }
    
    /**
     * @return 
     * Returns the everyPage.
     */
    public int getPageSize() {
        return pageSize;
    }
    
    /**
     * @param everyPage 
     * The everyPage to set.
     */
    public void setEveryPage(int pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * @return 
     * Returns the hasNextPage.
     */
    public boolean getHasNextPage() {
        return hasNextPage;
    }
    
    /**
     * @param hasNextPage 
     * The hasNextPage to set.
     */
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
    
    /**
     * @return 
     * Returns the hasPrePage.
     */
    public boolean getHasPrePage() {
        return hasPrePage;
    }
    
    /**
     * @param hasPrePage 
     * The hasPrePage to set.
     */
    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }
    
    /**
     * @return Returns the totalPage.
     * 
     */
    public int getPageCount() {
        return pageCount;
    }
    
    /**
     * @param totalPage 
     * The totalPage to set.
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordsCount() {
		return recordsCount;
	}

	public void setRecordsCount(int recordsCount) {
		this.recordsCount = recordsCount;
	}
	
	
	
	public int getMaxIndexPages() {
		return maxIndexPages;
	}

	public void setMaxIndexPages(int maxIndexPages) {
		this.maxIndexPages = maxIndexPages;
	}

	public int getSkipPages() {
		return skipPages;
	}

	public void setSkipPages(int skipPages) {
		this.skipPages = skipPages;
	}

	private static int calcPageCount(int pageSize, int recordsCount){
    	return (recordsCount % pageSize == 0) 
    				? (recordsCount / pageSize)
    				: (recordsCount / pageSize + 1);
    }
	
	private static int checkPageSize(int pageSize) {
		return pageSize <= 0 ? DEFAULT_PAGESIZE : pageSize;
	}
    
	private static int checkRecordsCount(int recordsCount) {
		return recordsCount >= 0 ? recordsCount : 0 ;
	}
	
    private static int checkCurrentPageNumber(int currentPageNumber,int pageCount) {
    	return	currentPageNumber >= pageCount 
    				?  pageCount 
    				: (currentPageNumber <= 0 ? 1 : currentPageNumber);
	}
    
    private static boolean hasNextPage(int currentPageNumber, int pageCount){
        return currentPageNumber < pageCount  ? true : false;
    }
    
    private static boolean hasPrePage(int currentPageNumber){
        return currentPageNumber > 1 ? true : false; 
    }
    
    private static int calcBeginIndex(int pageSize, int currentPageNumber){
        return currentPageNumber >=1 ? (currentPageNumber - 1) * pageSize + 1 : 0; 
    }
    
    private static int calcEndIndex(int pageSize, int currentPageNumber, int recordsCount) {
    	
    	return currentPageNumber * pageSize > recordsCount 
    				? recordsCount 
    				: currentPageNumber * pageSize;
	}
}
