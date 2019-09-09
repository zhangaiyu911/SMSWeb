package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.User;
import com.nkty.sms.bean.view.ViewUser;
import com.nkty.sms.bean.view.ViewUserAuthority;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 用户管理Service接口
 * @author 刘雪成 2017年4月7日15:29:13
 *
 */
public interface UserService extends BaseService<User, Integer> {
	

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @author 刘雪成
	 * @param username
	 * @return
	 */
	User getUser(String username);

	/**
	 * 获取用户数量(视图中)
	 * @author 刘雪成
	 * @param type
	 * @return
	 */
	int getViewUserCount(int type,String username);

	/**
	 * 获取用户分页列表(视图)
	 * @author 刘雪成 2017年4月6日11:40:07
	 * @param pageable
	 * @param type
	 * @return
	 */
	Page<ViewUser> getViewUserList(Pageable pageable, int type,String username);
	
	/**
	 * 保存用户信息 
	 * 
	 * @author 刘雪成 2017年4月6日11:40:29
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * 启用用户
	 * 
	 * @author 刘雪成
	 * @param ids 主键字符串,用,分隔
	 * @return
	 */
	int openUsers(String ids);
	
	/**
	 * 禁用用户
	 * @author 刘雪成
	 * @param ids 主键字符串,用,分隔
	 * @return
	 */
	int closeUsers(String ids);
	
	/**
	 * 根据用户权限获取部门列表
	 * 刘斌 2017年5月18日16:27:33
	 * @param userID
	 * @param functionCode
	 * @param type 1:普通，2：薪酬
	 * @return
	 */
	List<ViewUserAuthority> getDeptListByUserId(int userID,String functionCode,int type);
	
	public List<ViewUserAuthority> getUserAuthorityList(int userID,
			String functionCode);
	
	/**
	 * 根据用户名查询用户信息
	 * 
	 * @author 刘雪成
	 * @param username
	 * @return
	 */
	User getUserById(int userID);
	
	/**
	 * 修改密码
	 * 刘斌 2017年8月28日10:22:27
	 * @param password
	 * @param userID
	 * @return int
	 */
	int editUserPassword(String password,int userID);

}
