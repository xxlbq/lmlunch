package com.livedoor.flow_manager.sysConfig;

public class SysConfigService implements ISysConfigService{
	
	private SysConfigDao sysConfigDao;
	
	public void setSysConfigDao(SysConfigDao sysConfigDao) {
		this.sysConfigDao = sysConfigDao;
	}


	public String querySysConfig(String type,String key){
		return sysConfigDao.querySysConfig(type, key);
	}
	
}
