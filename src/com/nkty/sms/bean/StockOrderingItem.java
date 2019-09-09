package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 采购订单详情bean 2017年8月2日11:23:01
 */
@Entity
@Table(name = "StockOrderingItem")
public class StockOrderingItem implements Serializable{
	
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
	@Column(name = "OrderingItemID", nullable = false)
	public int getOrderingItemID() {
		return orderingItemID;
	}
	public void setOrderingItemID(int orderingItemID) {
		this.orderingItemID = orderingItemID;
	}
	@Column(name = "StockOrderingID", nullable = false)
	public int getStockOrderingID() {
		return stockOrderingID;
	}
	public void setStockOrderingID(int stockOrderingID) {
		this.stockOrderingID = stockOrderingID;
	}
	@Column(name = "UID", nullable = false)
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Column(name = "Price", nullable = false)
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name = "OrderingQuantity", nullable = false)
	public double getOrderingQuantity() {
		return orderingQuantity;
	}
	public void setOrderingQuantity(double orderingQuantity) {
		this.orderingQuantity = orderingQuantity;
	}
	@Column(name = "Money", nullable = false)
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Column(name = "DealQuantity", nullable = false)
	public double getDealQuantity() {
		return dealQuantity;
	}
	public void setDealQuantity(double dealQuantity) {
		this.dealQuantity = dealQuantity;
	}
	@Column(name = "ProductionDate")
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	@Column(name = "ShelfLife")
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	

}
