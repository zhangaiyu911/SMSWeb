package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.view.ViewOrderingItem;
import com.nkty.sms.dao.ViewOrderingItemDao;

@Repository("viewOrderingItemDaoImpl")
public class ViewOrderingItemDaoImpl extends BaseDaoImpl<ViewOrderingItem, Integer>
implements ViewOrderingItemDao{

}
