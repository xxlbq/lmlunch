package com.livedoor.flow_manager.food.dao.inf;

import java.util.List;

import com.livedoor.flow_manager.food.beans.Food;
import com.livedoor.flow_manager.tools.lbq.Page;

public interface IFood {

	
	
	/**
	 * @param s 
	 *
	 *	add a new Source
	 */
	void addFood(Food f);

	/**
	 * @param s
	 * 
	 * 	update a new Food
	 */
	void updateFood(Food f);

	/**
	 * @param s
	 * 
	 * 	delete a new Food
	 */
	void deleteFood(Food f);

	/**
	 * @param s
	 * 
	 * 	update a Food set deleteFlag = 1 in database
	 */
	void deleteFoodByDeleteFlag(Food f);
	
	
	/**
	 * @return List<Food>
	 * 
	 * get all Food list 
	 */
	List<Food> queryAllFood();
	
//	/**
//	 * Pagination
//	 * @param fromNumber
//	 * @param fetch
//	 * @return
//	 * 
//	 * 
//	 */
//	List<Food> queryPageFood(int begin,int fetch );
	
	List<Food> queryAllFood(Page page);

	/**
	 * @param FoodId
	 * @return
	 * 
	 * get Food by given Food id
	 */
	Food getFoodByFoodId(Integer foodId);
	
	/**
	 * @param FoodName
	 * @return
	 * 
	 * query Food by given Food name
	 */
	List<Food> getFoodByFoodName(String foodName);

	

	
}
