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

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.form.UserForm;
import com.livedoor.flow_manager.user.service.IUserService;

public class UserUpdateAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(UserUpdateAction.class);
	
	private IUserService userService;

	
	

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



	public ActionForward display(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
			
		
		
		LOGGER.info("display ---> ");
		
		String userId = request.getParameter("userId");
		User user = null;
		if(null == userId){
			user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
			LOGGER.info("update userId is null , not admin update . get user in session");
		}else{
			user = userService.getUserByUserId(Integer.parseInt(userId));
		}
		
		LOGGER.info("update user :"+user);
		UserForm gsf =(UserForm)form ;
		gsf.setId(user.getUserId());
		gsf.setUserDisplayName(user.getUserDisplayName());
		
		request.setAttribute("USER_UPDATE_KEY", userId);
		
		LOGGER.info("display <--- ");
		return mapping.findForward("success");
		
		}

	public ActionForward update(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
			
		
		
		LOGGER.info("update ---> ");
//		
//		String userId = request.getParameter("userId");
//		User user = null;
//		if(null == userId){
//			LOGGER.info("update userId is null , not admin update . get user in session");
//			user = userService.getUserByUserId(Integer.parseInt(userId));
//		}
//		
//		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);

		//check
		
		UserForm gsf =(UserForm)form ;
		LOGGER.info("update user :"+gsf);
		User updateUser = userService.getUserByUserId(gsf.getId());
		
		if(!updateUser.getPassword().equals(gsf.getPreviousPassword())){
			//
			ActionMessages errores = new ActionMessages();
			errores.add("previousPasswordWrong",new ActionMessage( "user.previousPasswordWrong" ) );
			request.setAttribute("ERROR_MESSAGE_INFO", errores);
			request.setAttribute("USER_UPDATE_KEY", updateUser.getUserId());
			return mapping.getInputForward();
		}
		
		if(gsf.getUserPassword()== null  || !gsf.getUserPassword().equals(gsf.getUserPassword2()) ){
			ActionMessages errores = new ActionMessages();
			errores.add("2PasswordNotSame",new ActionMessage( "reg.notSamePassword" ) );
			request.setAttribute("ERROR_MESSAGE_INFO", errores);
			request.setAttribute("USER_UPDATE_KEY", updateUser.getUserId());
			return mapping.getInputForward();
		}
		
		
		//update
		updateUser.setUserPassword(gsf.getUserPassword());
		userService.updateUser(updateUser);
		
		LOGGER.info("update <--- ");
		return mapping.findForward("success");
		
	}
}
