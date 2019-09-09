package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.CertificatesOrdering;
import com.nkty.sms.dao.CertificatesOrderingDao;

/**
 * 证件和订单关联表Dao实现类
 * 
 * @author 刘斌 2017年7月31日15:59:19
 * 
 */
@Repository(value="certificatesOrderingDaoImpl")
public class CertificatesOrderingDaoImpl extends BaseDaoImpl<CertificatesOrdering, Integer> implements
CertificatesOrderingDao {

}
