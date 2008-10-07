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

public class JasperReportsStaticDemo {
	public static void main(String[] args) throws Exception

	  {

	    JasperReport jasperReport;
	    JasperPrint jasperPrint;
	    JasperDesign japerDesign;
	    Map<String, String> paramMap;
	    
	    try

	    {
	    	paramMap = new HashMap<String, String>();
	    	paramMap.put("tittleVar", "IBM-T60");
/*	    	InputStream input
	        = new FileInputStream(new File("d://jasperStaticDemo.jrxml"));
	    	
	        JasperDesign design = JRXmlLoader.load(input);
	        jasperReport = JasperCompileManager.compileReport(design);

	    	jasperPrint = JasperFillManager.fillReport( 
	    	          jasperReport, paramMap, new JREmptyDataSource());


	    	OutputStream output= new FileOutputStream(new File("d://simple_report.pdf"));
	    	JasperExportManager.exportReportToPdfStream(jasperPrint, output);
*/
	    	
	    	
	    	jasperReport = JasperCompileManager.compileReport(
	          "d://jasperStaticDemo.jrxml");
	    	
	    	jasperPrint = JasperFillManager.fillReport(
	    	          jasperReport, paramMap, 
//	    	          new JREmptyDataSource()
	    	          getConnection()
	    	          );

	    	
	    	JasperExportManager.exportReportToPdfFile(
	    	          jasperPrint, "d://simple_report_01.pdf");

	    	
	    }

	    catch (JRException e)

	    {

	      e.printStackTrace();

	    }

	  }
	
	private static ApplicationContext ac;
//	private static SourceDAO sDao;
//	private static SourceService sService;

	private static Connection getConnection() throws Exception {
		
		ac =new FileSystemXmlApplicationContext(
				new String[]{
						"webroot//WEB-INF//conf//spring//applicationContext-permission.xml"
						,"webroot//WEB-INF//conf//spring//applicationContext-permission-other.xml"
//						,"webroot//WEB-INF//permission-hibernate-cfg.xml"
				});
//		sDao = (SourceDAO)ac.getBean("sourceDao");
//		sService = (SourceService)ac.getBean("sourceService");
		
		Connection conn =( (DataSource)ac.getBean("dataSource")).getConnection();
		return conn;
	}

}
