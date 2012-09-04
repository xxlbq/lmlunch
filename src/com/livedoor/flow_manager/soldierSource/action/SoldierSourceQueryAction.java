package com.livedoor.flow_manager.soldierSource.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.IConstant.PageConstant;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.role.RoleUtil;
import com.livedoor.flow_manager.soldier.ISoldierService;
import com.livedoor.flow_manager.soldier.Soldier;
import com.livedoor.flow_manager.soldierSource.ISoldierSourceService;
import com.livedoor.flow_manager.soldierSource.SoldierSource;
import com.livedoor.flow_manager.soldierSource.SoldierSourceUtil;
import com.livedoor.flow_manager.soldierSource.form.SoldierSourceForm;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.livedoor.flow_manager.tools.lbq.PageFactory;
import com.livedoor.flow_manager.tools.lbq.PageTemplate;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class SoldierSourceQueryAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(SoldierSourceQueryAction.class);
	
	private ISoldierService soldierService;
	private IKingdomService kingdomService ;
	private ISoldierSourceService soldierSourceService;
	private IUserService userService;

	
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setSoldierService(ISoldierService soldierService) {
		this.soldierService = soldierService;
	}

	public void setKingdomService(IKingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}


	public void setSoldierSourceService(ISoldierSourceService soldierSourceService) {
		this.soldierSourceService = soldierSourceService;
	}

	public ActionForward display(ActionMapping mapping,
		   ActionForm form,
		   HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" SoldierSourceQueryAction display ---> ");
		
		
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		
		List<Soldier> soldierList = soldierService.queryAllSoldier();
		request.setAttribute("SOLDIER_LIST", soldierList);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		LOGGER.info(" SoldierSourceQueryAction display <--- ");
		return mapping.findForward("success");
	
	}

	public ActionForward query(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {

		
		LOGGER.info(this.clazz.getName() + " query   ->");
		
		SoldierSourceForm sf = (SoldierSourceForm)form;
		
		ActionMessages aMsgs = sf.validateSourceForm();
//		
		if (aMsgs.size() > 0) {
			
			addMessages(request, aMsgs);  
			pageInfoProcess(mapping,sf,request,response);
			
			LOGGER.info(this.clazz.getName() + " query   <-");
			return mapping.findForward("failure"); 
		}else{
			
			pageInfoProcess(mapping,sf,request,response);

			LOGGER.info(this.clazz.getName() + " query   <-");
			return mapping.findForward("success"); 
		}

		
	}
	
	public void pageInfoProcess(ActionMapping mapping,
				SoldierSourceForm sf,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
//		==============mapping to user====================
		
//		User inputUser = new User();
//
//		if(StringCommonUtil.isNotEmpty(sf.getInputUserId())) 	inputUser.setUserId(Integer.valueOf(sf.getInputUserId()));
//		
//		User updateUser = new User();
//
//		if(StringCommonUtil.isNotEmpty(sf.getUpdateUserId())) updateUser.setUserId(Integer.valueOf(sf.getUpdateUserId()));
//		
//		com.livedoor.flow_manager.soldier.Soldier food = new Soldier();
//		
//		if(StringCommonUtil.isNotEmpty(sf.getSourceFoodId())) food.setSoldierId(Integer.valueOf(sf.getSourceFoodId()));
//		==================================================
		
//		Source criteriaSource = new Source();
//		
//		criteriaSource.setSourceName	(sf.getSourceName());
////		criteriaSource.setSourceDoor	(sf.getSourceDoor());
////		criteriaSource.setSourceDesc	(sf.getSourceDesc());
//		criteriaSource.setFood(food);
//		criteriaSource.setInputDatetime(GetDate.getCalendar(sf.getInputeDatetime()));
//		criteriaSource.setInputUser		(inputUser);
//		criteriaSource.setUpdateUser	(updateUser);
//		criteriaSource.setUpdateDatetime(GetDate.getCalendar(sf.getUpdateDatetime()));
//		
//		List<User> commonUser = getUserService().queryAllUser();
//		List<Soldier> foodList = soldierService.queryAllSoldier();
		
		/*  pageInfo Object */
//		SourcePageInfoBean sp = getSourceManager()
//									.getSourcePageInfoBeanByCriteriaQuerySource(criteriaSource, PageConstant.SOURCE_INIT_PAGE_NUMBER);

		User user = userService.getUniqueUserByUserName(sf.getUserName());
		if(null == user){
//			throw new Exception("there is no user ["+sf.getUserName()+"] in db . error fire !");
			LOGGER.info("there is no user ["+sf.getUserName()+"] in db . not choose user !");
		}
		SoldierSource ss = SoldierSourceUtil.toSoldierSource4Query(sf, user);
		
		int pageNo = Integer.parseInt(request.getParameter("pageNo")== null ? "1" : request.getParameter("pageNo"));
		int recordsCount = soldierSourceService.getSoldierSourceCount(ss);
		Page p = PageFactory.createPage(-1, pageNo, recordsCount);
		List<SoldierSource> list = soldierSourceService.getSourceListByCriteriaQuerySource(ss, p);
		
		PageTemplate sp = new PageTemplate(p,list);
		if( user != null ) sf.setUserId(user.getUserId());
		request.setAttribute(PageConstant.SOURCE_QUERY_OBJECT_KEY, sf);
		request.setAttribute(PageConstant.PAGER_VIEW_KEY, sp);

		
		
		request.setAttribute("USER_INFO", user);
		
		List<Soldier> soldierList = soldierService.queryAllSoldier();
		request.setAttribute("SOLDIER_LIST", soldierList);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		/*  page info */
		
//		request.setAttribute("PAGE_INFO_BEAN", SP);
		
//		request.setAttribute("INSERT_USER", commonUser);
//		
//		request.setAttribute("UPDATE_USER", commonUser);
//		request.setAttribute("QUERY_SOURCE_LIST", SourceList);
		
	}
	
	
	
}
