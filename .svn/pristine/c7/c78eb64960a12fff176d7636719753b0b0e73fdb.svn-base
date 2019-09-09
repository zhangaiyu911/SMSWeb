/**
 * StringUtil.java
 * Copyright 2014 NKTY(Tianjin) High Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2014年10月14日 下午4:24:41
 */
package com.nkty.sms.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 字符串工具类.
 * <p><br>
 * @author 陈荣盛 2014年10月14日 下午4:24:41
 * @version 1.0.0
 */
public class StringUtil {
	/**
	 * 转换空串.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年10月14日 下午4:25:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年10月14日 下午4:25:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param src
	 * @return
	 */
	public static String convertNullStr(String src) {
		return null == src ? "" : src.trim();
	}
	
	/**
	 * 取得随机号.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月08日 下午8:44:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月08 下午8:44:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @return 随机号
	 */
	public static String getSheetNo(String str) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
			String sheetNo = sdf.format(new Date());

			return str + "-" + String.format("%07d", Integer.parseInt(sheetNo.substring(10)) * 100000 
					+ (int)(Math.random() * 2500) * Integer.parseInt(sheetNo.substring(8, 10)) 
					+ (int)(Math.random() * 1500) * Integer.parseInt(sheetNo.substring(10)) 
					+ (int)(Math.random() * 2000));
			
		} catch (Exception e) {
			return str + "-" + "0000001";
		}
	}
	
	/**
	 * 取得金额大写格式.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @return 金额大写格式
	 */
	public static String getMoney(int num) {
		try {
			String str = num + "";
			String result = "";
			
			int leng = str.length();
			for (int i = 0; i < leng; i++) {
				result += getNum(Integer.parseInt(str.substring(i, i + 1))) + getDigit(leng - i);
			}
			
			return result;
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 取得数字大写格式.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @return 金额大写格式
	 */
	public static String getNum(int num) {
		switch(num) {
		  case 1:
			  return "壹";
		  case 2:
			  return "贰";
		  case 3:
			  return "叁";
		  case 4:
			  return "肆";
		  case 5:
			  return "伍";
		  case 6:
			  return "陆";
		  case 7:
			  return "柒";
		  case 8:
			  return "捌";
		  case 9:
			  return "玖";
		  case 0:
			  return "零";
		  default:
			  return "零";
		}
	}
	
	/**
	 * 取得位数大写格式.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @return 金额大写格式
	 */
	public static String getDigit(int digit) {
		switch(digit) {
		  case 1:
			  return "分";
		  case 2:
			  return "角";
		  case 3:
			  return "元";
		  case 4:
			  return "拾";
		  case 5:
			  return "佰";
		  case 6:
			  return "仟";
		  case 7:
			  return "万";
		  case 8:
			  return "拾";
		  case 9:
			  return "佰";
		  case 10:
			  return "仟";
		  case 11:
			  return "亿";
		  case 12:
			  return "拾";
		  case 13:
			  return "佰";
		  case 14:
			  return "仟";
		  default:
			  
			  return "万";
		}
	}
	/**
	 * 取得有效数据.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2015年01月20日 下午8:44:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @return 金额大写格式
	 */
	public static String format(Double data,int scope){
		if (null == data) {
			return "";
		}
		//10的位数次方 如保留2位则 tempDouble=100
		double tempDouble=Math.pow(10, scope);
		//原始数据先乘tempDouble再转成整型，作用是去小数点
		double d = 0.1;
		for (int i = 0; i < scope + 2; i++) {
			d *= 0.1;
		}
		data=data*tempDouble + d;
//		int tempInt=(int)((double)data);
		int tempInt = (int)Math.round(data);
		//返回去小数之后再除tempDouble的结果
		return String.valueOf(tempInt/tempDouble);
	}
	/**
	 * 截取指定长度的字符串.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2015年02月27日 下午8:44:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2015年02月27日 下午8:44:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @return 指定长度的字符串
	 */
	public static String bSubstring(String s,int length) {
		//如果为null，返回“”
		if (null == s || length <= 0)
			return "";
		//获取长度
		byte[] bytes;
		try {
			bytes = s.getBytes("Unicode");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
		//如果字符串长度小于等于截取长度，返回原字符串
		if (bytes.length <= length)
			return s;
		//表示当前的字节数
		int n = 0; 
		//要截取的字节数，从第3个字节开始
		int i = 2; 
		for (; i < bytes.length && n < length; i++)         { 
			//奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节             
			if (i % 2 == 1) { 
		    	n++; // 在UCS2第二个字节时n加1             
			} else { 
		    	// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节 
		    	if (bytes[i] != 0) {                     
					n++;                 
				}             
			} 
		} 
		// 如果i为奇数时，处理成偶数         
		if (i % 2 == 1) { 
			// 该UCS2字符是汉字时，去掉这个截一半的汉字             
			if (bytes[i - 1] != 0)                 
				i = i - 1; 
		    // 该UCS2字符是字母或数字，则保留该字符             
			else                 
				i = i + 1;        
		}  
		try {
			return new String(bytes, 0, i, "Unicode");
		} catch (UnsupportedEncodingException e) {
			return "";
		}  
	}  
  
	/**
	 * 
	 * @param s
	 * @param charset
	 * @return
	 */
    public static String getHexString(String s, String charset) {  
        byte[] b = null;  
        StringBuffer sb = new StringBuffer();  
        try {  
            b = s.getBytes(charset);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        for (int i = 0; i < b.length; i++) {  
            sb.append(Integer.toHexString(b[i] & 0xFF));  
        }  
        return sb.toString();  
    }
    
    /**
	 * 将数字转换成指定位数的字符串，前面补0
	 * @param num     数字
	 * @param length  位数
	 * @return 转换结果
	 */
    public static String getNumString(int num, int length) {
    	String s = "";
    	for (int i = 0; i < length; i++) {
			s += "0";
		}
        DecimalFormat df=new DecimalFormat(s);
    
    	return df.format(num);
    }
}
