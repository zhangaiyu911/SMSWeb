package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.WuliuSystem;

/**
 * 客户Service接口
 * 
 * @author 刘斌 2017年7月18日14:38:59
 * 
 */
public interface WuliuSystemService extends BaseService<WuliuSystem, Integer>{
	
	/**
	 * 根据ids查询
	 * 刘斌 2017年8月3日15:57:51
	 * @param ids
	 * @return
	 */
	List<WuliuSystem> getWuliuSystemList(String ids);
	/**
	 * 根据ids查询ids以外的数据
	 * 刘斌 2017年8月28日15:46:13
	 * @param ids
	 * @return
	 */
	List<WuliuSystem> getWuliuSystemListNoIds(String ids);

}
