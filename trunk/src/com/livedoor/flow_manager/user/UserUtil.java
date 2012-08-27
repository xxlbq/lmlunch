package com.livedoor.flow_manager.user;

import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.form.UserForm;

public class UserUtil {

	public static User toUser(UserForm ssf) {
		
		return null;
	}

	public static User toRegUser(UserForm ssf) {
		User u = new User();
		
		
		u.setUserId(userId);
		u.setUserName(userName);
		u.setUserDisplayName(ssf.getUserDisplayName());
		u.setUserPassword(ssf.getUserPassword());
		
		
		
		
		return u;
	}

	
	private static String getUserName(){
		return ;
	}
}
