package com.livedoor.flow_manager.sources.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.IConstant.ForwardMappingConstant;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldier.SoldierService;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.sources.service.ISourceService;
import com.livedoor.flow_manager.user.beans.User;

public class SourceAddAction extends Action{
	
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
		
		User insertAndUpdateUser = new User();
		
		insertAndUpdateUser.setUserId(3);
		
//		User t = new User();
//		
//		t.setId(3);
		
		
		SourceForm sf = (SourceForm)form;
//		User u = (User)request.getSession().getAttribute("USER_INFO");
		
		Source s= new Source();
		
		s.setDeletedFlag(0);
		
//		s.setSourceDesc(sf.getSourceDesc());
//		s.setSourceDoor(sf.getSourceDoor());
		
		s.setSourceName(sf.getSourceName());
		s.setFood(new Soldier(Integer.valueOf(sf.getSourceId())));
		s.setSourceFoodCount(Integer.valueOf(sf.getSourceFoodCount()));
		s.setSourceFoodPrice(
				foodService.getSoldierBySoldierId(
						Integer.valueOf(sf.getSourceFoodId())).getSoldierPoint()); 
				
		
//		s.setSourceFather(Integer.valueOf(sf.getSourceFather()));
		
		/* inputUserId mapping  user object */
		s.setInputDatetime(Calendar.getInstance());
//		s.setInputUserId(1);
		s.setInputUser(insertAndUpdateUser);
		
		/* updateUserId mapping  user object */
		s.setUpdateDatetime(Calendar.getInstance());
//		s.setUpdateUserId(1);
		s.setUpdateUser(insertAndUpdateUser);
		System.out.println(s.getSourceFoodPrice()+":"+s.getSourceFoodCount());
		sourceService.addSource(s);
		
		request.setAttribute("QUERY_SOURCE_OBJECT", form);
		request.setAttribute("SUCCESS_FORWARD", ForwardMappingConstant.SOURCE_ADD_SUCCESS_FORWARD);
		
		return mapping.findForward("success");
	}

}
