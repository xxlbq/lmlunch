package com.livedoor.flow_manager.food.beans;

import java.math.BigDecimal;
import java.util.Calendar;

public class Food {
	
	private int foodId;
	private String foodName;
	private BigDecimal foodPrice;
	private int foodProviderId;
	private Calendar inputDate;
	private Calendar updateDate;
	private int deletedFlag;
	
	public Food(){}
	public Food(int foodId) {
		this.foodId=foodId;
	}
	
	public int getFoodProviderId() {
		return foodProviderId;
	}
	public void setFoodProviderId(int foodProviderId) {
		this.foodProviderId = foodProviderId;
	}
	public int getFoodProvider() {
		return foodProviderId;
	}
	public void setFoodProvider(int foodProvider) {
		this.foodProviderId = foodProvider;
	}
	public Calendar getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}
	public int getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(int deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public BigDecimal getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(BigDecimal foodPrice) {
		this.foodPrice = foodPrice;
	}
	public Calendar getInputDate() {
		return inputDate;
	}
	public void setInputDate(Calendar inputDate) {
		this.inputDate = inputDate;
	}
	
	

}
