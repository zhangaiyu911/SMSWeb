package com.nkty.sms.util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nkty.sms.util.QueryOrder.Direction;
/**
 * 
 * Base Framework - 前端分页数据封装类.
 * <p><br>
 * @author 陈荣盛
 * @version 1.0.0, 2013-9-4
 */
public class Pageable implements Serializable {
    /**
     * 日志类
     */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 序列化标识
	 */
	private static final long serialVersionUID = 5192357666324600054L;
	/**
	 * 排序 - 升
	 */
	public static final String ASC = "asc";
	
	/**
	 * 排序 - 降
	 */
	public static final String DESC = "desc";
	/**
	 * 当前页面 - 默认为1
	 */
	protected int page = 1;
	/**
	 * 每页记录数 - 默认为15
	 */
	protected int limit = 25;
	/**
	 * 自动计算
	 */
	protected boolean autoCount = true;
	/**
	 * 起始记录标识
	 */
	protected int start = 0;
	/**
	 * 记录总数
	 */
	protected long totalCount = -1L;
	/**
	 * 查询条件
	 */
	protected String filterString = null;
	/** 
	 * 排序方向 
	 * */
	private Direction orderDirection;
	/** 
	 * 搜索属性 
	 * */
	private String searchProperty;

	/** 
	 * 搜索值
	 * */
	private String searchValue;

	/** 
	 * 排序属性
	 * */
	private String orderProperty;

	/** 
	 * 筛选
	 * */
	private List<QueryFilter> filters = new ArrayList<QueryFilter>();

	/** 
	 * 排序
	 *  */
	private List<QueryOrder> orders = new ArrayList<QueryOrder>();
	
	/**
	 * 构造方法
	 */
	public Pageable() {
	}
	
	/**
	 * 构造方法
	 * @param paramInt 
	 */
	public Pageable(int paramInt) {
		this.limit = paramInt;
	}

	public Pageable(int paramInt1, int paramInt2) {
		this.page = paramInt1;
		this.limit = paramInt2;
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;

		if (page < 1)
			this.page = 1;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	
		if (limit < 1)
			this.limit = 1;
	}
	
	public int getFirst() {
		if (this.start != 0)
			return this.start + 1;
		return (this.page - 1) * this.limit + 1;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getOrderFields() {
		return this.orderProperty;
	}

	public void setOrderFields(String orderFields) {
	    this.orderProperty = orderFields;
	}

	public Pageable orderFields(String theOrderFields) {
	    setOrderFields(theOrderFields);
		return this;
	}

	public String getOrder() {
		return this.orderDirection.toString();
	}

	public void setOrder(String order) {
	    String[] arrayOfString = StringUtils.split(
				StringUtils.lowerCase(order), ',');

		for (int i = 0; i < arrayOfString.length; i++) {
			String str = arrayOfString[i];
			if ((StringUtils.equals(DESC, str)) || (StringUtils.equals(ASC, str))){
				continue;
			}
			throw new IllegalArgumentException("排序方向" + str + "不是合法值");
		}
		if(ASC.equals(StringUtils.lowerCase(order))){
			this.orderDirection = QueryOrder.Direction.fromString(ASC);
		}
		if(DESC.equals(StringUtils.lowerCase(order))){
			this.orderDirection = QueryOrder.Direction.fromString(DESC);
		}
		
	}

	public Pageable order(String theOrder) {
	    setOrder(theOrder);
		return this;
	}

	public boolean isOrderFieldsSetted() {
		return (StringUtils.isNotBlank(this.orderProperty))
				&& (StringUtils.isNotBlank(this.orderDirection.toString()));
	}

	public boolean isAutoCount() {
		return this.autoCount;
	}

	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}

	public Pageable autoCount(boolean theAutoCount) {
		setAutoCount(theAutoCount);
		return this;
	}
	
	public long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPages() {
		if (this.totalCount < 0L) {
			return -1L;
		}

		long l = this.totalCount / this.limit;
		if (this.totalCount % this.limit > 0L) {
			l += 1L;
		}
		return l;
	}

	public boolean isHasNext() {
		return this.page + 1 <= getTotalPages();
	}

	public int getNextPage() {
		if (isHasNext()) {
			return this.page + 1;
		}
		return this.page;
	}
	
	public boolean isHasPre() {
		return this.page - 1 >= 1;
	}
	
	public int getPrePage() {
		if (isHasPre()) {
			return this.page - 1;
		}
		return this.page;
	}

	public int getStart() {
		return this.start;
	}

	public static String getPageCacheKey(String key) {
		String str = "";
		if (key.startsWith("/")) {
			str = key.substring(1, key.length());
		}

		if (str.indexOf("/") != -1) {
			str = str.substring(0, str.indexOf("/"));
		}

		return str;
	}
	
	/**
	 * 获取搜索属性
	 * 
	 * @return 搜索属性
	 */
	public String getSearchProperty() {
		return searchProperty;
	}

	/**
	 * 设置搜索属性
	 * 
	 * @param searchProperty
	 *            搜索属性
	 */
	public void setSearchProperty(String searchProperty) {
		this.searchProperty = searchProperty;
	}

	/**
	 * 获取搜索值
	 * 
	 * @return 搜索值
	 */
	public String getSearchValue() {
		return searchValue;
	}

	/**
	 * 设置搜索值
	 * 
	 * @param searchValue
	 *            搜索值
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	/**
	 * 获取排序属性
	 * 
	 * @return 排序属性
	 */
	public String getOrderProperty() {
		return orderProperty;
	}

	/**
	 * 设置排序属性
	 * 
	 * @param orderProperty
	 *            排序属性
	 */
	public void setOrderProperty(String orderProperty) {
	    if(this.orderProperty==null||"".equals(this.orderProperty)){
	        this.orderProperty = orderProperty;
	    }
	}
	/**
	 * 获取排序方向
	 * 
	 * @return 排序方向
	 */
	public Direction getOrderDirection() {
		return orderDirection;
	}

	/**
	 * 设置排序方向
	 * 
	 * @param orderDirection
	 *            排序方向
	 */
	public void setOrderDirection(Direction orderDirection) {
	    if(this.orderDirection==null||"".equals(this.orderDirection)){
	        this.orderDirection = orderDirection;
	    }
	}
	/**
	 * 获取筛选
	 * 
	 * @return 筛选
	 */
	public List<QueryFilter> getFilters() {
		return filters;
	}

	/**
	 * 设置筛选
	 * 
	 * @param filters
	 *            筛选
	 */
	public void setFilters(List<QueryFilter> filters) {
		this.filters = filters;
	}

	/**
	 * 获取排序
	 * 
	 * @return 排序
	 */
	public List<QueryOrder> getOrders() {
		return orders;
	}

	/**
	 * 设置排序
	 * 
	 * @param orders
	 *            排序
	 */
	public void setOrders(List<QueryOrder> orders) {
		this.orders = orders;
	}
	
	public String getFilterString() {
		return filterString;
	}

	public void setFilterString(String filterString) {
		try{
			ObjectMapper objectMapper =new ObjectMapper();
			FilterList filterList = objectMapper.readValue(filterString, FilterList.class);
			this.setFilters(filterList.getFilterList());
		}catch(Exception e){
			
		}
		this.filterString = filterString;
	}
}