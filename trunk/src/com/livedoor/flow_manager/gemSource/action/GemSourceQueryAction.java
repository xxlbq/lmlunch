package com.livedoor.flow_manager.gemSource.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.gem.IGemService;
import com.livedoor.flow_manager.gemSource.GemSource;
import com.livedoor.flow_manager.gemSource.GemSourceSumInfo;
import com.livedoor.flow_manager.gemSource.GemSourceUtil;
import com.livedoor.flow_manager.gemSource.IGemSourceService;
import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.sysConfig.ISysConfigConstants;
import com.livedoor.flow_manager.sysConfig.ISysConfigService;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class GemSourceQueryAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(GemSourceQueryAction.class);
	
	private IGemService gemService;
	private IKingdomService kingdomService ;
	private IGemSourceService gemSourceService;
	private IUserService userService;
	private ISysConfigService sysConfigService;
	

	
	public void setSysConfigService(ISysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	public IGemService getGemService() {
		return gemService;
	}

	public void setGemService(IGemService gemService) {
		this.gemService = gemService;
	}

	public IKingdomService getKingdomService() {
		return kingdomService;
	}

	public void setKingdomService(IKingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}

	public IGemSourceService getGemSourceService() {
		return gemSourceService;
	}

	public void setGemSourceService(IGemSourceService gemSourceService) {
		this.gemSourceService = gemSourceService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward display(ActionMapping mapping,
		   ActionForm form,
		   HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
		
		LOGGER.info(" SoldierSourceQueryAction display ---> ");
		
		
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		List gsList = gemSourceService.queryAllGemSourceDate();
		if(null != gsList && !gsList.isEmpty()){
			List<LabelValueBean> gsDateArr = toCollection(gsList);
			request.setAttribute("GEM_SOURCE_DATE_LIST", gsDateArr);
		}
		
		String ratioValue = sysConfigService.querySysConfig(ISysConfigConstants.CONFIG_TYPE_GEM, ISysConfigConstants.CONFIG_KEY_FAMILY_FOUNDATION);
		BigDecimal ratio = new BigDecimal(100 - Integer.parseInt(ratioValue)).divide(new BigDecimal("100"));
		request.setAttribute("RATIO_DISPLAY", (100 - (Integer.parseInt(ratioValue))+"%"));
		
		LOGGER.info(" SoldierSourceQueryAction display <--- ");
		return mapping.findForward("success");
	
	}

	private List<LabelValueBean> toCollection(List gsList) {
		List<LabelValueBean> ds = new ArrayList<LabelValueBean>();
		for (Object obj : gsList) {
			LabelValueBean bean = new LabelValueBean((String)obj, (String)obj);
			ds.add(bean);
		}
		return ds;
	}

	public ActionForward query(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {

		
		LOGGER.info(this.clazz.getName() + " query   ->");
		
		
//		GemSource gs = new GemSource();
//		gs.setSourceGemDate(DateUtil.getCurrentSaturday());
//		List<GemSource>
//		request.setAttribute("GEM_SOURCE_LIST", gs);
		
		
		GemSourceForm sf = (GemSourceForm)form;
		
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
				GemSourceForm sf,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		
		List gsList = gemSourceService.queryAllGemSourceDate();
		if(null != gsList || !gsList.isEmpty()){
			List<LabelValueBean> gsDateArr = toCollection(gsList);
			request.setAttribute("GEM_SOURCE_DATE_LIST", gsDateArr);
		}
		
		GemSource ss = GemSourceUtil.toGemSource4Query(sf);
		List<Object[]> los=gemSourceService.queryGemSourcePointList(ss);
//		List<GemSource> oneWeekGemsList = gemSourceService.getSourceListByCriteriaQuerySource(ss);
//		List<GemSource> oneWeekGemsList =toGemSourceList(los);
		
		
		String ratioValue = sysConfigService.querySysConfig(ISysConfigConstants.CONFIG_TYPE_GEM, ISysConfigConstants.CONFIG_KEY_FAMILY_FOUNDATION);
		BigDecimal ratio = new BigDecimal(100 - Integer.parseInt(ratioValue)).divide(new BigDecimal("100"));
		request.setAttribute("RATIO_DISPLAY", (100 - (Integer.parseInt(ratioValue))+"%"));
		
		Collection<GemSourceSumInfo> infoList = toGemSourceSumInfo(los,ratio);
		request.setAttribute("GEM_SOURCE_LIST",infoList);
	}


	private Collection<GemSourceSumInfo> toGemSourceSumInfo(List<Object[]> rs,BigDecimal ratio) {

		Map<String,GemSourceSumInfo> tempMap = new HashMap<String,GemSourceSumInfo>();
		for (Object[] element : rs) {
			if(tempMap.containsKey((String)element[1])){
				GemSourceUtil.fillGemSourceInfo(element,tempMap.get((String)element[1]),ratio) ;
			}else{
				GemSourceSumInfo n = new GemSourceSumInfo();
				GemSourceUtil.fillGemSourceInfo(element,n,ratio) ;
				tempMap.put((String)element[1], n);
			}
		}
		
		return tempMap.values();
	}
	
	



//	private List<GemSource> toGemSourceList(List<Object[]> objList) {
//		List<GemSource> r = new ArrayList<GemSource>();
//		for (Object[] objects : objList) {
//			GemSource gs = new GemSource();
//			Kingdom k = new Kingdom((Integer)objects[0],(String)objects[1]);
//			gs.setKingdom(k);
//			Gem g = new Gem((Integer)objects[2]);
//			gs.setGem(g);
//			
//			gs.se
//			r.add(gs);
//		}
//		return r;
//	}
}
