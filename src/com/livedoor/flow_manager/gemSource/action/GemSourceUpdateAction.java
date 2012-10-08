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
import com.livedoor.flow_manager.gem.Gem;
import com.livedoor.flow_manager.gem.IGemService;
import com.livedoor.flow_manager.gemSource.GemSource;
import com.livedoor.flow_manager.gemSource.IGemSourceService;
import com.livedoor.flow_manager.gemSource.form.UserForm;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class GemSourceUpdateAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(GemSourceUpdateAction.class);
	private IUserService userService;
	private IGemService gemService;
	private IKingdomService kingdomService ;
	private IGemSourceService gemSourceService;
	



	public void setGemSourceService(IGemSourceService gemSourceService) {
		this.gemSourceService = gemSourceService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public void setGemService(IGemService gemService) {
		this.gemService = gemService;
	}


	public void setKingdomService(IKingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}




	public ActionForward display(ActionMapping mapping,
		   ActionForm form,
		   HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" GemSourceUpdateAction display ---> ");
		
		String updateGemSourceId = request.getParameter("gemSourceId");
		if(null == updateGemSourceId){
			
		}
		
		GemSource gsource = gemSourceService.getGemSourceByGemSourceId(updateGemSourceId);
		LOGGER.info("update gem source :"+gsource);
		
		List<Gem> gemList = gemService.queryAllGem();
		LOGGER.info(" gem list size :"+gemList.size());
		
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("GEM_LIST", gemList);
		request.setAttribute("USER_INFO", user);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);

		UserForm gsf =(UserForm)form ;
		gsf.setGemSourcId(gsource.getGemSourcId());
		gsf.setKingdomId(gsource.getKingdom().getKingdomId());
		gsf.setKingdomDisplayName(gsource.getKingdom().getKingdomName());
		gsf.setGemId(gsource.getGem().getGemId());
		gsf.setGemName(gsource.getGem().getGemDisplayName());
		gsf.setSourceGemCount(gsource.getSourceGemCount());
		
		request.setAttribute("GEM_SOURCE_UPDATE_KEY", updateGemSourceId);
		
		LOGGER.info(" GemSourceUpdateAction display <--- ");
		return mapping.findForward("success");
	
	}
	
	public ActionForward update(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" GemSourceUpdateAction update ---> ");
		
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		List<Gem> gemList = gemService.queryAllGem();
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();

		request.setAttribute("GEM_LIST", gemList);
		request.setAttribute("USER_INFO", user);
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		UserForm ssf = (UserForm)form ;
		
		LOGGER.info("gem source id:"+ssf.getGemSourcId() +" ,update gem source count:"+ssf.getSourceGemCount());
		gemSourceService.updateAfterGetGemSource(new GemSource(ssf.getGemSourcId(),ssf.getSourceGemCount()),user);
		
		LOGGER.info(" GemSourceUpdateAction update <--- ");
		
		
		return mapping.findForward("success");
		
	}


}
