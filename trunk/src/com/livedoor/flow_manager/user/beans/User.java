package com.livedoor.flow_manager.user.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;

import com.livedoor.flow_manager.role.beans.Role;

/**
 * 
 * @author 		lubaoqiang <a>xxlbq@163.com</a>
 * @copyright 	2006, Moon.L(Dalian) Co.,Ltd
 * @version 	user: xxlbq
 *				date: 2007-4-22
 *              time: 下午12:53:02
 *              filename:User.java
 *				project: permission
 *              
 *  
 * @see                   
 */
public class User implements Serializable, Comparable ,UserDetails {

	/*
	 * 
	 * 以下方法为实现 UserDetails 接口的方法
	 * */
	
//    private String password;
//    private String username;
//    private GrantedAuthority[] authorities;
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;

    //~ Constructors ===================================================================================================
	/**
     * Construct the <code>User</code> with the details required by {@link org.acegisecurity.providers.dao.DaoAuthenticationProvider}.
     *
     * @param username the username presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param password the password that should be presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param enabled set to <code>true</code> if the user is enabled
     * @param accountNonExpired set to <code>true</code> if the account has not
     *        expired
     * @param credentialsNonExpired set to <code>true</code> if the credentials
     *        have not expired
     * @param accountNonLocked set to <code>true</code> if the account is not
     *        locked
     * @param authorities the authorities that should be granted to the caller
     *        if they presented the correct username and password and the user
     *        is enabled
     *
     * @throws IllegalArgumentException if a <code>null</code> value was passed
     *         either as a parameter or as an element in the
     *         <code>GrantedAuthority[]</code> array
     */
//    public User(String username, String password, boolean enabled, boolean accountNonExpired,
//        boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities)
//        throws IllegalArgumentException {
//        if (((username == null) || "".equals(username)) || (password == null)) {
//            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
//        }
//
//        this.username = username;
//        this.password = password;
//        this.enabled = enabled;
//        this.accountNonExpired = accountNonExpired;
//        this.credentialsNonExpired = credentialsNonExpired;
//        this.accountNonLocked = accountNonLocked;
//        setAuthorities(authorities);
//    }
	
	/**
     * Construct the <code>User</code> with the details required by {@link org.acegisecurity.providers.dao.DaoAuthenticationProvider}.
     *
     * @param username the username presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param password the password that should be presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param enabled set to <code>true</code> if the user is enabled
     * @param accountNonExpired set to <code>true</code> if the account has not
     *        expired
     * @param credentialsNonExpired set to <code>true</code> if the credentials
     *        have not expired
     * @param authorities the authorities that should be granted to the caller
     *        if they presented the correct username and password and the user
     *        is enabled
     *
     * @throws IllegalArgumentException if a <code>null</code> value was passed
     *         either as a parameter or as an element in the
     *         <code>GrantedAuthority[]</code> array
     *
     * @deprecated use new constructor with extended properties (this
     *             constructor will be removed from release 1.0.0)
     */
//    public User(String username, String password, boolean enabled, boolean accountNonExpired,
//        boolean credentialsNonExpired, GrantedAuthority[] authorities)
//        throws IllegalArgumentException {
//        this(username, password, enabled, accountNonExpired, credentialsNonExpired, true, authorities);
//    }
	
	
	
/**
     * Construct the <code>User</code> with the details required by {@link org.acegisecurity.providers.dao.DaoAuthenticationProvider}.
     *
     * @param username the username presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param password the password that should be presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param enabled set to <code>true</code> if the user is enabled
     * @param authorities the authorities that should be granted to the caller
     *        if they presented the correct username and password and the user
     *        is enabled
     *
     * @throws IllegalArgumentException if a <code>null</code> value was passed
     *         either as a parameter or as an element in the
     *         <code>GrantedAuthority[]</code> array
     *
     * @deprecated use new constructor with extended properties (this
     *             constructor will be removed from release 1.0.0)
     */
//    public User(String username, String password, boolean enabled, GrantedAuthority[] authorities)
//        throws IllegalArgumentException {
//        this(username, password, enabled, true, true, authorities);
//    }





    //~ Methods ========================================================================================================



   
//    protected void setAuthorities(GrantedAuthority[] authorities) {
//        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority array");
//
//        for (int i = 0; i < authorities.length; i++) {
//            Assert.notNull(authorities[i],
//                "Granted authority element " + i + " is null - GrantedAuthority[] cannot contain any null elements");
//        }
//
//        this.authorities = authorities;
//    }

	

	
	//	 primary key
	private java.lang.Integer userId;

	// fields
	private java.lang.String userName;
	private java.lang.String userPassword;
	private int userRole;
	private java.lang.String userDisplayName;
	private java.lang.String userPhoto;
	private java.lang.String userEmail;
	private java.lang.String userMsn;
	private java.lang.String userSkype;
	private java.lang.Integer inputUserId;
	private java.util.Date inputDatetime;
	private java.lang.Integer updateUserId;
	private java.util.Date updateDatetime;
	private java.lang.Integer deletedFlag;
	private java.lang.String userDesc;

	private Role role;
	
    private int accountNonExpiredInt;
    private int accountNonLockedInt;
    private int credentialsNonExpiredInt;
	
	private static final long serialVersionUID = 1L;

//	 constructors
	public User () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public User (java.lang.Integer userId) {
		this.setUserId(userId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public User (
		java.lang.String userName,
		java.lang.String userPassword,
		java.lang.Integer inputUserId,
		java.lang.Integer deletedFlag) {

		this.setUserName(userName);
		this.setUserPassword(userPassword);
		this.setInputUserId(inputUserId);
		this.setDeletedFlag(deletedFlag);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	





	public java.lang.String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(java.lang.String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * Return the value associated with the column: USER_NAME
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: USER_NAME
	 * @param userName the USER_NAME value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: USER_PASSWORD
	 */
	public java.lang.String getUserPassword () {
		return userPassword;
	}

	/**
	 * Set the value related to the column: USER_PASSWORD
	 * @param userPassword the USER_PASSWORD value
	 */
	public void setUserPassword (java.lang.String userPassword) {
		this.userPassword = userPassword;
	}



	/**
	 * Return the value associated with the column: USER_ROLE
	 */
	public java.lang.String getUserRole () {
		return role.getRoleName();
	}

	/**
	 * Set the value related to the column: USER_ROLE
	 * @param userRole the USER_ROLE value
	 */
	public void setUserRole (int userRole) {
//		this.userRole = userRole;
		this.role.setRoleId(userRole);
	}



	/**
	 * Return the value associated with the column: USER_PHOTO
	 */
	public java.lang.String getUserPhoto () {
		return userPhoto;
	}

	/**
	 * Set the value related to the column: USER_PHOTO
	 * @param userPhoto the USER_PHOTO value
	 */
	public void setUserPhoto (java.lang.String userPhoto) {
		this.userPhoto = userPhoto;
	}



	/**
	 * Return the value associated with the column: USER_EMAIL
	 */
	public java.lang.String getUserEmail () {
		return userEmail;
	}

	/**
	 * Set the value related to the column: USER_EMAIL
	 * @param userEmail the USER_EMAIL value
	 */
	public void setUserEmail (java.lang.String userEmail) {
		this.userEmail = userEmail;
	}



	/**
	 * Return the value associated with the column: USER_MSN
	 */
	public java.lang.String getUserMsn () {
		return userMsn;
	}

	/**
	 * Set the value related to the column: USER_MSN
	 * @param userMsn the USER_MSN value
	 */
	public void setUserMsn (java.lang.String userMsn) {
		this.userMsn = userMsn;
	}



	/**
	 * Return the value associated with the column: USER_SKYPE
	 */
	public java.lang.String getUserSkype () {
		return userSkype;
	}

	/**
	 * Set the value related to the column: USER_SKYPE
	 * @param userSkype the USER_SKYPE value
	 */
	public void setUserSkype (java.lang.String userSkype) {
		this.userSkype = userSkype;
	}



	/**
	 * Return the value associated with the column: INPUT_USER_ID
	 */
	public java.lang.Integer getInputUserId () {
		return inputUserId;
	}

	/**
	 * Set the value related to the column: INPUT_USER_ID
	 * @param inputUserId the INPUT_USER_ID value
	 */
	public void setInputUserId (java.lang.Integer inputUserId) {
		this.inputUserId = inputUserId;
	}



	/**
	 * Return the value associated with the column: INPUT_DATETIME
	 */
	public java.util.Date getInputDatetime () {
		return inputDatetime;
	}

	/**
	 * Set the value related to the column: INPUT_DATETIME
	 * @param inputDatetime the INPUT_DATETIME value
	 */
	public void setInputDatetime (java.util.Date inputDatetime) {
		this.inputDatetime = inputDatetime;
	}



	/**
	 * Return the value associated with the column: UPDATE_USER_ID
	 */
	public java.lang.Integer getUpdateUserId () {
		return updateUserId;
	}

	/**
	 * Set the value related to the column: UPDATE_USER_ID
	 * @param updateUserId the UPDATE_USER_ID value
	 */
	public void setUpdateUserId (java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}



	/**
	 * Return the value associated with the column: UPDATE_DATETIME
	 */
	public java.util.Date getUpdateDatetime () {
		return updateDatetime;
	}

	/**
	 * Set the value related to the column: UPDATE_DATETIME
	 * @param updateDatetime the UPDATE_DATETIME value
	 */
	public void setUpdateDatetime (java.util.Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}



	/**
	 * Return the value associated with the column: DELETED_FLAG
	 */
	public java.lang.Integer getDeletedFlag () {
		return deletedFlag;
	}

	/**
	 * Set the value related to the column: DELETED_FLAG
	 * @param deletedFlag the DELETED_FLAG value
	 */
	public void setDeletedFlag (java.lang.Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}



	/**
	 * Return the value associated with the column: USER_DESC
	 */
	public java.lang.String getUserDesc () {
		return userDesc;
	}

	/**
	 * Set the value related to the column: USER_DESC
	 * @param userDesc the USER_DESC value
	 */
	public void setUserDesc (java.lang.String userDesc) {
		this.userDesc = userDesc;
	}





	public int getAccountNonExpiredInt() {
		return accountNonExpiredInt;
	}

	public void setAccountNonExpiredInt(int accountNonExpiredInt) {
		this.accountNonExpiredInt = accountNonExpiredInt;
	}

	public int getAccountNonLockedInt() {
		return accountNonLockedInt;
	}

	public void setAccountNonLockedInt(int accountNonLockedInt) {
		this.accountNonLockedInt = accountNonLockedInt;
	}

	public int getCredentialsNonExpiredInt() {
		return credentialsNonExpiredInt;
	}

	public void setCredentialsNonExpiredInt(int credentialsNonExpiredInt) {
		this.credentialsNonExpiredInt = credentialsNonExpiredInt;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.livedoor.flow_manager.user.beans.User)) return false;
		else {
			com.livedoor.flow_manager.user.beans.User user = (com.livedoor.flow_manager.user.beans.User) obj;
			if (null == this.getUserId() || null == user.getUserId()) return false;
			else return (this.getUserId().equals(user.getUserId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUserId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUserId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

//	public void setAccountNonExpired(boolean accountNonExpired) {
//		this.accountNonExpired = accountNonExpired;
//	}
//
//	public void setAccountNonLocked(boolean accountNonLocked) {
//		this.accountNonLocked = accountNonLocked;
//	}
//
//	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//		this.credentialsNonExpired = credentialsNonExpired;
//	}
	
	
	
	
	
//	==============   UserDetails 接口的方式实现类   ==============================
	
	
	private StringBuffer authoritiesString = new StringBuffer(200); 
	
	public GrantedAuthority[] getAuthorities() {
		//user 认证的列表
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//获得 user 权限的数组
		String[] tokens = getUserRole().split(",");
		
		for (int i = 0; i < tokens.length; i++) {
			System.out.println("roleArr, role is :"+tokens[i]);
		}
		
		for (int i = 0; i < tokens.length; i++) {
            String currentToken = tokens[i].trim();

//            if (i == 0) {
//                userAttrib.setPassword(currentToken);
//            } else {
//                if (currentToken.toLowerCase().equals("enabled")) {
//                    userAttrib.setEnabled(true);
//                } else if (currentToken.toLowerCase().equals("disabled")) {
//                    userAttrib.setEnabled(false);
//                } else {
            authoritiesString.append(currentToken+",");
            authorities.add(new GrantedAuthorityImpl(currentToken));
//                }
//            }
        }
		
//		return this.authorities;
		return (GrantedAuthority[]) authorities.toArray(new GrantedAuthority[authorities.size()]);
//		org.acegisecurity.providers.dao.AbstractUserDetailsAuthenticationProvider
		
	}
	


	public String getPassword() {

		return this.getUserPassword();
	}

	public String getUsername() {

		return this.getUserName();
	}

	public boolean isAccountNonExpired() {

		return getAccountNonExpiredInt() == 1 ? true:false;
	}

	public boolean isAccountNonLocked() {
		return getAccountNonLockedInt() == 1 ? true:false;
	}

	public boolean isCredentialsNonExpired() {
		return getCredentialsNonExpiredInt() == 1 ? true:false;
	}

	public boolean isEnabled() {
		return (this.getDeletedFlag()== 1 ? false : true);
	}


//#############  These are really fields of The class User #########################
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String toString () {
		
		return "["+"id:"+this.userId+","
					+"username:"+this.userName+","
					+"userPassword:"+this.userPassword+","
					+"roleId:"+this.role.getRoleId()+","
					+"userDesc:"+this.userDesc+"]"
					+"userRole:" + authoritiesString
					
					;
	}
}

