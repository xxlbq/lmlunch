package com.livedoor.flow_manager.sysConfig;

import java.io.Serializable;

public class SysConfigId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1985062971651834320L;
	private String configType;
	private String configKey;
	
	public String getConfigType() {
		return configType;
	}
	public void setConfigType(String configType) {
		this.configType = configType;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	
	
}
