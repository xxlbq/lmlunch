package com.livedoor.flow_manager.download;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.tools.DateUtil;
import com.livedoor.flow_manager.tools.lbq.PageFactory;
import com.livedoor.flow_manager.tools.lbq.PageTemplate;

public class ShowDownLoadAction extends MappingDispatchAction{
	
	private static final Logger log = Logger.getLogger(ShowDownLoadAction.class);
	
	public ActionForward showDownLoad(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		String webRootPath = request.getSession()
					.getServletContext().getRealPath("/");
		String downloadPath = "download";
		String downFilePath = webRootPath+downloadPath;
		log.info(" downloadPath realpath ="+downFilePath);
		
		File downLoadFileDir = new File(downFilePath);
		
		File[] file = downLoadFileDir.listFiles();
		
		List<FileInfo> fileInfoList =getFileList(downFilePath,file);
		
		PageTemplate sp = new PageTemplate(
				PageFactory.createPage(fileInfoList.size(), 1, fileInfoList.size()),
				fileInfoList);
		
		request.setAttribute("PAGE_INFO_BEAN", sp);
		
		return mapping.findForward("success");
	}

	private List<FileInfo> getFileList(String root,File[] file) {
		
		List<FileInfo> list = new ArrayList<FileInfo>();
		
		for (int i = 0; i < file.length; i++) {
			FileInfo fi = new FileInfo();
			log.info("filename:"+file[i].getName());
			fi.setPath(root+File.separator+file[i].getName());
			fi.setFileName(file[i].getName());
			fi.setFileSize(file[i].length()/1024);
			fi.setLastModifyDate( 
				DateUtil.getDateStringAsYYYYMMddHHmmss(file[i].lastModified()));
			list.add(fi);
			
		}
		
		return list;
	}

}
