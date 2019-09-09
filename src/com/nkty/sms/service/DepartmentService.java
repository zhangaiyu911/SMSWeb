package com.nkty.sms.service;

import com.nkty.sms.bean.Department;

/**
 * 部门Service接口
 * 
 * @author 刘斌 2017年7月18日15:57:20
 * 
 */
public interface DepartmentService extends BaseService<Department, Integer>{

	/**
	 * 同步部门信息
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @return
	 */
	int syncDeptData(String strSystemIDs, String host, int port, String dbname,
			String username, String password);

}
