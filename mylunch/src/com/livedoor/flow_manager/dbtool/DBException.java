package com.livedoor.flow_manager.dbtool;


public class DBException extends Exception {

	public DBException(Throwable t) {
		//super(t);
	}

	public DBException(String msg, Throwable t) {
		//super(msg, t);
	}

	public DBException(String msg) {
		super(msg);
	}
 
}
