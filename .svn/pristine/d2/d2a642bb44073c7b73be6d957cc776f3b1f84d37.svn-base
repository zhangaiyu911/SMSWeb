package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.CertificatesOrdering;
import com.nkty.sms.bean.view.ViewCertificatesOrdering;
import com.nkty.sms.dao.CertificatesOrderingDao;
import com.nkty.sms.dao.ViewCertificatesOrderingDao;
import com.nkty.sms.service.CertificatesOrderingService;

/**
 * 证件和订单关联表Service实现类
 * 
 * @author 刘斌 2017年7月31日16:15:12
 * 
 */
@Service(value = "certificatesOrderingServiceImpl")
public class CertificatesOrderingServiceImpl extends BaseServiceImpl<CertificatesOrdering, Integer>
implements CertificatesOrderingService{
	
	@Resource
	private CertificatesOrderingDao certificatesOrderingDao;
	
	@Resource
	private ViewCertificatesOrderingDao viewCertificatesOrderingDao;
	
	@Resource(name = "certificatesOrderingDaoImpl")
	public void setBaseDao(CertificatesOrderingDao certificatesOrderingDao) {
		super.setBaseDao(certificatesOrderingDao);
	}

	@Override
	public List<ViewCertificatesOrdering> getViewCertificatesOrderingList(
			int systemID, int supplierID, int orderingID, int orderingItemID,int orderingType) {
		String sql="select t from ViewCertificatesOrdering t where t.systemID="+systemID+" and t.supplierID="+supplierID+" and t.orderingID="+orderingID+" and t.orderingItemID="+orderingItemID+" and t.orderingType="+orderingType;
		List<ViewCertificatesOrdering> findList = viewCertificatesOrderingDao.findList(sql, null);
		return findList;
	}

	@Override
	public int delCertificatesOrdering(String ids) {
		String sql="delete from CertificatesOrdering where itemID in("+ids+")";
		certificatesOrderingDao.execute(sql, null);
		return 0;
	}

}
