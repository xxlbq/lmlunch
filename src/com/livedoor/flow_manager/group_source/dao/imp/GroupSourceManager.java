package com.livedoor.flow_manager.group_source.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.livedoor.flow_manager.group_source.beans.GroupSource;
import com.livedoor.flow_manager.group_source.dao.inf.IGroupSource;

public class GroupSourceManager extends HibernateDaoSupport implements IGroupSource{
	


	public void addGroupSource(GroupSource s) {
		
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();

		Transaction tran = session.beginTransaction();
		session.save(s);

		tran.commit();
		session.close();

	}

	public void deleteGroupSource(GroupSource s) {
		
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();

		Transaction tran = session.beginTransaction();
		session.delete(s);
		tran.commit();
		session.close();

	}

	
	
	public void deleteGroupSourceByDeleteFlag(GroupSource s) {

		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();

		Transaction tran = session.beginTransaction();
		s.setDeletedFlag(1);
		session.update(s);
		tran.commit();
		session.close();
	}

	public void updateGroupSource(GroupSource s) {

		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();

		Transaction tran = session.beginTransaction();
		session.update(s);
		tran.commit();
		session.close();

	}
	
	public GroupSource getGroupSourceByGroupSourceId(Integer groupSourceId) {
		
		Session session = getHibernateTemplate().getSessionFactory()
							.openSession();
		
		GroupSource returnGroupSource = (GroupSource)session.get(GroupSource.class, groupSourceId);
		
		session.close();
		
		return returnGroupSource;
	}

	@SuppressWarnings("unchecked")
	public List<GroupSource> queryAllGroupSource() {
		
		Session session = getHibernateTemplate().getSessionFactory()
						.openSession();
		
		List<GroupSource> groupSourceList = session.createQuery("from com.livedoor.flow_manager.group_source.beans.GroupSource")
											.list();
		
		session.close();
		
		return groupSourceList;
	}


}
