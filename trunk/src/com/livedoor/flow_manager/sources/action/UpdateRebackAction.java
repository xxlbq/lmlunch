package com.livedoor.flow_manager.sources.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.sources.service.ISourceService;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.tools.lbq.PageFactory;
import com.livedoor.flow_manager.tools.lbq.PageTemplate;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class UpdateRebackAction extends Action{
	
	
	private IUserService userService;
	
	private ISourceService sourceService;
	
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}

	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
//		request.setAttribute("QUERY_SOURCE_OBJECT", null);
		
		SourceForm sf = new SourceForm();
		
		/*  pageInfo Object */
//		SourcePageInfoBean sp = getSourceManager()
//									.getSourcePageInfoBeanByCriteriaQuerySource(null, PageConstant.SOURCE_INIT_PAGE_NUMBER);
//		
		int pageNo = Integer.parseInt(request.getParameter("pageNo")== null ? "1" : request.getParameter("pageNo"));
		int recordsCount = getSourceService().getSourceCount();
		Page p = PageFactory.createPage(-1, pageNo, recordsCount);
		List list = getSourceService().queryAllSource(p);
		
		PageTemplate sp = new PageTemplate(p,list);
		
		List<User> commonUser = getUserService().queryAllUser();
		
		request.setAttribute("INSERT_USER", commonUser);
		
		request.setAttribute("UPDATE_USER", commonUser);
		
		request.setAttribute("PAGE_INFO_BEAN", sp);
		
		
		
		
		request.setAttribute("QUERY_SOURCE_OBJECT", sf);
		
		return mapping.findForward("success");
	}

}
