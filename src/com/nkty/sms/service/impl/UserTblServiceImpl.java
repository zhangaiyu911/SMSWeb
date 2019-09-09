package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.UserTbl;
import com.nkty.sms.dao.UserTblDao;
import com.nkty.sms.service.UserTblService;

@Service(value = "userTblServiceImpl")
public class UserTblServiceImpl extends BaseServiceImpl<UserTbl, Integer>
		implements UserTblService {

	@Resource
	private UserTblDao userTblDao;

	private int syncWuliuUserDatas(int systemID, String host,int port,String dbname, String username, String password) {

		// 加载数据库引擎
		String driverclass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try {
			Class.forName(driverclass);
			System.out.println("加载数据库引擎成功!");
		} catch (Exception e) {
			System.out.println("加载数据库引擎失败!");
			System.exit(0);
		}
//		connectDB = "jdbc:sqlserver://10.1.70.16:1433;DatabaseName=AsyncDB";
		String connectDB = "jdbc:sqlserver://"+host+":"+port+";DatabaseName="+dbname;
		// 连接数据库(物流服务器)
		try {
			Connection conn = DriverManager.getConnection(connectDB, username,
					password);
			Statement stmt = conn.createStatement();

			String sql = "select * from UserTbl where systemID="+systemID;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserTbl user = new UserTbl();
				user.setSystemID(systemID);
				user.setUserID(rs.getInt("UserID"));
				user.setUserName(rs.getString("UserName"));

				this.saveUser(user);
			}
			stmt.close();
			conn.close();
			System.out.println("物流用户信息同步完成!");
			return 0;

		} catch (Exception e) {
			System.out.println("物流用户信息同步失败!");
			e.printStackTrace();
			return -1;
		}

	}

	private void saveUser(UserTbl user) {
		String strSql = "select t from UserTbl t where t.systemID="
				+ user.getSystemID() + " and t.userID=" + user.getUserID();
		List<UserTbl> rsList = this.userTblDao.findList(strSql, null);
		if(rsList!=null&&rsList.size()>0){
			user.setItemID(rsList.get(0).getItemID());
			this.userTblDao.merge(user);
		}else{
			this.userTblDao.persist(user);
		}
		
	}

	@Override
	public int syncWuliuUserData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncWuliuUserDatas(Integer.parseInt(strs[i]), host, port, dbname, username, password);
			
		}
		return result;
		
	}
}
