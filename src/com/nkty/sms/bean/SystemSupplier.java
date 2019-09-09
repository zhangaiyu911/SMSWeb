package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 客户供货商bean 2017年7月19日09:19:113
 */
@Entity
@Table(name = "T_System_Supplier")
public class SystemSupplier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//客户编号
	private int systemID;
	//云端供货商编号
	private int clouldSupplierID;
	//物流内供货商编号
	private int wuliuSupplierID;
	//使用标识(0:待审核，1审核成功，2审核失败)
	private int usingFlag;
	//备注
	private String memo;
	
	@Id
	@GeneratedValue
	@Column(name = "ItemID", nullable = false)
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Column(name = "SystemID", nullable = false)
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
	@Column(name = "ClouldSupplierID", nullable = false)
	public int getClouldSupplierID() {
		return clouldSupplierID;
	}
	public void setClouldSupplierID(int clouldSupplierID) {
		this.clouldSupplierID = clouldSupplierID;
	}
	@Column(name = "WuliuSupplierID", nullable = false)
	public int getWuliuSupplierID() {
		return wuliuSupplierID;
	}
	public void setWuliuSupplierID(int wuliuSupplierID) {
		this.wuliuSupplierID = wuliuSupplierID;
	}
	
	public int getUsingFlag() {
		return usingFlag;
	}
	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}
	@Column(name = "Memo")
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	

}
