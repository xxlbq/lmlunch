package com.livedoor.flow_manager.common.configuration.xml.test;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

import com.livedoor.flow_manager.common.configuration.xml.XmlConfigurationHelper;

import junit.framework.TestCase;

public class ConfTest extends TestCase {

	XMLConfiguration xmlConf;
	HierarchicalConfiguration sub;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		System.setProperty("configPath",
				"E:\\java\\EclipseWorkSpace20060721\\permission\\javasource\\com\\livedoor\\flow_manager\\common\\configuration\\xml\\test");
		
		xmlConf = XmlConfigurationHelper.getXmlConfigInstance();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetConf() {
		
		assertEquals(
				xmlConf.getInt("rowsPerPage")
				, 15);
		
		assertEquals(
				xmlConf.getString("colors.link.content[@ignore]")
				, "never");
		
	}
	
	public void testHierarchicalConf(){
		
		sub =xmlConf.configurationAt("database.tables.table(0)");
		String tableName = sub.getString("name");  // only need to provide relative path
		List fieldNames = sub.getList("fields.field.name");
		
		assertEquals(fieldNames.size(), 8);
	}
	
	public void testAddConf(){
		xmlConf.addProperty("tables.table(1).fields.field(-1).name", "sizeyyy");
		xmlConf.addProperty("tables.table(1).fields.field.type", "int");
		try {
			xmlConf.save("abc.xml");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
