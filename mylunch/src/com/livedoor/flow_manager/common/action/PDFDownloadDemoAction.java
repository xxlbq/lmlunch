package com.livedoor.flow_manager.common.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

public class PDFDownloadDemoAction extends MappingDispatchAction{

//	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public ActionForward pdfDownload( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception{
		
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
	    	          dataSource.getConnection()
	    	          );
	    	 
//	    	OutputStream output= response.getOutputStream();
	    	JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//	    	
//	    	output.close();
//	    	response.
			response.setHeader("Content-disposition","filename=test.pdf");//attachment;
			response.setContentType("application/aaa");
//	    	JasperExportManager.exportReportToPdfFile(
//	    	          jasperPrint, "d://simple_report_01.pdf");
	    	
	    	System.out.println("pdf download over ~~~~~~~~~~~~~~~~~~~");
	    	
	    }

	    catch (JRException e)

	    {

	      e.printStackTrace();

	    }
		
		return mapping.findForward("success");
	}
}
