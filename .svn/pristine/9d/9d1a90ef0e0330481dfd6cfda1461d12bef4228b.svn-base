package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**客户
 * @author 刘斌 2017年7月18日11:14:36
 *
 */
@Entity
@Table(name = "WuliuSystem")
public class WuliuSystem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//客户编号
	private int systemID;
	//客户名称
	private String systemName;
	//使用标识
	private int usingFlag;
	//备注
	private String memo;
	
	
	@Id
	@GeneratedValue
	@Column(name = "SystemID", nullable = false)
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
	@Column(name = "SystemName", nullable = false)
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
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
	

}
