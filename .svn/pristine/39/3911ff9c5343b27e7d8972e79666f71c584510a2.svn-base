package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Function;
import com.nkty.sms.bean.RoleItem;
import com.nkty.sms.dao.FunctionDao;
import com.nkty.sms.dao.RoleItemDao;
import com.nkty.sms.service.RoleItemService;

/**
 * 角色-功能对应关系Service实现类
 * 
 * @author 刘雪成 2017年4月12日09:46:38
 * 
 */
@Service(value = "roleItemServiceImpl")
public class RoleItemServiceImpl extends BaseServiceImpl<RoleItem, Integer>
		implements RoleItemService {
	@Resource
	private RoleItemDao roleItemDao;

	@Resource(name = "roleItemDaoImpl")
	public void setBaseDao(RoleItemDao roleItemDao) {
		super.setBaseDao(roleItemDao);
	}

	@Resource(name = "functionDaoImpl")
	private FunctionDao functionDao;
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * 获取角色权限明细列表
	 */
	@Override
	public List<RoleItem> getRoleItemList(int roleID, int usingFlag) {
		String strSql="select t from RoleItem t where 1=1";
		if(roleID!=0){
			strSql+=" and t.roleID="+roleID;
		}
		if(usingFlag!=0){
			strSql+=" and t.usingFlag="+usingFlag;
		}
		List<RoleItem> rsList = this.roleItemDao.findList(strSql, null);
		return rsList;
	}

	/**
	 * 删除原有记录
	 */
	@Override
	public void deleteRoleItem(int roleID) {
		String strSql=" delete RoleItem t where t.roleID="+roleID;
		Query query = this.entityManager.createQuery(strSql);
		query.executeUpdate();
	}

	/**
	 * 保存角色功能配置信息
	 */
	@Override
	public int saveRoleItem(int roleID, String functionIDs) {
		String strSql="select t from Function t where t.functionID in("+functionIDs+")";
		List<Function> functionList = this.functionDao.findList(strSql, null);
		for(int i=0;i<functionList.size();i++){
			RoleItem item = new RoleItem();
			item.setRoleID(roleID);
			item.setFunctionID(functionList.get(i).getFunctionID());
			item.setUsingFlag(1);
			this.roleItemDao.persist(item);
		}
		return 0;
	}
	
}
