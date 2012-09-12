package com.livedoor.flow_manager.soldierSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SoldierSourceSumInfo {
	
	private String kingdomName;
	private String sourceDate;
	private String userName;
	
	private Integer qiangdunSum;
	private Integer dadaoSum;
	private Integer qibingSum;
	private Integer zhongjiaSum;
	
	private Integer gemPointSum;
	
	private BigDecimal taxRatio = BigDecimal.ONE;

	public BigDecimal getPoinSumAfterTax(){
		return taxRatio.multiply(new BigDecimal(gemPointSum)).setScale(0,RoundingMode.DOWN);
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

	public Integer getGemPointSum() {
		return gemPointSum;
	}

	public void setGemPointSum(Integer gemPointSum) {
		this.gemPointSum = gemPointSum;
	}

	
	
}
