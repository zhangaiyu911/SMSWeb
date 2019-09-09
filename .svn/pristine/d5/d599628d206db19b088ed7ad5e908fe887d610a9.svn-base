package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItem")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private int itemID;
	private int systemID;
	private int orderItemID;
	private int orderID;
	private int uid;
	private double orderQuantity;
	private double dealQuantity;
	private int supplierOrStockID;
	private int orderStorageType;
	private int orderingItemID;

	@Id
	@GeneratedValue
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

	public int getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getDealQuantity() {
		return dealQuantity;
	}

	public void setDealQuantity(double dealQuantity) {
		this.dealQuantity = dealQuantity;
	}

	public int getSupplierOrStockID() {
		return supplierOrStockID;
	}

	public void setSupplierOrStockID(int supplierOrStockID) {
		this.supplierOrStockID = supplierOrStockID;
	}

	public int getOrderStorageType() {
		return orderStorageType;
	}

	public void setOrderStorageType(int orderStorageType) {
		this.orderStorageType = orderStorageType;
	}

	public int getOrderingItemID() {
		return orderingItemID;
	}

	public void setOrderingItemID(int orderingItemID) {
		this.orderingItemID = orderingItemID;
	}

}
