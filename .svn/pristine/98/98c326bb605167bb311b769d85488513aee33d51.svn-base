/**
 * BaseDao.java
 * Copyright 2014 NKTY(Tianjin)High Technology Development Ltd.
 * All rights reserved. 
 * Created on 2014-3-10 下午2:17:48
 */
package com.nkty.sms.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.LockModeType;

import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.QueryFilter;
import com.nkty.sms.util.QueryOrder;


/**
 * 
 * Dao接口基类
 * <p><br>
 * @author 陈荣盛
 * @param <T> 实体
 * @param <ID> 主键
 * @version 1.0.0, 2014-3-10
 */
public interface BaseDao<T, ID extends Serializable> {

	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id);

	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @param lockModeType
	 *            锁定方式
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id, LockModeType lockModeType);

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
	 * 查找实体对象分页
	 * 
	 * @param pageable
	 *            分页信息
	 * @return 实体对象分页
	 */
	Page<T> findPage(Pageable pageable);
	
	/**
	 * 查找分页的实体对象(无主键或多主键).
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param page
	 *            分页信息
	 * @return 实体对象分页
	 */
	Page<T> findNoPKPage(Pageable pageable);
	
	/**
	 * 查找实体对象集合
	 * 
	 * @param jpql
	 *        jpql查询语句
	 * @param map
	 *        查询条件
	 * @return 实体对象集合
	 */
	List<T> findList(String jpql,Map<String,Object> map);
	/**
     * 查找数据集合(非实体查询)
     * 
     * @param jpql
     *        jpql查询语句
     * @param map
     *        查询条件
     * @return 实体对象集合
     */
    List<Object[]> findObjectsList(String jpql,Map<String,Object> map);
    /**
     * 根据条件执行增删改操作
     * 
     * @param jpql
     *            jpql查询语句
     * @param map
     *                 查询条件
     * @return 执行数量
     */
    int execute(String jpql,Map<String,Object> map);

	/**
	 * 查询实体对象数量
	 * 
	 * @param filters
	 *            筛选
	 * @return 实体对象数量
	 */
	long count(QueryFilter... filters);
	
	/**
     * 查询实体对象数量
     * 
     * @param jpql
     *            jpql查询语句
     * @param map
     *                 查询条件
     * @return 实体对象数量
     */
	long count(String jpql, Map<String,Object> map);

	/**
	 * 持久化实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void persist(T entity);

	/**
	 * 合并实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	T merge(T entity);

	/**
	 * 移除实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void remove(T entity);

	/**
	 * 刷新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void refresh(T entity);

	/**
	 * 刷新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @param lockModeType
	 *            锁定方式
	 */
	void refresh(T entity, LockModeType lockModeType);

	/**
	 * 获取实体对象ID
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象ID
	 */
	ID getIdentifier(T entity);

	/**
	 * 判断是否为托管状态
	 * 
	 * @param entity
	 *            实体对象
	 * @return 是否为托管状态
	 */
	boolean isManaged(T entity);

	/**
	 * 设置为游离状态
	 * 
	 * @param entity
	 *            实体对象
	 */
	void detach(T entity);

	/**
	 * 锁定实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @param lockModeType
	 *            锁定方式
	 */
	void lock(T entity, LockModeType lockModeType);

	/**
	 * 清除缓存
	 */
	void clear();

	/**
	 * 同步数据
	 */
	void flush();
	/**
	 * 取得分页(SQL Server查询语句).
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月4日 下午1:49:07<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月4日 下午1:49:07<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param column		字段 ，以逗号分隔
	 * @param table			表名
	 * @param where			条件，不包括where关键字
	 * @param order			排序
	 * @param currentPage   当前页 
	 * @param pageSize 		每页几条 
	 * @return Page<T> 		分页包装对象
	 */
	Page<T> findNativeSQLPage(String column, String table, String where, String order, 
		int currentPage, int pageSize);
	/**
	 * 取得实体分页.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月4日 下午4:42:33<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月4日 下午4:42:33<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param where			条件，不包括where关键字
	 * @param order			排序
	 * @param currentPage   当前页 
	 * @param pageSize 		每页几条 
	 * @return Page<T> 		分页包装对象
	 */
	Page<T> findPage(String where, String order, int currentPage, int pageSize);
	
	/**
     * 查询求和
     * 
     * @param jpql
     *            jpql查询语句
     * @return 求和
     */
	BigDecimal sum(String jpql);
	
	/**
	 * 直接查询数据库
	 * 
	 * @param jpql查询语句
	 * @return 查询结果
	 */
	@SuppressWarnings("rawtypes")
	List findList(String jpql);
	
	/**
	 * 执行存储过程
	 * 
	 * @param jpql查询语句
	 * @return 查询结果
	 */
	int execProcedure(String jpql);
	
	/**
	 * 取得记录个数.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param table		表名
	 * @param where		条件，不包括where关键字
	 * @return 记录个数
	 */
	int getNativeRecordCount(String table, String where);
	/**
	 * 取得记录个数.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param entityName	实体名称
	 * @param where		条件，不包括where关键字
	 * @return 记录个数
	 */
	int getEntityRecordCount(String where);
	
	int max(String jpql);
}