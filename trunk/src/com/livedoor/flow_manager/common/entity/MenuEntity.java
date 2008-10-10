package com.livedoor.flow_manager.common.entity;

public class MenuEntity {
	
	private String menuItem ;
	private String menuUrl ;
	
	
	public MenuEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuEntity(String menuItem,String menuUrl ) {
		this.menuItem = menuItem;
		this.menuUrl = menuUrl;
	}
	
	public String getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	

}
