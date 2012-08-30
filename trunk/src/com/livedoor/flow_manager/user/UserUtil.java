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
		
		
		
		u.setAccountNonExpiredInt(AccountNonExpiredEnum.AccountNonExpired.getValue());
		u.setAccountNonLockedInt(AccountNonLockedEnum.AccountNonLocked.getValue());
		u.setCredentialsNonExpiredInt(CredentialsNonExpiredEnum.NonExpired.getValue());
		
		u.setInputUserId(-1);
		u.setUpdateUserId(-1);
		u.setInputDatetime(d);
		u.setUpdateDatetime(d);
		
		u.setDeletedFlag(0);
		
//		//	 primary key
//		private java.lang.Integer userId;
//
//		// fields
//		private java.lang.String userName;
//		private java.lang.String userPassword;
//		private java.lang.String userDisplayName;
//		private java.lang.String userPhoto;
//		private java.lang.String userEmail;
//		private java.lang.String userMsn;
//		private java.lang.String userSkype;
//		private java.lang.Integer inputUserId;
//		private java.util.Date inputDatetime;
//		private java.lang.Integer updateUserId;
//		private java.util.Date updateDatetime;
//		private java.lang.Integer deletedFlag;
//		private java.lang.String userDesc;
//
//		private Role role;
//		
//	    private int accountNonExpiredInt;
//	    private int accountNonLockedInt;
//	    private int credentialsNonExpiredInt;
//		
//		
//		
//		
//		
//		
//		
//	    ACCOUNT_NON_EXPIRED` int(4) NOT NULL DEFAULT '0',
//	    `ACCOUNT_NON_LOCKED` int(4) NOT NULL DEFAULT '0',
//	    `CREDENTIALS_NON_EXPIRED` int(4) NOT NULL DEFAULT '0',
//	    `INPUT_USER_ID` int(10) NOT NULL,
//	    `INPUT_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//	    `UPDATE_USER_ID` int(10) DEFAULT NULL,
//	    `UPDATE_DATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
//	    `DELETED_FLAG` int(1) NOT NULL,
//	    `USER_DESC` varchar(500) DEFAULT NULL,
//		
		
		
		
		
		return u;
	}
	
}
