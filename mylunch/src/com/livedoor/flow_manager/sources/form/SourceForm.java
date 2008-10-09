package com.livedoor.flow_manager.sources.form;

import java.math.BigDecimal;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.livedoor.flow_manager.tools.DateUtil;
import com.lm.common.util.str.StringCommonUtil;

public class SourceForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1147582656262606617L;

	/**
	 * sourceId 
	 * */
	private String sourceId;	

	/**
	 * sourceName
	 * */
	private String sourceName;



	/**
	 * inputUserId ��Դ������ID
	 */
	private String inputUserId;

	/**
	 * inputeDatetime ��Դ��������
	 */
	private String inputeDatetime;

	/**
	 * updateUserId ��Դ���޸���ID
	 */
	private String updateUserId;

	/**
	 * updateDatetime ��Դ���޸�����
	 */
	private String updateDatetime;

	/**
	 * deletedFlag
	 * */
	private String deletedFlag;

	/**
	 * sourceDesc ��Դ����
	 */
	private String sourceFood;
	
	private BigDecimal sourceFoodPrice;
	
	private String sourceFoodId;
	
	private String sourceFoodCount;
	
	
	private String testStrustCheckbox1;
	private String testStrustCheckbox2;
	
	

	//	inputUserId->name
	private String inputUserName;
	//	updateUserId->name
	private String updateUserName;
	

	public String getInputUserName() {
		return inputUserName;
	}


	public void setInputUserName(String inputUserName) {
		this.inputUserName = inputUserName;
	}


	public String getUpdateUserName() {
		return updateUserName;
	}


	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}


	public String getDeletedFlag() {
		return deletedFlag;
	}


	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}


	public String getInputeDatetime() {
		return inputeDatetime;
	}


	public void setInputeDatetime(String inputeDatetime) {
		this.inputeDatetime = inputeDatetime;
	}


	public String getInputUserId() {
		return inputUserId;
	}


	public void setInputUserId(String inputUserId) {
		this.inputUserId = inputUserId;
	}


	public String getSourceId() {
		return sourceId;
	}


	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}


	public String getSourceName() {
		return sourceName;
	}


	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}


	public String getUpdateDatetime() {
		return updateDatetime;
	}


	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}


	public String getUpdateUserId() {
		return updateUserId;
	}


	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}


	public String toString(){
		
		StringBuffer returnValue=new StringBuffer("");
		returnValue.append("sourceId = ").append(this.sourceId).append(",")
			.append("sourceName = ").append(this.sourceName).append(",")

			.append("inputUserId = ").append(this.inputUserId).append(",")
			.append("inputeDatetime = ").append(this.inputeDatetime).append(",")
			.append("updateUserId = ").append(this.updateUserId).append(",")
			.append("updateDatetime = ").append(this.updateDatetime).append(",")
			.append("deletedFlag = ").append(this.deletedFlag).append(",")
			;
			
		return returnValue.toString();
	}
	
	public static ActionMessages validateSourceForm(SourceForm sf){
		
		ActionMessages actionMessages = new ActionMessages();
		
		if( StringCommonUtil.isNotEmpty(sf.getInputeDatetime()) ){
			
			if( !DateUtil.isNumericDateIfExist(sf.getInputeDatetime().trim()) ){
				actionMessages.add("source-inputTime",new ActionMessage("source.search.inputTime.error",sf.getInputeDatetime()));
				return actionMessages;
			}
			
			if( !DateUtil.isDateYYYYMMDD(sf.getInputeDatetime().trim())){
				actionMessages.add("source-inputTime",new ActionMessage("source.search.inputTime.error",sf.getInputeDatetime()));
				return actionMessages;
			}	
				
		}
		
		
		if( StringCommonUtil.isNotEmpty(sf.getUpdateDatetime()) ){
			
			if( !DateUtil.isNumericDateIfExist(sf.getUpdateDatetime().trim()) ){
				actionMessages.add("source-updateTime",new ActionMessage("source.search.updateTime.error",sf.getUpdateDatetime()));
				return actionMessages;
			}
			
			if( !DateUtil.isDateYYYYMMDD(sf.getUpdateDatetime().trim())){
				actionMessages.add("source-updateTime",new ActionMessage("source.search.updateTime.error",sf.getUpdateDatetime()));
				return actionMessages;
			}	
				
		}
		
		return actionMessages;
	}


	public String getSourceFood() {
		return sourceFood;
	}


	public void setSourceFood(String sourceFood) {
		this.sourceFood = sourceFood;
	}


	public String getSourceFoodId() {
		return sourceFoodId;
	}


	public void setSourceFoodId(String sourceFoodId) {
		this.sourceFoodId = sourceFoodId;
	}


	public BigDecimal getSourceFoodPrice() {
		return sourceFoodPrice;
	}


	public void setSourceFoodPrice(BigDecimal sourceFoodPrice) {
		this.sourceFoodPrice = sourceFoodPrice;
	}


	public String getSourceFoodCount() {
		return sourceFoodCount;
	}


	public void setSourceFoodCount(String sourceFoodCount) {
		this.sourceFoodCount = sourceFoodCount;
	}


	public String getTestStrustCheckbox1() {
		return testStrustCheckbox1;
	}


	public void setTestStrustCheckbox1(String testStrustCheckbox1) {
		this.testStrustCheckbox1 = testStrustCheckbox1;
	}


	public String getTestStrustCheckbox2() {
		return testStrustCheckbox2;
	}


	public void setTestStrustCheckbox2(String testStrustCheckbox2) {
		this.testStrustCheckbox2 = testStrustCheckbox2;
	}
	
	

}
