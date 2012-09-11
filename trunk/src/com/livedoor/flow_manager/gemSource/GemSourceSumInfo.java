package com.livedoor.flow_manager.gemSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GemSourceSumInfo {

	
	private String kongdomName;
	private String gemSourceDate;
	
	private BigDecimal xiuluoSum = BigDecimal.ZERO;
	private BigDecimal benleiSum= BigDecimal.ZERO;
	private BigDecimal	fangyuSum= BigDecimal.ZERO;
	private BigDecimal jifengSum= BigDecimal.ZERO;
	private BigDecimal fuzaiSum= BigDecimal.ZERO;
	
	private BigDecimal 	xiuluoPointSum= BigDecimal.ZERO;
	private BigDecimal 	benleiPointSum= BigDecimal.ZERO;
	private BigDecimal	fangyuPointSum= BigDecimal.ZERO;
	private BigDecimal 	jifengPointSum= BigDecimal.ZERO;
	private BigDecimal 	fuzaiPointSum= BigDecimal.ZERO;
	
	/**
	 * FOR EXAMPLE : 70%
	 */
	private BigDecimal taxRatio = BigDecimal.ONE;
	
	
	public BigDecimal getAllDiamondPointSum() {
		return xiuluoPointSum.add(benleiPointSum)
			.add(fangyuPointSum)
			.add(jifengPointSum)
			.add(fuzaiPointSum);
	}
	
	public BigDecimal getAllDiamondPointSumAfterTaxRatio(){
		return taxRatio.multiply(getAllDiamondPointSum()).setScale(0, RoundingMode.DOWN);
	}
	
	public BigDecimal getXiuluoPointSum() {
		return xiuluoPointSum;
	}
	public void setXiuluoPointSum(BigDecimal xiuluoPointSum) {
		this.xiuluoPointSum = xiuluoPointSum;
	}
	public BigDecimal getBenleiPointSum() {
		return benleiPointSum;
	}
	public void setBenleiPointSum(BigDecimal benleiPointSum) {
		this.benleiPointSum = benleiPointSum;
	}
	public BigDecimal getFangyuPointSum() {
		return fangyuPointSum;
	}
	public void setFangyuPointSum(BigDecimal fangyuPointSum) {
		this.fangyuPointSum = fangyuPointSum;
	}
	public BigDecimal getJifengPointSum() {
		return jifengPointSum;
	}
	public void setJifengPointSum(BigDecimal jifengPointSum) {
		this.jifengPointSum = jifengPointSum;
	}
	public BigDecimal getFuzaiPointSum() {
		return fuzaiPointSum;
	}
	public void setFuzaiPointSum(BigDecimal fuzaiPointSum) {
		this.fuzaiPointSum = fuzaiPointSum;
	}
	public BigDecimal getTaxRatio() {
		return taxRatio;
	}
	public void setTaxRatio(BigDecimal taxRatio) {
		this.taxRatio = taxRatio;
	}
	public String getGemSourceDate() {
		return gemSourceDate;
	}
	public void setGemSourceDate(String gemSourceDate) {
		this.gemSourceDate = gemSourceDate;
	}
	public String getKongdomName() {
		return kongdomName;
	}
	public void setKongdomName(String kongdomName) {
		this.kongdomName = kongdomName;
	}
	public BigDecimal getXiuluoSum() {
		return xiuluoSum;
	}
	public void setXiuluoSum(BigDecimal xiuluoSum) {
		this.xiuluoSum = xiuluoSum;
	}
	public BigDecimal getBenleiSum() {
		return benleiSum;
	}
	public void setBenleiSum(BigDecimal benleiSum) {
		this.benleiSum = benleiSum;
	}
	public BigDecimal getFangyuSum() {
		return fangyuSum;
	}
	public void setFangyuSum(BigDecimal fangyuSum) {
		this.fangyuSum = fangyuSum;
	}
	public BigDecimal getJifengSum() {
		return jifengSum;
	}
	public void setJifengSum(BigDecimal jifengSum) {
		this.jifengSum = jifengSum;
	}
	public BigDecimal getFuzaiSum() {
		return fuzaiSum;
	}
	public void setFuzaiSum(BigDecimal fuzaiSum) {
		this.fuzaiSum = fuzaiSum;
	}
	
}
