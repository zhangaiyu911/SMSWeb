package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 采购订单详情视图 2017年8月2日15:19:23
 */
@Entity
@Table(name = "ViewStockOrderingItem")
public class ViewStockOrderingItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//客户编号
	private int systemID;
	//采购订单详情编号
	private int orderingItemID;
	//采购订单主表编号
	private int stockOrderingID;
	//商品编号
	private int uid;
	//单价
	private double price;
	//订货数量
	private double orderingQuantity; 
	//金额
	private double money;
	//处理数量
	private double dealQuantity;
	//生产时间
	private String productionDate;
	//保质期
	private String shelfLife;
	//商品名称
	private String productName;
	//部门编号
	private int departmentID;
	//订货时间
	private String orderingTime;
	//供货商编号
	private int supplierID;
	//供货商名称
	private String supplierName;
	//标识
	private int orderingFlag;
	//部门名称
	private String departmentName;
	
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
	public int getOrderingItemID() {
		return orderingItemID;
	}
	public void setOrderingItemID(int orderingItemID) {
		this.orderingItemID = orderingItemID;
	}
	public int getStockOrderingID() {
		return stockOrderingID;
	}
	public void setStockOrderingID(int stockOrderingID) {
		this.stockOrderingID = stockOrderingID;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getOrderingQuantity() {
		return orderingQuantity;
	}
	public void setOrderingQuantity(double orderingQuantity) {
		this.orderingQuantity = orderingQuantity;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getOrderingTime() {
		return orderingTime;
	}
	public void setOrderingTime(String orderingTime) {
		this.orderingTime = orderingTime;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getOrderingFlag() {
		return orderingFlag;
	}
	public void setOrderingFlag(int orderingFlag) {
		this.orderingFlag = orderingFlag;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public double getDealQuantity() {
		return dealQuantity;
	}
	public void setDealQuantity(double dealQuantity) {
		this.dealQuantity = dealQuantity;
	}
	
	

}
