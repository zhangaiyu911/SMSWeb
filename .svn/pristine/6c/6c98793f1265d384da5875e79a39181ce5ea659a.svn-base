package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户-角色配置
 * 
 * @author 刘雪成
 * 
 */
@Entity
@Table(name = "T_User_Role")
public class T_User_Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userRoleID;
	private int userID;
	private int roleID;
	private int usingFlag;

	@Id
	@GeneratedValue
	@Column(name = "UserRoleID", nullable = false)
	public int getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}

	@Column(name = "UserID", nullable = false)
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Column(name = "RoleID", nullable = false)
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}

	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}

}
