package com.livedoor.flow_manager.download;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.common.zip.FileZip;

public class DownLoadAction extends BaseAction{
	
	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
//		org.apache.struts.action.ActionServlet
		String[] path=request.getParameterValues("id");
		
		if( null == path ){
			
			
			return mapping.findForward("error");
		}
		 
		System.out.println("--->:"+path.length);
		
		FileZip fz = new FileZip();
		
		fz.zipImg(path, response);
		
//		response.setHeader("Content-disposition","filename=crparam"+new SimpleDateFormat("MMddHHmmss").format(new Date())+".xls");//attachment;
//		response.setContentType("application/msexcel");
		
		logInfo("download action...");
		return mapping.findForward("success");
	}

}
