package com.livedoor.flow_manager.sources.beans;

import java.util.List;

import com.livedoor.flow_manager.tools.Pagination;

public class SourcePageInfoBean {
	
	private int recordCount;
	private int pageCount;
	private int currentPageNo;
	private int currentPageRecordBeginNo;
	private int currentPageRecordEndNo;
	
	private boolean isFirstPage;
	private boolean isLastPage;
	
	private List<Source> currentPageSourceList;
	


	public List<Source> getCurrentPageSourceList() {
		return currentPageSourceList;
	}

	public void setCurrentPageSourceList(List<Source> currentPageSourceList) {
		this.currentPageSourceList = currentPageSourceList;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getCurrentPageRecordBeginNo() {
		return currentPageRecordBeginNo;
	}

	public void setCurrentPageRecordBeginNo(int currentRecordFromNo) {
		this.currentPageRecordBeginNo = currentRecordFromNo;
	}

	public int getCurrentPageRecordEndNo() {
		return currentPageRecordEndNo;
	}

	public void setCurrentPageRecordEndNo(int currentRecordToNo) {
		this.currentPageRecordEndNo = currentRecordToNo;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean getIsFirstPage() {
		return isFirstPage;
	}

	public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean getIsLastPage() {
		return isLastPage;
	}

	public void setIsLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	
//	public PageInfoBean getPageInfoBeanAll(List list,int pageNo){
//		
//		
//		
//		PageInfoBean pBean = new PageInfoBean();
//		
//		pBean.setRecordCount(PageUtil.getRecordCount(list));
//		
//		pBean.setPageCount(PageUtil.getPageCount(
//				PageUtil.getRecordCount(list),
//				WebIConstants.PAGE_SIZE));
//		
//		pageNo = PageUtil.getCurrentPageNo(pageNo,PageUtil.getPageCount(
//				PageUtil.getRecordCount(list),
//				WebIConstants.PAGE_SIZE));
//		
//		pBean.setCurrentPageNo(pageNo);
//		
//		if(pageNo <= 0 ){
//			pBean.setRecordList(null);
//		}else{
//		
//		pBean.setRecordList(list.subList(
//				PageUtil.getCurrentPageRecordBegin(pageNo,WebIConstants.PAGE_SIZE)-1,
//				PageUtil.getCurrentPageRecordEnd(pageNo,WebIConstants.PAGE_SIZE,PageUtil.getRecordCount(list))));
//		}
//		
//		pBean.setIsFirstPage(pageNo == 1 || pageNo <= 0 );
//		pBean.setIsLastPage(pageNo == PageUtil.getPageCount(
//				PageUtil.getRecordCount(list),WebIConstants.PAGE_SIZE)
//				|| pageNo <= 0);
//		
//		return pBean;
//	}
//	
	public static SourcePageInfoBean getSourcePageInfoBeanInstance(int rowCount,int pageSize,int pageNo){

		SourcePageInfoBean pBean = new SourcePageInfoBean();
		
		pBean.setRecordCount(rowCount);
		
		pBean.setPageCount(Pagination.getPageCount(rowCount,pageSize));
		
		pageNo = Pagination.getCurrentPageNo(pageNo,Pagination.getPageCount(rowCount,pageSize));
		
		pBean.setCurrentPageNo(pageNo);
		
		pBean.setCurrentPageRecordBeginNo((pageNo-1)*pageSize+1);
		pBean.setCurrentPageRecordEndNo(pageNo*pageSize > rowCount ? rowCount : pageNo*pageSize);
		
		pBean.setIsFirstPage(pageNo == 1 || pageNo <= 0 );
		pBean.setIsLastPage(pageNo == Pagination.getPageCount(rowCount,pageSize) || pageNo <= 0);
		
		return pBean;
	}
	
	public static SourcePageInfoBean 
		buildSourcePageInfoBeanInstance(
			int rowCount,int pageSize,int pageNo,List<Source> currentPageSourceList){

		SourcePageInfoBean pBean = new SourcePageInfoBean();
		
		pBean.setRecordCount(rowCount);
		
		pBean.setPageCount(Pagination.getPageCount(rowCount,pageSize));
		
		pageNo = Pagination.getCurrentPageNo(pageNo,Pagination.getPageCount(rowCount,pageSize));
		
		pBean.setCurrentPageNo(pageNo);
		
		pBean.setCurrentPageRecordBeginNo(pageNo > 0  ? ( pageNo - 1 ) * pageSize + 1 : 0);
		pBean.setCurrentPageRecordEndNo(pageNo*pageSize > rowCount ? rowCount : pageNo*pageSize);
		
		pBean.setIsFirstPage(pageNo == 1 || pageNo <= 0 );
		pBean.setIsLastPage(pageNo == Pagination.getPageCount(rowCount,pageSize) || pageNo <= 0);
		
		pBean.setCurrentPageSourceList(currentPageSourceList);
		
		for (int i = 0; i < currentPageSourceList.size(); i++) {
//			System.out.println( currentPageSourceList.get(i).toString() );
		}
		
		return pBean;
	}

}
