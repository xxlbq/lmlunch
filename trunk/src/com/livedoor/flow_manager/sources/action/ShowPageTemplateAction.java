package com.livedoor.flow_manager.sources.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.sources.service.ISourceService;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.tools.lbq.PageFactory;
import com.livedoor.flow_manager.tools.lbq.PageTemplate;
public class ShowPageTemplateAction extends Action{
	
	private ISourceService sourceService;
	
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}
	

	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
	
		int pageNo = Integer.parseInt(request.getParameter("pageNo")== null ? "1" : request.getParameter("pageNo"));
		int recordsCount = getSourceService().getSourceCount();
		Page p = PageFactory.createPage(-1, pageNo, recordsCount);
		List list = getSourceService().queryAllSource(p);
		
		PageTemplate sp = new PageTemplate(p,list);
//		sp.setPage(PageFactory.createPage(-1, pageNo, recordsCount));
		
		/*  page info */
		request.setAttribute("PAGE_INFO_BEAN", sp);
		
//		request.setAttribute("QUERY_SOURCE_OBJECT", form);
//		request.setAttribute("QUERY_SOURCE_LIST",SourceList );
		
//		getSourceService().insertMany();
		return mapping.findForward("success");
		
	}

}
