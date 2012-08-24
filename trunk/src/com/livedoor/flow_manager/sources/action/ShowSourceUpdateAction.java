package com.livedoor.flow_manager.sources.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldier.SoldierService;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.sources.service.ISourceService;
import com.lm.common.util.str.StringCommonUtil;

public class ShowSourceUpdateAction extends BaseAction{
	
	private ISourceService sourceService;
	private SoldierService foodService;

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
			
		Source updateSource = sourceService
			.getSourceBySourceId(StringCommonUtil.isEmpty(request.getParameter("sourceId")) ? null 
					: Integer.parseInt(request.getParameter("sourceId")) ) ;
		
		if(null != updateSource){
			
			((SourceForm)form).setSourceFoodId(String.valueOf(updateSource.getFood().getSoldierId()));
		}else{
			updateSource = new Source();
		}
		
		List<Soldier> foodList = foodService.queryAllSoldier();
		request.setAttribute("SOURCE_FOOD_OBJ", foodList);
		
		request.setAttribute("UPDATE_SOURCE_OBJECT", updateSource);
			
			
			
		return mapping.findForward("success");
		
	}
}
