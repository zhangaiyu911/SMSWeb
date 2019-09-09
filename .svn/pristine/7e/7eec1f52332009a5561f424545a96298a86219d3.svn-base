package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.T_User_Role_Department;

/**
 * 用户角色权限配置Service接口
 * 
 * @author 刘雪成 2017年4月12日13:38:55
 * 
 */
public interface T_User_Role_DepartmentService extends BaseService<T_User_Role_Department, Integer> {

	/**
	 * 获取用户已配置权限部门列表
	 * @author 刘雪成
	 * @param userID
	 * @param roleID
	 * @return
	 */
	List<T_User_Role_Department> getUserRoleDeptList(int userID, int roleID);

	/**
	 * 保存用户角色权限
	 * @author 刘雪成
	 * @param userID 用户编号
	 * @param roleID 角色编号
	 * @param ids 部门编号1,2,3,...
	 * @return
	 */
	int saveUserRoleDeptList(int userID, int roleID, String ids);

	/**
	 * 删除用户角色权限配置信息
	 * @author 刘雪成
	 * @param userID
	 * @param roleID
	 * @return
	 */
	int deleteUserRoleDeptList(int userID, int roleID);

}
