package com.nkty.sms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RelayServer")
public class RelayServer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//编号
	private int itemID;
	//ip
	private String host;
	//端口号
	private int port;
	//数据库名
	private String dbName;
	//账号
	private String username;
	//密码
	private String password;
	//系统编号
	private String systemIDS;
	
	@Id
	@GeneratedValue
	@Column(name = "ItemID", nullable = false)
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Column(name = "Host", nullable = false)
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Column(name = "Port", nullable = false)
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Column(name = "DbName", nullable = false)
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	@Column(name = "Username", nullable = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "SystemIDS", nullable = false)
	public String getSystemIDS() {
		return systemIDS;
	}
	public void setSystemIDS(String systemIDS) {
		this.systemIDS = systemIDS;
	}
	
	
	

}
