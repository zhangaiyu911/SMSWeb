package com.nkty.sms.bean.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 食堂入库单视图
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "ViewInStock")
public class ViewInStock implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int itemID;
	private int systemID;
	private int instockID; // 入库单号(根据生成编号表中对应项值+1生成)
	private int supplierID; // 供货商编号
	private double instockmoney; // 入库金额
	private String memo; //
	private int userID; // 用户编号
	private String instocktime;// 入库时间
	private String operdate; // 操作时间
	private int billsource; // 单据来源（表示单据类型对应原始单据单号：手工录入入库=0/退货入库=原始退货单号/根据订货单入库=订货单号/根据补订货入库
							// =补订货单号/下载出库单(退库单)转入库=采购出库单号(采购退库单号)）/采购订货（单据来源为采购定单单号）
	private int billtype; // 手工录入入库1/退货入库2/根据订货单入库3/根据补订货入库/4/下载出库单转入库5/下载退库单转入库6/商品自采7/采购订货8/调拨入库10/调拨冲单11
	private int monthdealflag;// 月处理标志（0表示该单据未处理/月处理编号表示单据已处理）//张富来 2011-05-06
								// 1表示单据已处理
	private int stockofficeid;// 库房编号
	private int departmentid; // 部门编号
	private String supplierName;
	private String customerName;
	

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
	public int getInstockID() {
		return instockID;
	}
	public void setInstockID(int instockID) {
		this.instockID = instockID;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public double getInstockmoney() {
		return instockmoney;
	}
	public void setInstockmoney(double instockmoney) {
		this.instockmoney = instockmoney;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getInstocktime() {
		return instocktime;
	}
	public void setInstocktime(String instocktime) {
		this.instocktime = instocktime;
	}
	public String getOperdate() {
		return operdate;
	}
	public void setOperdate(String operdate) {
		this.operdate = operdate;
	}
	public int getBillsource() {
		return billsource;
	}
	public void setBillsource(int billsource) {
		this.billsource = billsource;
	}
	public int getBilltype() {
		return billtype;
	}
	public void setBilltype(int billtype) {
		this.billtype = billtype;
	}
	public int getMonthdealflag() {
		return monthdealflag;
	}
	public void setMonthdealflag(int monthdealflag) {
		this.monthdealflag = monthdealflag;
	}
	public int getStockofficeid() {
		return stockofficeid;
	}
	public void setStockofficeid(int stockofficeid) {
		this.stockofficeid = stockofficeid;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	

}
