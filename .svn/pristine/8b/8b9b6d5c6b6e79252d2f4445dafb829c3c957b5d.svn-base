package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Function;
import com.nkty.sms.bean.view.ViewFunction;
import com.nkty.sms.dao.FunctionDao;
import com.nkty.sms.dao.ViewFunctionDao;
import com.nkty.sms.service.FunctionService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

@Service(value = "functionServiceImpl")
public class FunctionServiceImpl extends BaseServiceImpl<Function, Integer>
		implements FunctionService {

	@Resource
	private FunctionDao functionDao;
	
	@Resource
	private ViewFunctionDao viewFunctionDao;

	@Resource(name = "functionDaoImpl")
	public void setBaseDao(FunctionDao functionDao) {
		super.setBaseDao(functionDao);
	}
	
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 获取功能列表
	 */
	@Override
	public List<Function> getUserFunctionList(int userID, int moduleID) {
		String strSql = "select t from Function t where functionID in(select functionID from ViewUserFunction where userID="
				+ userID + " and moduleId=" + moduleID + ") order by t.showOrder asc";
		List<Function> rsList = this.functionDao.findList(strSql, null);
		return rsList;
	}

	/**
	 * 获取功能数量
	 */
	@Override
	public int getFunctionCount(int type, String functionName) {
		StringBuffer where = new StringBuffer();
		if (type != 0) {
			where.append(" and t.usingFlag=" + type);
		}
		if(functionName!=""&&functionName!=null){
			where.append(" and t.functionName like '%"+functionName+"%'");
		}
		return viewFunctionDao.getEntityRecordCount(where.toString());
	}

	/**
	 * 获取功能分页信息
	 */
	@Override
	public Page<ViewFunction> getFunctionPage(Pageable pageable, int type,
			String functionName) {
		StringBuffer where = new StringBuffer();
		if (0 != type) {
			where.append(" and t.usingFlag = " + type);
		}
		if(functionName!=""&&functionName!=null){
			where.append(" and t.functionName like '%"+functionName+"%'");
		}

		
		return viewFunctionDao.findPage(where.toString(),
				" order by t.functionID desc", pageable.getPage(),
				pageable.getLimit());
	}

	/**
	 * 保存系统功能信息
	 */
	@Override
	public int saveFunction(Function function) {
		String strSql = "select t from Function t where t.functionID!="
				+ function.getFunctionID() + " and t.moduleID="
				+ function.getModuleID() + " and t.functionName='"
				+ function.getFunctionName() + "'";
		List<Function> rsList = this.functionDao.findList(strSql, null);
		if(rsList.size()>0&&rsList!=null){
			//重名
			return 2;
		}
		if(function.getFunctionID()==0){
			this.functionDao.persist(function);
			return 0;
		}else{
			this.functionDao.merge(function);
			return 1;
		}
	}

	/**
	 * 启用系统功能
	 */
	@Override
	public int openFunctions(String ids) {
		String strSql = "update T_Function set usingFlag=1 where functionID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSql);
		return query.executeUpdate();
	}

	/**
	 * 禁用系统功能
	 */
	@Override
	public int closeFunctions(String ids) {
		String strSql = "update T_Function set usingFlag=2 where functionID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSql);
		return query.executeUpdate();
	}

	/**
	 * 获取功能列表(视图)
	 */
	@Override
	public List<ViewFunction> getViewFunctionList(int moduleID,int type) {
		String strSql = "select t from ViewFunction t where 1=1";
		if(moduleID!=0){
			strSql+=" and t.moduleID="+moduleID;
		}
		if(type!=0){
			strSql+=" and t.usingFlag="+type;
		}
		strSql+=" order by t.moduleID asc,t.showOrder asc";
		List<ViewFunction> rsList = this.viewFunctionDao.findList(strSql, null);
		return rsList;
	}

	/**
	 * 获取功能列表
	 */
	@Override
	public List<Function> getFunctionList(int moduleID,int type) {
		String strSql = "select t from Function t where 1=1";
		if(moduleID!=0){
			strSql+=" and t.moduleID="+moduleID;
		}
		if(type!=0){
			strSql+=" and t.usingFlag="+type;
		}
		List<Function> rsList = this.functionDao.findList(strSql, null);
		return rsList;
	}

}
