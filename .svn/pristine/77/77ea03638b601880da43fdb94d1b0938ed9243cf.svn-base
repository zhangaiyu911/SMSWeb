/**
 * UserServiceImpl.java
 * Copyright 2015 NKTY(Tianjin)High Technology Development Ltd.
 * All rights reserved. 
 * Created on 2015-12-25 下午2:27:48
 */
package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.User;
import com.nkty.sms.bean.view.ViewUser;
import com.nkty.sms.bean.view.ViewUserAuthority;
import com.nkty.sms.dao.UserDao;
import com.nkty.sms.dao.ViewUserAuthorityDao;
import com.nkty.sms.dao.ViewUserDao;
import com.nkty.sms.service.UserService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 用户管理Service实现类
 * 
 * @author 刘雪成 2017年4月7日15:30:11
 */
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements
		UserService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private ViewUserAuthorityDao viewUserAuthorityDao;

	@Resource(name = "userDaoImpl")
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}
	@Resource
	private ViewUserDao viewUserDao;

	@Resource
	private ViewUserAuthorityDao userAuthorityDao;
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;
	
	public User getUser(String username) {
		// 获取用户信息
		String strSql = "SELECT t from User t where t.userName = '" + username + "'";
		List<User> userList = userDao.findList(strSql, null);
		if (null != userList && 0 < userList.size()) {
			return userList.get(0);
		}
		return null;
	}
	
	/**
	 * 获取用户数量(视图)
	 */
	@Override
	public int getViewUserCount(int type,String username) {
		StringBuffer where = new StringBuffer();
		if (type != 0) {
			where.append(" and t.usingFlag=" + type);
		}
		if(username!=""&&username!=null){
			where.append(" and t.userName like '%"+username+"%'");
		}
		return viewUserDao.getEntityRecordCount(where.toString());
		
	}

	/**
	 * 获取用户分页信息(视图)
	 */
	@Override
	public Page<ViewUser> getViewUserList(Pageable pageable, int type,String username) {
		// 使用标识type 0：全部 1：使用 2：禁用
		StringBuffer where = new StringBuffer();
		if (0 != type) {
			where.append(" and t.usingFlag = " + type);
		}
		if(username!=""&&username!=null){
			where.append(" and t.userName like '%"+username+"%'");
		}

		
		return viewUserDao.findPage(where.toString(),
				" order by t.departmentID,t.userID", pageable.getPage(),
				pageable.getLimit());
	}
	
	/**
	 * 保存用户信息
	 */
	@Override
	public int saveUser(User user) {
		// 查询是用户名是否重复
		String strsql = "select t from User t where t.userName ='"
				+ user.getUserName() + "' and t.userID!=" + user.getUserID();
		List<User> rList = userDao.findList(strsql, null);
		if (rList != null && rList.size() > 0) {
			return 2;
		}
		// 查询该用户是否已注册
//		String strsql2 = "select t from User t where t.idnumber = '"
//				+ user.getIdnumber() + "' and userID!=" + user.getUserID();
//		List<User> rList2 = userDao.findList(strsql2, null);
//		if (rList2 != null && rList2.size() > 0) {
//			return 3;
//		}
		if (user.getUserID() == 0) {
			user.setUserID(0);
			userDao.persist(user);
		} else {
			userDao.merge(user);
		}
		return 0;
	}
	
	/**
	 * 启用用户 使用标识 UsingFlag=1
	 */
	@Override
	public int openUsers(String ids) {
		String strSQL = "update T_User set usingFlag=1 where UserID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSQL);
		return query.executeUpdate();
	}

	/**
	 * 禁用用户 使用标识UsingFlag=2
	 */
	@Override
	public int closeUsers(String ids) {
		String strSQL = "update T_User  set usingFlag=2 where UserID in ("+ids+")";
		Query query = this.entityManager.createNativeQuery(strSQL);
		return query.executeUpdate();
	}


	@Override
	public List<ViewUserAuthority> getDeptListByUserId(int userID,
			String functionCode, int type) {
		String sql="select t from ViewUserAuthority t where t.userID="+userID+"  and t.functionCode='"+functionCode+"'";
		if (type!=0) {
			sql+=" and t.type="+type;
		}
		List<ViewUserAuthority> findList = viewUserAuthorityDao.findList(sql, null);
		return findList;
	}


	/**
	 * 获取当前员工权限部门列表
	 */
	@Override
	public List<ViewUserAuthority> getUserAuthorityList(int userID,
			String functionCode) {
		String strSql="select t from ViewUserAuthority t where t.userID="+userID+" and t.functionCode='"+functionCode+"'";
		List<ViewUserAuthority> rsList = this.userAuthorityDao.findList(strSql, null);
		return rsList;
	}

	@Override
	public User getUserById(int userID) {
		String sql="select t from User t where t.userID="+userID;
		List<User> rList = userDao.findList(sql, null);
		if (rList!=null&&rList.size()>0) {
			return rList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public int editUserPassword(String password, int userID) {
		if(password.trim()!=""&&password!=null &&userID!=0){
			String sql="update T_User  set password='"+password+"' where UserID in ("+userID+")";
			Query query = this.entityManager.createNativeQuery(sql);
			return query.executeUpdate();
		}else{
			//修改失败
			return 0;
		}
	}

}