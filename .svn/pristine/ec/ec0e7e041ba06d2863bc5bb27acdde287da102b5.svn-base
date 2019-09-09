package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 订单bean 2017年7月18日16:01:17
 */
@Entity
@Table(name = "Ordering")
public class Ordering implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//客户编号
	private int systemID;
	//订单编号
	private int orderingID;
	//食堂编号
	private int customerID;
	//供货商编号
	private int supplierID;
	//订单状态
	private int orderingFlag;
	//用户编号
	private int userID;
	//操作时间
	private String operDate;
	//订货时间
	private String orderingTime;
	//原单号
	private int orderingSource;
	//订单类型
	private int orderingType;
	//部门编号
	private int departmentID;
	
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
	@Column(name = "OrderingID", nullable = false)
	public int getOrderingID() {
		return orderingID;
	}
	public void setOrderingID(int orderingID) {
		this.orderingID = orderingID;
	}
	@Column(name = "CustomerID", nullable = false)
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	@Column(name = "SupplierID", nullable = false)
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	@Column(name = "OrderingFlag", nullable = false)
	public int getOrderingFlag() {
		return orderingFlag;
	}
	public void setOrderingFlag(int orderingFlag) {
		this.orderingFlag = orderingFlag;
	}
	@Column(name = "UserID", nullable = false)
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Column(name = "OperDate", nullable = false)
	public String getOperDate() {
		return operDate;
	}
	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}
	@Column(name = "OrderingTime", nullable = false)
	public String getOrderingTime() {
		return orderingTime;
	}
	public void setOrderingTime(String orderingTime) {
		this.orderingTime = orderingTime;
	}
	@Column(name = "OrderingSource", nullable = false)
	public int getOrderingSource() {
		return orderingSource;
	}
	public void setOrderingSource(int orderingSource) {
		this.orderingSource = orderingSource;
	}
	@Column(name = "OrderingType", nullable = false)
	public int getOrderingType() {
		return orderingType;
	}
	public void setOrderingType(int orderingType) {
		this.orderingType = orderingType;
	}
	@Column(name = "DepartmentID", nullable = false)
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	
	
	

}
