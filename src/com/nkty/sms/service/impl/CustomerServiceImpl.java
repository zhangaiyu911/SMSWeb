package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Customer;
import com.nkty.sms.dao.CustomerDao;
import com.nkty.sms.service.CustomerService;

/**
 * 食堂Service实现类
 * 
 * @author 刘斌 2017年7月19日09:24:48
 * 
 */
@Service(value = "customerServiceImpl")
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Integer>
implements CustomerService{
	
	@Resource
	private CustomerDao customerDao;

	@Resource(name = "customerDaoImpl")
	public void setBaseDao(CustomerDao customerDao) {
		super.setBaseDao(customerDao);
	}

	private int syncCustomerDatas(int systemID, String host, int port,
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

			String sql = "select * from Customer where systemID="+systemID;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setSystemID(systemID);
				customer.setCustomerID(rs.getInt("customerID"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setDepartmentID(rs.getInt("departmentID"));
				customer.setUsingFlag(rs.getInt("UsingFlag"));

				this.saveCustomer(customer);
			}
			stmt.close();
			conn.close();
			System.out.println("班组信息同步完成!");
			return 0;

		} catch (Exception e) {
			System.out.println("班组信息同步失败!");
			e.printStackTrace();
			return -1;
		}


	}

	private void saveCustomer(Customer customer) {
		String strSql = "select t from Customer t where t.systemID="
				+ customer.getSystemID() + " and t.customerID="
				+ customer.getCustomerID();
		List<Customer> rsList = this.customerDao.findList(strSql, null);
		if (rsList != null && rsList.size() > 0) {
			customer.setItemID(rsList.get(0).getItemID());
			this.customerDao.merge(customer);
		} else {
			this.customerDao.persist(customer);
		}
	}

	@Override
	public int syncCustomerData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncCustomerDatas(Integer.parseInt(strs[i]), host, port, dbname, username, password);
			
		}
		return result;
	}
}
