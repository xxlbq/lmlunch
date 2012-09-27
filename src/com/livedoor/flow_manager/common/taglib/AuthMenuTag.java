package com.livedoor.flow_manager.common.taglib;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.role.dao.RoleDao;
import com.livedoor.flow_manager.roleAction.beans.RoleAction;
import com.livedoor.flow_manager.user.beans.User;

//import cn.bestwiz.jhf.admin.authority.service.CsMenuService;
//import cn.bestwiz.jhf.common.admin.Constants;
//import cn.bestwiz.jhf.core.dao.bean.info.JhfCsGroupMenus;
//import cn.bestwiz.jhf.core.dao.bean.info.JhfCsOperator;

/**
 * 
 * @author JHF <jhf@bestwiz.cn>
 * 
 * @copyright 2006, BestWiz(Dalian) Co.,Ltd
 * @version $Id: AuthMenuTag.java,v 1.12 2008/02/23 20:28:22 liuxb Exp $
 */
public class AuthMenuTag extends javax.servlet.jsp.tagext.BodyTagSupport {

	private static Logger  LOGGER = Logger.getLogger(AuthMenuTag.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -6581697679255118455L;

	private String action;

	private String layers;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getLayers() {
		return layers;
	}

	public void setLayers(String layers) {
		this.layers = layers;
	}

	/**
	 * 
	 * @author binaryzhang <zhangwc@bestwiz.cn>
	 */
	public int doEndTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		String webpath = request.getContextPath();
		String uri = request.getRequestURI();
		int beginIndex = webpath.length() + 1;
		uri = uri.substring(beginIndex);

//		System.out.println(" request.getContextPath():" + webpath);
//		System.out.println(" request.getRequestURI() :"
//				+ request.getRequestURI());
//		System.out.println(" after sub URI :" + uri);

		try {

			//            JhfCsOperator user = (JhfCsOperator) (pageContext.getSession()
			//                    .getAttribute(Constants.CS_LOGIN_SESSION_KEY));
			//        	User user = (User)pageContext.getSession().getAttribute("");
			//        	
			//            if (user == null)
			//                return EVAL_PAGE;

			//            BigDecimal groupId = user.getCsGroupId();
			//            
			//            if (!GenericValidator.isBlankOrNull(String.valueOf(groupId))) {
			//                StringBuffer output = this.buildOutputHtml(webpath, groupId,uri);
			//                pageContext.getOut().print(output.toString());
			//            }
			if(!uri.equals("member_add.do")
					&&  !uri.equals("reg.do")){
				
				StringBuffer output = this.buildOutputHtml(uri);
				pageContext.getOut().print(output.toString());
			}else{
				LOGGER.info("reg page redirect to home page. not display menu page.");
			}

		} catch (Exception e) {
			throw new JspException("AuthMenuTag eroror : ", e);
		}

		return EVAL_PAGE;
	}

	private StringBuffer buildOutputHtml(String uri) {

		VelocityEngine ve = new VelocityEngine();

		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        p.setProperty(Velocity.ENCODING_DEFAULT, "gb2312");
        p.setProperty(Velocity.INPUT_ENCODING, "gb2312");
        p.setProperty(Velocity.OUTPUT_ENCODING, "gb2312");  
//		p.setProperty("class.resource.loader.class","org.apache.velocity.tools.view.WebappResourceLoader ");
		
//		p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH,  "/WEB-INF/classes/");

		//	  props.put("file.resource.loader.path", "E:\\java\\EclipseWorkSpace20060721\\lbq-velocity\\webroot\\WEB-INF\\classes");
		//	  props.put("runtime.log","E:\\java\\EclipseWorkSpace20060721\\lbq-velocity\\tmp.log");
		//	  
		StringWriter writer = new StringWriter();
		try {
			ve.init(p);
			//	  
			//	  
			////	  Template t = ve.getTemplate("hellosite.vm");
			////	  Template t = ve.getTemplate("com/lbq/test/velocity/hello/hellosite.vm");
			////	  Template t = ve.getTemplate("E:\\java\\EclipseWorkSpace20060721\\lbq-velocity\\webroot\\WEB-INF\\classes\\com\\lbq\\test\\velocity\\hello\\hellosite.vm");
			Template t = ve
					.getTemplate("com/livedoor/flow_manager/velocity/action/vm/menu.vm");
			//	  
			User user = (User) pageContext.getSession().getAttribute(
					AttributeKeyConstant.USER_INFO_KEY);

			//	  SecurityContext sc =  (SecurityContext)pageContext.getSession().getAttribute("ACEGI_SECURITY_CONTEXT_KEY");
			//	  sc.getAuthentication().getAuthorities()
			int roleId = user.getRole().getRoleId();
//			System.out.println("group get from user : " + roleId);

			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(pageContext.getServletContext());

			RoleDao rd = (RoleDao) wac.getBean("roleDao");
			if (null == rd) {
//				System.out.println(" 88888888   role dao is null 88888888");
			}

			//	  String doUrl = rd.getParentMenuSeq(url);

			List parentColl = queryPMenu(roleId, uri, rd);
			List sonColl = querySMenu(roleId, uri, rd);

			VelocityContext context = new VelocityContext();
			context.put("parentMenuRoleActionList", parentColl);
			context.put("sonMenuRoleActionList", sonColl);
			context.put("user", user);
			

//			t.setEncoding("gb2312");
			t.merge(context, writer);
			String result = writer.getBuffer().toString();
//			System.out.println("00000000000000000:" + writer.toString());
			writer.flush();
			writer.close();

		} catch (Exception e) {
			System.err.println("=-=============== velocity error fire ! ");
			e.printStackTrace();
		}

		return writer.getBuffer();
	}

	private List querySMenu(int groupId, String uri, RoleDao rd) {

//		System.out.println(" s menu param:" + "groupId=" + groupId + ",uri="
//				+ uri);

		List sList = rd.getSonMenu(groupId, uri);

//		System.out.println(" s menu size:" + sList.size());

		return convertList(sList);
	}

	private List queryPMenu(int groupId, String uri, RoleDao rd) {
//
//		System.out.println(" p menu param:" + "groupId=" + groupId + ",uri="
//				+ uri);
		List pList = rd.getRootMenu(groupId, uri);

		//		
//		System.out.println(" p menu size:" + pList.size());

		return convertList(pList);
	}

	private List convertList(List pList) {

		List entityList = new ArrayList();

//		System.out.println("begin -- convert !!!");

		//		for (Object object : pList) {
		//			
		//			List entity = (List)object;
		//			
		//			String menuSeq = (String)(entity.get(0));
		//			String roleActionUrl =   parseUrl( (String)(entity.get(1)) ) ;
		//			String roleActionName = (String)(entity.get(2));
		//			int diplayOrder = (Integer)(entity.get(3));
		//			
		//			System.out.println("menuSeq:"+menuSeq+",roleActionUrl:"+roleActionUrl 
		//					+",roleActionName:"+roleActionName+",diplayOrder:"+diplayOrder);
		//			
		//			RoleAction ra = new RoleAction(menuSeq ,roleActionUrl, roleActionName ,diplayOrder);
		//			entityList.add(ra);
		//		}

		for (Object object : pList) {

			RoleAction entity = (RoleAction) object;

			//			String menuSeq = (String)(entity.get(0));
			String roleActionUrl = parseUrl(entity.getRoleActionUrl());
			entity.setRoleActionUrl(roleActionUrl);

			//			String roleActionName = (String)(entity.get(2));
			//			int diplayOrder = (Integer)(entity.get(3));

//			System.out.println("menuSeq:" + entity.getMenuSeq()
//					+ ",roleActionUrl:" + roleActionUrl + ",roleActionName:"
//					+ entity.getRoleActionName() + ",diplayOrder:"
//					+ entity.getDisplayOrder());

			RoleAction ra = new RoleAction(entity.getMenuSeq(), entity
					.getRoleActionUrl(), entity.getRoleActionName(), entity
					.getDisplayOrder());
			entityList.add(ra);
		}

//		System.out.println("end -- convert !!!");

		return entityList;
	}

	private String parseUrl(String url) {
		String[] strArr = null;
		String value = url;
		strArr = url.split("\\|");
		if (strArr != null && strArr.length > 0) {
			value = strArr[0];
			if (value.startsWith("(")) {
				value = value.substring(1, value.length());
			}
			if (value.endsWith(")")) {
				value = value.substring(0, value.length() - 1);
			}
		}
		return value;
	}


}