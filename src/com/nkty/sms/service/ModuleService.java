package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.Module;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 系统模块Service接口
 * 
 * @author 刘雪成 2017年4月5日09:05:35
 * 
 */
public interface ModuleService extends BaseService<Module, Integer> {

	/**
	 * 根据用户编号获取模块列表
	 * @author 刘雪成
	 * @param userID
	 * @return
	 */
	List<Module> getModuleListByUserID(int userID);

	/**
	 * 获取模块数量
	 * 
	 * @author 刘雪成
	 * @param type
	 * @param moduleName
	 * @return
	 */
	int getModuleCount(int type,String moduleName);

	/**
	 * 获取模块分页列表
	 * @author 刘雪成
	 * @param pageable
	 * @param type
	 * @param userID
	 * @param trim
	 * @return
	 */
	Page<Module> getModulePage(Pageable pageable, int type, String sModuleName);

	/**
	 * 保存模块
	 * 
	 * @author 刘雪成
	 * @param module
	 * @return
	 */
	int saveModule(Module module);

	/**
	 * 启用模块 
	 * 
	 * @author 刘雪成 2017年4月10日08:56:49
	 * @param ids
	 * @return
	 */
	int openModules(String ids);

	/**
	 * 禁用模块
	 * 
	 * @author 刘雪成
	 * @param ids
	 * @return
	 */
	int closeModules(String ids);

	/**
	 * 获取模块列表
	 * 
	 * @author 刘雪成
	 * @param i
	 * @return
	 */
	List<Module> getModuleList(int type);


}
