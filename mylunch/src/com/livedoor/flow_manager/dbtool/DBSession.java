package com.livedoor.flow_manager.dbtool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author martin
 * @since 2004/6/9 11:42:22
 * @version 1.0
 * 
 */
public class DBSession {
	private static final ThreadLocal session = new ThreadLocal();

	private DBSession() {
	}

	public static void openSession(boolean isBeginTransaction)
		throws DBException {

		Connection conn = (Connection) session.get();
		if (conn != null) {
		    try{
			    if(!conn.isClosed()){
			        return;
			    }
		    }catch(Exception e){
		        e.printStackTrace();
		    }
		}

		Connection _conn = DataSourceSingleton.getInstance().getConnection();
		try {
			_conn.setAutoCommit(!isBeginTransaction);
		} catch (SQLException sqle) {
			throw new DBException("Session set auto commit failure.", sqle);
		}

		conn = _conn;
		session.set(conn);
	}

	public static void commitTransaction() throws DBException {
		Connection conn = currentConnection();
		try {
			conn.commit();
		} catch (SQLException sqle) {
			throw new DBException(
				"Session set commit transaction failure.",
				sqle);
		}

	}

	public static void rollbackTransaction() throws DBException {
		Connection conn = currentConnection();
		try {
			conn.rollback();
		} catch (SQLException sqle) {
			throw new DBException(
				"Session set rollback transaction failure.",
				sqle);
		}
	}

	public static void closeSession() throws DBException {
		Connection conn = (Connection) session.get();
		try {
		    if(conn != null && !conn.isClosed()){
		        conn.close(); 
		    }
		} catch (SQLException sqle) {
			throw new DBException("Session close failure.", sqle);
		}
		conn = null;
		session.set(null);
	}

	public static Connection currentConnection() throws DBException {
		Connection conn = (Connection) session.get();
		if (conn == null) {
		    openSession(false);
		}

		return conn;
	}

}