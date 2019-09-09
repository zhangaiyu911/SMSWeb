package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.StockOrderingItem;
import com.nkty.sms.bean.view.ViewStockOrderingItem;
import com.nkty.sms.dao.StockOrderingItemDao;
import com.nkty.sms.dao.ViewStockOrderingItemDao;
import com.nkty.sms.service.StockOrderingItemService;

/**
 * 采购订单Service实现类
 * 
 * @author 刘斌 2017年8月2日11:43:03
 * 
 */
@Service(value = "StockOrderingItemServiceImpl")
public class StockOrderingItemServiceImpl extends BaseServiceImpl<StockOrderingItem, Integer>
implements StockOrderingItemService{
	
	@Resource
	private StockOrderingItemDao stockOrderingItemDao;
	
	@Resource
	private  ViewStockOrderingItemDao viewStockOrderingItemDao;
	
	@Resource(name = "stockOrderingItemDaoImpl")
	public void setBaseDao(StockOrderingItemDao stockOrderingItemDao) {
		super.setBaseDao(stockOrderingItemDao);
	}

	@Override
	public List<ViewStockOrderingItem> getViewStockOrderingItemList(
			int systemID, int stockOrderingID) {
		String sql="select t from ViewStockOrderingItem t where 1=1";
		if (systemID!=0) {
			sql+=" and t.systemID="+systemID;
		}
		if (stockOrderingID!=0) {
			sql+=" and t.stockOrderingID="+stockOrderingID;
		}
		List<ViewStockOrderingItem> findList = viewStockOrderingItemDao.findList(sql, null);
		return findList;
	}

	@Override
	public int configureDate(int itemID, String productionDate, String shelfLife) {
		String sql2="select t from StockOrderingItem t where t.itemID in("+itemID+")";
		List<StockOrderingItem> findList = stockOrderingItemDao.findList(sql2, null);
		if (findList!=null&&findList.size()>0) {
			String sql="update StockOrderingItem set productionDate='"+productionDate+"', shelfLife='"+shelfLife+"' where itemID="+itemID;
			stockOrderingItemDao.execute(sql, null);
			return 0;
		}else {
			return -1;
		}
	}

}
