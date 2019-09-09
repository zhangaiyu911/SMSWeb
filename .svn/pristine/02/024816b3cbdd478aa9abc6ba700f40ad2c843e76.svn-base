package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InStockItem")
public class InStockItem implements Serializable {

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

}
