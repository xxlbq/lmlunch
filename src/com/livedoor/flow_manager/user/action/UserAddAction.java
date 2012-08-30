package com.livedoor.flow_manager.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.Decoder;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.common.info.MessageInfo;
import com.livedoor.flow_manager.enums.IdKeyEnum;
import com.livedoor.flow_manager.noGenerator.INoGeneratorService;
import com.livedoor.flow_manager.noGenerator.NoGeneratorService;
import com.livedoor.flow_manager.user.UserUtil;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.form.UserForm;
import com.livedoor.flow_manager.user.service.IUserService;

public class UserAddAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(UserAddAction.class);
	private static String prefix = "U";
	
	private IUserService userService;
//	private ISoldierService soldierService;
//	private IKingdomService kingdomService ;
//	private ISoldierSourceService soldierSourceService;
	private INoGeneratorService noGeneratorService;

	
//	public void setSoldierService(ISoldierService soldierService) {
//		this.soldierService = soldierService;
//	}
//
//	public void setKingdomService(IKingdomService kingdomService) {
//		this.kingdomService = kingdomService;
//	}
//
//
//	public void setSoldierSourceService(ISoldierSourceService soldierSourceService) {
//		this.soldierSourceService = soldierSourceService;
//	}

//	public ActionForward display(ActionMapping mapping,
//		   ActionForm form,
//		   HttpServletRequest request,
//		   HttpServletResponse response) throws Exception {
//		
//		LOGGER.info(" SoldierSourceAddAction display ---> ");
//		List<Soldier> soldierList = soldierService.queryAllSoldier();
//		LOGGER.info(" food list size :"+soldierList.size());
//		
//		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
//		request.setAttribute("SOLDIER_LIST", soldierList);
//		request.setAttribute("USER_INFO", user);
////		((SourceForm)form).setSourceFoodId(5);
//		
//		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
//		request.setAttribute("KINGDOM_LIST", kingdomList);
//		LOGGER.info(" SoldierSourceAddAction display <--- ");
//		return mapping.findForward("success");
//	
//	}
	
	public void setNoGeneratorService(INoGeneratorService noGeneratorService) {
		this.noGeneratorService = noGeneratorService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public ActionForward add(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
			
		
		
		LOGGER.info(" SoldierSourceAddAction add ---> ");
		UserForm ssf = (UserForm)form ;
//		ssf.setUserName(new String(ssf.getUserName().getBytes("ISO8859_1"),"gb2312"));
//		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
//		int newUserId = ngService.getId(IdKeyEnum.LOGIN_IN_ID.getValue());
		String loginId= noGeneratorService.getPrefixId(prefix,IdKeyEnum.LOGIN_IN_ID.getValue());
//		ssf.setId(newUserId);
		ssf.setUserName(loginId);
		User insertUser = UserUtil.toRegUser(ssf);
//		soldierSourceService.addSoldierSource(s);
		userService.addUser(insertUser);
		
		MessageInfo info = new MessageInfo();
		info.setMessage("OK");
		request.setAttribute("MESSAGE_INFO", info);
		request.setAttribute("USER_INFO", insertUser);
		LOGGER.info(" reg user ok <--- ");
		return mapping.findForward("success");
		
		}

}
