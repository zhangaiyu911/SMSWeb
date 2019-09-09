package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.OrderingItem;
import com.nkty.sms.bean.view.ViewOrderingItem;
/**
 * 订单详情Service接口
 * 
 * @author 刘斌 2017年7月18日16:33:32
 * 
 */
public interface OrderingItemService extends BaseService<OrderingItem, Integer>{
	
	/**
	 * 根据定单主表编号查询详情
	 * 刘斌 2017年7月26日11:21:45
	 * @param systemID
	 * @param orderingID
	 * @return
	 */
	List<ViewOrderingItem> getViewOrderingItemList(int systemID,int orderingID);
	
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
