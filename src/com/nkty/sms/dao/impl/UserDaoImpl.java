/**
 * UserDaoImpl.java
 * Copyright 2015 NKTY(Tianjin)High Technology Development Ltd.
 * All rights reserved. 
 * Created on 2015-12-25 下午2:16:48
 */
package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.User;
import com.nkty.sms.dao.UserDao;

/**
 * 用户管理dao接口实现类.
 * <p><br>
 * @author 陈荣盛
 * @version 1.0.0, 2015-12-25
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User, Integer>
	implements UserDao {
}