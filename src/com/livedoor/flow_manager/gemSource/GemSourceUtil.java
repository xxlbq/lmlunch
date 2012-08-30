package com.livedoor.flow_manager.gemSource;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.enums.ActiveEnum;
import com.livedoor.flow_manager.enums.ApproveEnum;
import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.kingdom.KingdomUtil;
import com.livedoor.flow_manager.soldier.SoldierUtil;
import com.livedoor.flow_manager.soldierSource.SoldierSource;
import com.livedoor.flow_manager.soldierSource.SoldierSourceUtil;
import com.livedoor.flow_manager.soldierSource.form.SoldierSourceForm;
import com.livedoor.flow_manager.tools.DateUtil;
import com.livedoor.flow_manager.tools.UUIDGenerator;
import com.livedoor.flow_manager.user.beans.User;

public class GemSourceUtil {
	private static Logger  LOGGER = Logger.getLogger(GemSourceUtil.class);
	
	public static GemSource toGemSource4Add(GemSourceForm ssf, User user) {
		LOGGER.info("GemSourceForm :"+ssf);
		GemSource gs = new GemSource();
		Date d = new Date();
		gs.setGemSourcId(UUIDGenerator.getUUID());
		gs.setKingdom(KingdomUtil.toKingdom(ssf.getKingdomId()));
//		gs.setGem(gem);
		gs.setSourceGemCount(ssf.getSourceGemCount());
		gs.setSourceGemDate(DateUtil.getCurrentSaturday());
		gs.setInputStaffId(user.getUserDisplayName());
		gs.setUpdateStaffId(user.getUserDisplayName());
		gs.setInputDate(d);
		gs.setUpdateDate(d);
		gs.setActiveFlag(ActiveEnum.ACTIVE.getValue());
		LOGGER.info("GemSource :"+gs);
		
		return gs;
	}

	
//	  `GEM_SOURCE_ID` varchar(50) NOT NULL,
//	  `KINGDOM_ID` int(10) NOT NULL,
//	  `GEM_ID` int(10) NOT NULL ,
//	  `SOURCE_GEM_COUNT` int(10) NOT NULL default '0',
//	  `SOURCE_GEM_DATE` varchar(8) NOT NULL,
//	  `INPUT_STAFF_ID` varchar(50) NOT NULL,
//	  `UPDATE_STAFF_ID` varchar(50) NOT NULL,
//	  `INPUT_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
//	  `UPDATE_DATE` timestamp NOT NULL,
//	  `ACTIVE_FLAG` int(1) NOT NULL,
	
	
//	public static SoldierSource toSoldierSource4Add(SoldierSourceForm ssf, User user) {
//		
//		SoldierSource ss = new SoldierSource();
//		Date d = new Date();
//		ss.setSourceId(UUIDGenerator.getUUID());
//		ss.setUser(user);
//		ss.setSoldier(SoldierUtil.toSoldier(ssf.getSourceSoldierId()));
//		ss.setSourceSoliderCount(ssf.getSourceSoliderCount());
//		ss.setKingdom(KingdomUtil.toKingdom(ssf.getKingdomId()));
//		ss.setSourceSoliderSumCount(BigDecimal.ZERO);
//		ss.setApproved(ApproveEnum.UNAPPROVE.getValue());
//		ss.setSourceDate(DateUtil.getCurrentSaturday());
//		ss.setInputStaffId(user.getUserDisplayName());
//		ss.setUpdateStaffId(user.getUserDisplayName());
//		ss.setInputDate(d);
//		ss.setUpdateDate(d);
//		ss.setActiveFlag(ActiveEnum.ACTIVE.getValue());
//		LOGGER.info("SoldierSource :"+ss);
//		return ss;
//	}
}
