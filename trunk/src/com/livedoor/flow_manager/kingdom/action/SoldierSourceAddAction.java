//package com.livedoor.flow_manager.kingdom.action;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.swing.text.AbstractDocument.AttributeContext;
//
//import org.apache.log4j.Logger;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;
//import org.apache.struts.actions.MappingDispatchAction;
//
//import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
//import com.livedoor.flow_manager.soldier.ISoldierService;
//import com.livedoor.flow_manager.soldier.Soldier;
//import com.livedoor.flow_manager.user.beans.User;
//import com.livedoor.flow_manager.user.service.IUserService;
//
//public class SoldierSourceAddAction extends MappingDispatchAction{
//	
//	private static Logger  log = Logger.getLogger(SoldierSourceAddAction.class);
//	
//	private ISoldierService soldierService;
////	private IUserService  userService ;
//
//	public void setSoldierService(ISoldierService soldierService) {
//		this.soldierService = soldierService;
//	}
//
//
////	public void setUserService(IUserService userService) {
////		this.userService = userService;
////	}
//
//
//	public ActionForward display(ActionMapping mapping,
//		   ActionForm form,
//		   HttpServletRequest request,
//		   HttpServletResponse response) throws Exception {
//		
//		log.info(" SoldierSourceAddDisplay ---> ");
//		List<Soldier> soldierList = soldierService.queryAllSoldier();
//		log.info(" food list size :"+soldierList.size());
//		
//		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
//		request.setAttribute("SOLDIER_LIST", soldierList);
//		request.setAttribute("USER_INFO", user);
////		((SourceForm)form).setSourceFoodId(5);
//		log.info(" SoldierSourceAddDisplay <--- ");
//		return mapping.findForward("success");
//	
//	}
//	public ActionForward add(ActionMapping mapping,
//			   ActionForm form,
//			   HttpServletRequest request,
//			   HttpServletResponse response) throws Exception {
//			
//			log.info(" SoldierSourceAddDisplay ---> ");
//			List<Soldier> soldierList = soldierService.queryAllSoldier();
//			log.info(" food list size :"+soldierList.size());
//			request.setAttribute("SOLDIER_LIST", soldierList);
////			request.setAttribute("SOURCE_FOOD_OBJ", soldierList);
////			((SourceForm)form).setSourceFoodId(5);
//			log.info(" SoldierSourceAddDisplay <--- ");
//			return mapping.findForward("success");
//		
//		}
//}
