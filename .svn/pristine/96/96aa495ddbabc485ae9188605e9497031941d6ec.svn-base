package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统参数实体Bean
 * 
 * @author 刘雪成
 * 
 */
@Entity
@Table(name = "SystemPara")
public class SystemPara implements Serializable {

	private static final long serialVersionUID = 1L;

	private int paraID;

	private String paraName;

	private String paraCode;

	private String paraValue;

	private String memo;

	@Id
	@GeneratedValue
	@Column(name = "ParaID", nullable = false)
	public int getParaID() {
		return paraID;
	}

	public void setParaID(int paraID) {
		this.paraID = paraID;
	}

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public String getParaCode() {
		return paraCode;
	}

	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}

	public String getParaValue() {
		return paraValue;
	}

	public void setParaValue(String paraValue) {
		this.paraValue = paraValue;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
