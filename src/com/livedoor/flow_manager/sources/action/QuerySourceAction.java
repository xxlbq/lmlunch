package com.livedoor.flow_manager.sources.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.IConstant.PageConstant;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldier.SoldierService;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.sources.service.ISourceService;
import com.livedoor.flow_manager.tools.GetDate;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.tools.lbq.PageFactory;
import com.livedoor.flow_manager.tools.lbq.PageTemplate;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;
import com.lm.common.util.str.StringCommonUtil;

public class QuerySourceAction extends Action{
	
	private  Logger logger = Logger.getLogger(this.getClass());
	
	private IUserService userService;
	
	private ISourceService sourceService;
	private SoldierService soldierService;
	
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}

	

	public void setFoodService(SoldierService foodService) {
		this.soldierService = foodService;
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
		
		logger.info("session id:"+request.getSession().getId());
		User user=(User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		logger.info("@_@ userid :"+user.getUserId()+", username:"+user.getUsername()+", password:"+user.getUserPassword());
		SourceForm sf = (SourceForm)form;
		
		ActionMessages aMsgs = SourceForm.validateSourceForm(sf);
//		
		if (aMsgs.size() > 0) {
			
			addMessages(request, aMsgs);  
			
			pageInfoProcess(mapping,sf,request,response);
			
			return mapping.findForward("failure"); 
		}else{
			
			pageInfoProcess(mapping,sf,request,response);
			
			return mapping.findForward("success"); 
		}

		
		
	}
	
	public void pageInfoProcess(ActionMapping mapping,
			   SourceForm sf,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
//		==============mapping to user====================
		
		User inputUser = new User();

		if(StringCommonUtil.isNotEmpty(sf.getInputUserId())) 	inputUser.setUserId(Integer.valueOf(sf.getInputUserId()));
		
		User updateUser = new User();

		if(StringCommonUtil.isNotEmpty(sf.getUpdateUserId())) updateUser.setUserId(Integer.valueOf(sf.getUpdateUserId()));
		
		com.livedoor.flow_manager.soldier.Soldier food = new Soldier();
		
		if(StringCommonUtil.isNotEmpty(sf.getSourceFoodId())) food.setSoldierId(Integer.valueOf(sf.getSourceFoodId()));
//		==================================================
		
		Source criteriaSource = new Source();
		
		criteriaSource.setSourceName	(sf.getSourceName());
//		criteriaSource.setSourceDoor	(sf.getSourceDoor());
//		criteriaSource.setSourceDesc	(sf.getSourceDesc());
		criteriaSource.setFood(food);
		criteriaSource.setInputDatetime(GetDate.getCalendar(sf.getInputeDatetime()));
		criteriaSource.setInputUser		(inputUser);
		criteriaSource.setUpdateUser	(updateUser);
		criteriaSource.setUpdateDatetime(GetDate.getCalendar(sf.getUpdateDatetime()));
		
		List<User> commonUser = getUserService().queryAllUser();
		List<Soldier> foodList = soldierService.queryAllSoldier();
		
		/*  pageInfo Object */
//		SourcePageInfoBean sp = getSourceManager()
//									.getSourcePageInfoBeanByCriteriaQuerySource(criteriaSource, PageConstant.SOURCE_INIT_PAGE_NUMBER);
		
		
		int pageNo = Integer.parseInt(request.getParameter("pageNo")== null ? "1" : request.getParameter("pageNo"));
		int recordsCount = getSourceService().getSourceCount(criteriaSource);
		Page p = PageFactory.createPage(-1, pageNo, recordsCount);
		List list = getSourceService().getSourceListByCriteriaQuerySource(criteriaSource, p);
		
		PageTemplate sp = new PageTemplate(p,list);

		/*  page info */
		
		request.setAttribute("SOURCE_FOOD", foodList);
//		request.setAttribute("PAGE_INFO_BEAN", SP);
		
		request.setAttribute("INSERT_USER", commonUser);
		
		request.setAttribute("UPDATE_USER", commonUser);
		
		request.setAttribute(PageConstant.SOURCE_QUERY_OBJECT_KEY, sf);
		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);
//		request.setAttribute("QUERY_SOURCE_LIST", SourceList);
		
		
		
	}
}