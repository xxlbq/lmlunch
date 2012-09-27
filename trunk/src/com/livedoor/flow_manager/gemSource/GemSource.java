package com.livedoor.flow_manager.gemSource;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.livedoor.flow_manager.gem.Gem;
import com.livedoor.flow_manager.kingdom.Kingdom;

public class GemSource {
	
	private String gemSourcId;
	private Kingdom kingdom;
	private Gem gem;
	private Integer sourceGemCount;
	private String sourceGemDate;
	
	private String inputStaffId;
	private String updateStaffId;
	private Date inputDate;
	private Date updateDate;

	private int activeFlag;
	
	
	
	

	public GemSource() {
		super();
	}

	
	
	public GemSource(String gemSourcId, Integer sourceGemCount) {
		super();
		this.gemSourcId = gemSourcId;
		this.sourceGemCount = sourceGemCount;
	}



	public GemSource(String gemSourcId) {
		super();
		this.gemSourcId = gemSourcId;
	}

	public String getGemSourcId() {
		return gemSourcId;
	}

	public void setGemSourcId(String gemSourcId) {
		this.gemSourcId = gemSourcId;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public Gem getGem() {
		return gem;
	}

	public void setGem(Gem gem) {
		this.gem = gem;
	}

	public Integer getSourceGemCount() {
		return sourceGemCount;
	}

	public void setSourceGemCount(Integer sourceGemCount) {
		this.sourceGemCount = sourceGemCount;
	}

	public String getSourceGemDate() {
		return sourceGemDate;
	}

	public void setSourceGemDate(String sourceGemDate) {
		this.sourceGemDate = sourceGemDate;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
	}

	
	
}
