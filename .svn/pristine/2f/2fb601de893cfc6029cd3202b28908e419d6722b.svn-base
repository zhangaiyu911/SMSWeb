package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 供货商bean 2017年7月18日16:01:17
 */
@Entity
@Table(name = "Supplier")
public class Supplier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	private int usingFlag;
	
	@Id
	@GeneratedValue
	@Column(name = "SupplierID", nullable = false)
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	@Column(name = "SupplierName", nullable = false)
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@Column(name = "SupplierCode", nullable = false)
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	@Column(name = "OfficeAddr", nullable = false)
	public String getOfficeAddr() {
		return officeAddr;
	}
	public void setOfficeAddr(String officeAddr) {
		this.officeAddr = officeAddr;
	}
	@Column(name = "SaleContent", nullable = false)
	public String getSaleContent() {
		return saleContent;
	}
	public void setSaleContent(String saleContent) {
		this.saleContent = saleContent;
	}
	@Column(name = "ConsignorName", nullable = false)
	public String getConsignorName() {
		return consignorName;
	}
	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}
	@Column(name = "ConsignorPhone", nullable = false)
	public String getConsignorPhone() {
		return consignorPhone;
	}
	public void setConsignorPhone(String consignorPhone) {
		this.consignorPhone = consignorPhone;
	}
	@Column(name = "ConsignorFax", nullable = false)
	public String getConsignorFax() {
		return consignorFax;
	}
	public void setConsignorFax(String consignorFax) {
		this.consignorFax = consignorFax;
	}
	@Column(name = "ConsignorMobile", nullable = false)
	public String getConsignorMobile() {
		return consignorMobile;
	}
	public void setConsignorMobile(String consignorMobile) {
		this.consignorMobile = consignorMobile;
	}
	@Column(name = "Memo", nullable = false)
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
	
	

}
