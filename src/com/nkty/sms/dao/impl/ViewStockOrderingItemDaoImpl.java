package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.view.ViewStockOrderingItem;
import com.nkty.sms.dao.ViewStockOrderingItemDao;

/**
 * 采购订单明细视图Dao实现类
 * 
 * @author 刘斌 2017年8月2日15:25:08
 * 
 */
@Repository(value="viewStockOrderingItemDaoImpl")
public class ViewStockOrderingItemDaoImpl extends BaseDaoImpl<ViewStockOrderingItem, Integer> implements
ViewStockOrderingItemDao {

}
