package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色-功能对应关系表(角色明细)
 * 
 * @author 刘雪成
 * 
 */
@Entity
@Table(name = "T_Role_Function")
public class RoleItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private int roleItemID;
	private int roleID;
	private int functionID;
	private int usingFlag;

	@Id
	@GeneratedValue
	@Column(name = "ItemID", nullable = false)
	public int getRoleItemID() {
		return roleItemID;
	}

	public void setRoleItemID(int roleItemID) {
		this.roleItemID = roleItemID;
	}

	@Column(name = "RoleID", nullable = false)
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	@Column(name = "FunctionID", nullable = false)
	public int getFunctionID() {
		return functionID;
	}

	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}

	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}

}
