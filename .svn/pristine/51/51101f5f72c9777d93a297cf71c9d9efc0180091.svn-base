package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 证件详情bean 2017年7月19日09:07:10
 */
@Entity
@Table(name = "CertificatesItem")
public class CertificatesItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//供货商编号
	private int supplierID;
	//证件编号
	private int certificatesID;
	//保存地址
	private String savePath;
	//证件名称
	private String certificatesName;
	//结束时间
	private String endDate;
	
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
	@Column(name = "SavePath", nullable = false)
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	@Column(name = "CertificatesName", nullable = false)
	public String getCertificatesName() {
		return certificatesName;
	}
	public void setCertificatesName(String certificatesName) {
		this.certificatesName = certificatesName;
	}
	@Column(name = "EndDate", nullable = false)
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}
