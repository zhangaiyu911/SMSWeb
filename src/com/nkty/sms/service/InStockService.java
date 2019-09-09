package com.nkty.sms.service;

import com.nkty.sms.bean.InStock;
import com.nkty.sms.bean.view.ViewInStock;
import com.nkty.sms.bean.view.ViewPurchaseInStock;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 入库单Service接口
 * 
 * @author 刘斌 2017年7月18日16:33:32
 * 
 */
public interface InStockService extends BaseService<InStock, Integer>{
	
	/**
	 * 获取入库单数量
	 * @author 刘斌 2017年7月26日09:11:33
	 * @return
	 */
	int getViewInStockCount(int systemID,int supplierID,String begintime,String endtime);

	/**
	 * 获取入库单分页列表(视图)
	 * @author 刘斌 2017年7月26日09:11:40
	 * @param pageable
	 * @return
	 */
	Page<ViewInStock> getViewInStockPage(Pageable pageable,int systemID,int supplierID,String begintime,String endtime);
	
	/**
	 * 获取采购入库单数量
	 * @author 刘斌 2017年7月26日09:11:33
	 * @return
	 */
	int getViewPurchaseInStockCount(int systemID,int supplierID,String begintime,String endtime);

	/**
	 * 获取采购入库单分页列表(视图)
	 * @author 刘斌 2017年7月26日09:11:40
	 * @param pageable
	 * @return
	 */
	Page<ViewPurchaseInStock> getViewPurchaseInStockPage(Pageable pageable,int systemID,int supplierID,String begintime,String endtime);

	/**
	 * 同步采购入库信息
	 * 
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @return
	 */
	int syncInStockData(String strSystemIDs, String host, int port, String dbname,
			String username, String password);

}
