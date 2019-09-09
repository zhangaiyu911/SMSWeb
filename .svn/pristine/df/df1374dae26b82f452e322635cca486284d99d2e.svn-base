package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 证件bean 2017年7月19日08:58:49
 */
@Entity
@Table(name = "Certificates")
public class Certificates implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int certificatesID;
	//证件名称
	private String certificatesName;
	//使用标识
	private int usingFlag;
	//备注
	private String memo;
	//类型 1：供货商证件，2：索证
	private int certificatesType;
	
	@Id
	@GeneratedValue
	@Column(name = "CertificatesID", nullable = false)
	public int getCertificatesID() {
		return certificatesID;
	}
	public void setCertificatesID(int certificatesID) {
		this.certificatesID = certificatesID;
	}
	@Column(name = "CertificatesName", nullable = false)
	public String getCertificatesName() {
		return certificatesName;
	}
	public void setCertificatesName(String certificatesName) {
		this.certificatesName = certificatesName;
	}
	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}
	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}
	@Column(name = "Memo", nullable = false)
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Column(name = "CertificatesType", nullable = false)
	public int getCertificatesType() {
		return certificatesType;
	}
	public void setCertificatesType(int certificatesType) {
		this.certificatesType = certificatesType;
	}
	

}
