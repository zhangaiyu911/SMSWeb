package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.RoleItem;

/**
 * 角色-功能对应关系Service接口
 * 
 * @author 刘雪成 2017年4月12日09:45:42
 * 
 */
public interface RoleItemService extends BaseService<RoleItem, Integer> {

	/**
	 * 获取角色明细
	 * @author 刘雪成
	 * @param roleID
	 * @param usingFlag
	 * @return
	 */
	List<RoleItem> getRoleItemList(int roleID, int usingFlag);

	/**
	 * 删除角色权限
	 * 
	 * @author 刘雪成
	 * @param roleID 角色编号
	 * @return
	 */
	void deleteRoleItem(int roleID);

	/**
	 * 
	 * @author 刘雪成
	 * @param roleID 角色编号
	 * @param functionIDs 功能编号组
	 */
	int saveRoleItem(int roleID, String functionIDs);

}
