package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.Function;
import com.nkty.sms.dao.FunctionDao;

@Repository(value = "functionDaoImpl")
public class FunctionDaoImpl extends BaseDaoImpl<Function, Integer> implements
		FunctionDao {

}
