package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.CertificatesItem;
import com.nkty.sms.dao.CertificatesItemDao;
/**
 * 证件详情Dao实现类
 * 
 * @author 刘斌 2017年7月19日09:15:02
 * 
 */
@Repository(value="certificatesItemDaoImpl")
public class CertificatesItemDaoImpl extends BaseDaoImpl<CertificatesItem, Integer> implements
	CertificatesItemDao {

}
