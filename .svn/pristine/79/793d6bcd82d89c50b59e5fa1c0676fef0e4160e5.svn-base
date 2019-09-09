package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.InStock;
import com.nkty.sms.bean.InStockItem;
import com.nkty.sms.bean.view.ViewInStock;
import com.nkty.sms.bean.view.ViewPurchaseInStock;
import com.nkty.sms.dao.InStockDao;
import com.nkty.sms.dao.InStockItemDao;
import com.nkty.sms.dao.ViewInStockDao;
import com.nkty.sms.dao.ViewPurchaseInStockDao;
import com.nkty.sms.service.InStockService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 入库单Service实现类
 * 
 * @author 刘斌 2017年7月26日14:52:07
 * 
 */
@Service(value = "inStockServiceImpl")
public class InStockServiceImpl extends BaseServiceImpl<InStock, Integer>
implements InStockService{
	
	@Resource
	private InStockDao inStockDao;
	
	@Resource
	private InStockItemDao inStockItemDao;
	
	@Resource
	private ViewInStockDao viewInStockDao;
	
	@Resource
	private ViewPurchaseInStockDao viewPurchaseInStockDao;
	
	@Resource(name = "inStockDaoImpl")
	public void setBaseDao(InStockDao inStockDao) {
		super.setBaseDao(inStockDao);
	}

	@Override
	public int getViewInStockCount(int systemID, int supplierID,String begintime,String endtime) {
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
			where.append("and t.instocktime>='"+begintime+"' and t.instocktime<='"+endtime+"'");
		}
		return viewInStockDao.getEntityRecordCount(where.toString());
	}

	@Override
	public Page<ViewInStock> getViewInStockPage(Pageable pageable,
			int systemID, int supplierID,String begintime,String endtime) {
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
			where.append("and t.instocktime>='"+begintime+"' and t.instocktime<='"+endtime+"'");
		}
		return viewInStockDao.findPage(where.toString(),
				" order by t.instockID desc", pageable.getPage(),
				pageable.getLimit());
	}

	private int syncInStockDatas(int systemID, String host, int port,
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
			Connection conn = DriverManager.getConnection(connectDB, username,
					password);
			Statement stmt = conn.createStatement();

			String jpql  = "select max(t.instockID) from InStock t where t.systemID="+systemID+" and t.departmentid=21";
			int instockid = this.inStockDao.max(jpql);
			String sql = "select * from InStock where systemID="+systemID+" and departmentID=21 and instockID>"+instockid;
			ResultSet rs = stmt.executeQuery(sql);
			List<InStock> instockList = new ArrayList<InStock>();
			while (rs.next()) {
				InStock instock = new InStock();
				instock.setSystemID(systemID);
				instock.setInstockID(rs.getInt("InStockID"));
				instock.setDepartmentid(rs.getInt("Departmentid"));
				instock.setBillsource(rs.getInt("billsource"));
				instock.setBilltype(rs.getInt("billtype"));
				instock.setInstockmoney(rs.getDouble("instockmoney"));
				instock.setInstocktime(rs.getString("instocktime"));
				instock.setMemo(rs.getString("memo"));
				instock.setMonthdealflag(rs.getInt("monthdealflag"));
				instock.setOperdate(rs.getString("operdate"));
				instock.setStockofficeid(rs.getInt("stockofficeid"));
				instock.setSupplierID(rs.getInt("supplierID"));
				instock.setUserID(rs.getInt("userID"));
				
				instockList.add(instock);
			}
			for(int i =0;i<instockList.size();i++){
				int result = this.saveInStock(instockList.get(i));
				if(result==0){
					//订单主表保存成功,继续保存明细
					String strSql = "select * from InStockItem where systemID="+systemID+" and instockID="+instockList.get(i).getInstockID();
					ResultSet rsItem = stmt.executeQuery(strSql);
					List<InStockItem> itemList = new ArrayList<InStockItem>();
					while(rsItem.next()){
						InStockItem item  = new InStockItem();
						item.setSystemID(systemID);
						item.setInstockid(instockList.get(i).getInstockID());
						item.setInstockitemid(rsItem.getInt("Instockitemid"));
						item.setUid(rsItem.getInt("UID"));
						item.setBatchid(rsItem.getInt("batchid"));
						item.setCostflag(rsItem.getInt("costflag"));
						item.setInstockitemid(rsItem.getInt("instockitemid"));
						item.setInstockprice(rsItem.getDouble("instockprice"));
						item.setInstockquantity(rsItem.getDouble("instockquantity"));
						item.setInstockmoney(rsItem.getDouble("instockmoney"));
						item.setProduceDate(rsItem.getString("produceDate").substring(0, 19));
						item.setShelfLife(rsItem.getString("shelfLife").substring(0, 19));
						item.setStoragetype(rsItem.getInt("storagetype"));
						
						itemList.add(item);
					}
					int flag = this.saveInStockItemList(itemList);
					if(flag==0){
						System.out.println("采购入库单保存成功,入库单号:"+instockList.get(i).getInstockID());
					}
				}
			}
			
			
			stmt.close();
			conn.close();
			System.out.println("入库单信息同步完成!");
			return 0;

		} catch (Exception e) {
			System.out.println("入库单信息同步失败!");
			e.printStackTrace();
			
			return -1;
		}

	}

	private int saveInStockItemList(List<InStockItem> itemList) {
		for(int i=0;i<itemList.size();i++){
			String strSql = "select t from InStockItem t where t.systemID="
					+ itemList.get(i).getSystemID() + " and t.instockitemid ="
					+ itemList.get(i).getInstockitemid()
					+ " and t.instockid = " + itemList.get(i).getInstockid();
			List<InStockItem> rsList = this.inStockItemDao.findList(strSql, null);
			if(rsList!=null&&rsList.size()>0){
				itemList.get(i).setItemID(rsList.get(0).getItemID());
				this.inStockItemDao.merge(itemList.get(i));
			}else{
				this.inStockItemDao.persist(itemList.get(i));
			}
		}
		return 0;
	}

	private int saveInStock(InStock inStock) {
		String strSql = "select t from InStock t where t.systemID="
				+ inStock.getSystemID() + " and instockID = "
				+ inStock.getInstockID();
		List<InStock> rsList = this.inStockDao.findList(strSql, null);
		if(rsList!=null&&rsList.size()>0){
			inStock.setItemID(rsList.get(0).getItemID());
			this.inStockDao.merge(inStock);
		}else{
			this.inStockDao.persist(inStock);
		}
		return 0;
	}

	@Override
	public int getViewPurchaseInStockCount(int systemID, int supplierID,
			String begintime, String endtime) {
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
			where.append("and t.instocktime>='"+begintime+"' and t.instocktime<='"+endtime+"'");
		}
		return viewPurchaseInStockDao.getEntityRecordCount(where.toString());
	}

	@Override
	public Page<ViewPurchaseInStock> getViewPurchaseInStockPage(Pageable pageable,
			int systemID, int supplierID, String begintime, String endtime) {
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
			where.append("and t.instocktime>='"+begintime+"' and t.instocktime<='"+endtime+"'");
		}
		return viewPurchaseInStockDao.findPage(where.toString(),
				" order by t.instockID desc", pageable.getPage(),
				pageable.getLimit());
	}

	@Override
	public int syncInStockData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncInStockDatas(Integer.parseInt(strs[i]), host, port, dbname, username, password);
		}
		return result;
	}

}
