package com.livedoor.flow_manager.main.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.user.service.IUserService;

public class LogoutAction extends BaseAction{

		
		private IUserService userService;
		
		public void setUserService(IUserService userService) {
			this.userService = userService;
		}

		public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			
//			HttpSession session=request.getSession();
			ActionForward forward = new ActionForward();
//			
//			session.setAttribute(AttributeKeyConstant.USER_INFO_KEY, arg1)
			forward = mapping.findForward("sucesses");
			
			
			
			
//			User user = (User) getSessionObject( request, AttributeKeyConstant.USER_INFO_KEY );
//			ActionMessages msg = new ActionMessages();
//			if ( user != null ){
//			   return new ActionForward(  user.getType() + ".htm", true );//成功就去type.htm
//			}
//			else{
//				String error = getRequestParameter( request, AttributeKeyConstant.USER_INFO_KEY );
//			   if ( error != null ) //对于不同的错误，都加以提示
//			   {
//			    if ( error.equalsIgnoreCase( "wrong" ) )
//			     msg.add( "msg", new ActionMessage( "fail.login.wrong" ) );
//			    else if ( error.equalsIgnoreCase( "too" ) )
//			     msg.add( "msg", new ActionMessage( "fail.login.too" ) );
//			    else if ( error.equalsIgnoreCase( "fail" ) )
//			     msg.add( "msg", new ActionMessage( "fail.login.fail" ) );
//			    else
//			     msg.add( "msg", new ActionMessage( "fail.login.please" ) );
//			   }
//			   else
//			    msg.add( "msg", new ActionMessage( "fail.login.please" ) );
//			  }
//			  saveErrors( request, msg );
//			  return mapping.findForward( "fail" );

			
		 	
			return (forward);

		}
}
