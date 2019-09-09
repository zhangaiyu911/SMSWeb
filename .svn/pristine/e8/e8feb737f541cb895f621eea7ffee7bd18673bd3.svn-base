package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.OrderingItem;
import com.nkty.sms.bean.view.ViewOrderingItem;
import com.nkty.sms.dao.OrderingItemDao;
import com.nkty.sms.dao.ViewOrderingItemDao;
import com.nkty.sms.service.OrderingItemService;

/**
 * 订单详情Service实现类
 * 
 * @author 刘斌 2017年7月18日16:34:07
 * 
 */
@Service(value = "orderingItemServiceImpl")
public class OrderingItemServiceImpl extends BaseServiceImpl<OrderingItem, Integer>
implements OrderingItemService{
	
	@Resource
	private OrderingItemDao orderingItemDao;
	
	@Resource
	private  ViewOrderingItemDao viewOrderingItemDao;

	@Resource(name = "orderingItemDaoImpl")
	public void setBaseDao(OrderingItemDao orderingItemDao) {
		super.setBaseDao(orderingItemDao);
	}

	@Override
	public List<ViewOrderingItem> getViewOrderingItemList(int systemID,
			int orderingID) {
		String sql="select t from ViewOrderingItem t where 1=1";
		if (systemID!=0) {
			sql+=" and t.systemID="+systemID;
		}
		if (orderingID!=0) {
			sql+=" and t.orderingID="+orderingID;
		}
		List<ViewOrderingItem> findList = viewOrderingItemDao.findList(sql, null);
		return findList;
	}

	@Override
	public int configureDate(int itemID,String productionDate,String shelfLife) {
		String sql2="select t from OrderingItem t where t.itemID in("+itemID+")";
		List<OrderingItem> findList = orderingItemDao.findList(sql2, null);
		if (findList!=null&&findList.size()>0) {
			String sql="update OrderingItem set productionDate='"+productionDate+"', shelfLife='"+shelfLife+"' where itemID="+itemID;
			orderingItemDao.execute(sql, null);
			return 0;
		}else {
			return -1;
		}
		
		
	}

}
