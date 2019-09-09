package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.view.ViewFunction;
import com.nkty.sms.dao.ViewFunctionDao;

/**
 * 系统功能视图Dao实现类
 * 
 * @author 刘雪成
 *
 */
@Repository(value="viewFunctionDaoImpl")
public class ViewFunctionDaoImpl extends BaseDaoImpl<ViewFunction, Integer> implements
		ViewFunctionDao {

}
