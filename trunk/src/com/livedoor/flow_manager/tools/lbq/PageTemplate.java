package com.livedoor.flow_manager.tools.lbq;

import java.util.List;



public class PageTemplate implements IPageTemplate {
	
	private Page page;

	private List items;

	public PageTemplate() {
		
	} 
	
	public PageTemplate(Page page,List items) {
		this.page = page;
		this.items = items;
	} 
	
	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	} 
	
}
