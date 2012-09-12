package com.livedoor.flow_manager.sysConfig;


public class SysConfig {
	
	private SysConfigId id;
	
	private String configValue;
	private String configMemo;
	
	
	public SysConfigId getId() {
		return id;
	}
	public void setId(SysConfigId id) {
		this.id = id;
	}
	
	
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getConfigMemo() {
		return configMemo;
	}
	public void setConfigMemo(String configMemo) {
		this.configMemo = configMemo;
	}
	
	
	
}
