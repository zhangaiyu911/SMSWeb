package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.CertificatesOrdering;
import com.nkty.sms.bean.view.ViewCertificatesOrdering;

/**
 * 证件和订单关联表Service接口
 * 
 * @author 刘斌 2017年7月31日16:14:21
 * 
 */
public interface CertificatesOrderingService extends BaseService<CertificatesOrdering, Integer>{
	
	/**
	 * 根据订单查询
	 * 刘斌 2017年7月31日17:12:15
	 * @param systemID
	 * @param supplierID
	 * @param orderingID
	 * @param orderingItemID
	 * @return
	 */
	List<ViewCertificatesOrdering> getViewCertificatesOrderingList(int systemID, int supplierID, int orderingID,int orderingItemID,int orderingType);
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	int delCertificatesOrdering(String ids);

}
