package com.livedoor.flow_manager.main.actions;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.role.beans.Role;
import com.livedoor.flow_manager.role.service.IRoleService;

/**
 * @version 	1.0
 * @author
 */
public class QueryCacheAction extends BaseAction {
	
	private  static Logger logger = Logger.getLogger(QueryCacheAction.class);
	
	private IRoleService roleService;
	


	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
//		System.out.println("=================  QueryCacheAction:   fired ");
		
		if(null == roleService){
			System.err.println(" ============ roleService  is NUL  ============");
			return mapping.getInputForward();
		}
		
		
		List<Role> roleList = roleService.queryAllRoles();
		for (Role role : roleList) {
			
//			System.out.println("@ roleId:"+role.getRoleId() +",roleName:"+role.getRoleName());
		}
		
		
		return (mapping.findForward("successes"));

	}


	public IRoleService getRoleService() {
		return roleService;
	}


	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	
	
}
