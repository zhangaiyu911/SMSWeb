package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.view.ViewCertificatesOrdering;
import com.nkty.sms.dao.ViewCertificatesOrderingDao;

/**
 * 证件和订单关联表视图Dao实现类
 * 
 * @author 刘斌 2017年7月31日17:09:58
 *
 */
@Repository(value="viewCertificatesOrderingDaoImpl")
public class ViewCertificatesOrderingDaoImpl extends BaseDaoImpl<ViewCertificatesOrdering, Integer> implements ViewCertificatesOrderingDao{

}
