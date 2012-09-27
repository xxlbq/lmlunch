package com.livedoor.flow_manager.group.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.group.forms.UpdateGroupForm;
import com.livedoor.flow_manager.group.implments.GroupDaoImpl;

public class UpdateGroupAction extends MappingDispatchAction
{
	private GroupDaoImpl groupDaoImpl ;

	public GroupDaoImpl getGroupDaoImpl()
	{
		return groupDaoImpl ;
	}

	public void setGroupDaoImpl( GroupDaoImpl groupDaoImpl )
	{
		this.groupDaoImpl = groupDaoImpl ;
	}

	public ActionForward updateGroup( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
		UpdateGroupForm updateGroupForm = ( UpdateGroupForm )form ;
		BeanUtils.copyProperties( updateGroupForm , this.getGroupFromSession( request ) ) ;
//		System.out.println( updateGroupForm.getGroupName() ) ;
		return mapping.findForward( "success" ) ;
	}
	public ActionForward initUpdateGroup( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
		UpdateGroupForm updateGroupForm = ( UpdateGroupForm )form ;
		BeanUtils.copyProperties( updateGroupForm , this.getGroupFromSession( request ) ) ;
//		System.out.println( updateGroupForm.getGroupName() ) ;
		return mapping.findForward( "success" ) ;
	}
	public Group getGroupFromSession( HttpServletRequest request )
	{
		HttpSession session = request.getSession() ;
		List list = ( List )session.getAttribute( "groupList" ) ;
		int id = Integer.parseInt( request.getParameter( "id" ) ) ;
		return ( Group )list.get( id - 1 ) ;
	}
}
