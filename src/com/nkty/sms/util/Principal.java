package com.nkty.sms.util;
import java.io.Serializable;

/**
 * 
 * Base Framework - 单点登录身份信息
 * <p><br>
 * @author 陈荣盛
 * @version 1.0.0, 2013-9-4
 */
public class Principal implements Serializable {
    /**
     * 序列化标识 
     */
	private static final long serialVersionUID = 5798882004228239559L;

	/** 
	 * ID 
	 * */
	private String id;

	/** 
	 * 用户名 
	 **/
	private String username;
	/**
	 * 账户类型
	 */
	private Integer accountType;
	
	/**
	 * 构造函数
	 * @param id
	 *            ID
	 * @param username
	 *            用户名
	 */
	public Principal(String id, String username) {
		this.id = id;
		this.username = username;
	}
	/**
	 * 构造函数
	 * @param id id
	 * @param username 用户名
	 * @param accountType 账户类型
	 */
	public Principal(String id,String username,Integer accountType){
		this.id = id;
		this.username = username;
		this.accountType = accountType;
	}
	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置 ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * 
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 得到账户类型
	 * @return 账户类型标识
	 */
	public Integer getAccountType() {
		return accountType;
	}
	/**
	 * 设置账户类型
	 * @param accountType 账户类型
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return username;
	}
}