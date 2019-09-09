package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Module;
import com.nkty.sms.dao.ModuleDao;
import com.nkty.sms.service.ModuleService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 系统模块Service实现类
 * 
 * @author 刘雪成 2017年4月5日09:07:37
 * 
 */
@Service(value = "moduleServiceImpl")
public class ModuleServiceImpl extends BaseServiceImpl<Module, Integer>
		implements ModuleService {

	@Resource
	private ModuleDao moduleDao;

	@Resource(name = "moduleDaoImpl")
	public void setBaseDao(ModuleDao moduleDao) {
		super.setBaseDao(moduleDao);
	}

	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * 根据用户编号获取用户权限模块
	 */
	@Override
	public List<Module> getModuleListByUserID(int userID) {
		String strSql = "select t from Module t where t.moduleID in(select moduleID from ViewUserFunction where userID = "
				+ userID + ") order by t.showOrder asc";
		List<Module> rsList = this.moduleDao.findList(strSql, null);
		return rsList;
	}

	/**
	 * 获取模块数量
	 */
	@Override
	public int getModuleCount(int type, String moduleName) {
		StringBuffer where = new StringBuffer();
		if (type != 0) {
			where.append(" and t.usingFlag=" + type);
		}
		if(moduleName!=""&&moduleName!=null){
			where.append(" and t.moduleName like '%"+moduleName+"%'");
		}
		return moduleDao.getEntityRecordCount(where.toString());
	}

	/**
	 * 获取模块分页信息
	 */
	@Override
	public Page<Module> getModulePage(Pageable pageable, int type,
			String sModuleName) {
		StringBuffer where = new StringBuffer();
		if (0 != type) {
			where.append(" and t.usingFlag = " + type);
		}
		if(sModuleName!=""&&sModuleName!=null){
			where.append(" and t.moduleName like '%"+sModuleName+"%'");
		}

		
		return moduleDao.findPage(where.toString(),
				" order by t.moduleID desc", pageable.getPage(),
				pageable.getLimit());
	}

	/**
	 * 保存模块信息
	 */
	@Override
	public int saveModule(Module module) {
		String strSql = "select t from Module t where t.moduleID!="
				+ module.getModuleID() + " and t.moduleName='"
				+ module.getModuleName() + "'";
		List<Module> rsList = this.moduleDao.findList(strSql, null);
		if(rsList!=null&&rsList.size()>0){
			return 2;
		}
		if(module.getModuleID()!=0){
			this.moduleDao.merge(module);
			return 1;
		}else{
			this.moduleDao.persist(module);
			return 0;
		}
		
	}

	/**
	 * 启用模块
	 */
	@Override
	public int openModules(String ids) {
		String strSQL = "update Module set usingFlag=1 where moduleID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSQL);
		return query.executeUpdate();
	}
	
	/**
	 * 禁用模块
	 */
	@Override
	public int closeModules(String ids) {
		String strSQL = "update Module set usingFlag=2 where moduleID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSQL);
		return query.executeUpdate();
	}

	/**
	 * 获取模块列表
	 */
	@Override
	public List<Module> getModuleList(int type) {
		String strSql="select t from Module t where 1=1";
		if(type!=0){
			strSql+=" and t.usingFlag="+type;
		}
		List<Module> rsList = this.moduleDao.findList(strSql, null);
		return rsList;
	}

}
