package com.livedoor.flow_manager.tools;

import java.util.ArrayList;
import java.util.List;

import com.livedoor.flow_manager.IConstant.PageConstant;

public class Pagination {
	 private int pageSize=20;			
	 private int currentPage=1;			
	 private int pageCount;				
	 private int rowsCount;				
	 private List list=null;			
	 public Pagination(){ 
		 
	 }
	 public Pagination(List list){
		      if(list==null){
		        rowsCount=0; 
		       }else{
			   rowsCount=list.size();
			   }
			this.list=list;
	 }
public List getList(List list,int pageSize,int currentPage){ 
	this.pageSize=pageSize;
	this.currentPage=currentPage;
	if(list==null) return null;
	this.rowsCount=list.size();
	//rowsCount=getPageRowsCount();
	pageCount=getPageCount();
    if(currentPage>pageCount) currentPage=1;
    List<Object> returnList=new ArrayList<Object>();
    for(int i=(currentPage-1)*pageSize;i<(currentPage*pageSize>rowsCount?rowsCount:currentPage*pageSize);i++){ 
    	returnList.add(list.get(i));
    }
    
    return returnList;
}
public List getList(){ 
	rowsCount=getPageRowsCount();
	pageCount=getPageCount();
    if(currentPage>pageCount) currentPage=1;
    List<Object> returnList=new ArrayList<Object>();
    for(int i=(currentPage-1)*pageSize;i<(currentPage*pageSize>rowsCount?rowsCount:currentPage*pageSize);i++){ 
    	returnList.add(list.get(i));
    }
    return returnList;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}

public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	if(pageSize>0){
	  	  this.pageSize=pageSize;	
	  	  currentPage=1;
	    }
}
public int getPageCount() {
	if(rowsCount==0) return 0;
    if(pageSize==0) return 0;
    double tempPageCount1=(double)rowsCount/pageSize;
    int tempPageCount2=(int)tempPageCount1;
    if(tempPageCount2<tempPageCount1) tempPageCount2++;
    return tempPageCount2;
}
public int getPageRowsCount(){
  	if(pageSize==0) return rowsCount;
    if(getRowsCount()==0) return 0;
    this.pageCount=getPageCount();
    if(currentPage>pageCount) return pageSize;
    return rowsCount-(getPageCount()-1)*pageSize;
  }
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}
public int getRowsCount() {
	return rowsCount;
}
public void setRowsCount(int rowsCount) {
	this.rowsCount = rowsCount;
}
public List getPageList(){ 
	List pagelist=new ArrayList();
	if(pageCount!=0){ 
		for(int i=0;i<pageCount;i++){ 
			pagelist.add(i+1);
			
		}
		return pagelist;	
	}else{ 
		return null;
	}
	
}

/**
 * lbq edit under this line
 * 
 * ------------------------------------------
 */
public static int getRecordCount(List recordList) {

	return recordList == null ? 0 : recordList.size();
}

public static int getPageCount(int recordCount, int pageSize) {

	return (recordCount % pageSize == 0) ? (recordCount / pageSize)
			: (recordCount / pageSize + 1);
}

public static int getCurrentPageRecordBegin(int currentPageNumber,
		int pageSize) {

	return (currentPageNumber - 1) * pageSize + 1;
}

public static int getCurrentPageRecordEnd(int currentPageNumber,
		int pageSize, int recordCount) {

	int VarCurrentPageRecordEnd = currentPageNumber * pageSize;

	return (VarCurrentPageRecordEnd > recordCount) ? recordCount
			: VarCurrentPageRecordEnd;
}

public static int getCurrentPageNo(int currentPageNo, int pageCount) {

	if (currentPageNo > 0) {

		return currentPageNo > pageCount ? pageCount : currentPageNo;

	} else {

		return 1;
	}
}

public static int pageNoValidator(String pageNo, int rowCount) {

	int pageNoInt;

	pageNoInt = (pageNo == null || "".equals(pageNo)) ? 1 : Integer
			.parseInt(pageNo);

	int pageCount = getPageCount(rowCount,
			PageConstant.SOURCE_PAGE_SIZE);

	return pageNoInt = (pageNoInt > pageCount ? pageCount : pageNoInt);
}

}
