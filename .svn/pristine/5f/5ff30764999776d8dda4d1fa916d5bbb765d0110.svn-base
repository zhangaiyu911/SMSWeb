/**
 * SysParaUtil.java
 * Copyright 2015 NKTY(Tianjin) High Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2015-11-11 13:38:01
 */
package com.nkty.sms.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 文本信息工具类.
 * <p><br>
 * @author 陈荣盛 2015-11-11 13:38:10
 * @version 1.0.0
 */
public class SysParaUtil {
	//公众号编号
	public static int Days = 30;

	static {
		System.out.println("初始化文本信息");
		//文本信息配置文件
		Properties properties = new Properties();
		InputStream is = null;
		try {
			is = SysParaUtil.class.getResourceAsStream("syspara.properties");
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			Days = Integer.parseInt(properties.getProperty("Days"));
		} catch (Exception e) {
			Days = 30;
		}
	}

	/**
	 * 无参数构造函数
	 */
	public SysParaUtil() {
	}
	
	public static String parseGBK(String sIn) {
		if (sIn == null || sIn.equals(""))
			return sIn;
		try {
			return new String(sIn.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException usex) {
			return sIn;
		}
	}
}

