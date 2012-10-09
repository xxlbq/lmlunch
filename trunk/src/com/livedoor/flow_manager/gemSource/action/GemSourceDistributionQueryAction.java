package com.livedoor.flow_manager.gemSource.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.livedoor.flow_manager.gemSource.IGemSourceService;
import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.kingdom.IKingdomService;
import com.livedoor.flow_manager.kingdom.Kingdom;
import com.livedoor.flow_manager.soldierSource.ISoldierSourceService;
import com.livedoor.flow_manager.soldierSource.SoldierSourceSumInfo;
import com.livedoor.flow_manager.soldierSource.SoldierSourceUtil;
import com.livedoor.flow_manager.sysConfig.ISysConfigConstants;
import com.livedoor.flow_manager.sysConfig.ISysConfigService;
import com.livedoor.flow_manager.tools.CollectionTools;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.service.IUserService;

public class GemSourceDistributionQueryAction extends MappingDispatchAction{
	
	private static Logger  LOGGER = Logger.getLogger(GemSourceQueryAction.class);
	
	private IGemService gemService;
	private IKingdomService kingdomService ;
	private IGemSourceService gemSourceService;
	private IUserService userService;
	private ISoldierSourceService soldierSourceService;
	private ISysConfigService sysConfigService;

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

	public void setSysConfigService(ISysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
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
			List<LabelValueBean> gsDateArr = CollectionTools.toCollection(gsList);
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
			List<LabelValueBean> gsDateArr = CollectionTools.toCollection(gsList);
			request.setAttribute("GEM_SOURCE_DATE_LIST", gsDateArr);
		}
		

		//本周兵力分合计
		BigDecimal soldierSourceTotalPoint = soldierSourceService.queryTotalSoldierSourcePoint(gsf.getSourceGemDate(),gsf.getKingdomId());
		LOGGER.info("date :"+gsf.getSourceGemDate()+",kingdomId:"+gsf.getKingdomId()+" ,soldierSourceTotalPoint:"+soldierSourceTotalPoint);

		
		//本周宝石分合计
		BigDecimal gemSourceTotalPoint = gemSourceService.queryTotalGemSourcePoint(gsf.getSourceGemDate(),gsf.getKingdomId());
		LOGGER.info("date :"+gsf.getSourceGemDate()+",kingdomId:"+gsf.getKingdomId()+" ,gemSourceTotalPoint:"+gemSourceTotalPoint);
	
		//本周宝石兵力比例       每1w防御对应的宝石 比率   ，1 兵力分 ：0.03 宝石分 
		BigDecimal gemPointPerSoldier =  soldierSourceTotalPoint.intValue() == 0 ? BigDecimal.ZERO : gemSourceTotalPoint.divide(soldierSourceTotalPoint,2, RoundingMode.DOWN);
		LOGGER.info("date :"+gsf.getSourceGemDate()+",kingdomId:"+gsf.getKingdomId()+" ,gemPointPerSoldier:"+gemPointPerSoldier);

		//家族基金比率
		String ratioValue = sysConfigService.querySysConfig(ISysConfigConstants.CONFIG_TYPE_GEM, ISysConfigConstants.CONFIG_KEY_FAMILY_FOUNDATION);
		BigDecimal ratio = new BigDecimal(100 - Integer.parseInt(ratioValue)).divide(new BigDecimal("100"));
		LOGGER.info("date :"+gsf.getSourceGemDate()+",kingdomId:"+gsf.getKingdomId()+" ,ratio:"+ratio);
		
		//国家 日期 名字 枪盾 大刀 骑兵 重甲  产生宝石分  交基金后宝石分
		List<Object[]> rs = soldierSourceService.getKingdomSoldierSourceCountOfWeek(gsf.getKingdomId(),gsf.getSourceGemDate());
		Collection<SoldierSourceSumInfo> ssInfoList = toSoldierSourceSumInfo(rs,gemPointPerSoldier,ratio);
		
		//本周兵力分种类数量合计
		List<Object[]> soldierSourceList = soldierSourceService.queryTotalSoldierSourceGroupbySoldierId(gsf.getSourceGemDate(),gsf.getKingdomId());
		SoldierSourceSumInfo sinfo = toSoldierSourceSumInfo(soldierSourceList);
		sinfo.setSourceDate(gsf.getSourceGemDate());

		
		
		
		request.setAttribute("SOLDIER_SOURCE_GROUPBY_SOLDIER_ID", sinfo);		
		request.setAttribute("SOLDIER_SOURCE_SUM_INFO", ssInfoList);
		
		request.setAttribute("soldierSourceTotalPoint", soldierSourceTotalPoint);
		request.setAttribute("soldierSourceTotalPointRatio", soldierSourceTotalPoint.multiply(ratio).setScale(0, RoundingMode.DOWN));
		
		request.setAttribute("gemSourceTotalPoint", gemSourceTotalPoint);
		request.setAttribute("gemSourceTotalPointRatio", gemSourceTotalPoint.multiply(ratio).setScale(0, RoundingMode.DOWN));
		
		request.setAttribute("gemPointPerSoldier", gemPointPerSoldier);
		request.setAttribute("ratio", ratio);
		
		LOGGER.info(" GemSourceDistributionQuery query <--- ");
		
		return mapping.findForward("success");
		
	}
	
	
	private SoldierSourceSumInfo toSoldierSourceSumInfo(List<Object[]> soldierSourceList) {
		SoldierSourceSumInfo sumInfo = new SoldierSourceSumInfo();
		
		for (Object[] obj : soldierSourceList) {
			SoldierSourceUtil.fillSoldierSourceSumInfo(sumInfo, (String)obj[1], (Integer)obj[2], (BigDecimal)obj[4], (BigDecimal)obj[5]);
		}
		return sumInfo;
	}

	
	/**
	 * 国家 兵种 数量  积分数
	 * 
	 * @param rs
	 * @param gemPointPerSoldier 
	 * @param ratio 
	 * @param string2 
	 * @param string 
	 * @return
	 */
	private Collection<SoldierSourceSumInfo> toSoldierSourceSumInfo(List<Object[]> rs, BigDecimal gemPointPerSoldier, BigDecimal ratio) {
		//Map<国家,Map<兵种,SoldierSourceSumInfo>>
		Map<String,SoldierSourceSumInfo> map = new HashMap<String,SoldierSourceSumInfo>();
		for (Object[] objArr : rs) {
			Integer kingdomId = (Integer)objArr[0];
			String 	kingdomName = (String)objArr[1];
			String  date = (String)objArr[2];
			String	displayName = (String)objArr[3];
			Integer soldierId = (Integer)objArr[5];
			
			BigDecimal sumSoldier =(BigDecimal)objArr[6];
			BigDecimal sumPoint = (BigDecimal)objArr[7];
			
			if(map.containsKey(displayName)){
				SoldierSourceUtil.fillSoldierSourceSumInfo(map.get(displayName),kingdomName,soldierId,sumSoldier,sumPoint) ;
			}else{
				SoldierSourceSumInfo n = new SoldierSourceSumInfo();
				n.setSourceDate(date);
				n.setUserName(displayName);
				n.setGemPointPerSoldier(gemPointPerSoldier);
				n.setTaxRatio(ratio);
				SoldierSourceUtil.fillSoldierSourceSumInfo(n,kingdomName,soldierId,sumSoldier,sumPoint);
				map.put(displayName, n);
			}
		}
		
		return map.values();
	}

}
