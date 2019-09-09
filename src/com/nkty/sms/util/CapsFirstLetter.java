package com.nkty.sms.util;

import java.io.Serializable;

public class CapsFirstLetter implements Serializable{
	

	private static final long serialVersionUID = 1L;

	/**
	 * 将属性名第一个字母转换成大写（拼接getter方法）
	 * 
	 * @author 刘雪成 2016年10月12日17:38:59
	 * @param fildeName
	 * @return
	 * @throws Exception
	 */
	public static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

}
