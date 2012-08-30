package com.livedoor.flow_manager.gem;

import java.math.BigDecimal;
import java.util.Date;

public class Gem {
	
	private Integer gemId;
	private String	gemDisplayName;
	private BigDecimal gemPoint;
	private String inputStaffId;
	private String updateStaffId;
	private Date inputDate;
	private Date updateDate;

	private int activeFlag;

	
	
	
	
	public Gem() {
		super();
	}

	public Gem(Integer gemId) {
		super();
		this.gemId = gemId;
	}

	public Integer getGemId() {
		return gemId;
	}

	public void setGemId(Integer gemId) {
		this.gemId = gemId;
	}

	public String getGemDisplayName() {
		return gemDisplayName;
	}

	public void setGemDisplayName(String gemDisplayName) {
		this.gemDisplayName = gemDisplayName;
	}



	public BigDecimal getGemPoint() {
		return gemPoint;
	}

	public void setGemPoint(BigDecimal gemPoint) {
		this.gemPoint = gemPoint;
	}

	public String getInputStaffId() {
		return inputStaffId;
	}

	public void setInputStaffId(String inputStaffId) {
		this.inputStaffId = inputStaffId;
	}

	public String getUpdateStaffId() {
		return updateStaffId;
	}

	public void setUpdateStaffId(String updateStaffId) {
		this.updateStaffId = updateStaffId;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	

}
