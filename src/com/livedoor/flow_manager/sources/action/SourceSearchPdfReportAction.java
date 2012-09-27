package com.livedoor.flow_manager.sources.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.sources.beans.Source;
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

public class SourceSearchPdfReportAction extends BaseAction {
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ActionForward pdfReportDownload(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {

		
		JasperReport jasperReport;
	    JasperPrint jasperPrint;
//	    JasperDesign japerDesign;
	    Map<String, String> paramMap;
	    
	    Source source = Source.buildSourceObjectFromRequest(request);
	    
	    try

	    {
	    	paramMap = new HashMap<String, String>();
	    	
	    	String sourceName = source.getSourceName();
	    	
	    	if(StringCommonUtil.isNotEmpty(sourceName)){
	    		paramMap.put("SOURCE_NAME", 
	    				" AND S.SOURCE_NAME LIKE '%"+sourceName+"%' ");
	    		logger.info("paramMap.put(SOURCE_NAM)==>"+sourceName);
	    	}else{
	    		paramMap.put("SOURCE_NAME", 
	    				" ");
	    	}
	    	
	    	
	    	if(ObjectCommonUtil
	    			.isNotEmpty(source.getFood())){
	    		
	    		if(ObjectCommonUtil
	    				.isNotEmpty(source.getFood().getSoldierId())){
	    			
	    			paramMap.put("FOOD_ID", 
		    				" AND S.FOOD_ID = "+source.getFood().getSoldierId());
	    			logger.info("paramMap.put(FOOD_ID)==>"+source.getFood().getSoldierId());
	    		}else{
		    		paramMap.put("FOOD_ID", 
					" ");
		    	}
	    		
	    	}else{
	    		paramMap.put("FOOD_ID", 
				" ");
	    	}
	    	
	    	
	    	if(ObjectCommonUtil
	    			.isNotEmpty(source.getInputUser())){
	    		
	    		if(ObjectCommonUtil
	    				.isNotEmpty(source.getInputUser().getInputUserId())){
	    			
	    			paramMap.put("INPUT_USER_ID", 
		    				" AND S.INPUT_USER_ID = "+source.getInputUser().getUserId().intValue());
	    			
	    			logger.info("paramMap.put(INPUT_USER_ID)==>"+source.getInputUser().getUserId().intValue());
	    			
	    		}else{
		    		paramMap.put("INPUT_USER_ID", 
					" ");
		    	}
	    		
	    	}else{
	    		paramMap.put("INPUT_USER_ID", 
				" ");
	    	}
	    	
//	    	paramMap.put("SOURCE_NAME", " AND ");
//	    	paramMap.put("FOOD_ID", " AND ");
//	    	paramMap.put("INPUT_USER_ID", "AND");
	    	
	    	
/*	    	InputStream input
	        = new FileInputStream(new File("d://jasperStaticDemo.jrxml"));
	    	
	        JasperDesign design = JRXmlLoader.load(input);
	        jasperReport = JasperCompileManager.compileReport(design);

	    	jasperPrint = JasperFillManager.fillReport( 
	    	          jasperReport, paramMap, new JREmptyDataSource());


	    	OutputStream output= new FileOutputStream(new File("d://simple_report.pdf"));
	    	JasperExportManager.exportReportToPdfStream(jasperPrint, output);
*/
	    	
	    	String webRootPath=request.getSession()
			.getServletContext().getRealPath(File.separator);
	    	logInfo("--->>>path:"+webRootPath);
	    	
	    	String dir = "WEB-INF\\classes\\com\\livedoor\\flow_manager\\report\\jasper\\xml\\";
	    	String fileName = "sourceSearchReport.jrxml";
	    	
	    	String filePath = webRootPath+dir+fileName;
	    	logInfo("--->>>filePath:"+filePath);
	    	
	    	File pdfTemplateFile = new File(filePath);
	    	
	    	InputStream input
	        = new FileInputStream(pdfTemplateFile);
	    	
	    	JasperDesign design = JRXmlLoader.load(input);
	    	
//	    	jasperReport = JasperCompileManager.compileReport(
//	          "d://sourceSearchReport.jrxml");
	    	
	    	jasperReport = JasperCompileManager.compileReport(design);
	    	
	    	jasperPrint = JasperFillManager.fillReport(
	    	          jasperReport, paramMap, 
//	    	          new JREmptyDataSource()
	    	          dataSource.getConnection()
	    	          );
	    	 
	    	response.setContentType("application/pdf");
	    	response.setHeader("Content-disposition", "inline;filename=food.pdf"); 
	    	
	    	OutputStream pdfOutput= response.getOutputStream();
	    	JasperExportManager.exportReportToPdfStream(jasperPrint, pdfOutput);

		


			
//	    	JasperExportManager.exportReportToPdfFile(
//	    	          jasperPrint, "d://simple_report_01.pdf");
	    	
//			pdfOutput.flush();
//	    	pdfOutput.close();

	    	
	    }

	    catch (JRException e)

	    {

	      e.printStackTrace();

	    }
		
//	    System.out.println("pdf download over ~~~~~~~~~"+System.currentTimeMillis()+"~~~~~~~~~~");
		
		return cancelled(mapping,
		   form,
		    request,
		   response);

	}

}
