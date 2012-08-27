package com.livedoor.flow_manager.soldierSource;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.enums.ActiveEnum;
import com.livedoor.flow_manager.enums.ApproveEnum;
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
		ss.setApproved(ApproveEnum.UNAPPROVE.getValue());
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
		
		ss.setInputStaffId(user.getUserDisplayName());
		ss.setUpdateStaffId(user.getUserDisplayName());
		ss.setInputDate(d);
		ss.setUpdateDate(d);
		ss.setActiveFlag(ActiveEnum.ACTIVE.getValue());
		LOGGER.info("SoldierSource :"+ss);
		return ss;
	}
}
