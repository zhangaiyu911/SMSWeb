package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.UserTbl;
import com.nkty.sms.dao.UserTblDao;

@Repository(value = "userTblDaoImpl")
public class UserTblDaoImpl extends BaseDaoImpl<UserTbl, Integer> implements
		UserTblDao {

}
