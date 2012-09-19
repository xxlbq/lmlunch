package com.livedoor.flow_manager.gemSource;

import java.math.BigDecimal;

public class GemSourceInfo {
	
	private String gemSourceId;
	private String kongdomName;
	private String gemSourceDate;

	private BigDecimal xiuluo = BigDecimal.ZERO;
	private BigDecimal benlei = BigDecimal.ZERO;
	private BigDecimal fangyu = BigDecimal.ZERO;
	private BigDecimal jifeng = BigDecimal.ZERO;
	private BigDecimal fuzai = BigDecimal.ZERO;
	
	
	
	
	public String getGemSourceId() {
		return gemSourceId;
	}
	public void setGemSourceId(String gemSourceId) {
		this.gemSourceId = gemSourceId;
	}
	public String getKongdomName() {
		return kongdomName;
	}
	public void setKongdomName(String kongdomName) {
		this.kongdomName = kongdomName;
	}
	public String getGemSourceDate() {
		return gemSourceDate;
	}
	public void setGemSourceDate(String gemSourceDate) {
		this.gemSourceDate = gemSourceDate;
	}
	public BigDecimal getXiuluo() {
		return xiuluo;
	}
	public void setXiuluo(BigDecimal xiuluo) {
		this.xiuluo = xiuluo;
	}
	public BigDecimal getBenlei() {
		return benlei;
	}
	public void setBenlei(BigDecimal benlei) {
		this.benlei = benlei;
	}
	public BigDecimal getFangyu() {
		return fangyu;
	}
	public void setFangyu(BigDecimal fangyu) {
		this.fangyu = fangyu;
	}
	public BigDecimal getJifeng() {
		return jifeng;
	}
	public void setJifeng(BigDecimal jifeng) {
		this.jifeng = jifeng;
	}
	public BigDecimal getFuzai() {
		return fuzai;
	}
	public void setFuzai(BigDecimal fuzai) {
		this.fuzai = fuzai;
	}
	
	
}
