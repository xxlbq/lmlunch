package com.livedoor.flow_manager.soldierSource.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.soldier.ISoldierService;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldierSource.ISoldierSourceService;
import com.livedoor.flow_manager.soldierSource.SoldierSource;
import com.livedoor.flow_manager.soldierSource.form.SoldierSourceForm;
import com.livedoor.flow_manager.user.beans.User;

public class SoldierSourceUpdateAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(SoldierSourceUpdateAction.class);
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
		
		LOGGER.info(" action display ---> ");
		List<Soldier> soldierList = soldierService.queryAllSoldier();
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		
		request.setAttribute("SOLDIER_LIST", soldierList);
		request.setAttribute("KINGDOM_LIST", kingdomList);
		request.setAttribute("USER_INFO", user);
		
		String updateSoldierSourceId = request.getParameter("soldierSourceId");
		if(null == updateSoldierSourceId){
			
		}
		
		SoldierSource ss = soldierSourceService.getSoldierSourceBySoldierSourceId(updateSoldierSourceId);
		LOGGER.info("update gem source :"+ss);
		
		SoldierSourceForm ssf = (SoldierSourceForm)form;
		ssf.setSourceId(ss.getSourceId());
		ssf.setUserId(ss.getUser().getUserId());
		ssf.setUserName(ss.getUser().getUsername());
		ssf.setUserDisplayName(ss.getUser().getUserDisplayName());
		ssf.setSourceSoldierId(ss.getSoldier().getSoldierId());
		ssf.setSourceSoldierName(ss.getSoldier().getSoldierName());
		ssf.setSourceSoliderCount(ss.getSourceSoliderCount());
		ssf.setKingdomId(ss.getKingdom().getKingdomId());
		ssf.setKingdomDisplayName(ss.getKingdom().getKingdomName());

		request.setAttribute("SOLDIER_SOURCE_UPDATE_KEY", ss.getSourceId());
		
		LOGGER.info(" action display <--- ");
		return mapping.findForward("success");
	
	}
	
	public ActionForward update(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" update ---> ");
		
		List<Soldier> soldierList = soldierService.queryAllSoldier();
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		
		request.setAttribute("SOLDIER_LIST", soldierList);
		request.setAttribute("KINGDOM_LIST", kingdomList);
		request.setAttribute("USER_INFO", user);
		
		SoldierSourceForm ssf = (SoldierSourceForm)form;
		LOGGER.info("update soldier source info:"+ssf);
		
		soldierSourceService.updateSoldierSourceById(
				ssf.getSourceId(), ssf.getKingdomId(),ssf.getSourceSoldierId(),ssf.getSourceSoliderCount(),user);
		
		LOGGER.info(" update <--- ");
		return mapping.findForward("success");
		
	}


}
