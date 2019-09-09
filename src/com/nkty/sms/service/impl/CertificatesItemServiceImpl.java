package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.CertificatesItem;
import com.nkty.sms.bean.view.ViewCertificatesItem;
import com.nkty.sms.dao.CertificatesItemDao;
import com.nkty.sms.dao.ViewCertificatesItemDao;
import com.nkty.sms.service.CertificatesItemService;

/**
 * 证件详情Service实现类
 * 
 * @author 刘斌 2017年7月19日09:16:47
 * 
 */
@Service(value = "certificatesItemServiceImpl")
public class CertificatesItemServiceImpl extends BaseServiceImpl<CertificatesItem, Integer>
implements CertificatesItemService{
	
	@Resource
	private CertificatesItemDao CertificatesItemDao;
	
	@Resource
	private ViewCertificatesItemDao viewCertificatesItemDao;

	@Resource(name = "certificatesItemDaoImpl")
	public void setBaseDao(CertificatesItemDao CertificatesItemDao) {
		super.setBaseDao(CertificatesItemDao);
	}
	
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public int saveCertificatesItem(int supplierID, String ids) {
		try {
			String sql="insert into CertificatesItem select "+supplierID+",t.certificatesID,'','','' from Certificates t where t.certificatesID in("+ids+")";
			Query query = this.entityManager.createNativeQuery(sql);
			query.executeUpdate();
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public List<ViewCertificatesItem> getViewCertificatesItemList(int supplierID,
			String ids) {
		String sql="select t from ViewCertificatesItem t where 1=1" ;
		if (supplierID!=0) {
			sql+=" and t.supplierID="+supplierID;
		}
		if (ids!=null&&ids.length()>0) {
			sql+=" and t.certificatesID in("+ids+")";
		}
		List<ViewCertificatesItem> findList = viewCertificatesItemDao.findList(sql, null);
		return findList;
	}

}
