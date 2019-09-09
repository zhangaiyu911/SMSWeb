package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.T_User_Role_Department;
import com.nkty.sms.dao.T_User_Role_DepartmentDao;
import com.nkty.sms.service.T_User_Role_DepartmentService;
/**
 * 用户角色权限配置Service实现类
 * 
 * @author 刘雪成 2017年4月12日13:39:45
 *
 */
@Service(value="t_User_Role_DepartmentServiceImpl")
public class T_User_Role_DepartmentServiceImpl extends BaseServiceImpl<T_User_Role_Department, Integer> implements
		T_User_Role_DepartmentService {
	
	@Resource
	private T_User_Role_DepartmentDao t_User_Role_DepartmentDao;

	@Resource(name = "t_User_Role_DepartmentDaoImpl")
	public void setBaseDao(T_User_Role_DepartmentDao t_User_Role_DepartmentDao) {
		super.setBaseDao(t_User_Role_DepartmentDao);
	}

	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 查询用户权限部门列表
	 */
	@Override
	public List<T_User_Role_Department> getUserRoleDeptList(int userID,
			int roleID) {
		String strSql="select t from T_User_Role_Department t where 1=1";
		if(userID!=0){
			strSql+=" and t.userID="+userID;
		}
		if(roleID!=0){
			strSql+=" and t.roleID="+roleID;
		}
		List<T_User_Role_Department> rsList = this.t_User_Role_DepartmentDao.findList(strSql, null);
		return rsList;
	}

	/**
	 * 保存用户角色权限配置信息
	 */
	@Override
	public int saveUserRoleDeptList(int userID, int roleID, String ids) {
		//保存用户角色权限配置信息
//		String strSql = "insert into T_User_Role_Department (userID,roleID,departmentID,usingFlag) " +
//				"select "+ userID+ ","+ roleID+ ",t1.departmentID,1 from Department t1 where t1.departmentID in("+ ids + ")";
		String strSql="insert into T_User_Role_Department (userID,roleID,departmentID,usingFlag)"+
					"select "+ userID+ ","+ roleID+ ",d.deptid,1  from (select d.DepartmentID as deptid from Department d union all select s.SalaryDeptID as deptid from SalaryDept s) d where d.deptid in("+ids+")";
		Query query= this.entityManager.createNativeQuery(strSql);
		return query.executeUpdate();
	}

	/**
	 * 删除用户角色权限配置信息
	 */
	@Override
	public int deleteUserRoleDeptList(int userID, int roleID) {
		String strSql = "delete from T_User_Role_Department where userID="+userID+" and roleID="+roleID;
		Query query = this.entityManager.createQuery(strSql);
		return query.executeUpdate();
	}

}
