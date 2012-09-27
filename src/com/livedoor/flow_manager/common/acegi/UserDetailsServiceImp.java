package com.livedoor.flow_manager.common.acegi;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;

import com.livedoor.flow_manager.user.service.IUserService;


public class UserDetailsServiceImp implements UserDetailsService{



	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
//	private UserService userService;
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}

//	protected boolean requiresAuthentication
//		( HttpServletRequest request ,HttpServletResponse response ){
//		
//		boolean requiresAuth = super.requiresAuthentication( request, response );
//		HttpSession httpSession = null;
//		try{
//			
//			httpSession = request.getSession( false );
//		}
//		catch ( IllegalStateException ignored ){
//		}
//		
//		if ( httpSession != null ){
//			if ( httpSession.getAttribute( AttributeKeyConstant.USER_INFO_KEY ) == null ){
//				if ( !requiresAuth ){
//					SecurityContext sc = SecurityContextHolder.getContext();
//					Authentication auth = sc.getAuthentication();
//					if ( auth != null && auth.getPrincipal() instanceof UserDetails ){
//						
//						UserDetails ud = (UserDetails) auth.getPrincipal();
//						User user = userService.getUniqueUserByUserName(ud.getUsername());
//						httpSession.setAttribute( AttributeKeyConstant.USER_INFO_KEY, user );
//					}
//				}
//			}
//		}
//		
//		return requiresAuth;
//	}
//	
	
	
	
	
	
	
	
//	~ Instance fields ================================================================================================

//    private UserMap userMap;

    //~ Methods ========================================================================================================

//    public void afterPropertiesSet() throws Exception {
//    	org.springframework.util.Assert.notNull(this.userService,
//            "A list of users, passwords, enabled/disabled status and their granted authorities must be set");
//    }



    /* 

     * 
     * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException, DataAccessException {
//    	System.out.println("== spring acegi call loadUserByUsername() method ,when login fired  ====@_@====>");
        return userService.getUniqueUserByUserName(username);
    }



//    /**
//     * Modifies the internal <code>UserMap</code> to reflect the <code>Properties</code> instance passed. This
//     * helps externalise user information to another file etc.
//     *
//     * @param props the account information in a <code>Properties</code> object format
//     */
//    public void setUserProperties(Properties props) {
//        UserMap userMap = new UserMap();
//        this.userMap = UserMapEditor.addUsersFromProperties(userMap, props);
//    }
	
}
