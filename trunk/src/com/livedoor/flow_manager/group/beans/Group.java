package com.livedoor.flow_manager.group.beans ;

import java.util.Date ;
import java.util.Set;

import com.livedoor.flow_manager.sources.beans.Source;

public class Group
{
	private static final long serialVersionUID = 1L ;

	public static String REF = "TGroup" ;

	public static String PROP_UPDATE_DATETIME = "updateDatetime" ;

	public static String PROP_INPUT_DATETIME = "inputDatetime" ;

	public static String PROP_GROUP_NAME = "groupName" ;

	public static String PROP_INPUT_USER_ID = "inputUserId" ;

	public static String PROP_DELETED_FLAG = "deletedFlag" ;

	public static String PROP_UPDATE_USER_ID = "updateUserId" ;

	public static String PROP_GROUP_FATHER = "groupFather" ;

	public static String PROP_GROUP_LEVEL_RELATION = "groupLevelRelation" ;

	public static String PROP_ID = "id" ;

	public static String PROP_GROUP_DESC = "groupDesc" ;

	private int hashCode = Integer.MIN_VALUE ;

	// primary key
	private Integer id ;

	// fields
	private String groupName ;

	private String groupLevelRelation ;

	private Integer groupFather ;

	private Integer inputUserId ;

	private Date inputDatetime ;

	private Integer updateUserId ;

	private Date updateDatetime ;

	private Integer deletedFlag ;

	private String groupDesc ;
	
	private Set user ;
	
	private Set<Source> sourceSet;
	
	
	public Set getUser()
	{
		return user ;
	}

	public void setUser( Set user )
	{
		this.user = user ;
	}

	public Set<Source> getSourceSet() {
		return sourceSet;
	}

	public void setSourceSet(Set<Source> sourceSet) {
		this.sourceSet = sourceSet;
	}

	public Group()
	{
		
	}

	/**
	 * Constructor for required fields
	 */
	public Group( Integer id , String groupName , String groupLevelRelation ,
			Integer groupFather , Integer inputUserId , Date inputDatetime ,
			Integer updateUserId , Date updateDatetime , Integer deletedFlag ,
			String groupDesc )
	{

		this.setId( id ) ;
		this.setGroupName( groupName ) ;
		this.setGroupLevelRelation( groupLevelRelation ) ;
		this.setGroupFather( groupFather ) ;
		this.setInputUserId( inputUserId ) ;
		this.setInputDatetime( inputDatetime ) ;
		this.setUpdateUserId( updateUserId ) ;
		this.setUpdateDatetime( updateDatetime ) ;
		this.setDeletedFlag( deletedFlag ) ;
		this.setGroupDesc( groupDesc ) ;
	}

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="GROUP_ID"
	 */
	public Integer getId()
	{
		return id ;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId( Integer id )
	{
		this.id = id ;
		this.hashCode = Integer.MIN_VALUE ;
	}

	/**
	 * Return the value associated with the column: GROUP_NAME
	 */
	public String getGroupName()
	{
		return groupName ;
	}

	/**
	 * Set the value related to the column: GROUP_NAME
	 * 
	 * @param groupName
	 *            the GROUP_NAME value
	 */
	public void setGroupName( String groupName )
	{
		this.groupName = groupName ;
	}

	/**
	 * Return the value associated with the column: GROUP_LEVEL_RELATION
	 */
	public String getGroupLevelRelation()
	{
		return groupLevelRelation ;
	}

	/**
	 * Set the value related to the column: GROUP_LEVEL_RELATION
	 * 
	 * @param groupLevelRelation
	 *            the GROUP_LEVEL_RELATION value
	 */
	public void setGroupLevelRelation( String groupLevelRelation )
	{
		this.groupLevelRelation = groupLevelRelation ;
	}

	/**
	 * Return the value associated with the column: GROUP_FATHER
	 */
	public Integer getGroupFather()
	{
		return groupFather ;
	}

	/**
	 * Set the value related to the column: GROUP_FATHER
	 * 
	 * @param groupFather
	 *            the GROUP_FATHER value
	 */
	public void setGroupFather( Integer groupFather )
	{
		this.groupFather = groupFather ;
	}

	/**
	 * Return the value associated with the column: INPUT_USER_ID
	 */
	public Integer getInputUserId()
	{
		return inputUserId ;
	}

	/**
	 * Set the value related to the column: INPUT_USER_ID
	 * 
	 * @param inputUserId
	 *            the INPUT_USER_ID value
	 */
	public void setInputUserId( Integer inputUserId )
	{
		this.inputUserId = inputUserId ;
	}

	/**
	 * Return the value associated with the column: INPUT_DATETIME
	 */
	public Date getInputDatetime()
	{
		return inputDatetime ;
	}

	/**
	 * Set the value related to the column: INPUT_DATETIME
	 * 
	 * @param inputDatetime
	 *            the INPUT_DATETIME value
	 */
	public void setInputDatetime( Date inputDatetime )
	{
		this.inputDatetime = inputDatetime ;
	}

	/**
	 * Return the value associated with the column: UPDATE_USER_ID
	 */
	public Integer getUpdateUserId()
	{
		return updateUserId ;
	}

	/**
	 * Set the value related to the column: UPDATE_USER_ID
	 * 
	 * @param updateUserId
	 *            the UPDATE_USER_ID value
	 */
	public void setUpdateUserId( Integer updateUserId )
	{
		this.updateUserId = updateUserId ;
	}

	/**
	 * Return the value associated with the column: UPDATE_DATETIME
	 */
	public Date getUpdateDatetime()
	{
		return updateDatetime ;
	}

	/**
	 * Set the value related to the column: UPDATE_DATETIME
	 * 
	 * @param updateDatetime
	 *            the UPDATE_DATETIME value
	 */
	public void setUpdateDatetime( Date updateDatetime )
	{
		this.updateDatetime = updateDatetime ;
	}

	/**
	 * Return the value associated with the column: DELETED_FLAG
	 */
	public Integer getDeletedFlag()
	{
		return deletedFlag ;
	}

	/**
	 * Set the value related to the column: DELETED_FLAG
	 * 
	 * @param deletedFlag
	 *            the DELETED_FLAG value
	 */
	public void setDeletedFlag( Integer deletedFlag )
	{
		this.deletedFlag = deletedFlag ;
	}

	/**
	 * Return the value associated with the column: GROUP_DESC
	 */
	public String getGroupDesc()
	{
		return groupDesc ;
	}

	/**
	 * Set the value related to the column: GROUP_DESC
	 * 
	 * @param groupDesc
	 *            the GROUP_DESC value
	 */
	public void setGroupDesc( String groupDesc )
	{
		this.groupDesc = groupDesc ;
	}

	public boolean equals( Object obj )
	{
		if( null == obj )
			return false ;
		if( !( obj instanceof Group ) )
			return false ;
		else
		{
			Group group = ( Group )obj ;
			if( null == this.getId() || null == group.getId() )
				return false ;
			else
				return ( this.getId().equals( group.getId() ) ) ;
		}
	}

	public int hashCode()
	{
		if( Integer.MIN_VALUE == this.hashCode )
		{
			if( null == this.getId() )
				return super.hashCode() ;
			else
			{
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode() ;
				this.hashCode = hashStr.hashCode() ;
			}
		}
		return this.hashCode ;
	}

	public int compareTo( Object obj )
	{
		if( obj.hashCode() > hashCode() )
			return 1 ;
		else
			if( obj.hashCode() < hashCode() )
				return -1 ;
			else
				return 0 ;
	}

	public String toString()
	{
		return super.toString() ;
	}

}