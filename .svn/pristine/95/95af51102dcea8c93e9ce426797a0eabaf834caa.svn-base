package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 订单视图 2017年7月25日16:56:01
 */
@Entity
@Table(name = "ViewOrdering")
public class ViewOrdering implements Serializable{
	
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
	//订单状态（0：未处理，1：处理，3：作废，5：下载，6：配置）
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
	//食堂名称
	private String customerName;
	//供货商名称
	private String supplierName;
	
	@Id
	@Column(name = "ItemID", nullable = false)
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
	public int getOrderingID() {
		return orderingID;
	}
	public void setOrderingID(int orderingID) {
		this.orderingID = orderingID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public int getOrderingFlag() {
		return orderingFlag;
	}
	public void setOrderingFlag(int orderingFlag) {
		this.orderingFlag = orderingFlag;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getOperDate() {
		return operDate;
	}
	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}
	public String getOrderingTime() {
		return orderingTime;
	}
	public void setOrderingTime(String orderingTime) {
		this.orderingTime = orderingTime;
	}
	public int getOrderingSource() {
		return orderingSource;
	}
	public void setOrderingSource(int orderingSource) {
		this.orderingSource = orderingSource;
	}
	public int getOrderingType() {
		return orderingType;
	}
	public void setOrderingType(int orderingType) {
		this.orderingType = orderingType;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	

}
