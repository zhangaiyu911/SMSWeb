package com.nkty.sms.service;

import com.nkty.sms.bean.Product;

/**
 * 商品Service接口
 * 
 * @author 刘斌 2017年7月18日14:15:05
 * 
 */
public interface ProductService extends BaseService<Product, Integer>{

	/**
	 * 同步商品信息
	 * 
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @return
	 */
	int syncProductData(String strSystemIDs, String host, int port, String dbname,
			String username, String password);

}
