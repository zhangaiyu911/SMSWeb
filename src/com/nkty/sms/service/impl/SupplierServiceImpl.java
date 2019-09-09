package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.Supplier;
import com.nkty.sms.bean.view.ViewSupplierSystem;
import com.nkty.sms.dao.SupplierDao;
import com.nkty.sms.dao.SystemSupplierDao;
import com.nkty.sms.dao.ViewSupplierSystemDao;
import com.nkty.sms.service.SupplierService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 供货商Service实现类
 * 
 * @author 刘斌 2017年7月19日08:55:37
 * 
 */
@Service(value = "supplierServiceImpl")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, Integer>
implements SupplierService{
	
	@Resource
	private SupplierDao supplierDao;
	
	@Resource
	private ViewSupplierSystemDao viewSupplierSystemDao;
	
	@Resource
	private SystemSupplierDao systemSupplierDao;

	@Resource(name = "supplierDaoImpl")
	public void setBaseDao(SupplierDao supplierDao) {
		super.setBaseDao(supplierDao);
	}

	@Override
	public int saveSupplier(Supplier supplier) {
		String sql="select t from Supplier t where t.supplierName='"+supplier.getSupplierName()+"' and t.supplierID!="+supplier.getSupplierID();
		List<Supplier> findList = supplierDao.findList(sql, null);
		if (findList!=null&&findList.size()>0) {
			return 2;
		}
		if (supplier.getSupplierID()==0) {
			supplierDao.persist(supplier);
		}else {
			supplierDao.merge(supplier);
		}
		return 0;
	}

	@Override
	public Supplier checkSupplier(String supplierName) {
		String sql="select t from Supplier t where t.supplierName='"+supplierName+"'";
		List<Supplier> findList = supplierDao.findList(sql, null);
		if (findList!=null&&findList.size()>0) {
			return findList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public int getViewSupplierSystemCount(int systemID,String supplierName) {
		StringBuffer where = new StringBuffer();
		if (systemID!=0) {
			where.append(" and t.systemID="+systemID);
		}
		if (supplierName!=null&&supplierName!="") {
			where.append(" and t.supplierName like '%"+supplierName+"%'");
		}
		return viewSupplierSystemDao.getEntityRecordCount(where.toString());
	}

	@Override
	public Page<ViewSupplierSystem> getViewSupplierSystemPage(Pageable pageable,int systemID,String supplierName) {
		StringBuffer where = new StringBuffer();
		if (systemID!=0) {
			where.append(" and t.systemID="+systemID);
		}
		if (supplierName!=null&&supplierName!="") {
			where.append(" and t.supplierName like '%"+supplierName+"%'");
		}
		return viewSupplierSystemDao.findPage(where.toString(),
				" order by t.usingFlag,t.supplierID", pageable.getPage(),
				pageable.getLimit());
	}

	@Override
	public int delSupplier(String itemIDs,String memo) {
		String strSQL = "update SystemSupplier  set usingFlag=2,memo='"+memo+"' where itemID in ("+itemIDs+")";
		supplierDao.execute(strSQL, null);
		return 0;
	}

	@Override
	public int successSupplier(String itemIDs) {
		String strSQL = "update SystemSupplier  set usingFlag=1 where itemID in ("+itemIDs+")";
		supplierDao.execute(strSQL, null);
		return 0;
	}

	@Override
	public List<Supplier> getSupplierList(String supplierIds) {
		String sql="select t from Supplier t where t.supplierID in("+supplierIds+")";
		List<Supplier> findList = supplierDao.findList(sql, null);
		return findList;
	}


}
