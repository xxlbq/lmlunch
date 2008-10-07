package com.livedoor.flow_manager.common.jasper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JasperReportDataSourceDemo {
	
    private static JasperReport jasperReport;
    private static JasperPrint  jasperPrint;
    private static JasperDesign japerDesign;
    private static Map<String, String> paramMap;
	
    // spring context
    private static ApplicationContext ac;
    
    
    
 
    
    private static Connection getConnection() 
    throws Exception {
    	
    	initSpringContext();
		Connection conn =( (DataSource)ac
				.getBean("dataSource") ).getConnection();
		return conn;
	}
    
    
    private static void initSpringContext(){
    	ac =new FileSystemXmlApplicationContext(
				new String[]{
						"webroot//WEB-INF//conf//spring//applicationContext-permission.xml"
						,"webroot//WEB-INF//conf//spring//applicationContext-permission-other.xml"
//						,"webroot//WEB-INF//permission-hibernate-cfg.xml"
				});
    }
    
    private static void initJasperParam(){
    	paramMap = new HashMap<String, String>();
    	paramMap.put("tittleVar", "IBM-T60");
    }
    
	public static void main(String[] args) 
	throws Exception{
		
	    try{
	    	
	    	jasperReport = JasperCompileManager.compileReport(
	          "d://jasperStaticDemo.jrxml");
	    	
	    	/////////////////////////////////////
	    	/*InputStream input = 
	    		new FileInputStream(new File("d://jasperStaticDemo.jrxml"));
	    	
	        JasperDesign design = 
	        	JRXmlLoader.load(input);
	        
	        jasperReport = JasperCompileManager.compileReport(design);*/
	        /////////////////////////////////////
	    	
	    	initJasperParam();
	    	
	    	jasperPrint = JasperFillManager.fillReport(
	    	          jasperReport, paramMap, 
	    	          /*new JREmptyDataSource()*/
	    	          getConnection()
	    	          );

	    	
	    	JasperExportManager.exportReportToPdfFile(
	    	          jasperPrint, "d://simple_report_01.pdf");

	    	///////////////////////////////////////
	    	/*OutputStream output= 
	    		new FileOutputStream(new File("d://simple_report.pdf"));
	    	JasperExportManager
	    	.exportReportToPdfStream(jasperPrint, output);*/
	    	///////////////////////////////////////
	    	
	    }catch (JRException e){
	      e.printStackTrace();
	    }

	  }

}
