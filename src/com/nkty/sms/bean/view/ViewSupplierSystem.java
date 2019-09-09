package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 供货商与客户关系视图 2017年7月24日10:11:07
 */
@Entity
@Table(name = "ViewSupplierSystem")
public class ViewSupplierSystem implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//供货商编号
	private int supplierID;
	//供货商名称
	private String supplierName;
	//供货商编码
	private String supplierCode;
	//办公地点
	private String officeAddr;
	//经营类型
	private String saleContent;
	//负责人名称
	private String consignorName;
	//负责人电话
	private String consignorPhone;
	//负责人传真
	private String consignorFax;
	//负责人电话
	private String consignorMobile;
	//简介
	private String memo;
	//使用标识
	private int sUsingFlag;
	//客户编号
	private int systemID;
	//物流内供货商编号
	private int wuliuSupplierID;
	//使用标识(0:待审核，1审核成功，2审核失败)
	private int usingFlag;
	//物流系统
	private String systemName;
	//失败原因
	private String reason;
	
	@Id
	@Column(name = "ItemID", nullable = false)
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getOfficeAddr() {
		return officeAddr;
	}
	public void setOfficeAddr(String officeAddr) {
		this.officeAddr = officeAddr;
	}
	public String getSaleContent() {
		return saleContent;
	}
	public void setSaleContent(String saleContent) {
		this.saleContent = saleContent;
	}
	public String getConsignorName() {
		return consignorName;
	}
	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}
	public String getConsignorPhone() {
		return consignorPhone;
	}
	public void setConsignorPhone(String consignorPhone) {
		this.consignorPhone = consignorPhone;
	}
	public String getConsignorFax() {
		return consignorFax;
	}
	public void setConsignorFax(String consignorFax) {
		this.consignorFax = consignorFax;
	}
	public String getConsignorMobile() {
		return consignorMobile;
	}
	public void setConsignorMobile(String consignorMobile) {
		this.consignorMobile = consignorMobile;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getsUsingFlag() {
		return sUsingFlag;
	}
	public void setsUsingFlag(int sUsingFlag) {
		this.sUsingFlag = sUsingFlag;
	}
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
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
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	

}
