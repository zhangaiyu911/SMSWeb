package com.nkty.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nkty.sms.bean.RelayServer;
import com.nkty.sms.dao.RelayServerDao;
import com.nkty.sms.service.RelayServerService;

/**
 * 转正服务器Service实现类
 * 
 * @author 刘斌
 * 
 */
@Service(value = "relayServerServiceImpl")
public class RelayServerServiceImpl extends BaseServiceImpl<RelayServer, Integer>
implements RelayServerService{
	
	@Resource
	private RelayServerDao relayServerDao;
	
	@Resource(name = "relayServerDaoImpl")
	public void setBaseDao(RelayServerDao relayServerDao) {
		super.setBaseDao(relayServerDao);
	}

	@Override
	public List<RelayServer> getRelayServerList() {
		String sql="select t from RelayServer t";
		List<RelayServer> findList = relayServerDao.findList(sql, null);
		return findList;
	}

}
