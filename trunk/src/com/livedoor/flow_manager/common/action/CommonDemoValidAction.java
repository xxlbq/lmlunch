package com.livedoor.flow_manager.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

public class CommonDemoValidAction extends  MappingDispatchAction {
	
	public ActionForward display( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
		HttpSession session = request.getSession() ;
		
		
		
		return mapping.findForward( "success" ) ;
	}

}
