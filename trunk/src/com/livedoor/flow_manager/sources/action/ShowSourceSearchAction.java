package com.livedoor.flow_manager.sources.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.IConstant.PageConstant;
import com.livedoor.flow_manager.common.action.BaseAction;
import com.livedoor.flow_manager.food.beans.Food;
import com.livedoor.flow_manager.food.service.IFoodService;
import com.livedoor.flow_manager.sources.service.ISourceService;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.tools.lbq.PageFactory;
import com.livedoor.flow_manager.tools.lbq.PageTemplate;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class ShowSourceSearchAction extends BaseAction{
	
	private  Logger logger = Logger.getLogger(ShowSourceSearchAction.class);
	private IUserService userService;
	
	private ISourceService sourceService;
	
	private IFoodService foodService;
	
	
	
	public void setFoodService(IFoodService foodService) {
		this.foodService = foodService;
	}

	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}




	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		
		if(null !=request.getSession().getAttribute("www")){
			logger.info("get session value OK!!!");
		}else{
			logger.info("session have no value");
		}
		logger.info("req test:"+(String)request.getSession().getAttribute("aaa"));
		request.getSession().setAttribute("www", ".com");
		logger.info("req test:"+request.getSession().getId());
		
		List<User> insertUserList = getUserService().queryAllUser();
		List<Food> foodList = foodService.queryAllFood();
//		List<Source> SourceList = getSourceManager().queryPageSource(PageConstant.SOURCE_BEGIN_NUMBER, PageConstant.SOURCE_PAGE_SIZE);
//		
//		SourcePageInfoBean SP = SourcePageInfoBean
//									.getSourcePageInfoBeanInstance(
//											SourceList.size(), 
//											PageConstant.SOURCE_PAGE_SIZE,
//											PageConstant.SOURCE_INIT_PAGE_NUMBER);
		
		
		/*  pageInfo Object */
//		SourcePageInfoBean sp = getSourceManager()
//									.getSourcePageInfoBeanByCriteriaQuerySource(null, PageConstant.SOURCE_INIT_PAGE_NUMBER);
//		
		int pageNo = Integer.parseInt(request.getParameter("pageNo")== null ? "1" : request.getParameter("pageNo"));
		int recordsCount = getSourceService().getSourceCount();
		Page p = PageFactory.createPage(-1, pageNo, recordsCount);
		List list = getSourceService().queryAllSource(p);
		
		PageTemplate pt = new PageTemplate(p,list);
		
		/*  select component list */
		request.setAttribute("INSERT_USER", insertUserList);
		request.setAttribute("UPDATE_USER", insertUserList);
		request.setAttribute("SOURCE_FOOD", foodList);
		
		/* set page info */
		setRequestObject(request,PageConstant.PAGER_VIEW_KEY, pt);
		
		request.setAttribute(PageConstant.SOURCE_QUERY_OBJECT_KEY, form);
//		request.setAttribute("QUERY_SOURCE_LIST",SourceList );
//		logger.info("show source: user->"+super.getSessionObject(request, AttributeKeyConstant.USER_INFO_KEY));
		
		return mapping.findForward("success");
		
	}

}
