package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.T_User_Role;

/**
 * 用户角色配置Service接口
 * 
 * @author 刘雪成 2017年4月12日14:30:09
 * 
 */
public interface T_User_RoleService extends BaseService<T_User_Role, Integer> {

	/**
	 * 获取用户-角色配置表
	 * 
	 * @author 刘雪成 2017年4月12日16:46:31
	 * @param userID
	 * @param usingFlag
	 * @return
	 */
	List<T_User_Role> getUserRoleList(int userID, int usingFlag);

	/**
	 * 删除用户角色配置信息
	 * 
	 * @author 刘雪成
	 * @param userID
	 */
	void deleteUserRole(int userID);

	/**
	 * 保存用户-角色配置信息
	 * @author 刘雪成
	 * @param userID
	 * @param roleIDs
	 * @return
	 */
	int saveUserRole(int userID, String roleIDs);

}
