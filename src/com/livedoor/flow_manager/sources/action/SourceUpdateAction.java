package com.livedoor.flow_manager.sources.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.soldier.SoldierService;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.sources.service.ISourceService;
import com.livedoor.flow_manager.user.beans.User;
import com.lm.common.util.str.StringCommonUtil;

public class SourceUpdateAction extends BaseAction{
	
	
	
	
	
	private ISourceService sourceService;
	private SoldierService foodService;
	
	
	public SoldierService getFoodService() {
		return foodService;
	}

	public void setFoodService(SoldierService foodService) {
		this.foodService = foodService;
	}

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
		
		logger.info("req test:"+(String)request.getSession().getAttribute("aaa"));
		
		SourceForm sf = (SourceForm)form;
		logger.info("wow:"+request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY));
//		loggerInfo("update action: user->"+getSessionObject(request, AttributeKeyConstant.USER_INFO_KEY));
		User updateUser = (User)
			getSessionObject(request,AttributeKeyConstant.USER_INFO_KEY);
		
		logger.info(" ====get= update =user========>"+updateUser.toString());
		
		Source updateSource = sourceService.getSourceBySourceId(
				(StringCommonUtil.isNotEmpty(sf.getSourceId())) 
				? null
						: Integer.parseInt(sf.getSourceId().trim())
				);
		
		Source.buildSourceObjectFromSourceFormObject( updateSource, sf );
		
		updateSource.setUpdateUserId(updateUser.getUserId());
		
		updateSource.setUpdateDatetime(Calendar.getInstance());
		
		
		logger.info(updateSource);
		sourceService.updateSource( updateSource);
		
		
		request.setAttribute("SUCCESS_FORWARD", "updateReback.do");
		
		return mapping.findForward("success");
	}
	
}
