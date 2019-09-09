package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.Role;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 角色管理Service接口
 * 
 * @author 刘雪成 2017年4月10日18:10:14
 * 
 */
public interface RoleService extends BaseService<Role, Integer> {

	/**
	 * 获取角色数量
	 * 
	 * @author 刘雪成
	 * @param type
	 * @param roleName
	 * @return
	 */
	int getRoleCount(int type, String roleName);

	/**
	 * 获取角色分页信息
	 * 
	 * @author 刘雪成
	 * @param pageable
	 * @param type
	 * @param roleName
	 * @return
	 */
	Page<Role> getRolePage(Pageable pageable, int type, String roleName);

	/**
	 * 获取角色列表
	 * 
	 * @author 刘雪成
	 * @param type
	 * @return
	 */
	List<Role> getRoleList(int type);

	/**
	 * 保存角色信息
	 * 
	 * @author 刘雪成
	 * @param role
	 * @return
	 */
	int saveRole(Role role);

	/**
	 * 启用角色
	 * 
	 * @author 刘雪成
	 * @param ids
	 * @return
	 */
	int openRoles(String ids);

	/**
	 * 禁用角色
	 * 
	 * @author 刘雪成
	 * @param ids
	 * @return
	 */
	int closeRoles(String ids);

	List<Role> getRoleList(int userID, int usingFlag);

}
