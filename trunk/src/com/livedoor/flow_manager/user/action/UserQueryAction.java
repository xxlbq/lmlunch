package com.livedoor.flow_manager.user.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.form.UserForm;
import com.livedoor.flow_manager.user.service.IUserService;

public class UserQueryAction extends MappingDispatchAction{

	private static Logger LOGGER = Logger.getLogger(UserQueryAction.class);
	
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward display(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" UserQueryAction display ---> ");
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		
		//check role
		//TODO:
		
		LOGGER.info(" UserQueryAction display <--- ");
		return mapping.findForward("success");
		
	}

	public ActionForward query(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" UserQueryAction display ---> ");

		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		
		//check role
		//TODO:
		
		UserForm uform = (UserForm)form ;
		User u = toUser(uform);
		LOGGER.info(" query user: "+u);
		List<User> userList = userService.getUserListByCriteriaQueryUser(u);
		request.setAttribute("USER_LIST", userList);
		
		LOGGER.info(" UserQueryAction display <--- ");
		return mapping.findForward("success");
		
	}

	private User toUser(UserForm uform) {
		User u =new User();
		u.setUserName(uform.getUserName());
		u.setUserDisplayName(uform.getUserDisplayName());
		return u;
	}
}
