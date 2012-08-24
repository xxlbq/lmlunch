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
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldier.SoldierService;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.sources.service.ISourceService;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.tools.lbq.PageFactory;
import com.livedoor.flow_manager.tools.lbq.PageTemplate;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;
import com.lm.common.util.str.StringCommonUtil;

public class SourceSearchMovePageAction extends BaseAction{
	private  Logger logger = Logger.getLogger(this.getClass());
	
	private IUserService userService;
	
	private ISourceService sourceService;
	
	private SoldierService foodService;
	
	public void setFoodService(SoldierService foodService) {
		this.foodService = foodService;
	}
	
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}

	

//	public ActionForward moveNextPage(ActionMapping mapping,
//			ActionForm form,
//			HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		Source source = Source.buildSourceObjectFromRequest(request);
//		
//		SourceForm sf = Source.buildSourceFormObjectFromSourceObject(source);
//		
//		List<User> insertUserList = getUserManager().queryAllUser();
//		
////		SourcePageInfoBean sp = getSourceManager()
////				.getSourcePageInfoBeanByCriteriaQuerySource(source, Integer.valueOf(request.getParameter("currentPageNo").trim())+1 );
//
//		int pageNo = Integer.parseInt(
//				StringCommonUtil.isEmpty(super.getRequestParameter(request, "pageNo"))
//				? "1" : request.getParameter("pageNo"));
//		int recordsCount = getSourceService().getSourceCount(source);
//		Page p = PageFactory.createPage(-1, pageNo+1, recordsCount);
//		List list = getSourceService().getSourceListByCriteriaQuerySource(source,p);
//		
//		PageTemplate sp = new PageTemplate(p,list);
//		
//		List<Food> foodList = foodService.queryAllFood();
//		
//		request.setAttribute("SOURCE_FOOD", foodList);
//		/*  select component list */
//		request.setAttribute("INSERT_USER", insertUserList);
//		request.setAttribute("UPDATE_USER", insertUserList);
//
//		/*  page info */
//		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);
//		
//		request.setAttribute("QUERY_SOURCE_OBJECT", sf);
////		request.setAttribute("QUERY_SOURCE_LIST",SourceList );
//		
//		logger.info("req test:"+request.getSession().getId());
//		return mapping.findForward("success");
//
//	}
//
//	public ActionForward movePreviousPage(ActionMapping mapping,
//			ActionForm form,
//			HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		Source source = Source.buildSourceObjectFromRequest(request);
//		
//		SourceForm sf = Source.buildSourceFormObjectFromSourceObject(source);
//		
//		List<User> insertUserList = getUserManager().queryAllUser();
//		
////		SourcePageInfoBean sp = getSourceManager()
////				.getSourcePageInfoBeanByCriteriaQuerySource(source, Integer.valueOf(request.getParameter("currentPageNo").trim()) -1 );
//		
//		int pageNo = Integer.parseInt(StringCommonUtil.isEmpty(
//				super.getRequestParameter(request, "pageNo")) 
//				? "1" : request.getParameter("pageNo"));
//		int recordsCount = getSourceService().getSourceCount(source);
//		Page p = PageFactory.createPage(-1, pageNo-1, recordsCount);
//		List list = getSourceService().getSourceListByCriteriaQuerySource(source,p);
//		
//		PageTemplate sp = new PageTemplate(p,list);
//		
//		
//		List<Food> foodList = foodService.queryAllFood();
//		
//		request.setAttribute("SOURCE_FOOD", foodList);
//		/*  select component list */
//		request.setAttribute("INSERT_USER", insertUserList);
//		request.setAttribute("UPDATE_USER", insertUserList);
//
//		/*  page info */
//		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);
//		
//		request.setAttribute("QUERY_SOURCE_OBJECT", sf);
////		request.setAttribute("QUERY_SOURCE_LIST",SourceList );
//
//		logger.info("req test:"+request.getSession().getId());
//		return mapping.findForward("success");
//		
//	}
//
//	public ActionForward moveFirstPage(ActionMapping mapping,
//			ActionForm form,
//			HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		Source source = Source.buildSourceObjectFromRequest(request);
//		
//		SourceForm sf = Source.buildSourceFormObjectFromSourceObject(source);
//		
//		List<User> insertUserList = getUserManager().queryAllUser();
//		
////		SourcePageInfoBean sp = getSourceManager()
////				.getSourcePageInfoBeanByCriteriaQuerySource(source, PageConstant.SOURCE_FIRST_PAGE );
//
//		int pageNo = Integer.parseInt(StringCommonUtil.isEmpty(
//				super.getRequestParameter(request, "pageNo")) 
//				? "1" : request.getParameter("pageNo"));
//		int recordsCount = getSourceService().getSourceCount(source);
//		Page p = PageFactory.createPage(-1, 1, recordsCount);
//		List list = getSourceService().getSourceListByCriteriaQuerySource(source,p);
//		
//		PageTemplate sp = new PageTemplate(p,list);
//		
//		List<Food> foodList = foodService.queryAllFood();
//		
//		request.setAttribute("SOURCE_FOOD", foodList);
//		
//		/*  select component list */
//		request.setAttribute("INSERT_USER", insertUserList);
//		request.setAttribute("UPDATE_USER", insertUserList);
//
//		/*  page info */
//		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);
//		
//		request.setAttribute("QUERY_SOURCE_OBJECT", sf);
////		request.setAttribute("QUERY_SOURCE_LIST",SourceList );
//
//		logger.info("req test:"+request.getSession().getId());
//		return mapping.findForward("success");
//		
//	}
//	
//	public ActionForward moveLastPage(ActionMapping mapping,
//			ActionForm form,
//			HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		Source source = Source.buildSourceObjectFromRequest(request);
//		
//		SourceForm sf = Source.buildSourceFormObjectFromSourceObject(source);
//		
//		List<User> insertUserList = getUserManager().queryAllUser();
//		
////		SourcePageInfoBean sp = getSourceManager()
////				.getSourcePageInfoBeanByCriteriaQuerySource(source,Integer.valueOf(request.getParameter("lastPageNo")));
//
//		int pageNo = Integer.parseInt(
//				StringCommonUtil.isEmpty(super.getRequestParameter(request, "pageNo"))? "1" 
//						: request.getParameter("pageNo"));
//		int recordsCount = getSourceService().getSourceCount(source);
//		
//		
//		
//		Page p = PageFactory.createPage(-1, PageFactory.getPageCount(-1, recordsCount), recordsCount);
//		List list = getSourceService().getSourceListByCriteriaQuerySource(source,p);
//		
//		PageTemplate sp = new PageTemplate(p,list);
//		
//		List<Food> foodList = foodService.queryAllFood();
//		
//		request.setAttribute("SOURCE_FOOD", foodList);
//		
//		/*  select component list */
//		request.setAttribute("INSERT_USER", insertUserList);
//		request.setAttribute("UPDATE_USER", insertUserList);
//
//		/*  page info */
//		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);
//		
//		request.setAttribute("QUERY_SOURCE_OBJECT", sf);
////		request.setAttribute("QUERY_SOURCE_LIST",SourceList );
//
//		logger.info("req test:"+request.getSession().getId());
//		return mapping.findForward("success");
//		
//	}
//	
//	public ActionForward moveAssignPage(ActionMapping mapping,
//			ActionForm form,
//			HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		Source source = Source.buildSourceObjectFromRequest(request);
//		
//		SourceForm sf = Source.buildSourceFormObjectFromSourceObject(source);
//		
//		List<User> insertUserList = getUserManager().queryAllUser();
//		
//		
//		
////		SourcePageInfoBean sp = getSourceManager()
////				.getSourcePageInfoBeanByCriteriaQuerySource(source,Integer.valueOf(request.getParameter("assignPage")));
//
//		int pageNo = Integer.parseInt(
//				StringCommonUtil.isEmpty(super.getRequestParameter(request, "pageNo"))
//								? "1" 
//								: request.getParameter("pageNo"));
//		
//		int recordsCount = getSourceService().getSourceCount(source);
//		Page p = PageFactory.createPage(-1, pageNo, recordsCount);
//		List list = getSourceService().getSourceListByCriteriaQuerySource(source,p);
//		
//		PageTemplate sp = new PageTemplate(p,list);
//		List<Food> foodList = foodService.queryAllFood();
//		
//		request.setAttribute("SOURCE_FOOD", foodList);
//		
//		/*  select component list */
//		request.setAttribute("INSERT_USER", insertUserList);
//		request.setAttribute("UPDATE_USER", insertUserList);
//
//		/*  page info */
//		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);
//		
//		request.setAttribute("QUERY_SOURCE_OBJECT", sf);
////		request.setAttribute("QUERY_SOURCE_LIST",SourceList );
//
//
//		return mapping.findForward("success");
//		
//	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward movePageSupport(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Source source = Source.buildSourceObjectFromRequest(request);
		
		SourceForm sf = Source.buildSourceFormObjectFromSourceObject(source);
		
		List<User> insertUserList = getUserService().queryAllUser();
		
		
		
//		SourcePageInfoBean sp = getSourceManager()
//				.getSourcePageInfoBeanByCriteriaQuerySource(source,Integer.valueOf(request.getParameter("assignPage")));

		int pageNo = Integer.parseInt(
				StringCommonUtil.isEmpty(super.getRequestParameter(request, "pageNo"))
								? "1" 
								: request.getParameter("pageNo"));
		
		int recordsCount = getSourceService().getSourceCount(source);
		Page p = PageFactory.createPage(-1, pageNo, recordsCount);
		List list = getSourceService().getSourceListByCriteriaQuerySource(source,p);
		
		PageTemplate sp = new PageTemplate(p,list);
		List<Soldier> foodList = foodService.queryAllSoldier();
		
		request.setAttribute("SOURCE_FOOD", foodList);
		
		/*  select component list */
		request.setAttribute("INSERT_USER", insertUserList);
		request.setAttribute("UPDATE_USER", insertUserList);

		/*  page info */
		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);
		
		request.setAttribute(PageConstant.SOURCE_QUERY_OBJECT_KEY, sf);
//		request.setAttribute("QUERY_SOURCE_LIST",SourceList );


		return mapping.findForward("success");


	}
}
