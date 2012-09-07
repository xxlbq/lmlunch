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
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.livedoor.flow_manager.IConstant.AttributeKeyConstant;
import com.livedoor.flow_manager.gem.IGemService;
import com.livedoor.flow_manager.gemSource.GemSourceSumInfo;
import com.livedoor.flow_manager.gemSource.GemSourceUtil;
import com.livedoor.flow_manager.gemSource.IGemSourceService;
import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.soldierSource.ISoldierSourceService;
import com.livedoor.flow_manager.soldierSource.SoldierSourceSumInfo;
import com.livedoor.flow_manager.soldierSource.SoldierSourceUtil;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class GemSourceDistributionQueryAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(GemSourceQueryAction.class);
	
	private IGemService gemService;
	private IKingdomService kingdomService ;
	private IGemSourceService gemSourceService;
	private IUserService userService;
	private ISoldierSourceService soldierSourceService;
	

	public void setSoldierSourceService(ISoldierSourceService soldierSourceService) {
		this.soldierSourceService = soldierSourceService;
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
		
		LOGGER.info(" GemSourceDistributionQuery display ---> ");
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		
		List gsList = gemSourceService.queryAllGemSourceDate();
		if(null != gsList || !gsList.isEmpty()){
			List<LabelValueBean> gsDateArr = toCollection(gsList);
			request.setAttribute("GEM_SOURCE_DATE_LIST", gsDateArr);
		}
		

		LOGGER.info(" GemSourceDistributionQuery display <--- ");
		return mapping.findForward("success");
	
	}


	public ActionForward query(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {

		LOGGER.info(" GemSourceDistributionQuery query ---> ");
		GemSourceForm gsf = (GemSourceForm)form;
		//
		User user = (User)request.getSession().getAttribute(AttributeKeyConstant.USER_INFO_KEY);
		request.setAttribute("USER_INFO", user);
		List<Kingdom> kingdomList = kingdomService.queryAllKingdom();
		request.setAttribute("KINGDOM_LIST", kingdomList);
		//
		List gsList = gemSourceService.queryAllGemSourceDate();
		if(null != gsList || !gsList.isEmpty()){
			List<LabelValueBean> gsDateArr = toCollection(gsList);
			request.setAttribute("GEM_SOURCE_DATE_LIST", gsDateArr);
		}
		
		//本周兵力总数
		//本周兵力分合计
		List<Object[]> rs = soldierSourceService.getKingdomSoldierSourceCountOfWeek(gsf.getKingdomId(),gsf.getSourceGemDate());
		Collection<SoldierSourceSumInfo> ssInfoList = toSoldierSourceSumInfo(rs,gsf.getSourceGemDate(),user.getUserDisplayName());
		request.setAttribute("SOLDIER_SOURCE_SUM_INFO", ssInfoList);
		
		
		//本周宝石总数
		
		//本周宝石分合计
		
		//国家 日期 名字 枪盾 大刀 骑兵 重甲 产生宝石分
		
		
		
		LOGGER.info(" GemSourceDistributionQuery query <--- ");
		
		return mapping.findForward("success");
		
	}
	
	
	/**
	 * 国家 兵种 数量  积分数
	 * 
	 * @param rs
	 * @param string2 
	 * @param string 
	 * @return
	 */
	private Collection<SoldierSourceSumInfo> toSoldierSourceSumInfo(List<Object[]> rs, String date, String displayName) {
		//Map<国家,Map<兵种,SoldierSourceSumInfo>>
		Map<Integer,SoldierSourceSumInfo> map = new HashMap<Integer,SoldierSourceSumInfo>();
		for (Object[] objArr : rs) {
			Integer kingdomId = (Integer)objArr[0];
			String 	kingdomName = (String)objArr[1];
			Integer soldierId = (Integer)objArr[2];
			BigDecimal sumSoldier =(BigDecimal)objArr[3];
			BigDecimal sumPoint = (BigDecimal)objArr[4];
			
			if(map.containsKey(kingdomId)){
				SoldierSourceUtil.fillSoldierSourceSumInfo(map.get(kingdomId),kingdomName,soldierId,sumSoldier.intValue(),sumPoint.intValue()) ;
			}else{
				SoldierSourceSumInfo n = new SoldierSourceSumInfo();
				n.setSourceDate(date);
				n.setUserName(displayName);
				SoldierSourceUtil.fillSoldierSourceSumInfo(n,kingdomName,soldierId,sumSoldier.intValue(),sumPoint.intValue());
				map.put(kingdomId, n);
			}
		}
		
		return map.values();
	}

	private List<LabelValueBean> toCollection(List gsList) {
		List<LabelValueBean> ds = new ArrayList<LabelValueBean>();
		for (Object obj : gsList) {
			LabelValueBean bean = new LabelValueBean((String)obj, (String)obj);
			ds.add(bean);
		}
		return ds;
	}
}
