package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.WuliuSystem;
import com.nkty.sms.dao.WuliuSystemDao;
import com.nkty.sms.service.WuliuSystemService;

/**
 * 客户Service实现类
 * 
 * @author 刘斌 2017年7月18日14:39:51
 * 
 */
@Service(value = "wuliuSystemServiceImpl")
public class WuliuSystemServiceImpl extends BaseServiceImpl<WuliuSystem, Integer>
implements WuliuSystemService{
	
	@Resource
	private WuliuSystemDao wuliuSystemDao;

	@Resource(name = "wuliuSystemDaoImpl")
	public void setBaseDao(WuliuSystemDao wuliuSystemDao) {
		super.setBaseDao(wuliuSystemDao);
	}

	@Override
	public List<WuliuSystem> getWuliuSystemList(String ids) {
		String sql="select t from WuliuSystem t where  (1=1)";
		if (ids!=null&&ids.length()>0) {
			sql+=" and t.systemID in ("+ids+")";
		}
		List<WuliuSystem> findList = wuliuSystemDao.findList(sql, null);
		return findList;
	}

	@Override
	public List<WuliuSystem> getWuliuSystemListNoIds(String ids) {
		String sql="select t from WuliuSystem t where  (1=1)";
		if (ids!=null&&ids.length()>0) {
			sql+=" and t.systemID not in ("+ids+")";
		}
		List<WuliuSystem> findList = wuliuSystemDao.findList(sql, null);
		return findList;
	}

}
