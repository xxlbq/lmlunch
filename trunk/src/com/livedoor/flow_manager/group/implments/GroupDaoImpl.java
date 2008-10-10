/**
 * GroupDaoImpl
 * GroupDaoImpl.java
 */
package com.livedoor.flow_manager.group.implments;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.group.interfaces.IGroupDao;
import com.livedoor.flow_manager.sources.beans.Source;
import com.livedoor.flow_manager.user.beans.User;

/**
 * @date:   2006-9-2 
 * @author: <a href="mailto:zhangchuang@livedoor.cn">Zhang Chuang</a>
 * @param list
 * @return int
 * <p>@description: </p>
 */

public class GroupDaoImpl implements IGroupDao
{
	private Logger log = Logger.getLogger( this.getClass() );
	private HibernateTemplate hibernateTemplate ;
	
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate ;
	}

	public void setHibernateTemplate( HibernateTemplate hibernateTemplate )
	{
		this.hibernateTemplate = hibernateTemplate ;
	}
	
	public List getGroupByGroupName( String groupName )
	{
		log.info( "******** method getGroupByGroupName() begin ********" ) ;
		String hql = "from Group g where g.groupName like '%" + groupName + "%'" ;
		return this.hibernateTemplate.find( hql ) ;
	}

	public int addGroup( Group group )
	{
		log.info( "******** method addGroup() begin ********" ) ;
		int i = 1 ;
		try
		{
			group.setUpdateDatetime( GroupDaoImpl.getCurrentDateTime() ) ;
			this.hibernateTemplate.save( group ) ;
		}
		catch( DataAccessException e )
		{
			e.printStackTrace();
			return 0 ;
		}
		return i ;
	}

	public int updateGroup( Group group )
	{
		log.info( "******** method updateGroup() begin ********" ) ;
		int i = 1 ;
		try
		{
			group.setUpdateDatetime( GroupDaoImpl.getCurrentDateTime() ) ;
			this.hibernateTemplate.update( group ) ;
		}
		catch( DataAccessException e )
		{
			e.printStackTrace();
			return 0 ;
		}
		return i ;
	}
	
	public static Date getCurrentDateTime()
	{
		Calendar calendar = Calendar.getInstance( Locale.CHINA ) ;
		return calendar.getTime() ;
	}

	/* (non-Javadoc)
	 * @see com.livedoor.flow_manager.group.interfaces.IGroupDao#deleteGroup(java.util.List)
	 */
	public int deleteGroup( List groupList )
	{
		log.info( "******** method deleteGroup() begin ********" ) ;
		int i = 0 ;
		Group group ;
		try
		{
			if( groupList.size() > 0 )
			{
				for( i = 0 ; i < groupList.size() ; i++ )
				{
					group = ( Group )groupList.get( i ) ;
					group.setDeletedFlag( new Integer( 1 ) ) ;
					this.updateGroup( group ) ;
				}
			}
		}
		catch( DataAccessException e )
		{
			e.printStackTrace();
			return 0 ;
		}
		return i ;
	}

	public List getAllGroups()
	{
		return this.hibernateTemplate.loadAll( Group.class ) ;
	}

	public List getFathers( List resultList , Group group )
	{
		log.info( "******** method getFathers() begin ********" ) ;
		if( group.getGroupFather() != 0 || group.getGroupFather() == null )
		{
			String hql = "from Group g where g.id = ?" ;
			List list = this.hibernateTemplate.find( hql , group.getGroupFather() ) ;
			Group temp = ( Group )list.get( 0 ) ;
			resultList.add( temp ) ;
			this.getFathers( resultList , temp ) ;
		}
		return resultList ;
	}

	public List getChildren( List resultList , Group group )
	{
		log.info( "******** method getFathers() begin ********" ) ;
		
		String hql = "from Group g where g.groupFather = ?" ;
		List list = this.hibernateTemplate.find( hql , group.getId() ) ;
		for( int i = 0  ; i < list.size() ; i++ )
		{
			Group temp = ( Group )list.get( i ) ;
			resultList.add( temp ) ;
		}
		return resultList ;
	}
	
	/* (non-Javadoc)
	 * @see com.livedoor.flow_manager.group.interfaces.IGroupDao#deleteGroupByDeletedFlag()
	 */
	public int deleteGroupByDeletedFlag()
	{
		log.info( "******** method deleteGroupByFlag() begin ********" ) ;
		return this.delete( this.getGroupByDeletedFlag( 1 ) ) ;
	}
	
	/**
	 * @param list
	 * @return int
	 * <p>@description: see invoked by deleteGroupByDeletedFlag()</p>
	 */
	private int delete( List list )
	{
		int i = 0 ;
		if( list.size() > 0 )
		{
			for( i = 0 ; i < list.size() ; i++ )
			{
				this.hibernateTemplate.delete( list.get( i ) ) ;
			}
		}
		return i ;
	}

	public List getGroupByDeletedFlag( int deletedFlag )
	{
		log.info( "******** method getGroupByDeletedFlag() begin ********" ) ;
		String hql = "from Group g where g.deletedFlag = ?" ;
		return this.hibernateTemplate.find( hql , deletedFlag ) ;
	}

	//	lbq edit
	public Group getGroupByLoadGroupId(Integer groupId) {

		return (Group) this.getHibernateTemplate().get(Group.class, groupId);
	}

	//lbq edit
	public List<Source> getSourcsByGroup(Group group) {

		List sourceList = new ArrayList<Source>();

		Iterator<Source> it = group.getSourceSet().iterator();

		while (it.hasNext()) {

			Source s = it.next();

			sourceList.add(s);
		}

		return sourceList;
	}

	public List getUsersByGroup( Group group )
	{
		List list = new ArrayList() ;
		Iterator it = group.getUser().iterator() ;
		while( it.hasNext() )
		{
			list.add( ( User )it.next() ) ;
		}
		return list ;
	}
	
	
	
}