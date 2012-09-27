package com.livedoor.flow_manager.soldierSource.form;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.tools.DateUtil;
import com.lm.common.util.str.StringCommonUtil;

public class SoldierSourceForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2733546925657151179L;
	private String sourceId;
	private Integer userId;
	private String userName;
	
	private int sourceSoldierId;
	private String sourceSoldierName;
	
	private BigDecimal sourceSoliderCount;

	private int kingdomId;
	private String kingdomDisplayName;
	
	private int sourceSoliderSumCount;
	private int approved;
	private String sourceDate;
	private String inputStaffId;
	private String updateStaffId;
	private Date inputDate;
	private Date updateDate;

	private int activeFlag;
	private String userDisplayName;
	
	
	
	
	
	public String getSourceSoldierName() {
		return sourceSoldierName;
	}

	public void setSourceSoldierName(String sourceSoldierName) {
		this.sourceSoldierName = sourceSoldierName;
	}

	public String getKingdomDisplayName() {
		return kingdomDisplayName;
	}

	public void setKingdomDisplayName(String kingdomDisplayName) {
		this.kingdomDisplayName = kingdomDisplayName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public int getKingdomId() {
		return kingdomId;
	}

	public void setKingdomId(int kingdomId) {
		this.kingdomId = kingdomId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getSourceSoldierId() {
		return sourceSoldierId;
	}

	public void setSourceSoldierId(int sourceSoldierId) {
		this.sourceSoldierId = sourceSoldierId;
	}



	public BigDecimal getSourceSoliderCount() {
		return sourceSoliderCount;
	}

	public void setSourceSoliderCount(BigDecimal sourceSoliderCount) {
		this.sourceSoliderCount = sourceSoliderCount;
	}

	public int getSourceSoliderSumCount() {
		return sourceSoliderSumCount;
	}

	public void setSourceSoliderSumCount(int sourceSoliderSumCount) {
		this.sourceSoliderSumCount = sourceSoliderSumCount;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public String getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(String sourceDate) {
		this.sourceDate = sourceDate;
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


	public SoldierSourceForm() {
		super();
	}

	
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public ActionMessages validateSourceForm(){
		
		ActionMessages actionMessages = new ActionMessages();
		
//		if( StringCommonUtil.isNotEmpty(sf.getInputeDatetime()) ){
//			
//			if( !DateUtil.isNumericDateIfExist(sf.getInputeDatetime().trim()) ){
//				actionMessages.add("source-inputTime",new ActionMessage("source.search.inputTime.error",sf.getInputeDatetime()));
//				return actionMessages;
//			}
//			
//			if( !DateUtil.isDateYYYYMMDD(sf.getInputeDatetime().trim())){
//				actionMessages.add("source-inputTime",new ActionMessage("source.search.inputTime.error",sf.getInputeDatetime()));
//				return actionMessages;
//			}	
//				
//		}
//		
//		
//		if( StringCommonUtil.isNotEmpty(sf.getUpdateDatetime()) ){
//			
//			if( !DateUtil.isNumericDateIfExist(sf.getUpdateDatetime().trim()) ){
//				actionMessages.add("source-updateTime",new ActionMessage("source.search.updateTime.error",sf.getUpdateDatetime()));
//				return actionMessages;
//			}
//			
//			if( !DateUtil.isDateYYYYMMDD(sf.getUpdateDatetime().trim())){
//				actionMessages.add("source-updateTime",new ActionMessage("source.search.updateTime.error",sf.getUpdateDatetime()));
//				return actionMessages;
//			}	
//				
//		}
		
		return actionMessages;
	}
}
