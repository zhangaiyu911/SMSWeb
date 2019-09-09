package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.view.ViewInStock;
import com.nkty.sms.dao.ViewInStockDao;

@Repository("viewInStockDaoImpl")
public class ViewInStockDaoImpl extends BaseDaoImpl<ViewInStock, Integer>
implements ViewInStockDao{

}
