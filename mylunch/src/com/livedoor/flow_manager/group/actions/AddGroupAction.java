package com.livedoor.flow_manager.group.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.group.forms.AddGroupForm;
import com.livedoor.flow_manager.group.implments.GroupDaoImpl;

public class AddGroupAction extends MappingDispatchAction
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

	public ActionForward addGroup( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
		AddGroupForm addform = ( AddGroupForm )form ;
		HttpSession session = request.getSession() ;
		Group group = new Group() ;
		BeanUtils.copyProperties( group , form ) ;
//		User user = ( User )session.getAttribute( "user" );
//		group.setInputUserId( user.getId() ) ;
		group.setInputUserId( 2 ) ;
		group.setDeletedFlag( 0 ) ;
		int i = this.groupDaoImpl.addGroup( group ) ;
		ActionMessages errors = new ActionMessages() ;
		if( i > 0 )
		{
			errors.add( "addGroup" , new ActionMessage( "group.add.success" ) ) ;
			this.saveErrors( request , errors ) ;
			return mapping.findForward( "success" ) ;
		}
		errors.add( "addGroup" , new ActionMessage( "group.add.failure" ) ) ;
		this.saveErrors( request , errors ) ;
		return mapping.getInputForward() ;
	}
	
	public ActionForward initAddGroup( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
		HttpSession session = request.getSession() ;
		List groupList = this.groupDaoImpl.getGroupByDeletedFlag( deletedFlag ) ;
		session.setAttribute( "groupList" , groupList ) ;
		return mapping.findForward( "success" ) ;
	}
}
