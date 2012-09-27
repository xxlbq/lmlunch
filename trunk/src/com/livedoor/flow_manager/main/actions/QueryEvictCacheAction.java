package com.livedoor.flow_manager.main.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;


import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.role.beans.Role;
import com.livedoor.flow_manager.role.service.IRoleService;

/**
 * @version 1.0
 * @author
 */
public class QueryEvictCacheAction extends BaseAction {
	
	private static Logger logger = Logger.getLogger(QueryEvictCacheAction.class);

	private IRoleService roleService;
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

//		System.out.println("=================  QueryCacheAction:   fired ");

		if (null == roleService) {
			System.err.println(" ============ roleService  is NUL  ============");
			return mapping.getInputForward();
		}

		
//		System.out.println(" begin evict .... ");
		sessionFactory.evictQueries(com.livedoor.flow_manager.IConstant.SystemConstants.QUERY_CACHE_PREFIX);
		sessionFactory.evict(Role.class);
//		System.out.println(" evict  over.    ");
		
		List<Role> roleList = roleService.queryAllRoles();
		
		for (Role role : roleList) {

//			System.out.println("@ roleId:" + role.getRoleId() + ",roleName:"
//					+ role.getRoleName());
		}

		return (mapping.findForward("successes"));

	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
