package com.livedoor.flow_manager.common.role;

import java.util.List;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.PermissionsAdapter;

public class StrustMenuDisplayAdapter implements PermissionsAdapter {
	//menu 名字
	private List<String> menuNames;

	/**
	  * Creates a new instance of SimplePermissionAdapter
	  */
	public StrustMenuDisplayAdapter(List<String> theMenuNames) {
		this.menuNames = theMenuNames;
	}

	    /**
	     * If the menu is allowed, this should return true.
	     *
	     * @return whether or not the menu is allowed.
	     */
	    public boolean isAllowed(MenuComponent menu) {
	        return !menuNames.contains(menu.getName());
	    }

}
