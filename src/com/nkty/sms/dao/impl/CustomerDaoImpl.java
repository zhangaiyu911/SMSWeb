package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.Customer;
import com.nkty.sms.dao.CustomerDao;

/**
 * 食堂Dao实现类
 * 
 * @author 刘斌 2017年7月19日09:23:22
 * 
 */
@Repository(value="customerDaoImpl")
public class CustomerDaoImpl extends BaseDaoImpl<Customer, Integer> implements
CustomerDao{

}
