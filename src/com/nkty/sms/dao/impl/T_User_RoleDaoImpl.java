package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.T_User_Role;
import com.nkty.sms.dao.T_User_RoleDao;

/**
 * 用户角色配置Dao实现类
 * 
 * @author 刘雪成 2017年4月12日14:29:03
 * 
 */
@Repository(value = "t_User_RoleDaoImpl")
public class T_User_RoleDaoImpl extends BaseDaoImpl<T_User_Role, Integer>
		implements T_User_RoleDao {

}
