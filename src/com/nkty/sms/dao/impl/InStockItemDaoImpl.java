package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.InStockItem;
import com.nkty.sms.dao.InStockItemDao;

/**
 * 入库单明细Dao实现类
 * 
 * @author 刘斌 2017年7月26日14:50:48
 * 
 */
@Repository(value="inStockItemDaoImpl")
public class InStockItemDaoImpl  extends BaseDaoImpl<InStockItem, Integer> implements
InStockItemDao{

}
