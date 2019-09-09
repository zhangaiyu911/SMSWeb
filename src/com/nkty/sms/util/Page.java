package com.nkty.sms.util;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * Base Framework - 后台分页封装类.
 * <p><br>
 * @author 陈荣盛
 * @param <T> 实体
 * @version 1.0.0, 2013-9-4
 */
public class Page<T> implements Serializable {
	/**
	 * 序列化标识
	 */
	private static final long serialVersionUID = -1258609270248897643L;
	/**
	 * 当前页页数
	 */
	private int page ;
	/**
	 * 当前页记录数
	 */
	private int totalCount;
	/**
	 * 记录总数
	 */
	private long total;
	/**
	 * 分页实体集合
	 */
	private List<T> rows;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}	
}
