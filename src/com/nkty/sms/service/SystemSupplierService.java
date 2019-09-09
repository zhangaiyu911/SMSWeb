package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.SystemSupplier;
import com.nkty.sms.bean.view.ViewSupplierSystem;

/**
 * 客户供货商Service接口
 * 
 * @author 刘斌2017年7月19日09:40:13
 * 
 */
public interface SystemSupplierService extends BaseService<SystemSupplier, Integer>{
	
	/**
	 * 保存
	 * 刘斌 2017年7月20日11:10:07
	 * @param systemSupplier
	 * @return
	 */
	 int saveSystemSupplier(SystemSupplier systemSupplier);
	 
	 /**
	  * 验证是否存在
	  * 刘斌 2017年7月21日17:06:44
	  * @param systemID
	  * @param wuliuSupplierID
	  * @return
	  */
	 SystemSupplier checkSystemSupplier(int systemID,int wuliuSupplierID);
	 
	 /**
	  * 根据供货商编号查询
	  * 刘斌 2017年7月26日09:21:35
	  * @param clouldSupplierID
	  * @return
	  */
	 List<ViewSupplierSystem> getSystemSupplierList(int clouldSupplierID);
	 
	 /**
	  * 根据系统编号查询供货商
	  * 刘斌 2017年8月3日15:45:38
	  * @param systemID
	  * @return
	  */
	 List<ViewSupplierSystem> getSystemSuppliers(int systemID);
	 
	 /**
	  * 根据供货商编号查询
	  * 刘斌 2017年7月26日09:21:35
	  * @param clouldSupplierID
	  * @return
	  */
	 List<ViewSupplierSystem> getAllSystemSupplierList(int clouldSupplierID);
	 
	 /**
	  * 根据供货商编号查询
	  * 刘斌 2017年7月26日09:21:35
	  * @param clouldSupplierID
	  * @return
	  */
	 List<ViewSupplierSystem> getSystemSupplierListByID(int clouldSupplierID);

}
