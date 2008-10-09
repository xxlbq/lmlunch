package com.livedoor.flow_manager.userGroupSource.beans ;


public class UserGroupSource
{
	private static final long serialVersionUID = 1L ;

	public static String REF = "UserGroupSource" ;

	public static String PROP_USER_GROUP_SOURCE_DESC = "userGroupSourceDesc" ;

	//public static String PROP_USER_ID = "user" ;

	public static String PROP_GROUP_SOURCE_ID = "groupSourceId" ;

	public static String PROP_ID = "id" ;

	

	private int hashCode = Integer.MIN_VALUE ;

	// primary key
	private Integer id ;

	// fields
	private Integer userId ;

	private Integer groupSourceId ;

	private String userGroupSourceDesc ;
	
	public UserGroupSource()
	{
		
	}
	
	/**
	 * Constructor for required fields
	 */
	public UserGroupSource( Integer id , Integer userId , Integer groupSourceId , String userGroupSourceDesc )
	{

		this.setId( id ) ;
		this.setUserId( userId ) ;
		this.setGroupSourceId( groupSourceId ) ;
		this.setUserGroupSourceDesc( userGroupSourceDesc ) ;
	}

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="USER_GROUP_SOURCE_ID"
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
	 * Return the value associated with the column: USER_ID
	 */
	public Integer getUserId()
	{
		return userId ;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * 
	 * @param userId
	 *            the USER_ID value
	 */
	public void setUserId( Integer userId )
	{
		this.userId = userId ;
	}

	/**
	 * Return the value associated with the column: GROUP_SOURCE_ID
	 */
	public Integer getGroupSourceId()
	{
		return groupSourceId ;
	}

	/**
	 * Set the value related to the column: GROUP_SOURCE_ID
	 * 
	 * @param groupSourceId
	 *            the GROUP_SOURCE_ID value
	 */
	public void setGroupSourceId( Integer groupSourceId )
	{
		this.groupSourceId = groupSourceId ;
	}

	/**
	 * Return the value associated with the column: USER_GROUP_SOURCE_DESC
	 */
	public String getUserGroupSourceDesc()
	{
		return userGroupSourceDesc ;
	}

	/**
	 * Set the value related to the column: USER_GROUP_SOURCE_DESC
	 * 
	 * @param userGroupSourceDesc
	 *            the USER_GROUP_SOURCE_DESC value
	 */
	public void setUserGroupSourceDesc( String userGroupSourceDesc )
	{
		this.userGroupSourceDesc = userGroupSourceDesc ;
	}

	public boolean equals( Object obj )
	{
		if( null == obj )
			return false ;
		if( !( obj instanceof UserGroupSource ) )
			return false ;
		else
		{
			UserGroupSource tUserGroupSource = ( UserGroupSource )obj ;
			if( null == this.getId() || null == tUserGroupSource.getId() )
				return false ;
			else
				return ( this.getId().equals( tUserGroupSource.getId() ) ) ;
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