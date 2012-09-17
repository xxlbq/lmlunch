package com.livedoor.flow_manager.soldierSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SoldierSourceSumInfo {
	
	private String kingdomName;
	private String sourceDate;
	private String userName;
	
	private Integer qiangdunSum = 0 ;
	private Integer dadaoSum = 0;
	private Integer qibingSum = 0;
	private Integer zhongjiaSum = 0;
	
	private Integer soldierPointSum = 0;
	
	private BigDecimal taxRatio = BigDecimal.ONE;

	private BigDecimal gemPointPerSoldier =BigDecimal.ZERO;

	
	public BigDecimal getGemPointSumAfterTax() {
		return gemPointPerSoldier.multiply(getSoldierPointSumAfterTax()).setScale(0,RoundingMode.DOWN) ;
	}
	
	public BigDecimal getGemPointSum() {
		return gemPointPerSoldier.multiply(new BigDecimal(soldierPointSum)).setScale(0,RoundingMode.DOWN) ;
	}
	
	public Integer getSoldierPointSum() {
		return soldierPointSum;
	}

	public void setSoldierPointSum(Integer soldierPointSum) {
		this.soldierPointSum = soldierPointSum;
	}

	public BigDecimal getGemPointPerSoldier() {
		return gemPointPerSoldier;
	}

	public void setGemPointPerSoldier(BigDecimal gemPointPerSoldier) {
		this.gemPointPerSoldier = gemPointPerSoldier;
	}

	public BigDecimal getSoldierPointSumAfterTax(){
		return taxRatio.multiply(new BigDecimal(soldierPointSum)).setScale(0,RoundingMode.DOWN);
	}
	
	public BigDecimal getTaxRatio() {
		return taxRatio;
	}

	public void setTaxRatio(BigDecimal taxRatio) {
		this.taxRatio = taxRatio;
	}

	public String getKingdomName() {
		return kingdomName;
	}

	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}

	public String getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(String sourceDate) {
		this.sourceDate = sourceDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public Integer getQiangdunSum() {
		return qiangdunSum;
	}

	public void setQiangdunSum(Integer qiangdunSum) {
		this.qiangdunSum = qiangdunSum;
	}

	public Integer getDadaoSum() {
		return dadaoSum;
	}

	public void setDadaoSum(Integer dadaoSum) {
		this.dadaoSum = dadaoSum;
	}

	public Integer getQibingSum() {
		return qibingSum;
	}

	public void setQibingSum(Integer qibingSum) {
		this.qibingSum = qibingSum;
	}

	public Integer getZhongjiaSum() {
		return zhongjiaSum;
	}

	public void setZhongjiaSum(Integer zhongjiaSum) {
		this.zhongjiaSum = zhongjiaSum;
	}


	
	
}
