package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.OrderItem;
import com.nkty.sms.bean.Ordering;
import com.nkty.sms.bean.OrderingItem;
import com.nkty.sms.bean.Orders;
import com.nkty.sms.bean.view.ViewOrdering;
import com.nkty.sms.dao.OrderingDao;
import com.nkty.sms.dao.OrderingItemDao;
import com.nkty.sms.dao.ViewOrderingDao;
import com.nkty.sms.service.OrderingService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 订单Service实现类
 * 
 * @author 刘斌 2017年7月18日16:24:54
 * 
 */
@Service(value = "orderingServiceImpl")
public class OrderingServiceImpl extends BaseServiceImpl<Ordering, Integer>
implements OrderingService{
	
	@Resource
	private OrderingDao orderingDao;
	
	@Resource
	private OrderingItemDao orderingItemDao;
	
	@Resource
	private ViewOrderingDao viewOrderingDao;

	@Resource(name = "orderingDaoImpl")
	public void setBaseDao(OrderingDao orderingDao) {
		super.setBaseDao(orderingDao);
	}

	@Override
	public int getViewOrderCount(int systemID,int supplierID,String begintime,String endtime,int orderingFlag) {
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
		if (orderingFlag!=-1) {
			where.append(" and t.orderingFlag=" + orderingFlag);
		}else {
			where.append(" and t.orderingFlag in(5,6)");
		}
		return viewOrderingDao.getEntityRecordCount(where.toString());
	}

	@Override
	public Page<ViewOrdering> getViewOrderPage(Pageable pageable,
			int systemID,int supplierID,String begintime,String endtime,int orderingFlag) {
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
		if (orderingFlag!=-1) {
			where.append(" and t.orderingFlag=" + orderingFlag);
		}else {
			where.append(" and t.orderingFlag in(5,6)");
		}
		return viewOrderingDao.findPage(where.toString(),
				" order by t.orderingID desc", pageable.getPage(),
				pageable.getLimit());
	}

	@Override
	public int updateFlag(int systemID, int supplierID, int orderingID) {
		String sql="update Ordering set orderingFlag=6 where systemID="+systemID+" and supplierID=(select wuliuSupplierID from SystemSupplier where clouldSupplierID="+supplierID+") and orderingID="+orderingID;
		orderingDao.execute(sql, null);
		return 0;
	}

	@Override
	public List<Ordering> getNoDownloadOrderingList(String itemIDS) {
		String sql="select t from Ordering t where t.orderingFlag=0 and t.itemID in("+itemIDS+")";
		List<Ordering> findList = orderingDao.findList(sql, null);
		return findList;
	}

	@Override
	public int updateOrderingFlag(String itemIDS,int type) {
		String sql=" update  Ordering set orderingFlag="+type+" where itemID in("+itemIDS+")";
		orderingDao.execute(sql, null);
		return 0;
	}

	private int syncOrderingDatas(int systemID, String host, int port,
			String dbname, String username, String password) {
		String connectDB = "jdbc:sqlserver://" + host + ":" + port
				+ ";DatabaseName=" + dbname;
		// 加载数据库引擎
		String driverclass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try {
			Class.forName(driverclass);
			System.out.println("加载数据库引擎成功!");
		} catch (Exception e) {
			System.out.println("加载数据库引擎失败!");
			System.exit(0);
		}
		// 连接数据库(物流服务器)
		try {
			String query = "select max(t.orderingID) from Ordering t where t.systemID="+systemID;
			int orderingID = this.orderingDao.max(query);
			Connection conn = DriverManager.getConnection(connectDB, username,
					password);
			Statement stmt = conn.createStatement();
			String sql = "select * from Ordering where OrderingID>"+orderingID+" and systemID="+systemID;
			ResultSet rs = stmt.executeQuery(sql);
			List<Ordering> orderingList = new ArrayList<Ordering>();
			while (rs.next()) {
				Ordering ordering = new Ordering();
				ordering.setSystemID(systemID);
				ordering.setOrderingID(rs.getInt("OrderingID"));
				ordering.setCustomerID(rs.getInt("CustomerID"));
				ordering.setSupplierID(rs.getInt("SupplierID"));
				ordering.setOrderingFlag(rs.getInt("OrderingFlag"));
				ordering.setUserID(rs.getInt("UserID"));
				ordering.setOperDate(rs.getString("OperDate"));
				ordering.setOrderingTime(rs.getString("OrderingTime"));
				ordering.setOrderingSource(rs.getInt("OrderingSource"));
				ordering.setOrderingType(rs.getInt("OrderingType"));
				ordering.setDepartmentID(rs.getInt("DepartmentID"));
				orderingList.add(ordering);
			}
			int count = 0;
			for(int i =0;i<orderingList.size();i++){
				int result = this.saveOrdering(orderingList.get(i));
				if(result==0){
					//订单主表保存成功,继续保存明细
					String strSql = "select * from OrderingItem where systemID="+systemID+" and orderingID="+orderingList.get(i).getOrderingID();
					ResultSet rsItem = stmt.executeQuery(strSql);
					List<OrderingItem> itemList = new ArrayList<OrderingItem>();
					while(rsItem.next()){
						OrderingItem item  = new OrderingItem();
						item.setSystemID(systemID);
						item.setOrderingID(orderingList.get(i).getOrderingID());
						item.setOrderingItemID(rsItem.getInt("OrderingItemID"));
						item.setUid(rsItem.getInt("UID"));
						item.setOrderingQuantity(rsItem.getDouble("OrderingQuantity"));
						item.setDealQuantity(rsItem.getDouble("DealQuantity"));
						itemList.add(item);
					}
					int flag = this.saveOrderingItemList(itemList);
				}
				count++;
				System.out.println("成功保存第"+count+"条数据,定单号为:"+orderingList.get(i).getOrderingID());
			}
			
			
			stmt.close();
			conn.close();
			System.out.println("订单信息同步完成!");
			return 0;

		} catch (Exception e) {
			System.out.println("订单信息同步失败!");
			e.printStackTrace();
			return -1;
		}
		
	}

	private int saveOrderingItemList(List<OrderingItem> itemList) {
		for(int i=0;i<itemList.size();i++){
			String strSql = " select t from OrderingItem t where t.systemID="
					+ itemList.get(i).getSystemID() + " and t.orderingItemID = "
					+ itemList.get(i).getOrderingItemID() + " and t.orderingID="
					+ itemList.get(i).getOrderingID();
			List<OrderingItem> rsList = this.orderingItemDao.findList(strSql, null);
			if(rsList!=null&&rsList.size()>0){
				itemList.get(i).setItemID(rsList.get(0).getItemID());
				this.orderingItemDao.merge(itemList.get(i));
			}else{
				this.orderingItemDao.persist(itemList.get(i));
			}
					
		}
			
		return 0;
	}

	private int saveOrdering(Ordering ordering) {
		String strSql = "select t from Ordering t where t.systemID="
				+ ordering.getSystemID() + " and t.orderingID="
				+ ordering.getOrderingID();
		List<Ordering> rsList = this.orderingDao.findList(strSql, null);
		if(rsList!=null&&rsList.size()>0){
			ordering.setItemID(rsList.get(0).getItemID());
			this.orderingDao.merge(ordering);
		}else{
			this.orderingDao.persist(ordering);
		}
		return 0;
	}

	@Override
	public int syncOrderingData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncOrderingDatas( Integer.parseInt(strs[i]),  host,  port,
					 dbname,  username,  password);
			
		}
		return result;
	}

}
