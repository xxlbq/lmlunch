package com.livedoor.flow_manager.velocity.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.velocity.tools.view.servlet.VelocityViewServlet;

public class VelocityAction extends MappingDispatchAction{


	public ActionForward showTemplate(ActionMapping mapping,
									ActionForm form, 
									HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		
		VelocityViewServlet vvs = new VelocityViewServlet();
		
		List<String> nameList = new ArrayList<String>();
		nameList.add("aaa");
		nameList.add("bbb");
		nameList.add("ccc");
		nameList.add("ddd");
		nameList.add("eee");
		
		request.setAttribute("theList", nameList);
		
		return mapping.findForward("success");
	}
	
}
