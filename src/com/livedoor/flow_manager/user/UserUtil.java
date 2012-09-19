package com.livedoor.flow_manager.user;

import java.util.Date;

import com.livedoor.flow_manager.enums.AccountNonExpiredEnum;
import com.livedoor.flow_manager.enums.AccountNonLockedEnum;
import com.livedoor.flow_manager.enums.CredentialsNonExpiredEnum;
import com.livedoor.flow_manager.enums.RoleEnum;
import com.livedoor.flow_manager.role.beans.Role;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.form.UserForm;

public class UserUtil {

	public static User toUser(UserForm ssf) {
		
		return null;
	}

	public static User toRegUser(UserForm ssf) {
		User u = new User();
		Date d = new Date();
		
//		u.setUserId(ssf.getId());
		u.setUserName(ssf.getUserName());
		u.setUserPassword(ssf.getUserPassword());
		u.setUserDisplayName(ssf.getUserDisplayName());
		u.setRole(new Role(RoleEnum.MEMBER.getValue()));
		u.setUserRegIp(ssf.getUserRegIp());
		u.setUserLastLoginIp("REG_INIT");
		
		u.setAccountNonExpiredInt(AccountNonExpiredEnum.AccountNonExpired.getValue());
		u.setAccountNonLockedInt(AccountNonLockedEnum.AccountNonLocked.getValue());
		u.setCredentialsNonExpiredInt(CredentialsNonExpiredEnum.NonExpired.getValue());
		
		u.setInputUserId(-1);
		u.setUpdateUserId(-1);
		u.setInputDatetime(d);
		u.setUpdateDatetime(d);
		
		u.setDeletedFlag(0);
		
		return u;
	}
	
}
