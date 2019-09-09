package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Certificates;
import com.nkty.sms.dao.CertificatesDao;
import com.nkty.sms.service.CertificatesService;

/**
 * 证件Service实现类
 * 
 * @author 刘斌 2017年7月19日09:05:34
 * 
 */
@Service(value = "certificatesServiceImpl")
public class CertificatesServiceImpl extends BaseServiceImpl<Certificates, Integer>
implements CertificatesService{
	
	@Resource
	private CertificatesDao certificatesDao;

	@Resource(name = "certificatesDaoImpl")
	public void setBaseDao(CertificatesDao certificatesDao) {
		super.setBaseDao(certificatesDao);
	}

	@Override
	public List<Certificates> getCertificatesList(int type) {
		String sql="select t from Certificates t where t.usingFlag=1";
		if (type!=0) {
			sql+=" and t.certificatesType="+type;
		}
		List<Certificates> findList = certificatesDao.findList(sql, null);
		return findList;
	}

}
