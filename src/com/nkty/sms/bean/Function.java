package com.nkty.sms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 功能表实体bean 刘斌2017年3月28日15:33:02
 * 
 */
@Entity
@Table(name = "T_Function")
public class Function implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// 功能编号
	private int functionID;
	// 功能模块编号
	private int moduleID;
	// 功能名称
	private String functionName;
	// 功能编码
	private String functionCode;
	// 功能url
	private String functionUrl;
	// 使用标识
	private int usingFlag;

	private int showOrder;
	
	private String memo;

	@Id
	@GeneratedValue
	@Column(name = "FunctionID", nullable = false)
	public int getFunctionID() {
		return functionID;
	}

	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

	@Column(name = "ModuleID", nullable = false)
	public int getModuleID() {
		return moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}

	@Column(name = "FunctionName", nullable = false)
	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "FunctionCode", nullable = false)
	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}

	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}

	@Column(name = "ShowOrder")
	public int getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name="FunctionUrl",nullable=false)
	public String getFunctionUrl() {
		return functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

}
