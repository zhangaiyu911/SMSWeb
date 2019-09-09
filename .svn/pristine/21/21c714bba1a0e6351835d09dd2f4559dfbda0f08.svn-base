package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 索证和订单关联表视图 2017年7月31日15:50:12
 */
@Entity
@Table(name = "ViewCertificatesOrdering")
public class ViewCertificatesOrdering implements Serializable{
	
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
	//证件名称
	private String certificatesName;
	private int orderingType;
	
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
	public int getCertificatesID() {
		return certificatesID;
	}
	public void setCertificatesID(int certificatesID) {
		this.certificatesID = certificatesID;
	}
	public int getOrderingID() {
		return orderingID;
	}
	public void setOrderingID(int orderingID) {
		this.orderingID = orderingID;
	}
	public int getOrderingItemID() {
		return orderingItemID;
	}
	public void setOrderingItemID(int orderingItemID) {
		this.orderingItemID = orderingItemID;
	}
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getCertificatesName() {
		return certificatesName;
	}
	public void setCertificatesName(String certificatesName) {
		this.certificatesName = certificatesName;
	}
	public int getOrderingType() {
		return orderingType;
	}
	public void setOrderingType(int orderingType) {
		this.orderingType = orderingType;
	}
	
	

}
