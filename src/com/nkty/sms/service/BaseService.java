/**
 * BaseService.java
 * Copyright 2014 NKTY(Tianjin)High Technology Development Ltd.
 * All rights reserved. 
 * Created on 2014-3-10 下午2:23:48
 */
package com.nkty.sms.service;

import java.io.Serializable;
import java.util.List;

import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.QueryFilter;
import com.nkty.sms.util.QueryOrder;

/**
 * Service基类
 * @author 奚志敏
 * @param <T> 实体
 * @param <ID> 主键
 */
public interface BaseService<T, ID extends Serializable> {
	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id);

	/**
	 * 查找所有实体对象集合
	 * 
	 * @return 所有实体对象集合
	 */
	List<T> findAll();

	/**
	 * 查找实体对象集合
	 * 
	 * @param ids
	 *            ID
	 * @return 实体对象集合
	 */
	List<T> findList(ID... ids);

	/**
	 * 查找实体对象集合
	 * 
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 实体对象集合
	 */
	List<T> findList(Integer count, List<QueryFilter> filters, List<QueryOrder> orders);

	/**
	 * 查找实体对象集合
	 * 
	 * @param first
	 *            起始记录
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 实体对象集合
	 */
	List<T> findList(Integer first, Integer count, List<QueryFilter> filters, List<QueryOrder> orders);

	/**
	 * 查找分页的实体对象.
	 * 
	 * @param page
	 *            分页信息
	 * @return 实体对象分页
	 */
	Page<T> findPage(Pageable pageable);
	
	/**
	 * 查找分页的实体对象(无主键或多主键).
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 奚志敏 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param page
	 *            分页信息
	 * @return 实体对象分页
	 */
	Page<T> findNoPKPage(Pageable pageable);

	/**
	 * 查询实体对象总数
	 * 
	 * @return 实体对象总数
	 */
	long count();

	/**
	 * 查询实体对象数量
	 * 
	 * @param filters
	 *            筛选
	 * @return 实体对象数量
	 */
	long count(QueryFilter... filters);

	/**
	 * 判断实体对象是否存在
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象是否存在
	 */
	boolean exists(ID id);

	/**
	 * 判断实体对象是否存在
	 * 
	 * @param filters
	 *            筛选
	 * @return 实体对象是否存在
	 */
	boolean exists(QueryFilter... filters);

	/**
	 * 保存实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void save(T entity);

	/**
	 * 更新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	T update(T entity);

	/**
	 * 更新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @param ignoreProperties
	 *            忽略属性
	 * @return 实体对象
	 */
	T update(T entity, String... ignoreProperties);

	/**
	 * 删除实体对象
	 * 
	 * @param id
	 *            ID
	 */
	void delete(ID id);

	/**
	 * 删除实体对象
	 * 
	 * @param ids
	 *            ID
	 */
	void delete(ID... ids);
	/**
	 * 删除实体对象
	 * 
	 * @param list 
	 *             主键集
	 */
	void delete(List<ID> list);

	/**
	 * 删除实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void delete(T entity);
}