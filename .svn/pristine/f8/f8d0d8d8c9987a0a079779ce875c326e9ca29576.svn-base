package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 订单详情bean 2017年7月18日16:27:20
 */
@Entity
@Table(name = "OrderingItem")
public class OrderingItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//客户编号
	private int systemID;
	//订单详细编号
	private int orderingItemID;
	//订单编号
	private int orderingID;
	//商品编号
	private int uid;
	//订货数量
	private double orderingQuantity;
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
	@Column(name = "OrderingID", nullable = false)
	public int getOrderingID() {
		return orderingID;
	}
	public void setOrderingID(int orderingID) {
		this.orderingID = orderingID;
	}
	@Column(name = "UID", nullable = false)
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Column(name = "OrderingQuantity", nullable = false)
	public double getOrderingQuantity() {
		return orderingQuantity;
	}
	public void setOrderingQuantity(double orderingQuantity) {
		this.orderingQuantity = orderingQuantity;
	}
	@Column(name = "DealQuantity", nullable = false)
	public double getDealQuantity() {
		return dealQuantity;
	}
	public void setDealQuantity(double dealQuantity) {
		this.dealQuantity = dealQuantity;
	}
	@Column(name = "ProductionDate", nullable = false)
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	@Column(name = "ShelfLife", nullable = false)
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	

}
