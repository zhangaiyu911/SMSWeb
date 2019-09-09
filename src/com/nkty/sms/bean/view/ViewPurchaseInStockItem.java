package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 采购入库单明细视图
 * @author 刘斌 2017年8月3日17:47:23
 */
@Entity
@Table(name = "ViewPurchaseInStockItem")
public class ViewPurchaseInStockItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private int itemID;
	private int systemID;
	private int instockitemid;// (自动生成)
	private int instockid; //
	private int uid; //
	private double instockprice; // 入库价
	private double instockquantity;// 入库数量
	private double instockmoney; // 入库金额
	private int batchid; // 批次编号
	private int costflag; // 商品入库参考类型（1成本/0经费）
	// 存储类型
	private int storagetype;
	// 生成日期
	private String produceDate;
	// 保质期
	private String shelfLife;
	//商品名称
	private String productName;
	//单位
	private String unit;
	//操作员
	private int userID;
	//供货商名称
	private String supplierName;
	private String instocktime;// 入库时间
	private int supplierID; // 供货商编号
	private int billtype;
	
	//生产时间
	private String productionDate;
	//保质期
	private String shelfLife2;
	
	private int orderingItemID;
	private int billsource;
	
	
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
	public int getInstockitemid() {
		return instockitemid;
	}
	public void setInstockitemid(int instockitemid) {
		this.instockitemid = instockitemid;
	}
	public int getInstockid() {
		return instockid;
	}
	public void setInstockid(int instockid) {
		this.instockid = instockid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getInstockprice() {
		return instockprice;
	}
	public void setInstockprice(double instockprice) {
		this.instockprice = instockprice;
	}
	public double getInstockquantity() {
		return instockquantity;
	}
	public void setInstockquantity(double instockquantity) {
		this.instockquantity = instockquantity;
	}
	public double getInstockmoney() {
		return instockmoney;
	}
	public void setInstockmoney(double instockmoney) {
		this.instockmoney = instockmoney;
	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	public int getCostflag() {
		return costflag;
	}
	public void setCostflag(int costflag) {
		this.costflag = costflag;
	}
	public int getStoragetype() {
		return storagetype;
	}
	public void setStoragetype(int storagetype) {
		this.storagetype = storagetype;
	}
	public String getProduceDate() {
		return produceDate;
	}
	public void setProduceDate(String produceDate) {
		this.produceDate = produceDate;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getInstocktime() {
		return instocktime;
	}
	public void setInstocktime(String instocktime) {
		this.instocktime = instocktime;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	public int getBilltype() {
		return billtype;
	}
	public void setBilltype(int billtype) {
		this.billtype = billtype;
	}
	
	
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	public String getShelfLife2() {
		return shelfLife2;
	}
	public void setShelfLife2(String shelfLife2) {
		this.shelfLife2 = shelfLife2;
	}
	
	
	public int getOrderingItemID() {
		return orderingItemID;
	}
	public void setOrderingItemID(int orderingItemID) {
		this.orderingItemID = orderingItemID;
	}
	
	public int getBillsource() {
		return billsource;
	}
	public void setBillsource(int billsource) {
		this.billsource = billsource;
	}
	public ViewPurchaseInStockItem() {
		super();
	}
	
	public ViewPurchaseInStockItem(int uid,String productName,String unit,double instockprice,double instockquantity,double instockmoney) {
		super();
		this.uid=uid;
		this.productName=productName;
		this.unit=unit;
		this.instockprice=instockprice;
		this.instockquantity=instockquantity;
		this.instockmoney=instockmoney;
	}
}
