package com.livedoor.flow_manager.group.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UpdateGroupForm extends ActionForm
{
	private String groupName ;

	private String groupLevelRelation ;

	private Integer groupFather ;

	private String groupDesc ;

	public String getGroupDesc()
	{
		return groupDesc ;
	}

	public void setGroupDesc( String groupDesc )
	{
		this.groupDesc = groupDesc.trim() ;
	}

	public Integer getGroupFather()
	{
		return groupFather ;
	}

	public void setGroupFather( Integer groupFather )
	{
		this.groupFather = groupFather ;
	}

	public String getGroupLevelRelation()
	{
		return groupLevelRelation ;
	}

	public void setGroupLevelRelation( String groupLevelRelation )
	{
		this.groupLevelRelation = groupLevelRelation.trim() ;
	}

	public String getGroupName()
	{
		return groupName ;
	}

	public void setGroupName( String groupName )
	{
		this.groupName = groupName.trim() ;
	}
	
	@Override
	public void reset( ActionMapping mapping , HttpServletRequest request )
	{
		this.groupName = null ;
		this.groupLevelRelation = null ;
		this.groupFather = null ;
		this.groupDesc = null ;
	}
	
	@Override
	public ActionErrors validate( ActionMapping mapping , HttpServletRequest request )
	{
		ActionErrors errors = new ActionErrors() ;
		/*if( this.groupName == null || this.groupName.length() < 1 )
		{
			errors.add( "groupName" , new ActionMessage( "group.add.null.error" ) ) ;
		}*/
		return errors ;
	}
}
