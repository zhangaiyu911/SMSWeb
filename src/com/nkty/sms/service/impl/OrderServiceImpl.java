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
import com.nkty.sms.bean.Orders;
import com.nkty.sms.dao.OrderDao;
import com.nkty.sms.dao.OrderItemDao;
import com.nkty.sms.service.OrderService;

@Service(value = "orderServiceImpl")
public class OrderServiceImpl extends BaseServiceImpl<Orders, Integer>
		implements OrderService {
	@Resource
	private OrderDao orderDao;
	
	@Resource
	private OrderItemDao orderItemDao;

	private int syncOrderDatas(int systemID, String host, int port, String dbname,
			String username, String password) {
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
			Connection conn = DriverManager.getConnection(connectDB, username,
					password);
			Statement stmt = conn.createStatement();

			String query = "select max(t.orderID) from Orders t where t.systemID="+systemID;
			int orderID = this.orderDao.max(query);
			String sql = "select * from Orders where systemID="+systemID+" and OrderID>"+orderID;
			ResultSet rs = stmt.executeQuery(sql);
			List<Orders> orderList = new ArrayList<Orders>();
			while (rs.next()) {
				Orders order = new Orders();
				order.setSystemID(systemID);
				order.setOrderID(rs.getInt("OrderID"));
				order.setCustomerID(rs.getInt("CustomerID"));
				order.setUserID(rs.getInt("UserID"));
				order.setOrderFlag(rs.getInt("OrderFlag"));
				order.setOperDate(rs.getString("OperDate"));
				order.setOrderTime(rs.getString("OrderTime"));
				order.setDepartmentID(rs.getInt("DepartmentID"));
				order.setGroupID(rs.getInt("GroupID"));
				order.setMemo(rs.getString("Memo"));
				
				orderList.add(order);
			}
			int count = 0;
			for(int i =0;i<orderList.size();i++){
				int result = this.saveOrder(orderList.get(i));
				if(result==0){
					//订单主表保存成功,继续保存明细
					String strSql = "select * from OrderItem where systemID="+systemID+" and  orderID="+orderList.get(i).getOrderID();
					ResultSet rsItem = stmt.executeQuery(strSql);
					List<OrderItem> itemList = new ArrayList<OrderItem>();
					while(rsItem.next()){
						OrderItem item  = new OrderItem();
						item.setSystemID(systemID);
						item.setOrderID(orderList.get(i).getOrderID());
						item.setOrderItemID(rsItem.getInt("OrderItemID"));
						item.setUid(rsItem.getInt("UID"));
						item.setOrderQuantity(rsItem.getDouble("OrderQuantity"));
						item.setDealQuantity(rsItem.getDouble("DealQuantity"));
						item.setSupplierOrStockID(rsItem.getInt("SupplierOrStockID"));
						item.setOrderStorageType(rsItem.getInt("OrderStorageType"));
						item.setOrderingItemID(rsItem.getInt("OrderingItemID"));
						itemList.add(item);
					}
					int flag = this.saveOrderItemList(itemList);
				}
				count++;
				System.out.println("成功保存第"+count+"条数据,定单号为:"+orderList.get(i).getOrderID());
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

	private int saveOrderItemList(List<OrderItem> itemList) {
		for(int i=0;i<itemList.size();i++){
			String strSql = " select t from OrderItem t where t.systemID="
					+ itemList.get(i).getSystemID() + " and t.orderItemID = "
					+ itemList.get(i).getOrderItemID() + " and t.orderID="
					+ itemList.get(i).getOrderID();
			List<OrderItem> rsList = this.orderItemDao.findList(strSql, null);
			if(rsList!=null&&rsList.size()>0){
				itemList.get(i).setItemID(rsList.get(0).getItemID());
				this.orderItemDao.merge(itemList.get(i));
			}else{
				this.orderItemDao.persist(itemList.get(i));
			}
					
		}
			
		return 0;
	}

	private int saveOrder(Orders order) {
		String strSql = "select t from Orders t where t.systemID="
				+ order.getSystemID() + " and t.orderID=" + order.getOrderID();
		List<Orders> rsList = this.orderDao.findList(strSql, null);
		if(rsList!=null&&rsList.size()>0){
			order.setItemID(rsList.get(0).getItemID());
			this.orderDao.merge(order);
		}else{
			this.orderDao.persist(order);
		}
		return 0;
	}

	@Override
	public int syncOrderData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncOrderDatas( Integer.parseInt(strs[i]),  host,  port,
					 dbname,  username,  password);
			
		}
		return result;
	}
}
