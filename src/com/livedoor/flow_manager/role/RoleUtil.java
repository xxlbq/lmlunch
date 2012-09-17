package com.livedoor.flow_manager.role;

import com.livedoor.flow_manager.enums.RoleEnum;

public class RoleUtil {
	public static boolean isAdmin(int roleId){
		return roleId <= RoleEnum.ADMIN.getValue();
	}
	public static boolean isGod(int roleId){
		return roleId  <= RoleEnum.GOD.getValue() ;
	}
	
	
}
