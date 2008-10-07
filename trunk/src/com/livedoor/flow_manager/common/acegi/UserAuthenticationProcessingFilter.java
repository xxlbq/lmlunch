package com.livedoor.flow_manager.common.acegi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
import org.acegisecurity.userdetails.UserDetails;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.user.service.IUserService;

public class UserAuthenticationProcessingFilter extends
	AuthenticationProcessingFilter  {
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	protected boolean requiresAuthentication
		( HttpServletRequest request ,HttpServletResponse response ){
		
		boolean requiresAuth = super.requiresAuthentication( request, response );
		HttpSession httpSession = null;
		try{
			
			httpSession = request.getSession( false );
		}
		catch ( IllegalStateException ignored ){
		}
		
		if ( httpSession != null ){
			if ( httpSession.getAttribute( AttributeKeyConstant.USER_INFO_KEY ) == null ){
				if ( !requiresAuth ){
					SecurityContext sc = SecurityContextHolder.getContext();
					Authentication auth = sc.getAuthentication();
					if ( auth != null && auth.getPrincipal() instanceof UserDetails ){
						
						UserDetails ud = (UserDetails) auth.getPrincipal();// 上面声明的sql无非就是要包装成这个对象
//						User user = userService.getUniqueUserByUserName(ud.getUsername());//从业务逻辑里找到用户，放到session里
//						httpSession.setAttribute( AttributeKeyConstant.USER_INFO_KEY, user );
					}
				}
			}
		}
		
		return requiresAuth;
	}
}
