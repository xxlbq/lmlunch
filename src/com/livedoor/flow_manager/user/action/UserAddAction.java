package com.livedoor.flow_manager.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.common.info.MessageInfo;
import com.livedoor.flow_manager.enums.IdKeyEnum;
import com.livedoor.flow_manager.noGenerator.INoGeneratorService;
import com.livedoor.flow_manager.sysConfig.ISysConfigConstants;
import com.livedoor.flow_manager.sysConfig.ISysConfigService;
import com.livedoor.flow_manager.tools.SystemTools;
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
	private ISysConfigService sysConfigService;
	
	
	
	
	
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


	public void setSysConfigService(ISysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}


	public ActionForward add(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
			
		
		
		LOGGER.info(" UserAddAction add ---> ");
		UserForm ssf = (UserForm)form ;
		String regIp = SystemTools.getIpAddr(request);
		
		Integer MAX_REG_IP_COUNT = Integer.parseInt(sysConfigService.querySysConfig(ISysConfigConstants.CONFIG_TYPE_SYS, ISysConfigConstants.CONFIG_KEY_MAX_REG_IP_COUNT));
		Boolean MAX_REG_IP_SWITCH = Boolean.parseBoolean(sysConfigService.querySysConfig(ISysConfigConstants.CONFIG_TYPE_SYS, ISysConfigConstants.CONFIG_KEY_MAX_REG_IP_SWITCH));
		//max 
		Integer max = userService.queryMaxRegIp(regIp);
		
		if(MAX_REG_IP_COUNT <= max && MAX_REG_IP_SWITCH){
			ActionMessages errores = new ActionMessages();
			errores.add("sameIpMaxReg",new ActionMessage( "reg.maxIpReg" ) );
			request.setAttribute("ERROR_MESSAGE_INFO", errores);
			return mapping.getInputForward();
		}
		//
		if(!ssf.getUserPassword().equals(ssf.getUserPassword2())){
			ActionMessages errores = new ActionMessages();
			errores.add("notSamePassword",new ActionMessage( "reg.notSamePassword" ) );
			request.setAttribute("ERROR_MESSAGE_INFO", errores);
			return mapping.getInputForward();
		}

		//same display name
		User user = userService.getUniqueUserByUserDisplayName(ssf.getUserDisplayName());
		if( null != user ){
			ActionMessages errores = new ActionMessages();
			errores.add("sameUserDisplayName",new ActionMessage( "reg.sameDisplayName" ) );
			request.setAttribute("ERROR_MESSAGE_INFO", errores);
			return mapping.getInputForward();
		}
		
		String loginId= noGeneratorService.getPrefixId(prefix,IdKeyEnum.LOGIN_IN_ID.getValue());
		ssf.setUserName(loginId);
		ssf.setUserRegIp(regIp);
		User insertUser = UserUtil.toRegUser(ssf);
		LOGGER.info("reg user detail:"+insertUser);
		userService.addUser(insertUser);
		
		MessageInfo info = new MessageInfo();
		info.setMessage("OK");
		request.setAttribute("MESSAGE_INFO", info);
		request.setAttribute("USER_INFO", insertUser);
		
		LOGGER.info(" UserAddAction add  <--- ");
		return mapping.findForward("success");
		
		}

}
