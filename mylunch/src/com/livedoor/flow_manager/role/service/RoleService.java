package com.livedoor.flow_manager.role.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.livedoor.flow_manager.role.beans.Role;
import com.livedoor.flow_manager.role.dao.RoleDao;
import com.livedoor.flow_manager.sources.exception.SourceException;

public class RoleService implements IRoleService{
	private final static Logger log = Logger.getLogger(RoleService.class);
	
	private RoleDao roleDao;
	
	
	@SuppressWarnings("unchecked")
	public List<Role> queryAllRoles() {
		
		List<Role> sList = null;
		try {
			sList= roleDao.query("FROM com.livedoor.flow_manager.role.beans.Role WHERE roleId >= ?", new Integer(5));
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In queryAllRoles() method ]++++++",he);
			throw new SourceException(1004,"queryAllRoles() error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In queryAllRoles() method ]++++++",e);
			throw new SourceException(9999,"queryAllRoles() error! :"+e.getMessage());
		}
		return sList;
		
	}


	public RoleDao getRoleDao() {
		return roleDao;
	}


	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	
	
}
