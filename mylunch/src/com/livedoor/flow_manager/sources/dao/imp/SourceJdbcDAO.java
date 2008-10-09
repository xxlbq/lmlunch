package com.livedoor.flow_manager.sources.dao.imp;

import com.livedoor.flow_manager.generic.dao.GenericDAOJdbcImpl;

public class SourceJdbcDAO extends GenericDAOJdbcImpl{
	
	public void addSource(String sql){
		save(sql);
	}

}
