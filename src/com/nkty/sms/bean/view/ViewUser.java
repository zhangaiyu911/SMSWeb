package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 用户（视图） 刘斌 2017年3月28日16:06:54
 * 
 */
@Entity
@Table(name = "ViewUser")
public class ViewUser implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户编号
	private int userID;
	// 用户名
	private String username;
	// 部门编号
	private int departmentID;
	// 部门名称
	private String departmentName;
	// 密码
	private String passWord;
	// 使用标识
	private int usingFlag;
	// 用户姓名
	private String realName;
	// 身份证号
	private String idNumber;
	// 联系电话
	private String linkPhone;

	@Id
	@Column(name = "UserID")
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getUsingFlag() {
		return usingFlag;
	}

	public void setUsingFlag(int usingFlag) {
		this.usingFlag = usingFlag;
	}


	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
