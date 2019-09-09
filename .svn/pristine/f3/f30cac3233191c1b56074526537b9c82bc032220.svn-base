package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.StockOrderingItem;
import com.nkty.sms.bean.view.ViewStockOrderingItem;

/**
 * 采购订单详情Service接口
 * 
 * @author 刘斌 2017年8月2日11:46:24
 * 
 */
public interface StockOrderingItemService extends BaseService<StockOrderingItem, Integer>{
	
	/**
	 * 根据定单主表编号查询详情
	 * 刘斌 2017年8月2日15:34:05
	 * @param systemID
	 * @param stockOrderingID
	 * @return
	 */
	List<ViewStockOrderingItem> getViewStockOrderingItemList(int systemID,int stockOrderingID);
	
	/**
	 * 配置时间（生产日期和保质期）
	 * 刘斌 2017年7月31日09:50:23
	 * @param itemID
	 * @param productionDate
	 * @param shelfLife
	 * @return
	 */
	int configureDate(int itemID,String productionDate,String shelfLife);

}
