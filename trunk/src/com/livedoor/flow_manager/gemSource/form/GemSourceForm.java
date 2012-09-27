package com.livedoor.flow_manager.gemSource.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessages;

import com.livedoor.flow_manager.gem.Gem;
import com.livedoor.flow_manager.kingdom.Kingdom;

public class GemSourceForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3231455918646328661L;
	private String gemSourcId;
	
	private Integer kingdomId;
	private String kingdomDisplayName;
	
	private Integer gemId;
	private String gemName;
	
	private Integer sourceGemCount;
	private String sourceGemDate;
	
	private String inputStaffId;
	private String updateStaffId;
	private Date inputDate;
	private Date updateDate;

	private int activeFlag;
	
	
	
	

	public GemSourceForm() {
		super();
	}

	public GemSourceForm(String gemSourcId) {
		super();
		this.gemSourcId = gemSourcId;
	}

	
	
	
	
	public String getKingdomDisplayName() {
		return kingdomDisplayName;
	}

	public void setKingdomDisplayName(String kingdomDisplayName) {
		this.kingdomDisplayName = kingdomDisplayName;
	}

	public String getGemName() {
		return gemName;
	}

	public void setGemName(String gemName) {
		this.gemName = gemName;
	}

	public String getGemSourcId() {
		return gemSourcId;
	}

	public void setGemSourcId(String gemSourcId) {
		this.gemSourcId = gemSourcId;
	}



	public Integer getKingdomId() {
		return kingdomId;
	}

	public void setKingdomId(Integer kingdomId) {
		this.kingdomId = kingdomId;
	}

	public Integer getGemId() {
		return gemId;
	}

	public void setGemId(Integer gemId) {
		this.gemId = gemId;
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
		StringBuilder builder = new StringBuilder();
		builder.append("GemSourceForm [gemSourcId=");
		builder.append(gemSourcId);
		builder.append(", kingdomId=");
		builder.append(kingdomId);
		builder.append(", gemId=");
		builder.append(gemId);
		builder.append(", sourceGemCount=");
		builder.append(sourceGemCount);
		builder.append(", sourceGemDate=");
		builder.append(sourceGemDate);
		builder.append(", inputStaffId=");
		builder.append(inputStaffId);
		builder.append(", updateStaffId=");
		builder.append(updateStaffId);
		builder.append(", inputDate=");
		builder.append(inputDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", activeFlag=");
		builder.append(activeFlag);
		builder.append(", servlet=");
		builder.append(servlet);
		builder.append(", multipartRequestHandler=");
		builder.append(multipartRequestHandler);
		builder.append(", getGemSourcId()=");
		builder.append(getGemSourcId());
		builder.append(", getKingdomId()=");
		builder.append(getKingdomId());
		builder.append(", getGemId()=");
		builder.append(getGemId());
		builder.append(", getSourceGemCount()=");
		builder.append(getSourceGemCount());
		builder.append(", getSourceGemDate()=");
		builder.append(getSourceGemDate());
		builder.append(", getInputStaffId()=");
		builder.append(getInputStaffId());
		builder.append(", getUpdateStaffId()=");
		builder.append(getUpdateStaffId());
		builder.append(", getInputDate()=");
		builder.append(getInputDate());
		builder.append(", getUpdateDate()=");
		builder.append(getUpdateDate());
		builder.append(", getActiveFlag()=");
		builder.append(getActiveFlag());
		builder.append(", getServlet()=");
		builder.append(getServlet());
		builder.append(", getServletWrapper()=");
		builder.append(getServletWrapper());
		builder.append(", getMultipartRequestHandler()=");
		builder.append(getMultipartRequestHandler());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	public ActionMessages validateSourceForm() {
		// TODO Auto-generated method stub
		return new ActionMessages();
	}

	
	
}
