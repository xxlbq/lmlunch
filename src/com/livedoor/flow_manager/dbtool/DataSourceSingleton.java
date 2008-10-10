package com.livedoor.flow_manager.dbtool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;



public class DataSourceSingleton {

	private static DataSourceSingleton m_instance = null;
	private static DataSource m_datasource = null;

	private DataSourceSingleton() {
	}

	public synchronized static DataSourceSingleton getInstance() {
		if (m_instance == null) {
			m_instance = new DataSourceSingleton();
		}
		return m_instance;
	}

	public synchronized Connection getConnection() throws DBException {
		if (m_datasource == null) {
			m_datasource = DataSourceConfigure.getDataSource();
		}

		return createConnection();
	}

	private Connection createConnection() throws DBException {
		try {
			Connection conn = m_datasource.getConnection();
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException sqle) {
			throw new DBException(sqle);
		}
	}

}
