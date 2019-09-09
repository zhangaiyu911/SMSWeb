package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Category;
import com.nkty.sms.dao.CategoryDao;
import com.nkty.sms.service.CategoryService;

/**
 * 商品类别Service实现类
 * 
 * @author 刘斌2017年7月18日14:31:36
 * 
 */
@Service(value = "categoryServiceImpl")
public class CategoryServiceImpl extends BaseServiceImpl<Category, Integer>
implements CategoryService{
	
	@Resource
	private CategoryDao categoryDao;

	@Resource(name = "categoryDaoImpl")
	public void setBaseDao(CategoryDao categoryDao) {
		super.setBaseDao(categoryDao);
	}

	private int syncCategoryDatas(int systemID, String host, int port,
			String dbname, String username, String password) {
		String connectDB = "jdbc:sqlserver://"+host+":"+port+";DatabaseName="+dbname;
		//加载数据库引擎
		String driverclass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try{
			Class.forName(driverclass);
			System.out.println("加载数据库引擎成功!");
		}catch(Exception e){
			System.out.println("加载数据库引擎失败!");
			System.exit(0);
		}
		//连接数据库(物流服务器)
		try {
			Connection conn = DriverManager.getConnection(connectDB, username,
					password);
			Statement stmt = conn.createStatement();

			String sql = "select * from Category where systemID="+systemID;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Category category = new Category();
				category.setSystemID(systemID);
				category.setCategoryID(rs.getInt("CategoryID"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setCurDegreeID(rs.getInt("CurDegreeID"));
				category.setParentID(rs.getInt("ParentID"));
				category.setUsingFlag(rs.getInt("UsingFlag"));
				category.setMemo(rs.getString("Memo"));
				
				this.saveCategory(category);
			}
			System.out.println("商品类别信息同步完成!");
			stmt.close();
			conn.close();
			
			return 0;

		} catch (Exception e) {
			System.out.println("商品类别信息同步失败!");
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 保存商品类别信息
	 * @param category
	 */
	private void saveCategory(Category category) {
		String strSql = "select t from Category t where t.systemID="
				+ category.getSystemID() + " and t.categoryID = "
				+ category.getCategoryID();
		List<Category> rsList = this.categoryDao.findList(strSql, null);
		if(rsList!=null&&rsList.size()>0){
			category.setItemID(rsList.get(0).getItemID());
			this.categoryDao.merge(category);
		}else{
			categoryDao.persist(category);
		}
		
	}

	@Override
	public int syncCategoryData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncCategoryDatas(Integer.parseInt(strs[i]), host, port, dbname, username, password);
			
		}
		return result;
	}

}
