package com.livedoor.flow_manager.role.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.livedoor.flow_manager.generic.dao.GenericDAOHibernateImpl;
import com.livedoor.flow_manager.roleAction.beans.RoleAction;
import com.livedoor.flow_manager.roleAuth.beans.RoleAuthority;
import com.livedoor.flow_manager.roleAuth.beans.RoleAuthorityId;

public class RoleDao extends GenericDAOHibernateImpl{
	private final static Logger log = Logger.getLogger(RoleDao.class);
	
//	public void addFood(Food f) {
//		save(f);
//	}
//
//	public void deleteFood(Food f) {
//		delete(f);		//	HibernateTemplate().delete()		
//	}
//
//	public void deleteFoodByDeleteFlag(Food f) {
//		f.setDeletedFlag(1);
//		update(f);		//HibernateTemplate().update()		
//	}
//
//	public void deleteSourceByDeleteFlag(int foodId){
//
//		Food food = getFoodByFoodId(foodId);
//		food.setDeletedFlag(1);
//		update(food);		//HibernateTemplate().update()
//	}
	
	public RoleAction getRoleAction(String menuSeq) {
		return (RoleAction)get(RoleAction.class, menuSeq);	//HibernateTemplate().get()
	}

	
	public RoleAuthority getRoleAuthority(int roleId,String menuSeq) {
		RoleAuthorityId id = new RoleAuthorityId(roleId,menuSeq);
		
		return (RoleAuthority)get(RoleAction.class, id);	//HibernateTemplate().get()
	}
	
	
//	public String getParentMenuSeq(String url){
//		String sql = "SELECT CASE WHEN PARENT_MENU_SEQ IS NULL THEN NULL ELSE PARENT_MENU_SEQ END " +
//				" FROM t_role_action WHERE INSTR(ROLE_ACTION_URL,'"+url+"') > 0";
//		List menuString = queryWithSQL(getHibernateTemplate(), sql);
//		
//		if(menuString == null) return null;
//		String aaa = menuString.get(0).toString();
//		System.out.println(" =================== menu Strng : "+aaa );
//		return aaa;
//	}

	
	public List getRootMenu(int roleId, String uri){
		
		
		//select some field
//		String SQL = " SELECT new list(ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder ) " +
//			  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT ," +
//			  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT  " +
//			  " WHERE AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq IS NULL ";
//		
		//select all field
		String SQL = " SELECT new RoleAction(ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder ) " +
		  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT ," +
		  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT  " +
		  " WHERE AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq IS NULL ORDER BY ACT.displayOrder ASC ";
		
		
		
		
//		String SQL = " SELECT ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder  " +
//		  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT      LEFT OUTER JOIN " +
//		  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT  " +
//		  " WHEREQ` AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq IS NULL ";
		
		System.out.println(" hib8 cache :"+getHibernateTemplate().getQueryCacheRegion());
		
		
	    return getHibernateTemplate().findByNamedParam(SQL, new String[]{"varRoleId","varSelectedFlag"}, new Object[]{new Integer(roleId),new Integer(1)});
       
	}
	
	public List<RoleAction> getSonMenu(int roleId,String uri){

	    String SQL = " SELECT new RoleAction(ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder ) " +
			  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT ," +
			  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT " +
			  " WHERE AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq =(" +
			  "SELECT roleAct.parentMenuSeq FROM RoleAction AS  roleAct WHERE INSTR(roleActionUrl,:varActionUrl) > 0) ORDER BY ACT.displayOrder ASC ";

	
//	    String SQL = " SELECT new list(ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder ) " +
//		  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT ," +
//		  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT " +
//		  " WHERE AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq =(" +
//		  "SELECT roleAct.parentMenuSeq FROM RoleAction AS  roleAct WHERE INSTR(roleActionUrl,:varActionUrl) > 0) ";
	    
	    String SQL2 = " SELECT new RoleAction(ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder ) " +
		  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT ," +
		  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT " +
		  " WHERE AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq =:varMenuSeq   ORDER BY ACT.displayOrder ASC "  ;

	    
	    
//	    String SQL2 = " SELECT new list(ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder ) " +
//		  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT ," +
//		  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT " +
//		  " WHERE AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq =:varMenuSeq" ;

	    
		
//	    String SQL = " SELECT ACT.menuSeq,ACT.roleActionUrl,ACT.roleActionName,ACT.displayOrder  " +
//		  " FROM  com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT      LEFT OUTER JOIN " +
//		  "       com.livedoor.flow_manager.roleAuth.beans.RoleAuthority AS AUT " +
//		  " WHERE AUT.id.menuSeq =ACT.menuSeq AND AUT.id.roleId = :varRoleId AND AUT.selectedFlag=:varSelectedFlag AND ACT.parentMenuSeq =(SELECT roleAct.parentMenuSeq FROM RoleAction AS  roleAct WHERE INSTR(roleActionUrl,':varActionUrl') > 0) ";

	    RoleAction ra = getPmenuSeq(uri) ;   
	    
	    if (null == ra ) {
	    	return new ArrayList<RoleAction>();
		} else {
			if( null == ra.getParentMenuSeq()){
				return getHibernateTemplate().findByNamedParam(SQL2, new String[]{"varRoleId","varSelectedFlag","varMenuSeq"}, new Object[]{new Integer(roleId),new Integer(1),  ra.getMenuSeq()});
			}
			
			
			
			return getHibernateTemplate().findByNamedParam(SQL, new String[]{"varRoleId","varSelectedFlag","varActionUrl"}, new Object[]{new Integer(roleId),new Integer(1),uri});	
		}
	} 
	
	
	
	private RoleAction getPmenuSeq(String url){
		String SQL  = "FROM   com.livedoor.flow_manager.roleAction.beans.RoleAction AS ACT WHERE INSTR(roleActionUrl,:varActionUrl) > 0  ";
		
		List list =  getHibernateTemplate().findByNamedParam(SQL, "varActionUrl", url);
		
		RoleAction ra = null;  
		
		if(null != list && list.size() >0 ){
			
			ra= (RoleAction)list.get(0);
		}
		
		
//		if((null != list || list.size() >0 )){
//			rt = (String)list.get(0);
//		}
		
		
		
		
		
		return ra;
	}
	
	
//	public List<RoleAction> getInitRootMenu(int roleId,String uri){
//		return ( List<RoleAction> )getHibernateTemplate()
//			.findByNamedParam("FROM ", paramName, value);
//	}
	
//	public List<Food> getFoodByFoodName(String foodName) {
//		String hql = "from com.livedoor.flow_manager.food.beans.Food as f where f.sourceName like ? and f.deletedFlag <> 1";
//		return query(hql, "%" + foodName + "%");
//	}
//
//
//	public List<Food> queryAllFood() {
//		return query("from com.livedoor.flow_manager.food.beans.Food as f where f.deletedFlag <> 1");
//	}
//
//	public List<Food> queryAllFood(final Page page) {
//
//		return (List<Food>)getHibernateTemplate().execute(
//			    new HibernateCallback() {
//			        public Object doInHibernate(Session session) throws HibernateException {
//			        	String querySentence = "from com.livedoor.flow_manager.food.beans.Food f " +
//			        			" where f.deletedFlag <> 1";	
//			        	Query query = session.createQuery(querySentence);
//			    		query	.setFirstResult(page.getBeginIndex()-1)
//			    				.setMaxResults(page.getPageSize())
//			    				//姝ゅ�浣跨�Source��ache
////			    				.setCacheable(true)
////			    				.setCacheRegion("com.livedoor.flow_manager.sources.beans.Source")
//			    				//
//			    				;
//			    		return query.list();
//			        }
//			    }
//			,true);
//	}
//
//	public void updateFood(Food f) {
//		update(f);		//HibernateTemplate().update()	
//	}
//	
//	public int getFoodCount() throws HibernateException {
//
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Food.class);
//		
//		return queryRowCount(detachedCriteria);
//	}
//	
//	
//	public int getFoodCount(final Food food) throws HibernateException {
//		
//		final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Food.class);
//		
////		return queryRowCount(detachedCriteria);
//		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
//			public Object doInHibernate(Session session) throws HibernateException {
//				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
//				buildCriteriaFromFoodObject(criteria, food);
//				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//				criteria.setProjection(null);
//				return totalCount;
//			}
//		}, true);
//	}
//	
//	private boolean buildCriteriaFromFoodObject(Criteria cr,Food food){
//		try{
//		if ( !ObjectCommonUtil.isEmpty(food) ){
//			
//			if (StringCommonUtil.isNotEmpty(food.getFoodName())){
//				cr.add(Restrictions.like("foodName", "%" + food.getFoodName()+ "%"));
//			}
//			
//			if(ObjectCommonUtil.isNotEmpty(food.getFoodPrice())){
//				cr.add(Restrictions.eq("foodPrice", food.getFoodPrice()));
//			}
//	
////			if (!UtilValidate.isEmpty(food.getSourceDesc()))
////	
////				cr.add(Restrictions.like("sourceDesc", "%" + food.getSourceDesc()+ "%"));
////	
////			if (!UtilValidate.isEmpty(food.getInputUserId()))
////	
////				cr.add(Restrictions.eq("inputUser", food.getInputUser()));
////			
////			if (!UtilValidate.isEmpty(food.getUpdateUserId()))
////	
////				cr.add(Restrictions.eq("updateUser", food.getUpdateUser()));
////			
////			
//			if (ObjectCommonUtil.isNotEmpty(food.getInputDate())) {
//	
//				Calendar end = (Calendar) BeanUtils.cloneBean(food.getInputDate());
//	
//				end.add(Calendar.DAY_OF_MONTH, 1);
//	
//				cr.add(Restrictions.between("inputDate", food.getInputDate(), end));
//			}
////	
////			if (!UtilValidate.isEmpty(food.getUpdateDatetime())) {
////	
////				Calendar end = (Calendar) BeanUtils.cloneBean(food.getUpdateDatetime());
////	
////				end.add(Calendar.DAY_OF_MONTH, 1);
////	
////				cr.add(Restrictions.between("updateDatetime", food.getUpdateDatetime(), end));
////			}
//		}
//		
//		cr.add(Restrictions.ne("deletedFlag", 1));
//		
//		
//		
//		}catch(Exception e){
//			log.error("buildCriteriaFromSourceObject() error ! ",e);
//			return false;
//		}
//		
//		return true;
//		
//	}
}
