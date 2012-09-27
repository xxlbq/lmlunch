package com.livedoor.flow_manager.soldierSource;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.enums.ActiveEnum;
import com.livedoor.flow_manager.enums.ApproveEnum;
import com.livedoor.flow_manager.enums.KingdomEnum;
import com.livedoor.flow_manager.kingdom.KingdomUtil;
import com.livedoor.flow_manager.soldier.SoldierUtil;
import com.livedoor.flow_manager.soldierSource.form.SoldierSourceForm;
import com.livedoor.flow_manager.tools.DateUtil;
import com.livedoor.flow_manager.tools.UUIDGenerator;
import com.livedoor.flow_manager.user.beans.User;

public class SoldierSourceUtil {
	private static Logger  LOGGER = Logger.getLogger(SoldierSourceUtil.class);
	
	public static SoldierSource toSoldierSource4Add(SoldierSourceForm ssf, User user) {
		LOGGER.info("SoldierSourceForm :"+ssf);
		SoldierSource ss = new SoldierSource();
		Date d = new Date();
		ss.setSourceId(UUIDGenerator.getUUID());
		ss.setUser(user);
		ss.setSoldier(SoldierUtil.toSoldier(ssf.getSourceSoldierId()));
		ss.setSourceSoliderCount(ssf.getSourceSoliderCount());
		ss.setKingdom(KingdomUtil.toKingdom(ssf.getKingdomId()));
		ss.setSourceSoliderSumCount(BigDecimal.ZERO);
		ss.setApproved(ApproveEnum.UNAPPROVED.getValue());
		ss.setSourceDate(DateUtil.getCurrentSaturday());
		ss.setInputStaffId(user.getUserDisplayName());
		ss.setUpdateStaffId(user.getUserDisplayName());
		ss.setInputDate(d);
		ss.setUpdateDate(d);
		ss.setActiveFlag(ActiveEnum.ACTIVE.getValue());
		LOGGER.info("SoldierSource :"+ss);
		return ss;
	}
	
	
	public static SoldierSource toSoldierSource4Query(SoldierSourceForm ssf, User user) {
		LOGGER.info("SoldierSourceForm :"+ssf);
		SoldierSource ss = new SoldierSource();
		Date d = new Date();
		ss.setSourceId(UUIDGenerator.getUUID());
		ss.setUser(user);
		ss.setSoldier(SoldierUtil.toSoldier(ssf.getSourceSoldierId()));
		ss.setSourceSoliderCount(ssf.getSourceSoliderCount());
		ss.setKingdom(KingdomUtil.toKingdom(ssf.getKingdomId()));
		ss.setSourceSoliderSumCount(BigDecimal.ZERO);
		ss.setApproved(ssf.getApproved());
		ss.setSourceDate(ssf.getSourceDate());
		
		if(null !=  user){
			ss.setInputStaffId(user.getUserDisplayName());
			ss.setUpdateStaffId(user.getUserDisplayName());
		}else{
			ss.setInputStaffId("INIT");
			ss.setUpdateStaffId("INIT");
		}
		
		
		ss.setInputDate(d);
		ss.setUpdateDate(d);
		ss.setActiveFlag(ActiveEnum.ACTIVE.getValue());
		LOGGER.info("SoldierSource :"+ss);
		return ss;
	}
	
	
	


	public static void fillSoldierSourceSumInfo(
			SoldierSourceSumInfo info, String kingdomName,Integer soldierId,BigDecimal soldierSum,BigDecimal pointSum) {
		info.setKingdomName(kingdomName);
//		info.setSoldierPointSum(info.getSoldierPointSum() == null ? 0 : info.getSoldierPointSum().add( pointSum ));
		info.setSoldierPointSum(info.getSoldierPointSum().add( pointSum ));
		switch (soldierId) {
		case 1:
			info.setQiangdunSum(soldierSum);
			break;
		case 2:
			info.setDadaoSum(soldierSum);
			break;
		case 3:
			info.setQibingSum(soldierSum);
			break;
		case 4:
			info.setZhongjiaSum(soldierSum);
			break;
			
		default:
			break;
		}
		
	}
	
	
}
