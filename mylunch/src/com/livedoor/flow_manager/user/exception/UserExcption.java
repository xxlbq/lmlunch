package com.livedoor.flow_manager.user.exception;

import org.springframework.dao.DataAccessException;

public class UserExcption extends DataAccessException {

	private static final long serialVersionUID = 3146543606062266411L;

	private final int errorCode;

	public static final int ADD_EXCEPTION = 1000;
	public static final int UPDATE_EXCEPTION = 1001;
	public static final int DELETE_EXCEPTION = 1002;
	public static final int GET_EXCEPTION = 1003;
	public static final int QUERY_LIKE_EXCEPTION = 1004;
	public static final int CRITERIA_EXCEPTION = 1005;
//	public static final int ADD_EXCEPTION = 1000;
	public static final int UNKNOWN_EXCEPTION = 9999;

	public UserExcption(String message, Throwable cause) {
		super(message, cause);
		this.errorCode = -1;
	}

	public UserExcption(String message) {
		super(message);
		this.errorCode = -1;
	}

	public UserExcption(int errorCode,String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public UserExcption(int errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
