package com.livedoor.flow_manager.noGenerator;

import java.util.List;

import com.livedoor.flow_manager.generic.dao.GenericDAOHibernateImpl;

public class NoGeneratorDao extends GenericDAOHibernateImpl{

	
//	public Integer getUserIncrementId(String key) throws Exception {
//		
//		String hql = "UPDATE NoGenerator SET noCount = noCount + 1 WHERE noType="+key;
//		int result = (Integer)executeSQL(getHibernateTemplate(),hql );
//		if(result !=1 ){
//			throw new Exception(" not unique result !");
//		}
//		String hql2 = "SELECT MAX(USER_ID) + 1  AS NEW_ID FROM User WHERE noType="+key + " FOR UPDATE ";
//		List obj = queryWithSQL(getHibernateTemplate(),hql2 );
////		NoGenerator ng = obj.get(0);
//		
//		return (Integer)((Object[])obj.get(0))[0];
//		
//	}
//	
	
	
	
	public Integer getGeneratorIncrementId(String key) throws Exception {
		
		String hql = "UPDATE t_no_generator SET NO_COUNT = NO_COUNT + 1 WHERE NO_TYPE='"+key+"'";
		int result = (Integer)executeSQL(getHibernateTemplate(),hql );
		if(result !=1 ){
			throw new Exception(" not unique result !");
		}
		String hql2 = "FROM NoGenerator WHERE noType='"+key+"'";
		List<NoGenerator> ngList = (List<NoGenerator> )queryWithHQL(getHibernateTemplate(),hql2 );
		NoGenerator ng = ngList.get(0);
		
		return ng.getNoCount();
		
	}
	
//	public 
	
}
