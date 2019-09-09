package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.InStockItem;
import com.nkty.sms.bean.view.ViewInStockItem;
import com.nkty.sms.bean.view.ViewPurchaseInStockItem;
import com.nkty.sms.dao.InStockItemDao;
import com.nkty.sms.dao.ViewInStockItemDao;
import com.nkty.sms.dao.ViewPurchaseInStockDao;
import com.nkty.sms.dao.ViewPurchaseInStockItemDao;
import com.nkty.sms.service.InStockItemService;
import com.nkty.sms.util.Pageable;

/**
 * 入库单明细Service实现类
 * 
 * @author 刘斌 2017年7月26日16:02:01
 * 
 */
@Service(value = "inStockItemServiceImpl")
public class InStockItemServiceImpl extends BaseServiceImpl<InStockItem, Integer>
implements InStockItemService{
	
	@Resource
	private InStockItemDao inStockItemDao;
	
	@Resource
	private ViewInStockItemDao viewInStockItemDao;
	
	@Resource
	private ViewPurchaseInStockDao viewPurchaseInStockDao;
	
	@Resource
	private ViewPurchaseInStockItemDao viewPurchaseInStockItemDao;
	
	@Resource(name = "inStockItemDaoImpl")
	public void setBaseDao(InStockItemDao inStockItemDao) {
		super.setBaseDao(inStockItemDao);
	}
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<ViewInStockItem> getViewInStockItemList(int systemID,
			int instockid) {
		String sql="select t from ViewInStockItem t where 1=1";
		if (systemID!=0) {
			sql+=" and t.systemID="+systemID;
		}
		if (instockid!=0) {
			sql+=" and t.instockid="+instockid;
		}
		List<ViewInStockItem> findList = viewInStockItemDao.findList(sql, null);
		return findList;
	}

	@Override
	public int getViewInStockItemCount(int systemID, int supplierID,String begintime, String endtime) {
		String sql="select count(*) from (select v.uid from ViewInStockItem v where (1=1)";
		if (begintime!=null&&begintime.length()>0) {
			sql+=" and v.instocktime>='"+begintime+"' and v.instocktime<='"+endtime+"'";
		}
		if (systemID!=0) {
			sql+=" and v.systemID="+systemID;
		}
		if (supplierID!=0) {
			sql+=" and v.supplierID="+supplierID;
		}
		sql+="group by v.uid,v.productName,v.unit having sum(v.instockquantity)<>0) as t";
		Query query = this.entityManager.createNativeQuery(sql);
		Object countObject = query.getSingleResult();
		String countString = countObject.toString();
		int count = Integer.parseInt(countString);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewInStockItem> getViewInStockItemPage(Pageable pageable,
			int systemID, int supplierID,String begintime, String endtime) {
		List<ViewInStockItem> resultList=null;
		String sql="select new ViewInStockItem(v.uid,v.productName,v.unit,AVG(v.instockprice) as instockprice," +
				"SUM(v.instockquantity) as instockquantity,SUM(v.instockmoney) as instockmoney) from ViewInStockItem v where (1=1)";
		if (begintime!=null&&begintime.length()>0) {
			sql+=" and v.instocktime>='"+begintime+"' and v.instocktime<='"+endtime+"'";
		}
		if (systemID!=0) {
			sql+=" and v.systemID="+systemID;
		}
		if (supplierID!=0) {
			sql+=" and v.supplierID="+supplierID;
		}
		sql+="group by v.uid,v.productName,v.unit having sum(v.instockquantity)<>0";
		sql+=" order by v.uid";
		Query query = entityManager.createQuery(sql);
		query.setFirstResult((pageable.getPage() - 1) * pageable.getLimit());
		query.setMaxResults(pageable.getLimit());
		resultList=query.getResultList();
		return resultList;
	}

	@Override
	public int getViewPurchaseInStockItemCount(int systemID, int supplierID,
			String begintime, String endtime) {
		String sql="select count(*) from (select v.uid from ViewPurchaseInStockItem v where (1=1)";
		if (begintime!=null&&begintime.length()>0) {
			sql+=" and v.instocktime>='"+begintime+"' and v.instocktime<='"+endtime+"'";
		}
		if (systemID!=0) {
			sql+=" and v.systemID="+systemID;
		}
		if (supplierID!=0) {
			sql+=" and v.supplierID="+supplierID;
		}
		sql+="group by v.uid,v.productName,v.unit having sum(v.instockquantity)<>0) as t";
		Query query = this.entityManager.createNativeQuery(sql);
		Object countObject = query.getSingleResult();
		String countString = countObject.toString();
		int count = Integer.parseInt(countString);
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ViewPurchaseInStockItem> getViewPurchaseInStockItemPage(
			Pageable pageable, int systemID, int supplierID, String begintime,
			String endtime) {
		List<ViewPurchaseInStockItem> resultList=null;
		String sql="select new ViewPurchaseInStockItem(v.uid,v.productName,v.unit,AVG(v.instockprice) as instockprice," +
				"SUM(v.instockquantity) as instockquantity,SUM(v.instockmoney) as instockmoney) from ViewPurchaseInStockItem v where (1=1)";
		if (begintime!=null&&begintime.length()>0) {
			sql+=" and v.instocktime>='"+begintime+"' and v.instocktime<='"+endtime+"'";
		}
		if (systemID!=0) {
			sql+=" and v.systemID="+systemID;
		}
		if (supplierID!=0) {
			sql+=" and v.supplierID="+supplierID;
		}
		sql+="group by v.uid,v.productName,v.unit having sum(v.instockquantity)<>0";
		sql+=" order by v.uid";
		Query query = entityManager.createQuery(sql);
		query.setFirstResult((pageable.getPage() - 1) * pageable.getLimit());
		query.setMaxResults(pageable.getLimit());
		resultList=query.getResultList();
		return resultList;
	}

	@Override
	public List<ViewPurchaseInStockItem> getViewPurchaseInInStockItemList(
			int systemID, int instockid) {
		String sql="select t from ViewPurchaseInStockItem t where 1=1";
		if (systemID!=0) {
			sql+=" and t.systemID="+systemID;
		}
		if (instockid!=0) {
			sql+=" and t.instockid="+instockid;
		}
		List<ViewPurchaseInStockItem> findList = viewPurchaseInStockItemDao.findList(sql, null);
		return findList;
	}

}
