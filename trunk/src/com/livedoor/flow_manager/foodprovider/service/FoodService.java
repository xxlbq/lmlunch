package com.livedoor.flow_manager.foodprovider.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.livedoor.flow_manager.food.beans.Food;
import com.livedoor.flow_manager.food.dao.imp.FoodDao;
import com.livedoor.flow_manager.food.exception.FoodExcption;
import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.sources.service.SourceService;
import com.livedoor.flow_manager.tools.lbq.Page;

public class FoodService implements IFoodService{

private final static Logger log = Logger.getLogger(SourceService.class);
	
	private FoodDao foodDao;
	
//	public FoodDao getFoodDao() {
//		return foodDao;
//	}

	public void setFoodDao(FoodDao foodDao) {
		this.foodDao = foodDao;
	}

	
	
	public void addFood(Food f) {
		try {
			foodDao.save(f);
		
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In addFood() method ]++++++",e);
			throw new FoodExcption(1000,"addFood() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%%[Other Exception In  addFood() method ]%%%%%%%",e);
			throw new FoodExcption(9999,"addFood() error! :"+e.getMessage());
		}	
	}

	public void deleteFood(Food f) {
		try {
			foodDao.delete(f);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In deleteFood() method ]++++++",e);
			throw new FoodExcption(1002,"deleteFood() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  deleteFood() method ]%%%%%%%",e);
			throw new FoodExcption(9999,"deleteFood() error! :"+e.getMessage());
		}	
	}

	public void deleteFoodByDeleteFlag(Food f) {
		f.setDeletedFlag(1);
		updateFood(f);
	}

	public void deleteFoodByDeleteFlag(int FoodId) {
		Food food = getFoodByFoodId(FoodId);
		food.setDeletedFlag(1);
		updateFood(food);
	}

	public Food getFoodByFoodId(Integer FoodId) {
		Food f = null;
		try {
			f = (Food)foodDao.get(Food.class, FoodId);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getFoodByFoodId(Integer FoodId) method ]++++++",e);
			throw new FoodExcption(1003,"getFoodByFoodId(Integer FoodId) error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getFoodByFoodId(Integer FoodId) method ]%%%%%%%",e);
			throw new FoodExcption(9999,"getFoodByFoodId(Integer FoodId) error! :"+e.getMessage());
		}
		return f;	
	}

	public List<Food> getFoodByFoodName(String foodName) {
		List<Food> sList = null;
		try {
			sList = foodDao.getFoodByFoodName(foodName);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In getFoodByFoodName method ]++++++",e);
			throw new FoodExcption(1004,"getFoodByFoodName() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%[Other Exception In  getFoodByFoodName method ]%%%%%%%",e);
			throw new FoodExcption(9999,"getFoodByFoodName() error! :"+e.getMessage());
		}
		return sList;
	}

	public int getFoodCount() {
		
		int count = -1 ;
		try {
			count= foodDao.getFoodCount();
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In getFoodCount() method ]++++++",he);
			throw new FoodExcption(1005,"getFoodCount() error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getFoodCount() method ]++++++",e);
			throw new FoodExcption(9999,"getFoodCount() error! :"+e.getMessage());
		}
        return count;
	}

	public int getFoodCount(Food f) {
		int count = -1 ;
		
		try {
			count= foodDao.getFoodCount(f);
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In getFoodCount(Food) method ]++++++",he);
			throw new FoodExcption(1005,"getFoodCount(Food) error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In getFoodCount(Food) method ]++++++",e);
			throw new FoodExcption(9999,"getFoodCount(Food) error! :"+e.getMessage());
		}

        return count;
	}

	public List<Food> getFoodListByCriteriaQueryFood(Food f, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Food> getFoodListByCriteriaQueryFood(Food f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Group> getGroupsByFood(Food f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Food> queryAllFood() {
		List<Food> sList = null;
		try {
			sList= foodDao.queryAllFood();
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In queryAllFood() method ]++++++",he);
			throw new FoodExcption(1004,"queryAllFood() error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In queryAllFood() method ]++++++",e);
			throw new FoodExcption(9999,"queryAllFood() error! :"+e.getMessage());
		}
		return sList;
	}

	public List<Food> queryAllFood(final Page page) {
		List<Food> sList = null;
		try {
			sList= foodDao.queryAllFood(page);
			
		} catch (DataAccessException he){
			log.error("+++@_@+++[ DataAccessException In queryAllFood(final Page page) method ]++++++",he);
			throw new FoodExcption(1004,"queryAllFood(final Page page) error! :"+he.getMessage());
		} catch (Exception e) {
			log.error("+++@_@+++[ Other Exception In queryAllFood(final Page page) method ]++++++",e);
			throw new FoodExcption(9999,"queryAllFood(final Page page) error! :"+e.getMessage());
		}
		return sList;
	}

	public void updateFood(Food f) {
		try {
			foodDao.update(f);
		} catch (DataAccessException e) {
			log.error("+++@_@+++[ DataAccessException In updateFood() method ]++++++",e);
			throw new FoodExcption(1001,"updateFood() error! :"+e.getMessage());
		} catch (Exception e){
			log.error("%%%@_@%%%%[Other Exception In  updateFood() method ]%%%%%%%",e);
			throw new FoodExcption(9999,"updateFood() error! :"+e.getMessage());
		}	
	}

	
}
