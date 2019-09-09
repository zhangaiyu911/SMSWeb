package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**商品类别 
 * @author 刘斌 2017年7月18日11:03:52
 *
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//客户编号
	private int systemID;
	//类别编号
	private int categoryID;
	//类别名称
	private String categoryName;
	//等级
	private int curDegreeID;
	//父类编号
	private int parentID;
	//使用标识
	private int usingFlag;
	//备注
	private String memo;
	
	@Id
	@GeneratedValue
	@Column(name = "ItemID", nullable = false)
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Column(name = "SystemID", nullable = false)
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
	@Column(name = "CategoryID", nullable = false)
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	@Column(name = "CategoryName", nullable = false)
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Column(name = "CurDegreeID", nullable = false)
	public int getCurDegreeID() {
		return curDegreeID;
	}
	public void setCurDegreeID(int curDegreeID) {
		this.curDegreeID = curDegreeID;
	}
	@Column(name = "ParentID", nullable = false)
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
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
