package com.nkty.sms.service.impl;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.OrderItem;
import com.nkty.sms.service.OrderItemService;

@Service(value = "orderItemServiceImpl")
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem, Integer>
		implements OrderItemService {

}
