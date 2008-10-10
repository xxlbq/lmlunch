package com.livedoor.flow_manager.user_group.beans;

import java.io.Serializable;

public class UserGroup implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;

	public static String PROP_INPUT_DATETIME = "InputDatetime";

	public static String PROP_GROUP_ID = "GroupId";

	public static String PROP_INPUT_USER_ID = "InputUserId";

	public static String PROP_USER_ID = "UserId";

	public static String PROP_GROUP_USER_DESC = "GroupUserDesc";

	public static String PROP_ID = "Id";

	// constructors
	public UserGroup() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public UserGroup(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public UserGroup(java.lang.Integer groupId,
			java.lang.Integer userId, java.lang.Integer inputUserId) {

		this.setGroupId(groupId);
		this.setUserId(userId);
		this.setInputUserId(inputUserId);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer groupId;

	private java.lang.Integer userId;

	private java.lang.Integer inputUserId;

	private java.util.Date inputDatetime;

	private java.lang.String groupUserDesc;

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="vm"
	 *  column="GROUP_USER_ID"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: GROUP_ID
	 */
	public java.lang.Integer getGroupId() {
		return groupId;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param groupId the GROUP_ID value
	 */
	public void setGroupId(java.lang.Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * Return the value associated with the column: USER_ID
	 */
	public java.lang.Integer getUserId() {
		return userId;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param userId the USER_ID value
	 */
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * Return the value associated with the column: INPUT_USER_ID
	 */
	public java.lang.Integer getInputUserId() {
		return inputUserId;
	}

	/**
	 * Set the value related to the column: INPUT_USER_ID
	 * @param inputUserId the INPUT_USER_ID value
	 */
	public void setInputUserId(java.lang.Integer inputUserId) {
		this.inputUserId = inputUserId;
	}

	/**
	 * Return the value associated with the column: INPUT_DATETIME
	 */
	public java.util.Date getInputDatetime() {
		return inputDatetime;
	}

	/**
	 * Set the value related to the column: INPUT_DATETIME
	 * @param inputDatetime the INPUT_DATETIME value
	 */
	public void setInputDatetime(java.util.Date inputDatetime) {
		this.inputDatetime = inputDatetime;
	}

	/**
	 * Return the value associated with the column: GROUP_USER_DESC
	 */
	public java.lang.String getGroupUserDesc() {
		return groupUserDesc;
	}

	/**
	 * Set the value related to the column: GROUP_USER_DESC
	 * @param groupUserDesc the GROUP_USER_DESC value
	 */
	public void setGroupUserDesc(java.lang.String groupUserDesc) {
		this.groupUserDesc = groupUserDesc;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof UserGroup))
			return false;
		else {
			UserGroup tGroupUser = (UserGroup) obj;
			if (null == this.getId() || null == tGroupUser.getId())
				return false;
			else
				return (this.getId().equals(tGroupUser.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode())
			return 1;
		else if (obj.hashCode() < hashCode())
			return -1;
		else
			return 0;
	}

	public String toString() {
		return super.toString();
	}

}
