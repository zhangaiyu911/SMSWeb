/**
 * DateUtil.java
 * Copyright 2012 NKTY(Tianjin) High Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2012-6-13 下午03:32:02
 */
package com.nkty.sms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类.
 * <p><br>
 * @author 陈荣盛 2012-6-13 下午03:32:02
 * @version 1.0.0
 */
public class DateUtil {
	/**
	 * 取得间隔天数.
	 * <p>如果是开始和结束日期为同一天，间隔天数为0<br>
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-6-13 下午03:40:52<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-6-13 下午03:40:52<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param startDate		开始日期
	 * @param endDate		结束日期
	 * @return		天数
	 */
	public static int getDaysBetween(Date startDate, Date endDate) {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(startDate);
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(endDate);
		toCalendar.set(Calendar.HOUR_OF_DAY, 0);
		toCalendar.set(Calendar.MINUTE, 0);
		toCalendar.set(Calendar.SECOND, 0);
		toCalendar.set(Calendar.MILLISECOND, 0);

		return (int) (Math.abs(toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 将字符串转换成日期.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-6-13 下午09:08:38<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-6-13 下午09:08:38<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param date	日期字符串
	 * @return	日期
	 */
	public static Date convertStr2Date(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch(Exception e) {
			try {
				d = sdf.parse("1900-01-01");
			} catch (ParseException e1) {
			}
		}
		return d;
	}
	
	/**
	 * 取得数字的字符表示.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-7-1 下午10:04:53<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-7-1 下午10:04:53<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param number	数字
	 * @return	字符数字
	 */
	public static String getStringNumber(int number){
		if(number <=0 || number > 9) {
			return Integer.toString(number);
		}
		
		String[] nums = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
		
		return nums[number - 1];
	}
	
	/**
	 * 日期增加天数.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-9-1 下午09:45:05<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-9-1 下午09:45:05<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param date		日期
	 * @param day		天数
	 * @return	增加天数后的日期
	 */
	@SuppressWarnings("static-access")
	public static Date addDay(Date date, int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(calendar.DATE, day);

		return calendar.getTime();
	}
	
	/**
	 * 日期加秒数.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2015年1月9日 下午11:57:52<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2015年1月9日 下午11:57:52<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param date		日期
	 * @param second	秒
	 * @return	日期
	 */
	@SuppressWarnings("static-access")
	public static Date addSecond(Date date, int second){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(calendar.SECOND, second);

		return calendar.getTime();
	}
	
	/**
	 * 转换为日期.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年10月18日 下午5:13:31<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年10月18日 下午5:13:31<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param dateSrc	日期字符串
	 * @param fmt	转换格式
	 * @return 日期
	 */
	public static Date parseDate(String dateSrc, String fmt) {
		if(null == dateSrc || "".equals(dateSrc)) {
			return null;
		}
		
		if(null == fmt || "".equals(fmt)) {
			fmt = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			return sdf.parse(dateSrc);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 转换为日期.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年10月18日 下午5:13:31<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年10月18日 下午5:13:31<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param dateSrc	日期字符串
	 * @param fmt	转换格式
	 * @return 日期
	 */
	public static Date parseDate(String dateSrc) {
		return DateUtil.parseDate(dateSrc, null);
	}
	
	/**
	 * 取得日期的星期.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年10月24日 下午12:43:53<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年10月24日 下午12:43:53<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param date	日期
	 * @return 中文周名称
	 */
	public static String getWeekOfDate(Date date) {
//	    String[] weekDaysName = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
	    String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	    
	    return weekDaysName[intWeek];
	} 
	
	/**
	 * 取得当前日期是周几.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年12月24日 下午3:16:40<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年12月24日 下午3:16:40<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param date
	 * @return
	 */
	public static int getWeekDay(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    
	    return calendar.get(Calendar.DAY_OF_WEEK);
	} 
}
