package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RegistCode")
public class RegistCode implements Serializable {

	private static final long serialVersionUID = 1L;
	// Id
	private int registCodeID;
	// 注册码
	private String registCodeStr;
	// 使用标识
	private int usingFlag;
	// 物流系统编号
	private int systemID;
	// 注册码类型 1:管理员 2:供应商
	private int registCodeType;

	@Id
	@GeneratedValue
	@Column(name = "RegistCodeID", nullable = false)
	public int getRegistCodeID() {
		return registCodeID;
	}

	public void setRegistCodeID(int registCodeID) {
		this.registCodeID = registCodeID;
	}

	@Column(name = "RegistCodeStr", nullable = false)
	public String getRegistCodeStr() {
		return registCodeStr;
	}

	public void setRegistCodeStr(String registCodeStr) {
		this.registCodeStr = registCodeStr;
	}

	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}

	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}

	@Column(name = "SystemID", nullable = false)
	public int getSystemID() {
		return systemID;
	}

	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}

	@Column(name = "RegistCodeType", nullable = false)
	public int getRegistCodeType() {
		return registCodeType;
	}

	public void setRegistCodeType(int registCodeType) {
		this.registCodeType = registCodeType;
	}

}
