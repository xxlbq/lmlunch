package com.livedoor.flow_manager.sources.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.food.beans.Food;
import com.livedoor.flow_manager.food.service.IFoodService;

public class ShowSourceAddAction extends Action{
	
	private static Logger  log = Logger.getLogger(ShowSourceAddAction.class);
	
	private IFoodService foodService;

	public void setFoodService(IFoodService foodService) {
		this.foodService = foodService;
	}
	
	
	public ActionForward execute(ActionMapping mapping,
		   ActionForm form,
		   HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
		
		log.info(" ShowSourceAddAction ---> ");
		List<Food> foodList = foodService.queryAllFood();
		log.info(" food list size :"+foodList.size());
		request.setAttribute("SOURCE_FOOD", foodList);
		request.setAttribute("SOURCE_FOOD_OBJ", foodList);
//		((SourceForm)form).setSourceFoodId(5);
		log.info(" ShowSourceAddAction <--- ");
		return mapping.findForward("success");
	
	}
	
}
