package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.view.ViewOrdering;
import com.nkty.sms.dao.ViewOrderingDao;

@Repository("viewOrderingDaoImpl")
public class ViewOrderingDaoImpl extends BaseDaoImpl<ViewOrdering, Integer>
implements ViewOrderingDao{

}
