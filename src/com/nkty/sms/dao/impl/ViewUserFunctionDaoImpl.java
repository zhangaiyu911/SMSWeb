package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.view.ViewUserFunction;
import com.nkty.sms.dao.ViewUserFunctionDao;

/**
 * 用户功能视图Dao实现类
 * 
 * @author 刘雪成 2017年4月12日15:16:44
 * 
 */
@Repository(value = "viewUserFunctionDaoImpl")
public class ViewUserFunctionDaoImpl extends
		BaseDaoImpl<ViewUserFunction, Integer> implements ViewUserFunctionDao {

}
