package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.StockOrdering;
import com.nkty.sms.bean.view.ViewStockOrdering;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 采购订单Service接口
 * 
 * @author 刘斌 2017年8月2日11:41:06
 * 
 */
public interface StockOrderingService extends BaseService<StockOrdering, Integer>{
	
	/**
	 * 获取订单数量
	 * @author 刘斌 2017年8月2日14:18:23
	 * @return
	 */
	int getViewStockOrderCount(int systemID,int supplierID,String begintime,String endtime,int type);

	/**
	 * 获取订单分页列表(视图)
	 * @author 刘斌 2017年8月2日14:18:41
	 * @param pageable
	 * @return
	 */
	Page<ViewStockOrdering> getViewStockOrderPage(Pageable pageable,int systemID,int supplierID,String begintime,String endtime,int type);

	/**
	 * 从中转临时库向云服务器同步采购订货信息
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @return
	 */
	int syncStockOrderingData(String strSystemIDs, String host, int port,
			String dbname, String username, String password);
	
	/**
	 * 根据itemID查询
	 * 刘斌 2017年8月2日09:55:42
	 * @param itemIDS
	 * @return
	 */
	List<StockOrdering> getNoDownloadOrderingList(String itemIDS);
	
	/**
	 * 修改状态
	 * 刘斌 2017年8月2日09:55:38
	 * @param itemIDS
	 * @return
	 */
	int updateOrderingFlag(String itemIDS,int type);
	
	/**
	 * 更改状态
	 * 刘斌 2017年8月2日16:47:50
	 * @param systemID
	 * @param supplierID
	 * @param stockOrderingID
	 * @return
	 */
	int updateFlag(int systemID,int supplierID,int stockOrderingID);

}
