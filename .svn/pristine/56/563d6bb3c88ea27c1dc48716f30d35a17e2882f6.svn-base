package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.Ordering;
import com.nkty.sms.bean.view.ViewOrdering;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 订单Service接口
 * 
 * @author 刘斌 2017年7月18日16:24:15
 * 
 */
public interface OrderingService extends BaseService<Ordering, Integer>{
	
	/**
	 * 获取订单数量
	 * @author 刘斌 2017年7月26日09:11:33
	 * @return
	 */
	int getViewOrderCount(int systemID,int supplierID,String begintime,String endtime,int orderingFlag);

	/**
	 * 获取订单分页列表(视图)
	 * @author 刘斌 2017年7月26日09:11:40
	 * @param pageable
	 * @return
	 */
	Page<ViewOrdering> getViewOrderPage(Pageable pageable,int systemID,int supplierID,String begintime,String endtime,int orderingFlag);
	
	/**
	 * 更改状态
	 * 刘斌 2017年7月31日12:02:33
	 * @param systemID
	 * @param supplierID
	 * @param orderingID
	 * @return
	 */
	int updateFlag(int systemID,int supplierID,int orderingID);
	
	/**
	 * 根据itemID查询
	 * 刘斌 2017年8月2日09:55:42
	 * @param itemIDS
	 * @return
	 */
	List<Ordering> getNoDownloadOrderingList(String itemIDS);
	
	/**
	 * 修改状态
	 * 刘斌 2017年8月2日09:55:38
	 * @param itemIDS
	 * @return
	 */
	int updateOrderingFlag(String itemIDS,int type);

	/**
	 * 同步食堂订货信息
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @return
	 */
	int syncOrderingData(String strSystemIDs, String host, int port, String dbname,
			String username, String password);

}
