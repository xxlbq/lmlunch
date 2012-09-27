package com.livedoor.flow_manager.dbtool;

import java.util.ResourceBundle;



public class DaoSqlConfigure { 
	
    private static ResourceBundle resource =
		ResourceBundle.getBundle("sql/daosql");
	private DaoSqlConfigure() {
	}
 
	/**
	 * daosql.properties    key = value
	 * @param key
	 * @return String value
	 */
	public static String getSql(String key) {
		return resource.getString(key);
	}
	

}
