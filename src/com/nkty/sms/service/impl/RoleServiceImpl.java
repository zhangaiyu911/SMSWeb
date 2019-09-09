package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Role;
import com.nkty.sms.dao.RoleDao;
import com.nkty.sms.service.RoleService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 角色管理Service实现类
 * 
 * @author 刘雪成 2017年4月10日18:11:05 
 *
 */
@Service(value="roleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements
		RoleService {
	@Resource
	private RoleDao roleDao;

	@Resource(name = "roleDaoImpl")
	public void setBaseDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}
	
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 获取角色数量
	 */
	@Override
	public int getRoleCount(int type, String roleName) {
		StringBuffer where = new StringBuffer();
		if(type!=0){
			where.append(" and t.usingFlag="+type);
		}
		if(roleName!=null&&roleName!=""){
			where.append(" and t.roleName like '%"+roleName+"%'");
		}
		return this.roleDao.getEntityRecordCount(where.toString());
	}

	/**
	 * 获取角色分页信息
	 */
	@Override
	public Page<Role> getRolePage(Pageable pageable, int type, String roleName) {
		// 使用标识type 0：全部 1：使用 2：禁用
		StringBuffer where = new StringBuffer();
		if (0 != type) {
			where.append(" and t.usingFlag = " + type);
		}
		if (roleName != "" && roleName != null) {
			where.append(" and t.roleName like '%" + roleName + "%'");
		}

		return roleDao.findPage(where.toString(),
				" order by t.roleID desc", pageable.getPage(),
				pageable.getLimit());

	}

	/**
	 * 获取角色列表
	 */
	@Override
	public List<Role> getRoleList(int type) {
		String strSql ="select t from Role t where 1=1";
		if(type!=0){
			strSql+=" and t.usingFlag="+type;
		}
		List<Role> rsList = this.roleDao.findList(strSql, null);
		return rsList;
	}

	/**
	 * 保存角色信息
	 */
	@Override
	public int saveRole(Role role) {
		String strSql = "select t from Role t where t.roleID!="
				+ role.getRoleID() + " and t.roleName='" + role.getRoleName()
				+ "'";
		List<Role> roleList = this.roleDao.findList(strSql, null);
		if(roleList.size()>0&&roleList!=null){
			return 2;
		}
		if(role.getRoleID()!=0){
			this.roleDao.merge(role);
			return 1;
		}else{
			this.roleDao.persist(role);
			return 0;
		}
	}

	/**
	 * 启用角色
	 */
	@Override
	public int openRoles(String ids) {
		String strSql = "update Role set usingFlag=1 where roleID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSql);
		return query.executeUpdate();
	}

	/**
	 * 禁用角色
	 */
	@Override
	public int closeRoles(String ids) {
		String strSql = "update Role set usingFlag=2 where roleID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSql);
		return query.executeUpdate();
	}

	@Override
	public List<Role> getRoleList(int userID, int usingFlag) {
		String strSql = "select t from Role t where t.roleID in(select t1.roleID from T_User_Role t1 where t1.userID="+userID+") and t.usingFlag=1";
		List<Role> rsList = this.roleDao.findList(strSql, null);
		return rsList;
	}

}
