package com.livedoor.flow_manager.group.forms ;

import org.apache.struts.action.ActionForm ;

public class SearchGroupForm extends ActionForm
{
	

	private int pageSize ;

	private int currentPage ;

	private int pageCount ;

	private int rowsCount ;
	
	
	public int getCurrentPage()
	{
		return currentPage ;
	}

	public void setCurrentPage( int currentPage )
	{
		this.currentPage = currentPage ;
	}

	public int getPageCount()
	{
		return pageCount ;
	}

	public void setPageCount( int pageCount )
	{
		this.pageCount = pageCount ;
	}

	public int getPageSize()
	{
		return pageSize ;
	}

	public void setPageSize( int pageSize )
	{
		this.pageSize = pageSize ;
	}

	public int getRowsCount()
	{
		return rowsCount ;
	}

	public void setRowsCount( int rowsCount )
	{
		this.rowsCount = rowsCount ;
	}

}
