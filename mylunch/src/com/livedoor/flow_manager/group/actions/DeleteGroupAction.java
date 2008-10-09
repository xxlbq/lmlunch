package com.livedoor.flow_manager.group.actions ;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.group.forms.DeleteGroupForm;
import com.livedoor.flow_manager.group.implments.GroupDaoImpl;

public class DeleteGroupAction extends MappingDispatchAction
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

	public ActionForward execute( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
		HttpSession session = request.getSession() ;
		DeleteGroupForm deleteGroupForm = ( DeleteGroupForm )form ;
		
		int i = this.groupDaoImpl.deleteGroup( this.getDeleteGroup( session , deleteGroupForm ) ) ;
		ActionMessages errors = new ActionMessages() ;
		if( i > 0 )
		{
			errors.add( "deleteGroup" , new ActionMessage( "group.delete.success" ) ) ;
			this.saveErrors( request , errors ) ;
			return mapping.findForward( "success" ) ;
		}
		errors.add( "deleteGroup" , new ActionMessage( "group.delete.failure" ) ) ;
		this.saveErrors( request , errors ) ;
		return mapping.getInputForward() ;
	}
	public List getDeleteGroup( HttpSession session , DeleteGroupForm deleteGroupForm )
	{
		List list = new ArrayList() ;
		List groupList = ( List )session.getAttribute( "groupList" ) ;
		if( groupList.size() > 0 )
		{
			for( int i = 0 ; i < deleteGroupForm.getIdCheckBox().length ; i++ )
			{
				list.add( groupList.get( deleteGroupForm.getIdCheckBox()[i-1] ) ) ;
			}
		}
		return list ;
	}
}
