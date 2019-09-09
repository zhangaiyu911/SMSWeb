package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Product;
import com.nkty.sms.dao.ProductDao;
import com.nkty.sms.service.ProductService;

/**
 * 商品Service实现类
 * 
 * @author 刘斌 2017年7月18日14:17:20
 * 
 */
@Service(value = "productServiceImpl")
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer>
implements ProductService{
	
	@Resource
	private ProductDao productDao;

	@Resource(name = "productDaoImpl")
	public void setBaseDao(ProductDao productDao) {
		super.setBaseDao(productDao);
	}

	@SuppressWarnings("unused")
	private int syncProductDatas(int systemID, String host, int port,
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

			String sql = "select * from Product where systemID="+systemID;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setSystemID(systemID);
				product.setUid(rs.getInt("UID"));
				product.setProductName(rs.getString("ProductName"));
				product.setProductCode(rs.getString("ProductCode"));
				product.setUnit(rs.getString("Unit"));
				product.setParentID(rs.getInt("ParentID"));
				product.setCurDegreeID(rs.getInt("CurDegreeID"));
				product.setScale(rs.getString("Scale"));
				product.setUsingFlag(rs.getInt("UsingFlag"));
				product.setMemo(rs.getString("Memo"));
				this.saveProduct(product);
			}
			stmt.close();
			conn.close();
			System.out.println("商品信息同步完成!");
			return 0;

		} catch (Exception e) {
			System.out.println("商品信息同步失败!");
			e.printStackTrace();
			return -1;
		}

	}

	/**
	 * 更新云平台商品表
	 */
	public void saveProduct(Product product) {
		String strSql = "select t from Product t where t.systemID = "
				+ product.getSystemID() + " and t.uid = " + product.getUid();
		List<Product> rsList = this.productDao.findList(strSql, null);
		if (rsList != null && rsList.size() > 0) {
			// 已存在该记录,直接修改
			product.setItemID(rsList.get(0).getItemID());
			this.productDao.merge(product);
		} else {
			this.productDao.persist(product);
		}

	}

	@Override
	public int syncProductData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncProductDatas( Integer.parseInt(strs[i]),  host,  port,
					 dbname,  username,  password);
			
		}
		return result;
	}

}
