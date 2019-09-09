package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.StockOrdering;
import com.nkty.sms.bean.StockOrderingItem;
import com.nkty.sms.bean.view.ViewStockOrdering;
import com.nkty.sms.dao.StockOrderingDao;
import com.nkty.sms.dao.StockOrderingItemDao;
import com.nkty.sms.dao.ViewStockOrderingDao;
import com.nkty.sms.service.StockOrderingService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 采购订单Service实现类
 * 
 * @author 刘斌 2017年8月2日11:43:03
 * 
 */
@Service(value = "stockOrderingServiceImpl")
public class StockOrderingServiceImpl extends BaseServiceImpl<StockOrdering, Integer>
implements StockOrderingService{
	
	@Resource
	private StockOrderingDao stockOrderingDao;
	
	@Resource
	private StockOrderingItemDao stockOrderingItemDao;
	
	@Resource
	private ViewStockOrderingDao viewStockOrderingDao;
	
	@Resource(name = "stockOrderingDaoImpl")
	public void setBaseDao(StockOrderingDao stockOrderingDao) {
		super.setBaseDao(stockOrderingDao);
	}

	@Override
	public int getViewStockOrderCount(int systemID, int supplierID,
			String begintime, String endtime, int type) {
		StringBuffer where = new StringBuffer();
		begintime=begintime+" 00:00";
		endtime=endtime+" 23:59";
		if (systemID != 0) {
			where.append(" and t.systemID=" + systemID);
		}
		if (supplierID!=0) {
			where.append(" and t.supplierID=" + supplierID);
		}
		if (begintime!=null&&begintime.length()>0) {
			where.append(" and t.orderingTime>='"+begintime+"' and t.orderingTime<='"+endtime+"'");
		}
		if (type!=-1) {
			where.append(" and t.orderingFlag=" + type);
		}else {
			where.append(" and t.orderingFlag in(5,6)");
		}
		return viewStockOrderingDao.getEntityRecordCount(where.toString());
	}

	@Override
	public Page<ViewStockOrdering> getViewStockOrderPage(Pageable pageable,
			int systemID, int supplierID, String begintime, String endtime,
			int type) {
		StringBuffer where = new StringBuffer();
		begintime=begintime+" 00:00";
		endtime=endtime+" 23:59";
		if (systemID != 0) {
			where.append(" and t.systemID=" + systemID);
		}
		if (supplierID!=0) {
			where.append(" and t.supplierID=" + supplierID);
		}
		if (begintime!=null&&begintime.length()>0) {
			where.append(" and t.orderingTime>='"+begintime+"' and t.orderingTime<='"+endtime+"'");
		}
		if (type!=-1) {
			where.append(" and t.orderingFlag=" + type);
		}else {
			where.append(" and t.orderingFlag in(5,6)");
		}
		return viewStockOrderingDao.findPage(where.toString(),
				" order by t.stockOrderingID desc", pageable.getPage(),
				pageable.getLimit());
	}

	private int syncStockOrderingDatas(int systemID, String host, int port,
			String dbname, String username, String password) {
		// 加载数据库驱动,创建连接
		String driverclass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try {
			Class.forName(driverclass);
			System.out.println("加载数据库引擎成功!");
		} catch (Exception e) {
			System.out.println("加载数据库引擎失败!");
			System.exit(0);
		}
		//连接到中间库
		String connectDB = "jdbc:sqlserver://"+host+":"+port+";DatabaseName="+dbname;
		try {
			Connection conn = DriverManager.getConnection(connectDB, username,
					password);
			Statement stmt = conn.createStatement();

			String sql = "select * from StockOrdering where systemID="+systemID;
			ResultSet rs = stmt.executeQuery(sql);
			List<StockOrdering> orderingList = new ArrayList<StockOrdering>();
			while (rs.next()) {
				StockOrdering ordering = new StockOrdering();
				ordering.setSystemID(systemID);
				ordering.setStockOrderingID(rs.getInt("StockOrderingID"));
				ordering.setDepartmentID(rs.getInt("DepartmentID"));
				ordering.setSupplierID(rs.getInt("SupplierID"));
				ordering.setOrderingSource(rs.getInt("OrderingSource"));
				ordering.setOrderingFlag(rs.getInt("OrderingFlag"));
				ordering.setOrderingTime(rs.getString("OrderingTime").substring(0, 19));
				ordering.setUserID(rs.getInt("UserID"));
				ordering.setOperTime(rs.getString("OperTime"));
				ordering.setRemark(rs.getString("Remark"));
				
				orderingList.add(ordering);
			}
			
			for(int i =0;i<orderingList.size();i++){
				int result = this.saveStockOrdering(orderingList.get(i));
				if(result==0){
					//订单主表保存成功,继续保存明细
					String strSql = "select * from StockOrderingItem where systemID="+systemID+" and stockOrderingID="+orderingList.get(i).getStockOrderingID();
					ResultSet rsItem = stmt.executeQuery(strSql);
					List<StockOrderingItem> itemList = new ArrayList<StockOrderingItem>();
					while(rsItem.next()){
						StockOrderingItem item  = new StockOrderingItem();
						item.setSystemID(systemID);
						item.setOrderingItemID(rsItem.getInt("OrderingItemID"));
						item.setStockOrderingID(rsItem.getInt("stockOrderingID"));
						item.setUid(rsItem.getInt("UID"));
						item.setPrice(rsItem.getDouble("Price"));
						item.setOrderingQuantity(rsItem.getDouble("OrderingQuantity"));
						item.setMoney(rsItem.getDouble("Money"));
						item.setDealQuantity(rsItem.getDouble("DealQuantity"));
						itemList.add(item);
						
					}
					int flag = this.saveStockOrderingItemList(itemList);
				}
			}
			
			stmt.close();
			conn.close();
			System.out.println("物流用户信息同步完成!");

		} catch (Exception e) {
			System.out.println("物流用户信息同步失败!");
			e.printStackTrace();
		}
		return 0;
	}

	private int saveStockOrderingItemList(List<StockOrderingItem> itemList) {
		for(int i=0;i<itemList.size();i++){
			String strSql = "select t from StockOrderingItem t where t.systemID="
					+ itemList.get(i).getSystemID()
					+ " and t.orderingItemID="
					+ itemList.get(i).getOrderingItemID();
			List<StockOrderingItem> rsList = this.stockOrderingItemDao.findList(strSql,null);
			if(rsList!=null&&rsList.size()>0){
				itemList.get(i).setItemID(rsList.get(0).getItemID());
				this.stockOrderingItemDao.merge(itemList.get(i));
			}else{
				this.stockOrderingItemDao.persist(itemList.get(i));
			}
		}
		return 0;
	}

	private int saveStockOrdering(StockOrdering stockOrdering) {
		String strSql = "select t from StockOrdering t where t.systemID="
				+ stockOrdering.getSystemID() + " and t.stockOrderingID="
				+ stockOrdering.getStockOrderingID();
		List<StockOrdering> rsList = this.stockOrderingDao.findList(strSql, null);
		if(rsList!=null&&rsList.size()>0){
			stockOrdering.setItemID(rsList.get(0).getItemID());
			this.stockOrderingDao.merge(stockOrdering);
		}else{
			this.stockOrderingDao.persist(stockOrdering);
		}
		return 0;
	}

	@Override
	public List<StockOrdering> getNoDownloadOrderingList(String itemIDS) {
		String sql="select t from StockOrdering t where t.orderingFlag=1 and t.itemID in("+itemIDS+")";
		List<StockOrdering> findList = stockOrderingDao.findList(sql, null);
		return findList;
	}

	@Override
	public int updateOrderingFlag(String itemIDS, int type) {
		String sql=" update  StockOrdering set orderingFlag="+type+" where itemID in("+itemIDS+")";
		stockOrderingDao.execute(sql, null);
		return 0;
	}

	@Override
	public int updateFlag(int systemID, int supplierID, int stockOrderingID) {
		String sql="update StockOrdering set orderingFlag=6 where systemID="+systemID+" and supplierID=(select wuliuSupplierID from SystemSupplier where clouldSupplierID="+supplierID+") and stockOrderingID="+stockOrderingID;
		stockOrderingDao.execute(sql, null);
		return 0;
	}

	@Override
	public int syncStockOrderingData(String strSystemIDs, String host,
			int port, String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncStockOrderingDatas(Integer.parseInt(strs[i]), host, port, dbname, username, password);
			
		}
		return result;
	}

}
