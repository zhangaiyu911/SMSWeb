package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.UserSysSupplier;
import com.nkty.sms.dao.UserSysSupplierDao;

@Repository("userSysSupplierDaoImpl")
public class UserSysSupplierDaoImpl extends BaseDaoImpl<UserSysSupplier, Integer>
	implements UserSysSupplierDao{

}
