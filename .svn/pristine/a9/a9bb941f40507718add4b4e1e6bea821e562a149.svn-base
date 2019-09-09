/**
 * Log4j.java
 * Copyright 2015 NKTY(Tianjin) High Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2015年11月5日 下午2:21:09
 */
package com.nkty.sms.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * .
 * <p><br>
 * @author 陈荣盛 2015年11月5日 下午2:21:09
 * @version 1.0.0
 */
public class Log4j {
	
	private static Log infologger = LogFactory.getLog("info"); 
	private static Log debuglogger = LogFactory.getLog("debug");
	private static Log warnlogger = LogFactory.getLog("warn");
	private static Log errorlogger = LogFactory.getLog("error"); 
	
	/**
	 * 写日志
	 * .
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2015年11月5日 下午2:22:27<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2015年11月5日 下午2:22:27<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param type	1：info 2:debug 3:warn 4:error
	 * @param logs  日志内容
	 */
	public static void writeLog(int type, String logs) {
		if (null == logs)
			return;
		switch (type) {
			case 1:
				infologger.info(logs);
				break;
			case 2:
				debuglogger.debug(logs);
				break;
			case 3:
				warnlogger.warn(logs);
				break;
			case 4:
				errorlogger.error(logs);
				break;
			default:
				infologger.info(logs);
				break;
		}
	}

	/**
	 * 写日志.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 奚志敏 2010-8-3 下午03:33:18<br>
	 * @param logMsg	日志信息	
	 */
	public static void writeLog(String logMsg) {
		//写本地日志
		infologger.info(logMsg);
	}
}
