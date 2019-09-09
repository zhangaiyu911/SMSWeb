package com.nkty.sms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户、客户、供货商关系实体Bean
 */
@Entity
@Table(name = "T_User_System_Supplier")
public class UserSysSupplier implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//用户编号
	private int userID;
	//客户或者供货商编号
	private int currencyID;
	//用户类型
	private int userType;
	//使用标识
	private int usingFlag;
	
	@Id
	@GeneratedValue
	@Column(name = "ItemID", nullable = false)
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Column(name = "UserID", nullable = false)
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Column(name = "CurrencyID", nullable = false)
	public int getCurrencyID() {
		return currencyID;
	}
	public void setCurrencyID(int currencyID) {
		this.currencyID = currencyID;
	}
	@Column(name = "UserType", nullable = false)
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}
	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}
	
	

}
