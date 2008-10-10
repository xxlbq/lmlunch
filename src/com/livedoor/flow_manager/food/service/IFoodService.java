package com.livedoor.flow_manager.food.service;

import java.util.List;

import com.livedoor.flow_manager.food.beans.Food;
import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.tools.lbq.Page;

public interface IFoodService {
	/*================= service ==========================*/
	///////////////////////////////////////////
	//		Spring Rollback Transactions Methods ---> SETUP IN XML
	///////////////////////////////////////////
	public void addFood(Food f);
	
	public void updateFood(Food f);
	
	
	public void deleteFood(Food f);
	
	public void deleteFoodByDeleteFlag(Food f);
	
	public void deleteFoodByDeleteFlag(int FoodId);
	
	
	///////////////////////////////////////////
	//		Spring ReadOnly Transactions Methods   ---> SETUP IN XML
	///////////////////////////////////////////
	
	public Food getFoodByFoodId(Integer FoodId);
	
	@SuppressWarnings("unchecked")
	public List<Food> getFoodByFoodName(String FoodName);
	
	public List<Food> getFoodListByCriteriaQueryFood(final Food f);
	
	public List<Food> getFoodListByCriteriaQueryFood(final Food f,final Page page);
	

	@SuppressWarnings("unchecked")
	public List<Food> queryAllFood();
	
	public List<Food> queryAllFood(final Page page);

	public int getFoodCount();
	
	public int getFoodCount(final Food f);
	///////////////////////////////////////////
	//		Get Mapping Collection Method  ---> Mapping in hibernate XML
	///////////////////////////////////////////
	
	public List<Group> getGroupsByFood(Food f);

	
}
