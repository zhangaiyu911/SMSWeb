package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.Supplier;
import com.nkty.sms.bean.view.ViewSupplierSystem;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 供货商Service接口
 * 
 * @author 刘斌 2017年7月19日08:54:33
 * 
 */
public interface SupplierService extends BaseService<Supplier, Integer>{
	
	/**
	 * 保存供货商
	 * 刘斌 2017年7月20日10:54:46
	 * @param supplier
	 * @return
	 */
	int saveSupplier(Supplier supplier);
	
	/**
	 * 根据供货商名称查询
	 * 刘斌 2017年7月21日17:03:56
	 * @param supplierName
	 * @return
	 */
	Supplier checkSupplier(String supplierName);
	
	/**
	 * 获取供货商数量
	 * @author 刘斌 2017年7月24日10:15:58
	 * @return
	 */
	int getViewSupplierSystemCount(int systemID,String supplierName);

	/**
	 * 获取供货商分页列表(视图)
	 * @author 刘斌 2017年7月24日10:16:07
	 * @param pageable
	 * @return
	 */
	Page<ViewSupplierSystem> getViewSupplierSystemPage(Pageable pageable,int systemID,String supplierName);
	
	/**
	 * 审核不通过
	 * 刘斌 2017年7月24日10:57:30
	 * @param itemIDs
	 * @return
	 */
	int delSupplier(String itemIDs,String memo);
	
	/**
	  * 审核通过
	  * 刘斌 2017年7月24日10:57:40
	  * @param itemIDs
	  * @return
	  */
	 int successSupplier(String itemIDs);
	 
	 /**
	  * 根据供货商编号ids查询
	  * @param supplierIds
	  * @return
	  */
	 List<Supplier> getSupplierList(String supplierIds);
	 

}
