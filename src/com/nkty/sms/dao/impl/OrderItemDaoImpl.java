package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.OrderItem;
import com.nkty.sms.dao.OrderItemDao;

@Repository(value = "orderItemDaoImpl")
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem, Integer> implements
		OrderItemDao {

}
