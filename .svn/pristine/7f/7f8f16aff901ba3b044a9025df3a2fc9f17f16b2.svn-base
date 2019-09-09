package com.nkty.sms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体Bean 刘斌2017年3月28日15:29:19
 */
@Entity
@Table(name = "Role")
public class Role implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// 角色编号
	private int roleID;
	// 角色名称
	private String roleName;
	// 使用标识
	private int usingFlag;
	private String memo;
	//类型 0：普通，1：薪酬
	private int roleType;

	@Id
	@GeneratedValue
	@Column(name = "RoleID", nullable = false)
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	@Column(name = "RoleName", nullable = false)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "UsingFlag", nullable = false)
	public int getUsingFlag() {
		return usingFlag;
	}

	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}

	@Column(name = "Memo")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Column(name = "RoleType", nullable = false)
	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	
	

}
