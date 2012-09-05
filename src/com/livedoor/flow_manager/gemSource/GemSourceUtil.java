package com.livedoor.flow_manager.gemSource;

import java.util.Date;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.enums.ActiveEnum;
import com.livedoor.flow_manager.gem.Gem;
import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.kingdom.KingdomUtil;
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
		gs.setGem(new Gem(ssf.getGemId()));
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

	
	public static GemSource toGemSource4Query(GemSourceForm ssf) {
		LOGGER.info("GemSourceForm :"+ssf);
		GemSource gs = new GemSource();
		
		if(ssf.getKingdomId()!=null ) gs.setKingdom(KingdomUtil.toKingdom(ssf.getKingdomId()));
		if(ssf.getSourceGemDate()!=null ) gs.setSourceGemDate(ssf.getSourceGemDate());
		
		LOGGER.info("GemSource :"+gs);
		
		return gs;
	}

	/**
	 * 
	 * 
	 * 	1,'2级负载宝石(绑)'
		2,'2级疾风宝石(绑)'
		3,'2级防御宝石(绑)'
		4,'2级奔雷宝石(绑)'
		5,'2级修罗宝石(绑)'


	 * @param gs
	 * @param info
	 */
	public static void fillGemSourceInfo(GemSource gs,GemSourceSumInfo info){
		info.setKongdomName(gs.getKingdom().getKingdomName());
		info.setGemSourceDate(gs.getSourceGemDate());
		
		switch (gs.getGem().getGemId()) {
		case 1:
			info.setFuzaiSum(gs.getSourceGemCount());
			break;
		case 2:
			info.setJifengSum(gs.getSourceGemCount());
			break;
		case 3:
			info.setFangyuSum(gs.getSourceGemCount());
			break;
		case 4:
			info.setBenleiSum(gs.getSourceGemCount());
			break;
		case 5:
			info.setXiuluoSum(gs.getSourceGemCount());
			break;
			
		default:
			break;
		}
	}
	
	
	
	
}
