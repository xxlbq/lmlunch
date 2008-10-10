package com.livedoor.flow_manager.jms.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.livedoor.flow_manager.test.bean.Employee;



public class ToJmsSend extends Action{
	
	

	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		DynaValidatorForm df = (DynaValidatorForm) form;
//		DynaValidatorForm df = new DynaValidatorForm();
		Map<String, Employee> hm = new HashMap<String, Employee>();
		
		Employee p = new Employee();
		p.setName("aaa");p.setAge(111);
		hm.put("1", p);
		
		p = new Employee();
		p.setName("bbb");p.setAge(222);
		hm.put("2", p);
		
		p = new Employee();
		p.setName("ccc");p.setAge(333);
		hm.put("3", p);  
		
		df.set("comments", hm);
		df.set("people", new String[]{"str1","str2","str3"});
		
//		request.setAttribute("dynamicForm", df);
		
		return mapping.findForward("success");
	}
}