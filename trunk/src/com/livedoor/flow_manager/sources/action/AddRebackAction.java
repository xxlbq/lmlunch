package com.livedoor.flow_manager.sources.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddRebackAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
//		request.setAttribute("QUERY_SOURCE_OBJECT", null);
//		org.apache.struts.taglib.bean.WriteTag
		return mapping.findForward("success");
	}

}
