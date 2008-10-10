package com.livedoor.flow_manager.group.forms;

import org.apache.struts.action.ActionForm;

public class DeleteGroupForm extends ActionForm
{
	private int [] idCheckBox = new int[0] ;

	public int [] getIdCheckBox()
	{
		return idCheckBox ;
	}

	public void setIdCheckBox( int [] idCheckBox )
	{
		this.idCheckBox = idCheckBox ;
	}

}
