package com.livedoor.flow_manager.dbtool;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.DataSource;


public abstract class DataSourceConfigure {

	private static final String PROPERTY_CONFIG_CLASS = "configure.class";
	public static final String CONFIG_FILE = "ds-config";

	public DataSourceConfigure() { 
	}

	public static DataSource getDataSource() throws DBException {
		Properties prop = new Properties(); 

//		ResourceBundle resource = ResourceBundle.getBundle("/WEB-INF/dbconf/"+CONFIG_FILE);
		ResourceBundle resource = ResourceBundle.getBundle(CONFIG_FILE);
		
		Enumeration enums = resource.getKeys();
		while (enums.hasMoreElements()) {
			String key = (String) enums.nextElement();
			prop.put(key, resource.getString(key));
		}

		try {
			String configureClass = prop.getProperty(PROPERTY_CONFIG_CLASS);
			DataSourceConfigure clazz =
				(DataSourceConfigure) Class
					.forName(configureClass)
					.newInstance();
			return clazz.getDataSource(prop);
		} catch (InstantiationException e) {
			throw new DBException(e);
		} catch (IllegalAccessException e) {
			throw new DBException(e);
		} catch (ClassNotFoundException e) {
			throw new DBException(e);
		}
	}

	public abstract DataSource getDataSource(Properties prop)
		throws DBException;
}
