package com.livedoor.flow_manager.soldierSource.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.enums.ApproveEnum;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.role.RoleUtil;
import com.livedoor.flow_manager.soldier.ISoldierService;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldierSource.ISoldierSourceService;
import com.livedoor.flow_manager.tools.CollectionTools;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class SoldierSourceApproveAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(SoldierSourceApproveAction.class);
	private IUserService userService;
	private ISoldierService soldierService;
	private IKingdomService kingdomService ;
	private ISoldierSourceService soldierSourceService;
	
	
	public void setSoldierService(ISoldierService soldierService) {
		this.soldierService = soldierService;
	}


	public void setKingdomService(IKingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}


	public void setSoldierSourceService(ISoldierSourceService soldierSourceService) {
		this.soldierSourceService = soldierSourceService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public ActionForward approve(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		//ROLE CHECK
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		if(!RoleUtil.isAdmin(user.getRole().getRoleId())){
			
			ActionMessages errores = new ActionMessages();
			errores.add("permissionDenied",new ActionMessage( "sys.permissionDenied" ) );
			request.setAttribute("ERROR_MESSAGE_INFO", errores);
			return mapping.getInputForward();
		}
		
		String ssIdArray = request.getParameter("soldierSourceIdArray");
		String[] ids =  ssIdArray.split(",");
		LOGGER.info("approve id :"+ssIdArray);
		
		for (String id : ids) {
			soldierSourceService.updateSoldierSourceApprove(id,ApproveEnum.APPROVED.getValue(),user);
		}
		
//		request.setAttribute("USER_INFO", user);
		
		List<Soldier> soldierList = soldierService.queryAllSoldier();
		request.setAttribute("SOLDIER_LIST", soldierList);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		List gsList = soldierSourceService.queryAllSoldierSourceDate();
		if(null != gsList && !gsList.isEmpty()){
			List<LabelValueBean> gsDateArr = CollectionTools.toCollection(gsList);
			request.setAttribute("SOLDIER_SOURCE_DATE_LIST", gsDateArr);
		}
		return mapping.findForward("success");
	}

	public ActionForward cancelApprove(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		//ROLE CHECK
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		if(!RoleUtil.isAdmin(user.getRole().getRoleId())){
			
			ActionMessages errores = new ActionMessages();
			errores.add("permissionDenied",new ActionMessage( "sys.permissionDenied" ) );
			request.setAttribute("ERROR_MESSAGE_INFO", errores);
			return mapping.getInputForward();
		}
		
		String ssIdArray = request.getParameter("soldierSourceIdArray");
		String[] ids =  ssIdArray.split(",");
		LOGGER.info("cancel approve id :"+ssIdArray);
		
		for (String id : ids) {
			soldierSourceService.updateSoldierSourceApprove(id,ApproveEnum.UNAPPROVED.getValue(),user);
		}
		
//		request.setAttribute("USER_INFO", user);
		
		List<Soldier> soldierList = soldierService.queryAllSoldier();
		request.setAttribute("SOLDIER_LIST", soldierList);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		List gsList = soldierSourceService.queryAllSoldierSourceDate();
		if(null != gsList && !gsList.isEmpty()){
			List<LabelValueBean> gsDateArr = CollectionTools.toCollection(gsList);
			request.setAttribute("SOLDIER_SOURCE_DATE_LIST", gsDateArr);
		}
		return mapping.findForward("success");
	}
}
