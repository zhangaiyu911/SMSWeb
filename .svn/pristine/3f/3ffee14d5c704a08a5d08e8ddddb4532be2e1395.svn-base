/**
 * QueryFilterOrder.java
 * Copyright 2014 NKTY(Tianjin) High Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2014年9月20日 下午4:25:00
 */
package com.nkty.sms.util;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 查询条件、排序的工具类.
 * <p><br>
 * @author 陈荣盛 2014年9月20日 下午4:25:00
 * @version 1.0.0
 */
public class QueryFilterOrder {
	/**
	 * 根据查询字符串获得查询过滤条件对象列表.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年9月20日 下午4:29:04<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年9月20日 下午4:29:04<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param filterString 查询字符串，格式为"字段名,操作符(见QueryFilter.Operator),值"
	 * 					        多个时用分号隔开
	 * @return 过滤条件对象列表
	 */
	public static List<QueryFilter> getFilters(String filterString) {
		if(null == filterString || "".equals(filterString)) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer("{\"filterList\":[");
		//按分号，拆分成多组条件
		String[] gFilters = filterString.split(";");
		String filter = "";
		for(int i=0; i<gFilters.length; i++) {
			//取得一组条件
			filter = gFilters[i];
			//按逗号拆分成条件的各部分
			String[] f = filter.split(",");
			if(f.length < 2) {
				continue;
			}
			sb.append("{\"property\":\"");
			sb.append(f[0].trim());
			sb.append("\",\"operator\":\"");
			sb.append(f[1].trim());
			sb.append("\",\"value\":\"");
			if(2 == f.length) {
				sb.append("");
			} else {
				sb.append(f[2]);
			}
			sb.append("\"}");
			
			if(i < gFilters.length - 1) {
				sb.append(",");
			}
		}
		sb.append("]}");
		filterString = sb.toString();
		
		List<QueryFilter> filters = null;
		try{
			ObjectMapper objectMapper =new ObjectMapper();
			FilterList filterList = objectMapper.readValue(filterString, FilterList.class);
			filters = filterList.getFilterList();
		}catch(Exception e){
		}
		
		return filters;
	}
	
	/**
	 * 构建排序列表.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年9月20日 下午5:13:07<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年9月20日 下午5:13:07<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param propertys	字段字符串，格式为"字段1,字段2"
	 * @param directions 排序字符串，格式为"desc,asc"
	 * @return 排序列表
	 */
	public static List<QueryOrder> getOrders(String propertys, String directions) {
		if(null == propertys || "".equals(propertys) 
			|| null == directions || "".equals(directions)) {
			return null;
		}
		
		//拆分排序字段和顺序
		String[] prts = propertys.split(",");
		String[] dirs = directions.split(",");
		if(prts.length != dirs.length) {
			return null;
		}
		
		List<QueryOrder> orders = new ArrayList<QueryOrder>();
		QueryOrder order = null;
		for(int i=0; i<prts.length; i++) {
			order = new QueryOrder();
			order.setProperty(prts[i].trim());
			order.setDirection(QueryOrder.Direction.fromString(dirs[i].trim()));
			
			orders.add(order);
		}
		
		return orders;
	}
}
