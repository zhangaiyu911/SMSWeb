package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Role;
import com.nkty.sms.bean.T_User_Role;
import com.nkty.sms.dao.RoleDao;
import com.nkty.sms.dao.T_User_RoleDao;
import com.nkty.sms.service.T_User_RoleService;

/**
 * 用户角色配置Service实现类
 * 
 * @author 刘雪成 2017年4月12日14:31:07
 * 
 */
@Service(value = "t_User_RoleServiceImpl")
public class T_User_RoleServiceImpl extends
		BaseServiceImpl<T_User_Role, Integer> implements T_User_RoleService {
	@Resource
	private T_User_RoleDao t_User_RoleDao;

	@Resource(name = "t_User_RoleDaoImpl")
	public void setBaseDao(T_User_RoleDao t_User_RoleDao) {
		super.setBaseDao(t_User_RoleDao);
	}
	
	@Resource(name="roleDaoImpl")
	private RoleDao roleDao;
	
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 查询用户-角色配置表
	 */
	@Override
	public List<T_User_Role> getUserRoleList(int userID, int usingFlag) {
		String strSql = "select t from T_User_Role t where 1=1";
		if(userID!=0){
			strSql+=" and t.userID="+userID;
		}
		if(usingFlag!=0){
			strSql+=" and t.usingFlag="+usingFlag;
		}
		List<T_User_Role> rsList = this.t_User_RoleDao.findList(strSql, null);
		return rsList;
	}

	/**
	 * 删除用户-角色配置信息
	 */
	@Override
	public void deleteUserRole(int userID) {
		String strSql="delete from T_User_Role t where t.userID="+userID;
		Query query = this.entityManager.createQuery(strSql);
		query.executeUpdate();
		
	}

	/**
	 * 保存用户-角色配置信息
	 */
	@Override
	public int saveUserRole(int userID, String roleIDs) {
		String strSql="select t from Role t where t.roleID in("+roleIDs+")";
		List<Role> roleList = this.roleDao.findList(strSql, null);
		for(int i=0;i<roleList.size();i++){
			T_User_Role item = new T_User_Role();
			item.setUserID(userID);
			item.setRoleID(roleList.get(i).getRoleID());
			item.setUsingFlag(1);
			this.t_User_RoleDao.persist(item);
		}
		return 0;
	}

}
