package com.livedoor.flow_manager.gemSource.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.gem.IGemService;
import com.livedoor.flow_manager.gemSource.IGemSourceService;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class GemSourceDistributionQuery extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(GemSourceQueryAction.class);
	
	private IGemService gemService;
	private IKingdomService kingdomService ;
	private IGemSourceService gemSourceService;
	private IUserService userService;

	

	public IGemService getGemService() {
		return gemService;
	}

	public void setGemService(IGemService gemService) {
		this.gemService = gemService;
	}

	public IKingdomService getKingdomService() {
		return kingdomService;
	}

	public void setKingdomService(IKingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}

	public IGemSourceService getGemSourceService() {
		return gemSourceService;
	}

	public void setGemSourceService(IGemSourceService gemSourceService) {
		this.gemSourceService = gemSourceService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward display(ActionMapping mapping,
		   ActionForm form,
		   HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" GemSourceDistributionQuery display ---> ");
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		List gsList = gemSourceService.queryAllGemSourceDate();
		if(null != gsList || !gsList.isEmpty()){
			List<LabelValueBean> gsDateArr = toCollection(gsList);
			request.setAttribute("GEM_SOURCE_DATE_LIST", gsDateArr);
		}
		

		LOGGER.info(" GemSourceDistributionQuery display <--- ");
		return mapping.findForward("success");
	
	}


	public ActionForward query(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {

		LOGGER.info(" GemSourceDistributionQuery query ---> ");
		
		
		
		
		
		LOGGER.info(" GemSourceDistributionQuery query <--- ");
		
		return mapping.findForward("success");
		
	}
	
	
	private List<LabelValueBean> toCollection(List gsList) {
		List<LabelValueBean> ds = new ArrayList<LabelValueBean>();
		for (Object obj : gsList) {
			LabelValueBean bean = new LabelValueBean((String)obj, (String)obj);
			ds.add(bean);
		}
		return ds;
	}
}
