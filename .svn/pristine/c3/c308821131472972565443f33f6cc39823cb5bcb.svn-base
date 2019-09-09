package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 证件详情视图 2017年7月20日15:22:32
 */
@Entity
@Table(name = "ViewCertificatesItem")
public class ViewCertificatesItem implements Serializable{
	
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
	//证件号
	private String certificatesCode;
	
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
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCertificatesCode() {
		return certificatesCode;
	}
	public void setCertificatesCode(String certificatesCode) {
		this.certificatesCode = certificatesCode;
	}
	
	

}
