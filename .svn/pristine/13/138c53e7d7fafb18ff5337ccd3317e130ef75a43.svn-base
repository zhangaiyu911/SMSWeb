package com.nkty.sms.service;

import com.nkty.sms.bean.RegistCode;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
/**
 * 注册码Service接口
 * 
 * @author 刘雪成
 *
 */
public interface RegistCodeService extends BaseService<RegistCode, Integer> {
	
	/**
	 * 根据验证码获取记录
	 * 刘斌 2017年7月20日10:13:01
	 * @param registCodeStr
	 * @return
	 */
	RegistCode getRegistCode(String registCodeStr);
	
	/**
	 * 修改使用标识
	 * 刘斌 2017年7月20日10:18:31
	 * @param registCodeID
	 * @return
	 */
	int updateFlag(int registCodeID);
	
	/**
	 * 获取验证码数量
	 * @author 刘斌 2017年8月28日11:49:02
	 * @return
	 */
	int getRegistCodeCount(int systemID,int registCodeType,int usingFlag);

	/**
	 * 获取验证码分页列表
	 * @author 刘斌2017年8月28日11:49:05
	 * @param pageable
	 * @return
	 */
	Page<RegistCode> getRegistCodePage(Pageable pageable,int systemID,int registCodeType,int usingFlag);

}
