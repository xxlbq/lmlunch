package com.livedoor.flow_manager.soldierSource.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.common.info.MessageInfo;
import com.livedoor.flow_manager.enums.ActiveEnum;
import com.livedoor.flow_manager.enums.ApproveEnum;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.soldier.ISoldierService;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldierSource.ISoldierSourceService;
import com.livedoor.flow_manager.soldierSource.SoldierSource;
import com.livedoor.flow_manager.soldierSource.SoldierSourceUtil;
import com.livedoor.flow_manager.soldierSource.form.SoldierSourceForm;
import com.livedoor.flow_manager.tools.DateUtil;
import com.livedoor.flow_manager.tools.UUIDGenerator;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class SoldierSourceAddAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(SoldierSourceAddAction.class);
//	private IUserService userService;
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

	public ActionForward display(ActionMapping mapping,
		   ActionForm form,
		   HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" SoldierSourceAddAction display ---> ");
		List<Soldier> soldierList = soldierService.queryAllSoldier();
		LOGGER.info(" food list size :"+soldierList.size());
		
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("SOLDIER_LIST", soldierList);
		request.setAttribute("USER_INFO", user);
//		((SourceForm)form).setSourceFoodId(5);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		LOGGER.info(" SoldierSourceAddAction display <--- ");
		return mapping.findForward("success");
	
	}
	
	public ActionForward add(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
			
		
		
		LOGGER.info(" SoldierSourceAddAction add ---> ");
		SoldierSourceForm ssf = (SoldierSourceForm)form ;
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		SoldierSource s = SoldierSourceUtil.toSoldierSource4Add(ssf,user);
		soldierSourceService.addSoldierSource(s);
		
		MessageInfo info = new MessageInfo();
		info.setMessage("OK");
		request.setAttribute("MESSAGE_INFO", info);
		LOGGER.info(" SoldierSourceAddAction add <--- ");
		return mapping.findForward("success");
		
		}


}
