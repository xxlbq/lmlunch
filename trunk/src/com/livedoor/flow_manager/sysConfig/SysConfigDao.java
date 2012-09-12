package com.livedoor.flow_manager.sysConfig;

import com.livedoor.flow_manager.generic.dao.GenericDAOHibernateImpl;

public class SysConfigDao  extends GenericDAOHibernateImpl{

	
	
	
	
	public String querySysConfig(String type, String key) {
		
		String hql = "SELECT configValue FROM SysConfig WHERE id.configType= ? AND id.configKey= ? ";
		
		String s = (String)queryUseCache(hql, new Object[]{type,key}).get(0);
		return s;
	}

	
}
