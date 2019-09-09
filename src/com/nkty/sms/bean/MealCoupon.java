package com.nkty.sms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MealCoupon")
public class MealCoupon implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "Id", nullable = false)
	private int id;//餐票Id
	@Column(name = "CardName", nullable = false)
	private String cardName;//餐票名称
	@Column(name = "CardType", nullable = false)
	private int cardType;//餐券类型 1：普通，2：自助
	@Column(name = "TotalMoney", nullable = false)
	private BigDecimal totalMoney;//总金额
	@Column(name = "ServiceMoney", nullable = false)
	private BigDecimal serviceMoney;//服务费
	@Column(name = "RealMoney", nullable = false)
	private BigDecimal realMoney;//可用金额
	@Column(name = "UseDate", nullable = false)
	private Date useDate;//使用时间
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public BigDecimal getServiceMoney() {
		return serviceMoney;
	}
	public void setServiceMoney(BigDecimal serviceMoney) {
		this.serviceMoney = serviceMoney;
	}
	public BigDecimal getRealMoney() {
		return realMoney;
	}
	public void setRealMoney(BigDecimal realMoney) {
		this.realMoney = realMoney;
	}
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	
	

}
