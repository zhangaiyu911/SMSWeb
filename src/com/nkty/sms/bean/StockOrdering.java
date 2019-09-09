package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 采购订单bean 2017年8月2日11:01:00
 */
@Entity
@Table(name = "StockOrdering")
public class StockOrdering implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//系统编号
	private int systemID;
	//采购订单编号
	private int stockOrderingID;
	//部门编号
	private int departmentID;
	//物流供货商编号
	private int supplierID;
	//
	private int orderingSource;
	//标识
	private int orderingFlag;
	//订单时间
	private String orderingTime;
	//物流用户编号
	private int userID;
	//操作时间
	private String operTime;
	//
	private String remark;
	
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
	@Column(name = "StockOrderingID", nullable = false)
	public int getStockOrderingID() {
		return stockOrderingID;
	}
	public void setStockOrderingID(int stockOrderingID) {
		this.stockOrderingID = stockOrderingID;
	}
	@Column(name = "DepartmentID", nullable = false)
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	@Column(name = "SupplierID", nullable = false)
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	@Column(name = "OrderingSource", nullable = false)
	public int getOrderingSource() {
		return orderingSource;
	}
	public void setOrderingSource(int orderingSource) {
		this.orderingSource = orderingSource;
	}
	@Column(name = "OrderingFlag", nullable = false)
	public int getOrderingFlag() {
		return orderingFlag;
	}
	public void setOrderingFlag(int orderingFlag) {
		this.orderingFlag = orderingFlag;
	}
	@Column(name = "OrderingTime", nullable = false)
	public String getOrderingTime() {
		return orderingTime;
	}
	public void setOrderingTime(String orderingTime) {
		this.orderingTime = orderingTime;
	}
	@Column(name = "UserID", nullable = false)
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Column(name = "OperTime", nullable = false)
	public String getOperTime() {
		return operTime;
	}
	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}
	@Column(name = "Remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}