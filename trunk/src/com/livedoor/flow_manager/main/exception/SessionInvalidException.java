package com.livedoor.flow_manager.main.exception;

public class SessionInvalidException extends Exception{
	
	int code;
	public SessionInvalidException() {
		super();
	}
	public SessionInvalidException(int errorCode) {
		super();
		this.code = errorCode;
	}
	
	
}
