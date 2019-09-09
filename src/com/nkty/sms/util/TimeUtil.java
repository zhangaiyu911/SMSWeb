package com.nkty.sms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	/*
	 * 以时间生成文件夹的名字
	 */
	public static String getDirByTime() {
		String dateDir = null;
		dateDir = new SimpleDateFormat("yyyyMMdd").format(new Date());
		return dateDir;
	}

	/*
	 * 以时间生成文件的前缀名
	 */
	public static String getFilePrefix() {
		String prefix = null;
		prefix = new SimpleDateFormat("HHmmssS").format(new Date());
		return prefix;
	}

	/*
	 * 当前系统时间
	 */
	public static String getTimeNow() {
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		return nowTime;

	}

	/**
	 * 根据月份,结账日期获取开始日期
	 * 根据月份值字符串获取开始日期 例如2016-10,25 ->2016-09-25
	 * 
	 * @author 刘雪成
	 * @param monthValue 月份 例如2016-10
	 * @param monthDealDay 日期 例如每月25日
	 * @return
	 */
	public static String getBeginTime(String monthValue, int monthDealDay) {
		// TODO Auto-generated method stub
		int year = Integer.parseInt(monthValue.substring(0, 4));
		int month = Integer.parseInt(monthValue.substring(5, 7));
		String beginTime = "";
		// endTime='2016-10-25 23:59:59' beginTime='2016-09-26
		// 00:00:00:'/2016-09-25 23:59:59
		// endTime=monthValue+"-"+monthDealDay+" 23:59:59";
		if (month == 1) {
			year = year - 1;
			beginTime = year + "-12-" + monthDealDay + " 23:59:59";
		} else if (month > 1 && month < 11) {
			month = month - 1;
			beginTime = year + "-0" + month + "-" + monthDealDay + " 23:59:59";
		} else {
			month = month - 1;
			beginTime = year + "-" + month + "-" + monthDealDay + " 23:59:59";
		}
		return beginTime;
	}
	/**
	 * 
	 * @author 刘雪成
	 * @param monthValue 月份
	 * @param monthDealDay 截止日期
	 * @return 数组(开始时间,截止时间)
	 */
	public static String[] getTimes(String monthValue,int monthDealDay){
		String []times=new String[2];
		String beginTime="";
		String endTime="";
		int year = Integer.parseInt(monthValue.substring(0,4));
		int month = Integer.parseInt(monthValue.substring(5,7));
		if(monthDealDay==0){//按自然月计算
			Calendar time = Calendar.getInstance();
			time.set(Calendar.YEAR,year);
			time.set(Calendar.MONTH, month-1);
			
			beginTime = monthValue+"-01";
			endTime = monthValue+"-"+time.getActualMaximum(Calendar.DAY_OF_MONTH)+" 23:59:59";
		}else if(monthDealDay<10){
			endTime = monthValue+"-0"+monthDealDay+" 23:59:59";
			if(month==1&&monthDealDay<9){
				beginTime = (year-1)+"-12-0"+(monthDealDay+1);
			}else if(month==1&&monthDealDay==9){
				beginTime = (year-1)+"-12-"+(monthDealDay+1);
			}else if(month<11&&monthDealDay<9){
				beginTime = year+"-0"+(month-1)+"-0"+(monthDealDay+1);
			}else if(month<11&&monthDealDay==9){
				beginTime = year+"-0"+(month-1)+"-"+(monthDealDay+1);
			}else if(month>10&&monthDealDay<9){
				beginTime = year+"-"+(month-1)+"-0"+(monthDealDay+1);
			}else if(month>10&&monthDealDay==9){
				beginTime = year+"-"+(month-1)+"-"+(monthDealDay+1);
			}
		}else{
			endTime = monthValue+"-"+monthDealDay+" 23:59:59"; 
			//开始日期
			if(month==1){
				beginTime = (year-1)+"-12-"+(monthDealDay+1);
			}else if(month<11){
				beginTime = year+"-0"+(month-1)+"-"+(monthDealDay+1);
			}else{
				beginTime = year+"-"+(month-1)+"-"+(monthDealDay+1);
			}
		}
		times[0]=beginTime;
		times[1]=endTime;
		
		return times;
	}
	
	public static String getLastMonthValue(String monthValue){
		String lastMonthValue="";
		int year = Integer.parseInt(monthValue.substring(0,4));
		int month = Integer.parseInt(monthValue.substring(5,7));
		if(month==1){
			lastMonthValue=(year-1)+"-12";
		}else if(month<11){
			lastMonthValue = year+"-0"+(month-1);
		}else{
			lastMonthValue = year+"-"+(month-1);
		}
		
		return lastMonthValue;
	}
}
