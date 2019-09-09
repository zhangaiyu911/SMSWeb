package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 索证和订单关联表bean 2017年7月31日15:50:12
 */
@Entity
@Table(name = "CertificatesOrdering")
public class CertificatesOrdering implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//供货商编号
	private int supplierID;
	//证件编号
	private int certificatesID;
	//订单编号
	private int orderingID;
	//订单详情
	private int orderingItemID;
	//系统编号
	private int systemID;
	//保存地址
	private String savePath;
	//类型(1:食堂订单，2：采购订单)
	private int orderingType;
	
	@Id
	@GeneratedValue
	@Column(name = "ItemID", nullable = false)
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Column(name = "SupplierID", nullable = false)
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	@Column(name = "CertificatesID", nullable = false)
	public int getCertificatesID() {
		return certificatesID;
	}
	public void setCertificatesID(int certificatesID) {
		this.certificatesID = certificatesID;
	}
	@Column(name = "OrderingID", nullable = false)
	public int getOrderingID() {
		return orderingID;
	}
	public void setOrderingID(int orderingID) {
		this.orderingID = orderingID;
	}
	@Column(name = "OrderingItemID", nullable = false)
	public int getOrderingItemID() {
		return orderingItemID;
	}
	public void setOrderingItemID(int orderingItemID) {
		this.orderingItemID = orderingItemID;
	}
	@Column(name = "SystemID", nullable = false)
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
	@Column(name = "SavePath", nullable = false)
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	@Column(name = "OrderingType", nullable = false)
	public int getOrderingType() {
		return orderingType;
	}
	public void setOrderingType(int orderingType) {
		this.orderingType = orderingType;
	}
	
	

}
