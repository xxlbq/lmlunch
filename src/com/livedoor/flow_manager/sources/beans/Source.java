package com.livedoor.flow_manager.sources.beans;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils;

import com.livedoor.flow_manager.food.beans.Food;
import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.form.SourceForm;
import com.livedoor.flow_manager.tools.DateUtil;
import com.livedoor.flow_manager.tools.GetDate;
import com.livedoor.flow_manager.user.beans.User;
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

/**
 * @author xxlbq
 *
 */
/**
 * 
 * @author 		lubaoqiang <a>xxlbq@163.com</a>
 * @copyright 	2006, Moon.L(Dalian) Co.,Ltd
 * @version 	user: xxlbq
 *				date: 2007-4-4
 *              time: 下午09:09:43
 *              filename:Source.java
 *				project: permission
 *              
 *  
 * @see                   
 */
public class Source {
	
	
	/**
	 * sourceId
	 */
	private Integer sourceId;	

	/**
	 * sourceName
	 */
	private String sourceName;


	/**
	 * sourcePrice
	 */
	private BigDecimal sourceFoodPrice;
	/**
	 * sourceCount
	 */
	private Integer sourceFoodCount;
	/**
	 * sourceSum
	 */
	private BigDecimal sourceFoodSum;

	/**
	 * inputUserId ��Դ������ID
	 */
	private Integer inputUserId;

	/**
	 * inputeDatetimeԴ��������
	 */
	private Calendar inputDatetime;

	/**
	 * updateUserId
	 */
	private Integer updateUserId;

	/**
	 * updateDatetimeԴ���޸�����
	 */
	private Calendar updateDatetime;

	/**
	 * deletedFlag
	 */
	private Integer deletedFlag;

	
	
	private String inputUserName;
	
	private String updateUserName;
	
	
	private User inputUser;
	
	private User updateUser;
	
	/**
	 * sourceFoodԴ����
	 */
	private Integer sourceFood;

	private Food food;
	
	
	
	/**
	 * groupSet t_group_source
	 */
	
	private Set<Group> groupSet;

//	private String inputUserId;
	
//	private String inputUserName;
	


	

	public User getInputUser() {
		return inputUser;
	}

	public void setInputUser(User inputUser) {
		this.inputUser = inputUser;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

//	public String getInputUserName() {
//		return this.inputUserName;
//	}
	
	public String getInputUserName() {
		return this.inputUser.getUserName();
	}

	public void setInputUserName(String inputUserName) {
		this.inputUserName = inputUserName;
	}

//	public String getSourceFatherName() {
//		return sourceFatherName;
//	}
//
//	public void setSourceFatherName(String sourceFatherName) {
//		this.sourceFatherName = sourceFatherName;
//	}

	public String getUpdateUserName() {
		return this.updateUser.getUserName();
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Set<Group> getGroupSet() {
		return groupSet;
	}

	public void setGroupSet(Set<Group> groupSet) {
		this.groupSet = groupSet;
	}

	public Integer getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public Calendar getInputeDatetime() {
		return inputDatetime;
	}

	public void setInputDatetime(Calendar inputDatetime) {
		this.inputDatetime = inputDatetime;
	}

//	public Integer getInputUserId() {
//		return this.inputUserId;
//	}
	
	public Integer getInputUserId() {
		return inputUser.getUserId();
	}

	public void setInputUserId(Integer inputUserId) {
		this.inputUserId = inputUserId;
	}



	

	public BigDecimal getSourceFoodPrice() {
		return sourceFoodPrice;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Calendar getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Calendar updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Integer getUpdateUserId() {
		return updateUser.getUserId();
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 
	 * @return updateDatetime  <String>
	 */
	public String getUpdateDatetimeAsString(){
		return DateUtil.getDateStringAsYYYYMMddHHmmss(this.updateDatetime.getTime());
	}
	
	/**
	 * @return inputeDatetime  <String>
	 */
	public String getInputeDatetimeAsString(){
		return DateUtil.getDateStringAsYYYYMMddHHmmss(this.inputDatetime.getTime());
	}
	
	
	public String toString(){
		
		StringBuffer returnValue=new StringBuffer("");
		returnValue.append("sourceId = ").append(this.sourceId).append(",")
			.append("sourceName = ").append(this.sourceName).append(",")


			.append("inputUserId = ").append(this.inputUserId).append(",")
			.append("inputeDatetime = ").append(this.inputDatetime).append(",")
			.append("updateUserId = ").append(this.updateUserId).append(",")
			.append("updateDatetime = ").append(this.updateDatetime).append(",")
			.append("deletedFlag = ").append(this.deletedFlag).append(",");
			
		return returnValue.toString();
	}

	public static Source buildSourceObjectFromRequest(HttpServletRequest request){
		
		Source sobj = new Source();
		
		User inputUser = new User();

		if(StringCommonUtil.isNotEmpty(request.getParameter("inputUserId"))) 	
			inputUser.setUserId(Integer.valueOf(request.getParameter("inputUserId").trim()));
		
		User updateUser = new User();

		if(StringCommonUtil.isNotEmpty(request.getParameter("updateUserId"))) 
			updateUser.setUserId(Integer.valueOf(request.getParameter("updateUserId").trim()));
		
		if(StringCommonUtil.isNotEmpty(request.getParameter("sourceName")))
			sobj.setSourceName	(request.getParameter("sourceName").trim());
		
		if(StringCommonUtil.isNotEmpty(request.getParameter("sourceFoodId"))){
			Food food = new Food();
			sobj.setFood(food);
			sobj.setSourceFood(Integer.parseInt(request.getParameter("sourceFoodId")));
			
		}
		sobj.setInputUser	(inputUser);
		sobj.setUpdateUser	(updateUser);
		
		if(StringCommonUtil.isNotEmpty(request.getParameter("inputeDatetime")))
			sobj.setInputDatetime(GetDate.getCalendar(request.getParameter("inputeDatetime").trim()));
		
		if(StringCommonUtil.isNotEmpty(request.getParameter("updateDatetime")))
			sobj.setUpdateDatetime(GetDate.getCalendar(request.getParameter("updateDatetime").trim()));
		
		return sobj;
		
	}
	
	public static SourceForm buildSourceFormObjectFromSourceObject(Source source){
		
		SourceForm sf = new SourceForm();
		
		sf.setSourceName(source.getSourceName());
		
		if(null != source.getFood()){
			sf.setSourceFoodId((ObjectUtils.toString(source.getFood().getFoodId() ,"-1")));
		}
		
		sf.setInputUserId( source.getInputUserId() == null ? null : String.valueOf(source.getInputUserId()));
		sf.setUpdateUserId( source.getUpdateUserId() == null ? null : String.valueOf(source.getUpdateUserId()));
		sf.setInputeDatetime(GetDate.getyyyymmddStringFromCalendarObject(source.getInputeDatetime()));
		sf.setUpdateDatetime(GetDate.getyyyymmddStringFromCalendarObject(source.getUpdateDatetime()));
		
		return sf;
	}
	
	public static void buildSourceObjectFromSourceFormObject( Source updateSource,SourceForm sourceForm){
		
//		if( !UtilValidate.isEmpty(sourceForm.getSourceId())) updateSource.setSourceId( Integer.parseInt(sourceForm.getSourceId().trim()));
		
		if( StringCommonUtil.isNotEmpty(sourceForm.getSourceName())) updateSource.setSourceName(sourceForm.getSourceName().trim());
		
//		if( !UtilValidate.isEmpty(sourceForm.getSourceDesc())) updateSource.setSourceDesc(sourceForm.getSourceDesc().trim());
		
		if( ObjectCommonUtil.isNotEmpty(
				sourceForm.getSourceFoodCount())) 
			updateSource.setSourceFoodCount(Integer.parseInt(sourceForm.getSourceFoodCount().trim()));
		
		if( ObjectCommonUtil.isNotEmpty(sourceForm.getSourceFoodId())) updateSource.setSourceFood(Integer.parseInt(sourceForm.getSourceFoodId().trim()));
		
	}



	public BigDecimal getSourcFoodPrice() {
		return food.getFoodPrice();
	}

	public void setSourceFoodPrice(BigDecimal sourceFoodPrice) {
		this.sourceFoodPrice = sourceFoodPrice;
	}

	public BigDecimal getSourceFoodSum() {
		return sourceFoodSum;
	}

	public void setSourceFoodSum(BigDecimal sourceFoodSum) {
		this.sourceFoodSum = sourceFoodSum;
	}

	
	
	//many to one
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	

	public Integer getSourceFood() {
		return food.getFoodId();
	}

	public void setSourceFood(Integer sourceFood) {
		this.food.setFoodId(sourceFood) ;
	}

	public void setSourceFoodCount(Integer sourceFoodCount) {
		this.sourceFoodCount = sourceFoodCount;
	}

	public Integer getSourceFoodCount() {
		return sourceFoodCount;
	}

	public String getSourceFoodName() {
		return food.getFoodName();
	}
	
	public String getSourceFoodPriceString(){
		return getSourcFoodPrice().toString();
	}
//	public void setSourceFoodName(String sourceFoodName) {
//		this.food = sourceFoodName;
//	}

	public Calendar getInputDatetime() {
		return inputDatetime;
	}

}
