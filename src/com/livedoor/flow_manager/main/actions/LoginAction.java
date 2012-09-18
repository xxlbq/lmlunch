package com.livedoor.flow_manager.main.actions;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationManager;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.common.acegi.UserDetailsServiceImp;
import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.main.forms.LoginForm;
import com.livedoor.flow_manager.tools.SystemTools;
import com.livedoor.flow_manager.tools.UtilValidate;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;
import com.lm.common.util.obj.ObjectCommonUtil;

/**
 * @version 	1.0
 * @author
 */
public class LoginAction extends BaseAction {
	
	private  static Logger LOGGER = Logger.getLogger(LoginAction.class);
	
	private IUserService userService;
	private UserDetailsServiceImp userDetailsServiceImp;
	private AuthenticationManager authenticationManager;   
  
	
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {   
        this.authenticationManager = authenticationManager;   
    }  
	
    
    
	public UserDetailsServiceImp getUserDetailsServiceImp() {
		return userDetailsServiceImp;
	}



	public void setUserDetailsServiceImp(UserDetailsServiceImp userDetailsServiceImp) {
		this.userDetailsServiceImp = userDetailsServiceImp;
	}



	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		LoginForm lnForm = (LoginForm)form;
		if(ObjectCommonUtil.isEmpty(lnForm)){
			return mapping.getInputForward();
		}
		User user =userService.getUserByNameAndPwd(
				lnForm.getLoginID() , lnForm.getLoginPwd());
		
		if(ObjectCommonUtil.isEmpty(user)){
			LOGGER.warn(" the user is invalid~~~");
			ActionMessages errores = new ActionMessages();
			errores.add("loginIdOrPwd",new ActionMessage( "login.error" ) );
			saveErrors(request, errores);
			return mapping.getInputForward();
		}
		
		if(UtilValidate.isNotValidUser(user)){
			ActionMessages errores = new ActionMessages();
			errores.add("userExpired",new ActionMessage( "user.Expired" ) );
			saveErrors(request, errores);
			return mapping.getInputForward();
		}
		
		UserDetails userDetails;
		userDetails = this.userDetailsServiceImp.loadUserByUsername(user.getUserName());   
		
//		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		UsernamePasswordAuthenticationToken auth = 
			new UsernamePasswordAuthenticationToken(null,null,user.getAuthorities());

//		Authentication authResult = 
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					user.getUserName(), user.getPassword(),user.getAuthorities())); 
		
		auth.setDetails(userDetails);
//		auth.setAuthenticated(true);
		
		LOGGER.info("Authentication:"+auth.toString());
		SecurityContextHolder.getContext().setAuthentication(auth);   
		
		//
		String lastLoginIp = SystemTools.getIpAddr(request);
		user.setUserLastLoginIp(lastLoginIp);
		
		LOGGER.info("login user :"+user.toString());
		LOGGER.info("login request sessionId:"+request.getSession().getId());
		
		userService.updateUser(user);
		
		request.getSession().setAttribute(AttributeKeyConstant.USER_INFO_KEY, user);
		
		LOGGER.info(" before login return ~~~");
		return (mapping.findForward("successes"));

	}
	
}
