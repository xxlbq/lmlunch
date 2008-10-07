package com.livedoor.flow_manager.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.MenuRepository;
import net.sf.navigator.menu.PermissionsAdapter;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.HttpSessionContextIntegrationFilter;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.ui.WebAuthenticationDetails;
import org.apache.log4j.Logger;

import com.livedoor.flow_manager.IConstant.ExceptionCodeConstant;
import com.livedoor.flow_manager.common.role.StrustMenuDisplayAdapter;
import com.livedoor.flow_manager.user.beans.User;



public class StrustMenuRoleFilter implements Filter {
	private static Logger logger = Logger.getLogger(StrustMenuRoleFilter.class);
	
	protected FilterConfig filterConfig = null; 
	
	public void init(FilterConfig fc) throws ServletException {
		this.filterConfig 	= fc;
		logger.info("FrameSetSessionFilter  init ==============>");

	}
	
	public void doFilter(ServletRequest req, 
							ServletResponse res,
							FilterChain chain)
				throws IOException, ServletException {

		
		
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

//		User usr = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		
		/*
		 * 从acegi中获取user的具体信息
		 * @see HttpSessionContextIntegrationFilter 
		 * */
		SecurityContext contextFromSessionObject = (SecurityContext)request.getSession().getAttribute(
				HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY);
		
		if(null == contextFromSessionObject){
			logger.error(" SecurityContext in session is null ! ");
			throw new ServletException(
					String.valueOf(ExceptionCodeConstant.USER_IN_SESSION_NULL_EXCEPTION));
		}else{
			logger.info(" SecurityContext get from session is not null . ");
		}
		
		Authentication authentication =  contextFromSessionObject.getAuthentication();
		WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();
		User usr = (User)authentication.getPrincipal();
		
		
		System.out.println(">>>>>>>> details:"+details.toString());
		System.out.println(">>>>>>>> user:"+usr.toString());
		
//		String usrName = details.getUsername();
//		String pwd = details.getPassword();
		
		GrantedAuthority[] roles =  authentication.getAuthorities();
		
//		System.out.println(" username:"+usrName + ",roles");
		
//		if(null == usr){
//			throw new ServletException(
//					String.valueOf(ExceptionCodeConstant.USER_IN_SESSION_NULL_EXCEPTION));
//		}
		
//		Role usrRole = usr.getRole();
//		if(null == usrRole){
//			logger.error(" user in session is null !  , sessionId:"+request.getSession().getId());
//			throw new ServletException(
//					String.valueOf(ExceptionCodeConstant.USERROLE_IN_SESSION_NULL_EXCEPTION));
//		}
//		
//		int roleNo = usrRole.getRoleId();
//		logger.info("*** User *** "+usr.getUsername()+" role no --------------> "+roleNo);
		
		//
//		if(StringUtils.isNotEmpty(headerKey)
//				&& StringUtils.isNotEmpty(headerValue)){
//		
//			((HttpServletResponse)res)
//				.addHeader(headerKey, headerValue);
//		}
//		
//		chain.doFilter(req, res);
		

//		response.setHeader("P3P","CP=CAO PSA OUR");
		response.addHeader("P3P","CP=CAO PSA OUR");
		chain.doFilter(request, response);
	}
	
	
	
	public HttpServletRequest setupBreadcrumbs(HttpServletRequest request) {
	    MenuRepository repository =
	        (MenuRepository) request.getSession().getServletContext()
	                                .getAttribute(MenuRepository.MENU_REPOSITORY_KEY);

	    MenuComponent menu = repository.getMenu("JobPostingMenu");
	    List menusToEnable = new ArrayList();
	    boolean enableMenu = false;

	    List items = menu.getComponents();
	    List menus = new ArrayList();

	    String currentURL = request.getRequestURI();

	    if (logger.isInfoEnabled()) {
	    	logger.info("currentURL: " + currentURL);
	    }

	    // if the currentURL matches any in the JobPostingMenu, 
	    // perform logic to show/hide menus
	    if (items != null) {
	        for (Iterator it = items.iterator(); it.hasNext();) {
	            MenuComponent kid = (MenuComponent) it.next();

	            // using descriptions to match URLs since the actions
	            // and forwards are determined in the taglib at runtime
	            String pattern = kid.getDescription().trim();
	            menus.add(kid.getName());

	            if (logger.isInfoEnabled()) {
	            	logger.info("comparing itemURL: " + pattern);
	            }

	            boolean matchFound =
	                Pattern.compile(pattern).matcher(currentURL).find();

	            if (matchFound) {
	                enableMenu = true;

	                break;
	            }
	        }
	    }

	    if (logger.isInfoEnabled()) {
	    	logger.info(((enableMenu) ? "enabling" : "disabling") +
	                  " JobPostingMenu");
	    }

	    if (enableMenu) {
	        String positionId =
	            (request.getParameter("positionId") == null)
	            ? request.getParameter("id") : request.getParameter("positionId");
	        request.getSession().setAttribute("positionId", positionId);
	        menusToEnable.add(menu.getName());

	        // loop through, get the first one that matches, and then enable
	        // all the ones up to that point
	        for (int i = 0; i < menus.size(); i++) {
	            menusToEnable.add((String) menus.get(i));
	        }
	    }

	    if (logger.isInfoEnabled()) {
	    	logger.debug("allowed menus: " + menusToEnable);
	    }

	    PermissionsAdapter permissions = new StrustMenuDisplayAdapter(menusToEnable);
	    request.setAttribute("breadcrumbsAdapter", permissions);

	    return request;
	}
	
	
	public void destroy() {
		this.filterConfig 	= null;
	}
	
}

