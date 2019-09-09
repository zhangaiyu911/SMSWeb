package com.nkty.sms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Department;
import com.nkty.sms.dao.DepartmentDao;
import com.nkty.sms.service.DepartmentService;

/**
 * 部门Service实现类
 * 
 * @author 刘斌 2017年7月18日15:57:59
 * 
 */
@Service(value = "departmentServiceImpl")
public class DepartmentServiceImpl extends BaseServiceImpl<Department, Integer>
implements DepartmentService{
	
	@Resource
	private DepartmentDao deptDao;

	@Resource(name = "departmentDaoImpl")
	public void setBaseDao(DepartmentDao departmentDao) {
		super.setBaseDao(departmentDao);
	}
	
	private int syncDeptDatas(int systemID, String host, int port, String dbname,
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

			String sql = "select * from Department where systemID="+systemID;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Department dept = new Department();
				dept.setSystemID(systemID);
				dept.setDepartmentID(rs.getInt("DepartmentID"));
				dept.setDepartmentName(rs.getString("DepartmentName"));
				dept.setUsingFlag(rs.getInt("UsingFlag"));

				this.saveDept(dept);
			}
			stmt.close();
			conn.close();
			System.out.println("部门信息同步完成!");
			return 0;

		} catch (Exception e) {
			System.out.println("部门信息同步失败!");
			e.printStackTrace();
			return -1;
		}

		
	}

	/**
	 * 同步部门信息
	 * 
	 * @param dept
	 */
	private void saveDept(Department dept) {
		String strSql = "select t from Department t where t.systemID = "
				+ dept.getSystemID() + " and t.departmentID ="
				+ dept.getDepartmentID();
		List<Department> rsList = this.deptDao.findList(strSql, null);
		if (rsList != null && rsList.size() > 0) {
			dept.setItemID(rsList.get(0).getItemID());
			this.deptDao.merge(dept);
		} else {
			deptDao.persist(dept);
		}
	}

	@Override
	public int syncDeptData(String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		String strs[]=strSystemIDs.split(",");
		int result=0;
		for (int i = 0; i < strs.length; i++) {
			result=syncDeptDatas(Integer.parseInt(strs[i]), host, port, dbname, username, password);
			
		}
		return result;
	}



}
