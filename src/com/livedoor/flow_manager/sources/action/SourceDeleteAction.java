package com.livedoor.flow_manager.sources.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.sources.service.ISourceService;
import com.lm.common.util.str.StringCommonUtil;

public class SourceDeleteAction extends Action{
	
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
		
		String sId[] = request.getParameterValues("sId");
		
		for (int i = 0; i < sId.length; i++) {
			
			if(StringCommonUtil.isNotEmpty(sId[i])){
				
				sourceService.deleteSourceByDeleteFlag( Integer.parseInt(sId[i]));
			}
		}
		
		request.setAttribute("SUCCESS_FORWARD", "deleteReback.do");
		
		return mapping.findForward("success");
	}
}
