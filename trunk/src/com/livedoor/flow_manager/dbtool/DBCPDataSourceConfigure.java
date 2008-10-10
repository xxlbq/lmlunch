package com.livedoor.flow_manager.dbtool;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;


public class DBCPDataSourceConfigure extends DataSourceConfigure {

	public static final String PROPERTY_PASSWORD = "connection.password";
	public static final String PROPERTY_USER = "connection.user";
	public static final String PROPERTY_URL = "connection.url";
	public static final String PROPERTY_DRIVER_CLASS =
		"connection.driver_class";

	public static final String PROPERTY_POOL_MAX_ACTIVE =
		"connection.pool.maxactive";
	public static final String PROPERTY_POOL_MAX_WAIT =
		"connection.pool.maxwait";

	public DBCPDataSourceConfigure() {
	}

	public DataSource getDataSource(Properties prop) throws DBException {
		DriverAdapterCPDS cpds = new DriverAdapterCPDS();
		try {
			cpds.setDriver(prop.getProperty(PROPERTY_DRIVER_CLASS));
			cpds.setUrl(prop.getProperty(PROPERTY_URL));
			cpds.setUser(prop.getProperty(PROPERTY_USER));
			cpds.setPassword(prop.getProperty(PROPERTY_PASSWORD));
		} catch (ClassNotFoundException e) {
			throw new DBException(e);
		}

		int maxActiveCount = 100;
		int maxWaitAcount = 50;
		try {
			maxActiveCount =
				Integer.parseInt(prop.getProperty(PROPERTY_POOL_MAX_ACTIVE));
			maxWaitAcount =
				Integer.parseInt(prop.getProperty(PROPERTY_POOL_MAX_WAIT));
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

		SharedPoolDataSource tds = new SharedPoolDataSource();
		tds.setConnectionPoolDataSource(cpds);
		tds.setMaxActive(maxActiveCount);
		tds.setMaxWait(maxWaitAcount);
		return tds;
	}

}
