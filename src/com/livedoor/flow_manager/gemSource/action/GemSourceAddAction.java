package com.livedoor.flow_manager.gemSource.action;

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
import com.livedoor.flow_manager.gem.Gem;
import com.livedoor.flow_manager.gem.IGemService;
import com.livedoor.flow_manager.gemSource.GemSource;
import com.livedoor.flow_manager.gemSource.GemSourceUtil;
import com.livedoor.flow_manager.gemSource.IGemSourceService;
import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class GemSourceAddAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(GemSourceAddAction.class);
	private IUserService userService;
	private IGemService gemService;
	private IKingdomService kingdomService ;
	private IGemSourceService GemSourceService;
	



	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public void setGemService(IGemService gemService) {
		this.gemService = gemService;
	}


	public void setKingdomService(IKingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}


	public void setGemSourceService(IGemSourceService GemSourceService) {
		this.GemSourceService = GemSourceService;
	}

	public ActionForward display(ActionMapping mapping,
		   ActionForm form,
		   HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" GemSourceAddAction display ---> ");
		List<Gem> gemList = gemService.queryAllGem();
		LOGGER.info(" gem list size :"+gemList.size());
		
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("GEM_LIST", gemList);
		request.setAttribute("USER_INFO", user);
//		((SourceForm)form).setSourceFoodId(5);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		LOGGER.info(" GemSourceAddAction display <--- ");
		return mapping.findForward("success");
	
	}
	
	public ActionForward add(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
			
		
		
		LOGGER.info(" GemSourceAddAction add ---> ");
		GemSourceForm ssf = (GemSourceForm)form ;
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		GemSource s = GemSourceUtil.toGemSource4Add(ssf,user);
		GemSourceService.addGemSource(s);
		
		MessageInfo info = new MessageInfo();
		info.setMessage("OK");
		request.setAttribute("MESSAGE_INFO", info);
		LOGGER.info(" GemSourceAddAction add <--- ");
		
		
		return mapping.findForward("success");
		
	}


}
