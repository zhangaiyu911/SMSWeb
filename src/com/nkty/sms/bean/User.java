package com.nkty.sms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体Bean
 */
@Entity
@Table(name = "T_User")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// 用户编号
	private int userID;
	// 用户名
	private String userName;
	// 用户密码
	private String password;
	// 使用标识
	private int usingFlag;
	// 电话
	private String linkphone;
	// 备注
	private String memo;
	// 类型
	private int userType;

	@Id
	@GeneratedValue
	@Column(name = "UserID", nullable = false)
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Column(name = "UserName", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Linkphone", nullable = false)
	public String getLinkphone() {
		return linkphone;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}

	@Column(name = "Memo")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}

	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}

	@Column(name = "UserType", nullable = false)
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
