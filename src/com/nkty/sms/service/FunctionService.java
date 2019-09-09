package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.Function;
import com.nkty.sms.bean.view.ViewFunction;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

public interface FunctionService extends BaseService<Function, Integer> {

	/**
	 * 获取功能列表
	 * @author 刘雪成
	 * @param userID
	 * @param moduleID
	 * @return
	 */
	List<Function> getUserFunctionList(int userID, int moduleID);

	/**
	 * 获取功能数
	 * 
	 * @author 刘雪成
	 * @param type
	 * @param functionName
	 * @return
	 */
	int getFunctionCount(int type, String functionName);

	/**
	 * 获取功能分页信息
	 * 
	 * @author 刘雪成
	 * @param pageable
	 * @param type
	 * @param functionName
	 * @return
	 */
	Page<ViewFunction> getFunctionPage(Pageable pageable, int type,
			String functionName);

	/**
	 * 保存系统功能信息
	 * 
	 * @author 刘雪成
	 * @param function
	 * @return
	 */
	int saveFunction(Function function);

	/**
	 * 启用系统功能
	 * 
	 * @author 刘雪成
	 * @param ids
	 * @return
	 */
	int openFunctions(String ids);

	/**
	 * 禁用系统功能
	 * 
	 * @author 刘雪成
	 * @param ids
	 * @return
	 */
	int closeFunctions(String ids);

	/**
	 * 获取功能列表
	 * 
	 * @author 刘雪成
	 * @param moduleID
	 * @return
	 */
	List<ViewFunction> getViewFunctionList(int moduleID,int type);

	/**
	 * 获取功能列表
	 * 
	 * @author 刘雪成
	 * @param type
	 * @return
	 */
	List<Function> getFunctionList(int moduleID,int type);

}
