package com.livedoor.flow_manager.group.actions ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.group.forms.SearchGroupForm;
import com.livedoor.flow_manager.group.implments.GroupDaoImpl;
import com.livedoor.flow_manager.tools.Pagination;

public class SearchGroupAction extends MappingDispatchAction
{
	private static final Integer deletedFlag = 0 ;

	private GroupDaoImpl groupDaoImpl ;

	public GroupDaoImpl getGroupDaoImpl()
	{
		return groupDaoImpl ;
	}

	public void setGroupDaoImpl( GroupDaoImpl groupDaoImpl )
	{
		this.groupDaoImpl = groupDaoImpl ;
	}

	public ActionForward searchGroup( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
		HttpSession session = request.getSession() ;

		String pageCountStr = ( String )session.getAttribute( "pageCount" ) ;
		int pageCount = 1 ;
		if( null != pageCountStr && !"".equals( pageCountStr ) )
		{
			pageCount = Integer.parseInt( pageCountStr ) ;
		}

		String currentPageStr = request.getParameter( "currentPage" ) ;
		int currentPage = 1 ;
		if( currentPageStr == null )
		{
			currentPage = Integer.parseInt( ( String )session
					.getAttribute( "currentPage" ) ) ;
		}
		else
		{
			currentPage = Integer.parseInt( request
					.getParameter( "currentPage" ) ) ;
		}
		if( pageCount < currentPage )
		{
			currentPage = pageCount ;
		}
		if( currentPage == 0 )
		{
			currentPage = 1 ;
		}
		SearchGroupForm searchGroupForm = ( SearchGroupForm )form ;
		List list = this.groupDaoImpl.getGroupByDeletedFlag( deletedFlag ) ;
		Pagination pagination = new Pagination() ;
		List groupList = pagination.getList( list , pagination.getPageSize() ,
				currentPage ) ;

		searchGroupForm.setCurrentPage( currentPage ) ;
		searchGroupForm.setPageCount( pagination.getPageCount() ) ;
		searchGroupForm.setPageSize( pagination.getPageSize() ) ;
		searchGroupForm.setRowsCount( pagination.getRowsCount() ) ;

		session.setAttribute( "groupList" , groupList ) ;
		session.setAttribute( "pageList" , pagination.getPageList() ) ;
		session.setAttribute( "searchGroupForm" , searchGroupForm ) ;
		session.setAttribute( "pagination" , pagination ) ;
		session.setAttribute("currentPage", ""+currentPage);
		session.setAttribute("pageCount", ""+pageCount);
		
		return mapping.findForward( "success" ) ;
	}
	
	public ActionForward initSearchGroup( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{

		// ActionForward forward = new ActionForward();
		// forward = mapping.findForward("finish");
		//SearchGroupForm searchGroupForm = ( SearchGroupForm )form ;
		SearchGroupForm searchGroupForm = new SearchGroupForm() ;
		HttpSession session = request.getSession() ;

		session.removeAttribute( "pageCount" ) ;
		session.removeAttribute( "currentPage" ) ;
		session.removeAttribute( "groupList" ) ;
		session.removeAttribute( "pageList" ) ;
		session.removeAttribute( "searchGroupForm" ) ;
		session.removeAttribute( "pagination" ) ;

		Pagination pagination = new Pagination() ;
		List list = pagination.getList( this.groupDaoImpl
				.getGroupByDeletedFlag( deletedFlag ) , pagination
				.getPageSize() , 1 ) ;
		int pageSize = pagination.getPageSize() ;
		int currentPage = pagination.getCurrentPage() ;
		int pageCount = pagination.getPageCount() ;
		int rowsCount = pagination.getRowsCount() ;

		searchGroupForm.setCurrentPage( currentPage ) ;
		searchGroupForm.setPageCount( pageCount ) ;
		searchGroupForm.setPageSize( pageSize ) ;
		searchGroupForm.setRowsCount( rowsCount ) ;

		List pageList = pagination.getPageList() ;

		session.setAttribute( "pageCount" , "" + pageCount ) ;
		session.setAttribute( "currentPage" , "" + currentPage ) ;
		session.setAttribute( "groupList" , list ) ;
		session.setAttribute( "pageList" , pageList ) ;
		session.setAttribute( "searchGroupForm" , searchGroupForm ) ;
		session.setAttribute( "pagination" , pagination ) ;
		
		form = searchGroupForm ;
		return mapping.findForward( "success" ) ;
	}
}
