package com.nkty.sms.service;

import com.nkty.sms.bean.SystemPara;

/**
 * 系统参数Service接口
 * 
 * @author 刘雪成 2017年1月20日14:03:41
 * 
 */
public interface SystemParaService extends BaseService<SystemPara, Integer> {

	/**
	 * 根据
	 * @author 刘雪成
	 * @param systemParaCode 属性代码
	 * @return
	 */
	String getSystemParaValueByCode(String systemParaCode);
	
	int updteSystemPara(String paraCode,String paraValue);

}
