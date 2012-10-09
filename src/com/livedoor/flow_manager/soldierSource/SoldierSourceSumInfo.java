package com.livedoor.flow_manager.soldierSource;

import java.math.BigDecimal;

import com.livedoor.flow_manager.tools.BigDecimalTools;

public class SoldierSourceSumInfo {
	
	private String kingdomName;
	private String sourceDate;
	private String userName;
	
	private BigDecimal qiangdunSum =BigDecimal.ZERO;
	private BigDecimal dadaoSum = BigDecimal.ZERO;
	private BigDecimal qibingSum = BigDecimal.ZERO;
	private BigDecimal zhongjiaSum = BigDecimal.ZERO;
	
	private BigDecimal gangshaoSum = BigDecimal.ZERO;
	private BigDecimal jianglingSum = BigDecimal.ZERO;
	
	
	private BigDecimal soldierPointSum = BigDecimal.ZERO;
	
	private BigDecimal taxRatio = BigDecimal.ONE;

	private BigDecimal gemPointPerSoldier =BigDecimal.ZERO;

	
	public BigDecimal getGemPointSumAfterTax() {
		return BigDecimalTools.roundingDownToInt(gemPointPerSoldier.multiply(getSoldierPointSumAfterTax()));
	}
	
	public BigDecimal getGemPointSum() {
		return BigDecimalTools.roundingDownToInt(gemPointPerSoldier.multiply(soldierPointSum));
	}
	
	public BigDecimal getSoldierPointSum() {
		return BigDecimalTools.roundingDownToInt(soldierPointSum);
	}

	public void setSoldierPointSum(BigDecimal soldierPointSum) {
		this.soldierPointSum = soldierPointSum;
	}

	public BigDecimal getGemPointPerSoldier() {
		return gemPointPerSoldier;
	}

	public void setGemPointPerSoldier(BigDecimal gemPointPerSoldier) {
		this.gemPointPerSoldier = gemPointPerSoldier;
	}

	public BigDecimal getSoldierPointSumAfterTax(){
		return BigDecimalTools.roundingDownToInt(taxRatio.multiply(soldierPointSum));
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

	public BigDecimal getQiangdunSum() {
		return BigDecimalTools.roundingDownToInt(qiangdunSum);
	}

	public void setQiangdunSum(BigDecimal qiangdunSum) {
		this.qiangdunSum = qiangdunSum;
	}

	public BigDecimal getDadaoSum() {
		return BigDecimalTools.roundingDownToInt(dadaoSum);
	}

	public void setDadaoSum(BigDecimal dadaoSum) {
		this.dadaoSum = dadaoSum;
	}

	public BigDecimal getQibingSum() {
		return BigDecimalTools.roundingDownToInt(qibingSum);
	}

	public void setQibingSum(BigDecimal qibingSum) {
		this.qibingSum = qibingSum;
	}

	public BigDecimal getZhongjiaSum() {
		return BigDecimalTools.roundingDownToInt(zhongjiaSum);
	}

	public void setZhongjiaSum(BigDecimal zhongjiaSum) {
		this.zhongjiaSum = zhongjiaSum;
	}

	public BigDecimal getGangshaoSum() {
		return gangshaoSum;
	}

	public void setGangshaoSum(BigDecimal gangshaoSum) {
		this.gangshaoSum = gangshaoSum;
	}

	public BigDecimal getJianglingSum() {
		return jianglingSum;
	}

	public void setJianglingSum(BigDecimal jianglingSum) {
		this.jianglingSum = jianglingSum;
	}

	public BigDecimal getGangshaoJiangling(){
		return BigDecimalTools.roundingDownToInt(getGangshaoSum().add(getJianglingSum()));
	}
	
	public BigDecimal getFinalSum(){
		return BigDecimalTools.roundingDownToInt(
				getGemPointSumAfterTax().add( getGangshaoSum() ).add(getJianglingSum()));
	}
}
