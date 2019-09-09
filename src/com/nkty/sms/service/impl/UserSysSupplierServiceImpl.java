package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.UserSysSupplier;
import com.nkty.sms.dao.UserSysSupplierDao;
import com.nkty.sms.service.UserSysSupplierService;

@Service("userSysSupplierServiceImpl")
public class UserSysSupplierServiceImpl extends BaseServiceImpl<UserSysSupplier, Integer> implements
	UserSysSupplierService{
	
	@Resource
	private UserSysSupplierDao userSysSupplierDao;
	
	@Resource(name = "userSysSupplierDaoImpl")
	public void setBaseDao(UserSysSupplierDao userSysSupplierDao) {
		super.setBaseDao(userSysSupplierDao);
	}

	@Override
	public int saveUserSysSupplier(UserSysSupplier userSysSupplier) {
		userSysSupplierDao.persist(userSysSupplier);
		return 0;
	}

	@Override
	public UserSysSupplier getUserSysSupplier(int userID, int userType) {
		String sql="select t from UserSysSupplier t where t.userID="+userID+" and t.userType="+userType;
		List<UserSysSupplier> findList = userSysSupplierDao.findList(sql, null);
		if(findList!=null&&findList.size()>0){
			return findList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<UserSysSupplier> getUserSysSupplierList(int userID, int userType) {
		String sql="select t from UserSysSupplier t where t.userID="+userID+" and t.userType="+userType;
		List<UserSysSupplier> findList = userSysSupplierDao.findList(sql, null);
		return findList;
	}

}
