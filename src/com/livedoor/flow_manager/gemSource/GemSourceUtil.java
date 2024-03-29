package com.livedoor.flow_manager.gemSource;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.enums.ActiveEnum;
import com.livedoor.flow_manager.gem.Gem;
import com.livedoor.flow_manager.gemSource.form.GemSourceForm;
import com.livedoor.flow_manager.kingdom.KingdomUtil;
import com.livedoor.flow_manager.tools.DateUtil;
import com.livedoor.flow_manager.tools.UUIDGenerator;
import com.livedoor.flow_manager.user.beans.User;
import com.livedoor.flow_manager.user.form.UserForm;




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
	 * 	1,'2�����ر�ʯ(��)'
		2,'2�����籦ʯ(��)'
		3,'2��������ʯ(��)'
		4,'2�����ױ�ʯ(��)'
		5,'2�����ޱ�ʯ(��)'


	 * @param gs
	 * @param info
	 * @param ratio 
	 */
//	public static void fillGemSourceInfo(GemSource gs,GemSourceSumInfo info){
//		info.setKongdomName(gs.getKingdom().getKingdomName());
//		info.setGemSourceDate(gs.getSourceGemDate());
//		
//		switch (gs.getGem().getGemId()) {
//		case 1:
//			info.setFuzaiSum(gs.getSourceGemCount());
//			break;
//		case 2:
//			info.setJifengSum(gs.getSourceGemCount());
//			break;
//		case 3:
//			info.setFangyuSum(gs.getSourceGemCount());
//			break;
//		case 4:
//			info.setBenleiSum(gs.getSourceGemCount());
//			break;
//		case 5:
//			info.setXiuluoSum(gs.getSourceGemCount());
//			break;
//			
//		default:
//			break;
//		}
//	}

	public static void fillGemSourceSumInfo(Object[] objs,GemSourceSumInfo info, BigDecimal ratio){
		info.setKongdomName((String)objs[1]);
		info.setGemSourceDate((String)objs[5]);
		info.setTaxRatio(ratio);
		
		switch ((Integer)objs[2]) {
		case 1:
			info.setFuzaiSum((BigDecimal)objs[3]);
			info.setFuzaiPointSum((BigDecimal)objs[4]);
			break;
		case 2:
			info.setJifengSum((BigDecimal)objs[3]);
			info.setJifengPointSum((BigDecimal)objs[4]);
			break;
		case 3:
			info.setFangyuSum((BigDecimal)objs[3]);
			info.setFangyuPointSum((BigDecimal)objs[4]);
			break;
		case 4:
			info.setBenleiSum((BigDecimal)objs[3]);
			info.setBenleiPointSum((BigDecimal)objs[4]);
			break;
		case 5:
			info.setXiuluoSum((BigDecimal)objs[3]);
			info.setXiuluoPointSum((BigDecimal)objs[4]);
			break;
			
		default:
			break;
		}
	}
	
}
