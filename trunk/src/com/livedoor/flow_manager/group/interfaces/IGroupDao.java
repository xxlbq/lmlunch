package com.livedoor.flow_manager.group.interfaces ;

import java.util.List ;

import com.livedoor.flow_manager.group.beans.Group ;
import com.livedoor.flow_manager.sources.beans.Source;

/**
 * @date:   2006-9-2 
 * @author: <a href="mailto:zhangchuang@livedoor.cn">Zhang Chuang</a>
 * @param groupName
 * @return List
 * <p>@description: </p>
 */

public interface IGroupDao
{
	public List getGroupByGroupName( String groupName ) ;

	public int addGroup( Group group ) ;

	public int updateGroup( Group group ) ;

	/**
	 * @param groupList
	 * @return int-->
	 ** <p>@description:</p>
	 */
	
	public int deleteGroup( List groupList ) ;//��ɾ�� set deleted_flag = 1
	
	/**
	 * @param 
	 * @return int-->����ɾ�������
	 * <p>@description:�ļ�¼ɾ��</p>
	 */
	
	public int deleteGroupByDeletedFlag() ;//delete where deleted_flag = 1
	
	public List getGroupByDeletedFlag( int deletedFlag ) ;

	public List getAllGroups() ;

	public List getFathers( List resultList , Group group ) ;

	public List getChildren( List resultList , Group group ) ;
	
	public List getUsersByGroup( Group group ) ;
	
	//lbq edit
	
	List<Source> getSourcsByGroup(Group group);
}
