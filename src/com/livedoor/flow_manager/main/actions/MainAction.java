package com.livedoor.flow_manager.main.actions;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @version 	1.0
 * @author
 */
public class MainAction extends Action {
	private Logger logger = Logger.getLogger(this.getClass());
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
		HttpSession session = request.getSession(false);
		
		if(null == session){
			logger.info("the main.do session is null");
		}else{
			logger.info("main.do sessionID:"+session.getId());
		}
		return (mapping.findForward("mainDefaultcomponent"));

	}
}
