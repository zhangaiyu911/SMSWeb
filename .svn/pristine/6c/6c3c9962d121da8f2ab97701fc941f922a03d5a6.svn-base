package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.InStockItem;
import com.nkty.sms.bean.view.ViewInStockItem;
import com.nkty.sms.bean.view.ViewPurchaseInStockItem;
import com.nkty.sms.util.Pageable;

/**
 * 入库单明细Service接口
 * 
 * @author 刘斌 2017年7月26日16:01:27
 * 
 */
public interface InStockItemService extends BaseService<InStockItem, Integer>{
	
	/**
	 * 根据入库单主表编号查询详情
	 * 刘斌 2017年7月26日16:04:57
	 * @param systemID
	 * @param orderingID
	 * @return
	 */
	List<ViewInStockItem> getViewInStockItemList(int systemID,int instockid);
	
	/**
	 * 获取入库单明细汇总数量
	 * @author 刘斌 2017年7月26日17:04:40
	 * @return
	 */
	int getViewInStockItemCount(int systemID,int supplierID,String begintime, String endtime);

	/**
	 * 获取入库单明细汇总分页列表(视图)
	 * @author 刘斌 2017年7月26日17:04:44
	 * @param pageable
	 * @return
	 */
	List<ViewInStockItem> getViewInStockItemPage(Pageable pageable,int systemID,int supplierID,String begintime, String endtime);
	
	/**
	 * 获取入库单明细汇总数量
	 * @author 刘斌 2017年7月26日17:04:40
	 * @return
	 */
	int getViewPurchaseInStockItemCount(int systemID,int supplierID,String begintime, String endtime);

	/**
	 * 获取入库单明细汇总分页列表(视图)
	 * @author 刘斌 2017年7月26日17:04:44
	 * @param pageable
	 * @return
	 */
	List<ViewPurchaseInStockItem> getViewPurchaseInStockItemPage(Pageable pageable,int systemID,int supplierID,String begintime, String endtime);
	
	/**
	 * 根据入库单主表编号查询详情
	 * 刘斌 2017年7月26日16:04:57
	 * @param systemID
	 * @param orderingID
	 * @return
	 */
	List<ViewPurchaseInStockItem> getViewPurchaseInInStockItemList(int systemID,int instockid);

}
