package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.RegistCode;
import com.nkty.sms.dao.RegistCodeDao;
import com.nkty.sms.service.RegistCodeService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 注册码Service实现类
 * 
 * @author 刘雪成
 * 
 */
@Service(value = "registCodeServiceImpl")
public class RegistCodeServiceImpl extends BaseServiceImpl<RegistCode, Integer>
		implements RegistCodeService {
	
	@Resource
	private RegistCodeDao registCodeDao;
	
	@Resource(name = "registCodeDaoImpl")
	public void setBaseDao(RegistCodeDao registCodeDao) {
		super.setBaseDao(registCodeDao);
	}

	@Override
	public RegistCode getRegistCode(String registCodeStr) {
		String sql="select t from RegistCode t where t.usingFlag=1 and t.registCodeStr='"+registCodeStr+"'";
		List<RegistCode> findList = registCodeDao.findList(sql, null);
		if (findList!=null&&findList.size()>0) {
			return findList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public int updateFlag(int registCodeID) {
		String sql="update RegistCode set usingFlag=2 where registCodeID="+registCodeID;
		registCodeDao.execute(sql, null);
		return 0;
	}

	@Override
	public int getRegistCodeCount(int systemID, int registCodeType,
			int usingFlag) {
		StringBuffer where = new StringBuffer();
		if (systemID!=0) {
			where.append(" and t.systemID="+systemID);
		}
		if (systemID!=0) {
			where.append(" and t.registCodeType="+registCodeType);
		}
		if (systemID!=0) {
			where.append(" and t.usingFlag="+usingFlag);
		}
		return registCodeDao.getEntityRecordCount(where.toString());
	}

	@Override
	public Page<RegistCode> getRegistCodePage(Pageable pageable, int systemID,
			int registCodeType, int usingFlag) {
		StringBuffer where = new StringBuffer();
		if (systemID!=0) {
			where.append(" and t.systemID="+systemID);
		}
		if (systemID!=0) {
			where.append(" and t.registCodeType="+registCodeType);
		}
		if (systemID!=0) {
			where.append(" and t.usingFlag="+usingFlag);
		}
		return registCodeDao.findPage(where.toString(),
				" order by t.registCodeID", pageable.getPage(),
				pageable.getLimit());
	}

}
