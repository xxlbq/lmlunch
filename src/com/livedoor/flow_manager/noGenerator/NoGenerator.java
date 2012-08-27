package com.livedoor.flow_manager.noGenerator;


import java.util.Date;


public class NoGenerator  {

	private String noType;

	private Integer noCount;

	private Integer activeFlag;

	private Date inputDate;

	private Date updateDate;

	
	
	public String getNoType() {
		return noType;
	}

	public void setNoType(String noType) {
		this.noType = noType;
	}

	public Integer getNoCount() {
		return noCount;
	}

	public void setNoCount(Integer noCount) {
		this.noCount = noCount;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
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


}
