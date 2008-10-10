package com.livedoor.flow_manager.common.configuration.xml;

import java.io.File;
import java.net.URISyntaxException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;

public class XmlConfigurationHelper {
	
	private static final Logger log = Logger.getLogger(XmlConfigurationHelper.class);
	private static XMLConfiguration config;
	private static String SYSTEM_KEY = "configPath";
	
//	private static String DEFAULT_RESOURCE = "resource.xml";
	private static String DEFAULT_RESOURCE = "demo.xml";
	private static String resourcePath = null; 
	private static File configFile = null;
	
	static{
		init();
	}
	
	private static void init() {
		
		try {
			
			resourcePath = System.getProperty(SYSTEM_KEY);
			
			if (null == resourcePath){
				
				configFile = new File(
						XmlConfigurationHelper.class.getResource("/"+DEFAULT_RESOURCE).toURI());
				config = new XMLConfiguration(configFile);

			}else{
				
				configFile = new File(
						resourcePath + File.separator+ DEFAULT_RESOURCE);
				config = new XMLConfiguration(configFile);
			}
			
		} catch (ConfigurationException e) {
			log.error(	"xml configuration init() error ! " +
						"[SYSTEM.KEY[configPath] or DEFAULT_RESOURCE not setup~]", e);
			e.printStackTrace();
		} catch (URISyntaxException e) {
			log.error("URL.toURI() error !", e);
			e.printStackTrace();
		}

	}
	
	private static void destory() {

	}
	
	public static XMLConfiguration getXmlConfigInstance(){
		return config;
	}
	
	//-DconfigPath=E:\\java\\EclipseWorkSpace20060721\\permission\\javasource\\com\\livedoor\\flow_manager\\common\\configuration\\xml\\test
}
