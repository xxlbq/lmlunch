package com.livedoor.flow_manager.role;

import com.livedoor.flow_manager.enums.RoleEnum;

public class RoleUtil {
	public static boolean isAdmin(int roleId){
		return RoleEnum.ADMIN.getValue() == roleId;
	}
}
