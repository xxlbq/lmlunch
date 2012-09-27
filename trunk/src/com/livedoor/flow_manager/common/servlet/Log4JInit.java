package com.livedoor.flow_manager.common.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

import com.livedoor.flow_manager.tools.GetDate;

public class Log4JInit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2576462163042385406L;

	public void init() {
//		System.out.println("log4j servletinit begin ");
		String prefix = getServletContext().getRealPath("/");
//		System.out.println("prifix:"+prefix);
		String file = getInitParameter("log4j-init-file");

		if (file != null) {
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(prefix + file));
				String dataformat = prop.getProperty("logfile.dateformat");
				String datePrefix =  GetDate.getDateAsString(new Date(), dataformat);
				
				prop.setProperty("date.prefix", datePrefix);
				
				prop.setProperty("log4j.appender.fileout.File", prefix
						+ prop.getProperty("log4j.appender.fileout.File")
						);
				
//				System.out.println("log4j.appender.fileout.File:"+prop.getProperty("log4j.appender.fileout.File"));
				PropertyConfigurator.configure(prop);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//		System.out.println("log4j servletinit end ");
	}

}
