package com.livedoor.flow_manager.foodprovider.dao.imp;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.livedoor.flow_manager.food.beans.Food;
import com.livedoor.flow_manager.food.dao.inf.IFood;
import com.livedoor.flow_manager.generic.dao.GenericDAOHibernateImpl;
import com.livedoor.flow_manager.tools.lbq.Page;
import com.lm.common.util.obj.ObjectCommonUtil;
import com.lm.common.util.str.StringCommonUtil;

public class FoodDao extends GenericDAOHibernateImpl implements IFood{

	private final static Logger log = Logger.getLogger(FoodDao.class);
	
	public void addFood(Food f) {
		save(f);
	}

	public void deleteFood(Food f) {
		delete(f);		//	HibernateTemplate().delete()		
	}

	public void deleteFoodByDeleteFlag(Food f) {
		f.setDeletedFlag(1);
		update(f);		//HibernateTemplate().update()		
	}

	public void deleteSourceByDeleteFlag(int foodId){

		Food food = getFoodByFoodId(foodId);
		food.setDeletedFlag(1);
		update(food);		//HibernateTemplate().update()
	}
	
	public Food getFoodByFoodId(Integer foodId) {
		return (Food)get(Food.class, foodId);	//HibernateTemplate().get()
	}

	public List<Food> getFoodByFoodName(String foodName) {
		String hql = "from com.livedoor.flow_manager.food.beans.Food as f where f.sourceName like ? and f.deletedFlag <> 1";
		return query(hql, "%" + foodName + "%");
	}


	public List<Food> queryAllFood() {
		return query("from com.livedoor.flow_manager.food.beans.Food as f where f.deletedFlag <> 1");
	}

	public List<Food> queryAllFood(final Page page) {

		return (List<Food>)getHibernateTemplate().execute(
			    new HibernateCallback() {
			        public Object doInHibernate(Session session) throws HibernateException {
			        	String querySentence = "from com.livedoor.flow_manager.food.beans.Food f " +
			        			" where f.deletedFlag <> 1";	
			        	Query query = session.createQuery(querySentence);
			    		query	.setFirstResult(page.getBeginIndex()-1)
			    				.setMaxResults(page.getPageSize())
			    				//此处使用Source的cache
//			    				.setCacheable(true)
//			    				.setCacheRegion("com.livedoor.flow_manager.sources.beans.Source")
			    				//
			    				;
			    		return query.list();
			        }
			    }
			,true);
	}

	public void updateFood(Food f) {
		update(f);		//HibernateTemplate().update()	
	}
	
	public int getFoodCount() throws HibernateException {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Food.class);
		
		return queryRowCount(detachedCriteria);
	}
	
	
	public int getFoodCount(final Food food) throws HibernateException {
		
		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Food.class);
		
//		return queryRowCount(detachedCriteria);
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				buildCriteriaFromFoodObject(criteria, food);
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				return totalCount;
			}
		}, true);
	}
	
	private boolean buildCriteriaFromFoodObject(Criteria cr,Food food){
		try{
		if ( ObjectCommonUtil.isNotEmpty(food) ){
			
			if (StringCommonUtil.isNotEmpty(food.getFoodName())){
				cr.add(Restrictions.like("foodName", "%" + food.getFoodName()+ "%"));
			}
			
			if(ObjectCommonUtil.isNotEmpty(food.getFoodPrice())){
				cr.add(Restrictions.eq("foodPrice", food.getFoodPrice()));
			}
	
//			if (!UtilValidate.isEmpty(food.getSourceDesc()))
//	
//				cr.add(Restrictions.like("sourceDesc", "%" + food.getSourceDesc()+ "%"));
//	
//			if (!UtilValidate.isEmpty(food.getInputUserId()))
//	
//				cr.add(Restrictions.eq("inputUser", food.getInputUser()));
//			
//			if (!UtilValidate.isEmpty(food.getUpdateUserId()))
//	
//				cr.add(Restrictions.eq("updateUser", food.getUpdateUser()));
//			
//			
			if (ObjectCommonUtil.isNotEmpty(food.getInputDate())) {
	
				Calendar end = (Calendar) BeanUtils.cloneBean(food.getInputDate());
	
				end.add(Calendar.DAY_OF_MONTH, 1);
	
				cr.add(Restrictions.between("inputDate", food.getInputDate(), end));
			}
//	
//			if (!UtilValidate.isEmpty(food.getUpdateDatetime())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(food.getUpdateDatetime());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("updateDatetime", food.getUpdateDatetime(), end));
//			}
		}
		
		cr.add(Restrictions.ne("deletedFlag", 1));
		
		
		
		}catch(Exception e){
			log.error("buildCriteriaFromSourceObject() error ! ",e);
			return false;
		}
		
		return true;
		
	}
}
