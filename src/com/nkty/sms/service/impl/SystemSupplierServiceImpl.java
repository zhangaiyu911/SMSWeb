package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.SystemSupplier;
import com.nkty.sms.bean.view.ViewSupplierSystem;
import com.nkty.sms.dao.SystemSupplierDao;
import com.nkty.sms.dao.ViewSupplierSystemDao;
import com.nkty.sms.service.SystemSupplierService;
/**
 * 客户供货商Service实现类
 * 
 * @author 刘斌2017年7月19日09:41:02
 * 
 */
@Service(value = "systemSupplierServiceImpl")
public class SystemSupplierServiceImpl extends BaseServiceImpl<SystemSupplier, Integer>
implements SystemSupplierService{
	
	@Resource
	private SystemSupplierDao systemSupplierDao;
	
	@Resource
	private ViewSupplierSystemDao viewSupplierSystemDao;

	@Resource(name = "systemSupplierDaoImpl")
	public void setBaseDao(SystemSupplierDao systemSupplierDao) {
		super.setBaseDao(systemSupplierDao);
	}

	@Override
	public int saveSystemSupplier(SystemSupplier systemSupplier) {
		String sql="select t from SystemSupplier t where t.systemID="+systemSupplier.getSystemID()+
				" and t.wuliuSupplierID="+systemSupplier.getWuliuSupplierID()+" and t.itemID!="+systemSupplier.getItemID();
		List<SystemSupplier> findList = systemSupplierDao.findList(sql, null);
		if (findList!=null&&findList.size()>0) {
			return 2;
		}
		if (systemSupplier.getItemID()==0) {
			systemSupplierDao.persist(systemSupplier);
		}else {
			systemSupplierDao.merge(systemSupplier);
		}
		return 0;
	}

	@Override
	public SystemSupplier checkSystemSupplier(int systemID, int wuliuSupplierID) {
		String sql="select t from SystemSupplier t where t.systemID="+systemID+
				" and t.wuliuSupplierID="+wuliuSupplierID;
		List<SystemSupplier> findList = systemSupplierDao.findList(sql, null);
		if (findList!=null&&findList.size()>0) {
			return findList.get(0);
		}else {
			
			return null;
		}
	}

	@Override
	public List<ViewSupplierSystem> getSystemSupplierList(int clouldSupplierID) {
		String sql="select t from ViewSupplierSystem t where t.usingFlag=1 and t.supplierID="+clouldSupplierID;
		List<ViewSupplierSystem> findList = viewSupplierSystemDao.findList(sql, null);
		return findList;
	}

	@Override
	public List<ViewSupplierSystem> getSystemSuppliers(int systemID) {
		String sql="select t from ViewSupplierSystem t where t.usingFlag=1 and t.systemID="+systemID;;
		List<ViewSupplierSystem> findList = viewSupplierSystemDao.findList(sql, null);
		return findList;
	}

	@Override
	public List<ViewSupplierSystem> getAllSystemSupplierList(
			int clouldSupplierID) {
		String sql="select t from ViewSupplierSystem t where  t.supplierID="+clouldSupplierID;
		List<ViewSupplierSystem> findList = viewSupplierSystemDao.findList(sql, null);
		return findList;
	}

	@Override
	public List<ViewSupplierSystem> getSystemSupplierListByID(
			int clouldSupplierID) {
		String sql="select t from ViewSupplierSystem t where  t.supplierID="+clouldSupplierID;
		List<ViewSupplierSystem> findList = viewSupplierSystemDao.findList(sql, null);
		return findList;
	}

}
