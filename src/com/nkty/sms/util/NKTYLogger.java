/**
 * NKTYLogger.java
 * Copyright 2010 NKTY(Tianjin) High Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2010-3-29 上午09:42:36
 */
package com.nkty.sms.util;

import org.apache.log4j.Logger;
/**
 * 日志包装类.
 * <p>定义log4j实现对日志的记录<br>
 * @author 奚志敏 2010-3-29 上午09:42:36
 * @version 1.0.0
 */

/**
 * 日志包装类.
 * <p>定义log4j实现对日志的记录<br>
 * @author 奚志敏 2010-3-29 上午09:42:36
 * @version 1.0.0
 */
public final class NKTYLogger {
	//定义log4j对象
	public static final Logger LOGGER = Logger.getLogger(NKTYLogger.class);

	/**
	 * 写本地日志.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 奚志敏 2010-8-3 下午03:18:43<br>
	 * @param logMsg	日志信息	
	 */
	public static void writeLocalLog(String logMsg) {
		NKTYLogger.LOGGER.info(logMsg);
	}

	/**
	 * 写日志.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 奚志敏 2010-8-3 下午03:33:18<br>
	 * @param logMsg	日志信息	
	 */
	public static void WriteLog(String logMsg) {
		//写本地日志
		writeLocalLog(logMsg);
	}
}

