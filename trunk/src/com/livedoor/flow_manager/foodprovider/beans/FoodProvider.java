package com.livedoor.flow_manager.foodprovider.beans;


import java.util.Calendar;

public class FoodProvider {
	
	private int foodProviderId;
	private String foodProviderName;
	private String foodProviderAddress;
	private String foodProviderPhone;
	private Calendar inputDate;
	private Calendar updateDate;
	private int activeFlag;
	
	
	
	
	public String getFoodProviderAddress() {
		return foodProviderAddress;
	}
	public void setFoodProviderAddress(String foodProviderAddress) {
		this.foodProviderAddress = foodProviderAddress;
	}
	public int getFoodProviderId() {
		return foodProviderId;
	}
	public void setFoodProviderId(int foodProviderId) {
		this.foodProviderId = foodProviderId;
	}
	public String getFoodProviderName() {
		return foodProviderName;
	}
	public void setFoodProviderName(String foodProviderName) {
		this.foodProviderName = foodProviderName;
	}
	public String getFoodProviderPhone() {
		return foodProviderPhone;
	}
	public void setFoodProviderPhone(String foodProviderPhone) {
		this.foodProviderPhone = foodProviderPhone;
	}
	public Calendar getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}
	

	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Calendar getInputDate() {
		return inputDate;
	}
	public void setInputDate(Calendar inputDate) {
		this.inputDate = inputDate;
	}
	
	

}
