package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.RegistCode;
import com.nkty.sms.dao.RegistCodeDao;

/**
 * 注册码Dao实现类
 * 
 * @author 刘雪成
 * 
 */
@Repository(value = "registCodeDaoImpl")
public class RegistCodeDaoImpl extends BaseDaoImpl<RegistCode, Integer>
		implements RegistCodeDao {

}
