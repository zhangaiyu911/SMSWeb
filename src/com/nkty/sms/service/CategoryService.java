package com.nkty.sms.service;

import com.nkty.sms.bean.Category;

/**
 * 商品类别Service接口
 * 
 * @author 刘斌 2017年7月18日14:30:47
 * 
 */
public interface CategoryService extends BaseService<Category, Integer>{

	/**
	 * 向服云平台同步商品类别信息
	 * 
	 * @param systemID
	 * @param host 中转服务器地址
	 * @param port 数据库端口
	 * @param dbname 中转数据库名称
	 * @param username 中转数据库用户名
	 * @param password 密码
	 * @return
	 */
	int syncCategoryData(String strSystemIDs, String host, int port, String dbname,
			String username, String password);

}
