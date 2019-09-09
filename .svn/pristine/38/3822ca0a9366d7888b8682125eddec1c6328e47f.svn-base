/**
 * BaseDaoImpl.java
 * Copyright 2014 NKTY(Tianjin)High Technology Development Ltd.
 * All rights reserved. 
 * Created on 2014-3-10 下午2:17:48
 */
package com.nkty.sms.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.nkty.sms.dao.BaseDao;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.QueryFilter;
import com.nkty.sms.util.QueryOrder;
import com.nkty.sms.util.QueryFilter.Operator;
import com.nkty.sms.util.QueryOrder.Direction;

/**
 * 
 * Dao接口实现基类 
 * <p><br>
 * @author 陈荣盛
 * @param <T> 实体
 * @param <ID> 主键
 * @version 1.0.0, 2014-3-10
 */
public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
	/** 
	 * 实体类类型 
	 * */
	private Class<T> entityClass;

	/** 
	 * 别名数
	 **/
	private static volatile long aliasCount = 0;
	
	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * 构造方法
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = (Class<T>) parameterizedType[0];
	}
	
	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象，若不存在则返回null
	 */
	public T find(ID id) {
		if (id != null) {
			return entityManager.find(entityClass, id);
		}
		return null;
	}
	
	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @param lockModeType
	 *            锁定方式
	 * @return 实体对象，若不存在则返回null
	 */
	public T find(ID id, LockModeType lockModeType) {
		if (id != null) {
			if (lockModeType != null) {
				return entityManager.find(entityClass, id, lockModeType);
			} else {
				return entityManager.find(entityClass, id);
			}
		}
		return null;
	}
	
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
	public List<T> findList(Integer first, Integer count, List<QueryFilter> filters, List<QueryOrder> orders) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return findList(criteriaQuery, first, count, filters, orders);
	}
	
	/**
     * 查找实体对象分页
     * 
     * @param pageable
     *            分页信息
     * @return 实体对象分页
     */
	public Page<T> findPage(Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return findPage(criteriaQuery, pageable);
	}
	
	/**
	 * 查找分页的实体对象(无主键或多主键).
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param page
	 *            分页信息
	 * @return 实体对象分页
	 */
	public Page<T> findNoPKPage(Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return findNoPKPage(criteriaQuery, pageable);
	}
	
	/**
     * 查询实体对象数量
     * 
     * @param filters
     *            筛选
     * @return 实体对象数量
     */
	public long count(QueryFilter... filters) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return count(criteriaQuery, filters != null ? Arrays.asList(filters) : null);
	}
	
	/**
     * 查询实体对象数量
     * 
     * @param jpql
     *            jpql查询语句
     * @param map
     *                 查询条件
     * @return 实体对象数量
     */
    public long count(String jpql, Map<String,Object> map) {
        Query query = this.entityManager.createQuery(jpql);
         
        if(map != null && map.size() > 0){
            Set<String> keySet = map.keySet();
            for(String key:keySet){
                query.setParameter(key, map.get(key));
            }
        }
        
        Object o = query.getSingleResult();
        return Long.parseLong(o.toString());
    }
    
	/**
     * 根据查找实体对象集合
     * 
     * @param jpql
     *            jpql查询语句
     * @param map
     *                 查询条件
     * @return 实体对象集合
     */
    @SuppressWarnings("unchecked")
    public List<T> findList(String jpql,Map<String,Object> map){
        Query query = this.entityManager.createQuery(jpql);
        if(map!=null&&map.size()>0){
            Set<String> keySet = map.keySet();
            for(String key:keySet){
                query.setParameter(key, map.get(key));
            }
        }
        return query.getResultList();
    }
    
    /**
     * 根据条件执行增删改操作
     * 
     * @param jpql
     *            jpql查询语句
     * @param map
     *                 查询条件
     * @return 执行数量
     */
    public int execute(String jpql,Map<String,Object> map){
        Query query = this.entityManager.createQuery(jpql);
        if(map!=null&&map.size()>0){
            Set<String> keySet = map.keySet();
            for(String key:keySet){
                query.setParameter(key, map.get(key));
            }
        }

        return query.executeUpdate();
    }
    
    /**
     * 根据查找实体对象集合
     * 
     * @param jpql
     *            jpql查询语句
     * @param map
     *                 查询条件
     * @return 实体对象集合
     */
    public List<Object[]> findObjectsList(String jpql,Map<String,Object> map){
        TypedQuery<Object[]> query = this.entityManager.createQuery(jpql,Object[].class);
        if(map!=null&&map.size()>0){
            Set<String> keySet = map.keySet();
            for(String key:keySet){
                query.setParameter(key, map.get(key));
            }
        }
        return query.getResultList();
    }
    
	/**
     * 持久化实体对象
     * 
     * @param entity
     *            实体对象
     */
	public void persist(T entity) {
		Assert.notNull(entity);
		entityManager.persist(entity);
	}
	
	/**
     * 合并实体对象
     * 
     * @param entity
     *            实体对象
     * @return 实体对象
     */
	public T merge(T entity) {
		Assert.notNull(entity);
		return entityManager.merge(entity);
	}
	
	/**
     * 移除实体对象
     * 
     * @param entity
     *            实体对象
     */
	public void remove(T entity) {
		if (entity != null) {
			entityManager.remove(entity);
		}
	}
	
	/**
     * 刷新实体对象
     * 
     * @param entity
     *            实体对象
     */
	public void refresh(T entity) {
		if (entity != null) {
			entityManager.refresh(entity);
		}
	}
	
	/**
     * 刷新实体对象
     * 
     * @param entity
     *            实体对象
     * @param lockModeType
     *            锁定方式
     */
	public void refresh(T entity, LockModeType lockModeType) {
		if (entity != null) {
			if (lockModeType != null) {
				entityManager.refresh(entity, lockModeType);
			} else {
				entityManager.refresh(entity);
			}
		}
	}
	
	/**
     * 获取实体对象ID
     * 
     * @param entity
     *            实体对象
     * @return 实体对象ID
     */
	@SuppressWarnings("unchecked")
	public ID getIdentifier(T entity) {
		Assert.notNull(entity);
		return (ID) entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
	}
	
	/**
     * 判断是否为托管状态
     * 
     * @param entity
     *            实体对象
     * @return 是否为托管状态
     */
	public boolean isManaged(T entity) {
		return entityManager.contains(entity);
	}
	
	/**
     * 设置为游离状态
     * 
     * @param entity
     *            实体对象
     */
	public void detach(T entity) {
		entityManager.detach(entity);
	}
	
	/**
     * 锁定实体对象
     * 
     * @param entity
     *            实体对象
     * @param lockModeType
     *            锁定方式
     */
	public void lock(T entity, LockModeType lockModeType) {
		if (entity != null && lockModeType != null) {
			entityManager.lock(entity, lockModeType);
		}
	}
	
	/**
     * 清除缓存
     */
	public void clear() {
		entityManager.clear();
	}
	
	/**
     * 同步数据
     */
	public void flush() {
		entityManager.flush();
	}
	
	/**
	 * 根据条件得到数据集合
	 * @param criteriaQuery  查询
	 * @param first 起始 
	 * @param count 记录数
	 * @param filters 过滤器
	 * @param orders 排序
	 * @return List<T> 数据集合
	 */
	protected List<T> findList(CriteriaQuery<T> criteriaQuery
	        , Integer first, Integer count, List<QueryFilter> filters, List<QueryOrder> orders) {
		Assert.notNull(criteriaQuery);
		Assert.notNull(criteriaQuery.getSelection());
		Assert.notEmpty(criteriaQuery.getRoots());
		addRestrictions(criteriaQuery, filters);
		addOrders(criteriaQuery, orders);
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT);
		if (first != null) {
			query.setFirstResult(first);
		}
		if (count != null) {
			query.setMaxResults(count);
		}
		return query.getResultList();
	}
	
	/**
	 * 分页查询
	 * @param criteriaQuery 查询
	 * @param pageable 分页参数
	 * @return Page<T> 分页包装对象
	 */
	protected Page<T> findPage(CriteriaQuery<T> criteriaQuery, Pageable pageable) {
		Assert.notNull(criteriaQuery);
		Assert.notNull(criteriaQuery.getSelection());
		Assert.notEmpty(criteriaQuery.getRoots());

		if (pageable == null) {
			pageable = new Pageable();
		}
		addRestrictions(criteriaQuery, pageable);
		addOrders(criteriaQuery, pageable);
		long records = count(criteriaQuery, null);
		int total = (int) (Math.ceil((double) records -1) / (double) pageable.getLimit())+1;
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT);
		query.setFirstResult((pageable.getPage() - 1) * pageable.getLimit());
		query.setMaxResults(pageable.getLimit());
		Page<T> page = new Page<T>();
		page.setRows(query.getResultList());
		page.setTotalCount(total);
		page.setPage(pageable.getPage());
		page.setTotal(records);
		pageable.setTotalCount(total);
		return page;
	}
	
	/**
	 * 分页查询
	 * @param criteriaQuery 查询
	 * @param pageable 分页参数
	 * @return Page<T> 分页包装对象
	 */
	protected Page<T> findNoPKPage(CriteriaQuery<T> criteriaQuery, Pageable pageable) {
		Assert.notNull(criteriaQuery);
		Assert.notNull(criteriaQuery.getSelection());
		Assert.notEmpty(criteriaQuery.getRoots());

		if (pageable == null) {
			pageable = new Pageable();
		}
		addRestrictions(criteriaQuery, pageable);
		addOrders(criteriaQuery, pageable);
		long records = count(criteriaQuery.getResultType(), pageable.getFilters());
		int total = (int) (Math.ceil((double) records -1) / (double) pageable.getLimit())+1;
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT);
		query.setFirstResult((pageable.getPage() - 1) * pageable.getLimit());
		query.setMaxResults(pageable.getLimit());
		Page<T> page = new Page<T>();
		page.setRows(query.getResultList());
		page.setTotalCount(total);
		page.setPage(pageable.getPage());
		page.setTotal(records);
		pageable.setTotalCount(total);
		return page;
	}
	
	/**
	 * 根据过滤条件取得记录个数.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年9月16日 下午9:04:18<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年9月16日 下午9:04:18<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param clazz	实体类的类
	 * @param filters	过滤条件列表 
	 * @return	记录个数
	 */
	protected Long count(Class<T> clazz, List<QueryFilter> filters) {
		//查询条件buffer
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from ");
        sb.append(clazz.getName());
        sb.append(" where 1=1");
        
        QueryFilter filter = null;
        Date dateValue = null;//开始时间
        //拼接过滤条件
        for (int i=0; i<filters.size(); i++) {
        	filter = filters.get(i);
			if (filter == null || StringUtils.isEmpty(filter.getProperty())) {
				continue;
			}
			
			if (filter.getOperator() == Operator.eq && filter.getValue() != null) {
				sb.append(filter.getProperty());
				sb.append("=");
				sb.append(filter.getValue().toString());
			} else if (filter.getOperator() == Operator.ne && filter.getValue() != null) {
				sb.append(filter.getProperty());
				sb.append("<>");
				sb.append(filter.getValue().toString());
			} else if (filter.getOperator() == Operator.gt && filter.getValue() != null) {
				sb.append(filter.getProperty());
				sb.append(">");
				sb.append(filter.getValue().toString());
			}else if (filter.getOperator() == Operator.lt && filter.getValue() != null) {
				sb.append(filter.getProperty());
				sb.append("<");
				sb.append(filter.getValue().toString());
			} else if (filter.getOperator() == Operator.ge && filter.getValue() != null) {
				sb.append(filter.getProperty());
				sb.append(">=");
				sb.append(filter.getValue().toString());
			} else if (filter.getOperator() == Operator.le && filter.getValue() != null) {
				sb.append(filter.getProperty());
				sb.append("<=");
				sb.append(filter.getValue().toString());
			} else if (filter.getOperator() == Operator.like && filter.getValue() != null && filter.getValue() instanceof String) {
				sb.append(filter.getProperty());
				sb.append(" like '%");
				sb.append(filter.getValue().toString());
				sb.append("%' ");
			} else if (filter.getOperator() == Operator.in && filter.getValue() != null) {
				sb.append(filter.getProperty());
				sb.append(" in (");
				sb.append(filter.getValue().toString());
				sb.append(") ");
			} else if (filter.getOperator() == Operator.isNull) {
				sb.append(" isnull(");
				sb.append(filter.getProperty());
				sb.append(") ");
			} else if (filter.getOperator() == Operator.isNotNull) {
				sb.append(" isnotnull(");
				sb.append(filter.getProperty());
				sb.append(") ");
			} else if (filter.getOperator() == Operator.between && filter.getValue() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    dateValue = sdf.parse(filter.getValue().toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else if (filter.getOperator() == Operator.and && filter.getValue() != null) {
            	if(" and ".equals(sb.substring(sb.length() - 5))) {	//最后有and，则删除它
            		sb.delete(sb.length() - 5, sb.length());
            	}
            	
                Date dateValue2 = null;//终止时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    dateValue2 = sdf.parse(filter.getValue().toString());
                    if(dateValue == null){
                        dateValue = sdf.parse("1971-01-01 00:00:01");
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e.getMessage());
                }
                
                sb.append(filter.getProperty());
				sb.append(" between (");
				sb.append(dateValue);
				sb.append(" and ");
				sb.append(dateValue2);
				sb.append(") ");
            } 
			
			if(i < filters.size() - 1) {
				sb.append(" and ");
			}
		}
        
        System.out.println(sb.toString());
        Query query = this.entityManager.createQuery(sb.toString());
        Object o = query.getSingleResult();
        
        return Long.parseLong(o.toString());
	}
	
	/**
	 * 根据过滤条件得到查询结果数
	 * @param criteriaQuery 查询
	 * @param filters 过滤条件集合
	 * @return 结果数
	 */
	protected Long count(CriteriaQuery<T> criteriaQuery, List<QueryFilter> filters) {
		Assert.notNull(criteriaQuery);
		Assert.notNull(criteriaQuery.getSelection());
		Assert.notEmpty(criteriaQuery.getRoots());

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		addRestrictions(criteriaQuery, filters);

		CriteriaQuery<Long> countCriteriaQuery = criteriaBuilder.createQuery(Long.class);
		for (Root<?> root : criteriaQuery.getRoots()) {
			Root<?> dest = countCriteriaQuery.from(root.getJavaType());
			dest.alias(getAlias(root));
			copyJoins(root, dest);
		}

		Root<?> countRoot = getRoot(countCriteriaQuery, criteriaQuery.getResultType());
		countCriteriaQuery.select(criteriaBuilder.count(countRoot));

		if (criteriaQuery.getGroupList() != null) {
			countCriteriaQuery.groupBy(criteriaQuery.getGroupList());
		}
		if (criteriaQuery.getGroupRestriction() != null) {
			countCriteriaQuery.having(criteriaQuery.getGroupRestriction());
		}
		if (criteriaQuery.getRestriction() != null) {
			countCriteriaQuery.where(criteriaQuery.getRestriction());
		}
		return entityManager.createQuery(countCriteriaQuery)
		        .setFlushMode(FlushModeType.COMMIT).getSingleResult();
	}

	/**
	 * 根据条件得到别名
	 * @param selection selection
	 * @return alias
	 */
	private synchronized String getAlias(Selection<?> selection) {
		if (selection != null) {
			String alias = selection.getAlias();
			if (alias == null) {
				if (aliasCount >= 1000) {
					aliasCount = 0;
				}
				alias = "portalGeneratedAlias" + aliasCount++;
				selection.alias(alias);
			}
			return alias;
		}
		return null;
	}
	
	/**
	 * 根据查询得到 Root<T>
	 * @param criteriaQuery 查询
	 * @return Root<T> 
	 */
	private Root<T> getRoot(CriteriaQuery<T> criteriaQuery) {
		if (criteriaQuery != null) {
			return getRoot(criteriaQuery, criteriaQuery.getResultType());
		}
		return null;
	}
	
	/**
	 * 根据查询、类得到与类相匹配的Root<T>
	 * @param criteriaQuery 查询
	 * @param clazz 类
	 * @return Root<T>
	 */
	private Root<T> getRoot(CriteriaQuery<?> criteriaQuery, Class<T> clazz) {
		if (criteriaQuery != null && criteriaQuery.getRoots() != null && clazz != null) {
			for (Root<?> root : criteriaQuery.getRoots()) {
				if (clazz.equals(root.getJavaType())) {
					return (Root<T>) root.as(clazz);
				}
			}
		}
		return null;
	}
	
	/**
	 * 复制 Joins
	 * @param from 源From
	 * @param to  目标From
	 */
	private void copyJoins(From<?, ?> from, From<?, ?> to) {
		for (Join<?, ?> join : from.getJoins()) {
			Join<?, ?> toJoin = to.join(join.getAttribute().getName(), join.getJoinType());
			toJoin.alias(getAlias(join));
			copyJoins(join, toJoin);
		}
		for (Fetch<?, ?> fetch : from.getFetches()) {
			Fetch<?, ?> toFetch = to.fetch(fetch.getAttribute().getName());
			copyFetches(fetch, toFetch);
		}
	}
	
	/**
	 * 复制 Fetch
	 * @param from 源From
	 * @param to 目标From
	 */
	private void copyFetches(Fetch<?, ?> from, Fetch<?, ?> to) {
		for (Fetch<?, ?> fetch : from.getFetches()) {
			Fetch<?, ?> toFetch = to.fetch(fetch.getAttribute().getName());
			copyFetches(fetch, toFetch);
		}
	}
	
	/**
	 * 根据过滤器增加查询条件
	 * @param criteriaQuery 查询
	 * @param filters 过滤器
	 */
	private void addRestrictions(CriteriaQuery<T> criteriaQuery, List<QueryFilter> filters) {
		if (criteriaQuery == null || filters == null || filters.isEmpty()) {
			return;
		}
		Root<T> root = getRoot(criteriaQuery);
		if (root == null) {
			return;
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		Predicate restrictions = criteriaQuery.getRestriction() != null ? criteriaQuery.getRestriction() : criteriaBuilder.conjunction();
		
		Date dateValue = null;//起始时间
		for (QueryFilter filter : filters) {
			if (filter == null || StringUtils.isEmpty(filter.getProperty())) {
				continue;
			}
			if (filter.getOperator() == Operator.eq && filter.getValue() != null) {
				if (filter.getIgnoreCase() != null && filter.getIgnoreCase() && filter.getValue() instanceof String) {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(criteriaBuilder.lower(root.<String> get(filter.getProperty())), ((String) filter.getValue()).toLowerCase()));
				} else {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get(filter.getProperty()), filter.getValue()));
				}
			} else if (filter.getOperator() == Operator.ne && filter.getValue() != null) {
				if (filter.getIgnoreCase() != null && filter.getIgnoreCase() && filter.getValue() instanceof String) {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(criteriaBuilder.lower(root.<String> get(filter.getProperty())), ((String) filter.getValue()).toLowerCase()));
				} else {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(root.get(filter.getProperty()), filter.getValue()));
				}
			} else if (filter.getOperator() == Operator.between && filter.getValue() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    dateValue = sdf.parse(filter.getValue().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }else if (filter.getOperator() == Operator.and && filter.getValue() != null) {
                Date dataValue2 = null;//终止时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    dataValue2 = sdf.parse(filter.getValue().toString());
                    if(dateValue == null){
                        dateValue = sdf.parse("1971-01-01 00:00:01");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
                restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.between(root.<Date> get(filter.getProperty()), dateValue, dataValue2));
            }else if (filter.getOperator() == Operator.gt && filter.getValue() != null) {
				restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.gt(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
			}else if (filter.getOperator() == Operator.lt && filter.getValue() != null) {
				restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.lt(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
			} else if (filter.getOperator() == Operator.ge && filter.getValue() != null) {
				restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.ge(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
			} else if (filter.getOperator() == Operator.le && filter.getValue() != null) {
				restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.le(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
			} else if (filter.getOperator() == Operator.like && filter.getValue() != null && filter.getValue() instanceof String) {
				restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(root.<String> get(filter.getProperty()), (String) filter.getValue()));
			} else if (filter.getOperator() == Operator.in && filter.getValue() != null) {
				restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).in(filter.getValue()));
			} else if (filter.getOperator() == Operator.isNull) {
				restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).isNull());
			} else if (filter.getOperator() == Operator.isNotNull) {
				restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).isNotNull());
			}
		}
		criteriaQuery.where(restrictions);
	}
	
    /**
     * 根据分页增加查询条件
     * @param criteriaQuery 
     *                  查询
     * @param pageable 
     *              分页
     */
	private void addRestrictions(CriteriaQuery<T> criteriaQuery, Pageable pageable) {
		if (criteriaQuery == null || pageable == null) {
			return;
		}
		Root<T> root = getRoot(criteriaQuery);
		if (root == null) {
			return;
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		Predicate restrictions = criteriaQuery.getRestriction() != null ? criteriaQuery.getRestriction() : criteriaBuilder.conjunction();
		if (StringUtils.isNotEmpty(pageable.getSearchProperty()) && StringUtils.isNotEmpty(pageable.getSearchValue())) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(root.<String> get(pageable.getSearchProperty()), "%" + pageable.getSearchValue() + "%"));
		}
		if (pageable.getFilters() != null) {
		    Date dateValue = null;//起始时间
			for (QueryFilter filter : (List<QueryFilter>)pageable.getFilters()) {
				if (filter == null || StringUtils.isEmpty(filter.getProperty())) {
					continue;
				}
				if (filter.getOperator() == Operator.eq && filter.getValue() != null) {
					if (filter.getIgnoreCase() != null && filter.getIgnoreCase() && filter.getValue() instanceof String) {
						restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(criteriaBuilder.lower(root.<String> get(filter.getProperty())), ((String) filter.getValue()).toLowerCase()));
					} else {
						restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get(filter.getProperty()), filter.getValue()));
					}
				} else if (filter.getOperator() == Operator.ne && filter.getValue() != null) {
					if (filter.getIgnoreCase() != null && filter.getIgnoreCase() && filter.getValue() instanceof String) {
						restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(criteriaBuilder.lower(root.<String> get(filter.getProperty())), ((String) filter.getValue()).toLowerCase()));
					} else {
						restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(root.get(filter.getProperty()), filter.getValue()));
					}
				}
				else if (filter.getOperator() == Operator.between && filter.getValue() != null) {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                try {
	                    dateValue = sdf.parse(filter.getValue().toString());
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                    throw new RuntimeException(e.getMessage());
	                }
	            }else if (filter.getOperator() == Operator.and && filter.getValue() != null) {
	                Date dataValue2 = null;//终止时间
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                try {
	                    dataValue2 = sdf.parse(filter.getValue().toString());
	                    if(dateValue == null){
	                        dateValue = sdf.parse("1971-01-01 00:00:01");
	                    }
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                    throw new RuntimeException(e.getMessage());
	                }
	                restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.between(root.<Date> get(filter.getProperty()), dateValue, dataValue2));
	            } 
				
				else if (filter.getOperator() == Operator.gt && filter.getValue() != null) {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.gt(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
				} else if (filter.getOperator() == Operator.lt && filter.getValue() != null) {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.lt(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
				} else if (filter.getOperator() == Operator.ge && filter.getValue() != null) {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.ge(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
				} else if (filter.getOperator() == Operator.le && filter.getValue() != null) {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.le(root.<Number> get(filter.getProperty()), (Number) filter.getValue()));
				} else if (filter.getOperator() == Operator.like && filter.getValue() != null && filter.getValue() instanceof String) {
					restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(root.<String> get(filter.getProperty()), (String) filter.getValue()));
				} else if (filter.getOperator() == Operator.in && filter.getValue() != null) {
					restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).in(filter.getValue()));
				} else if (filter.getOperator() == Operator.isNull) {
					restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).isNull());
				} else if (filter.getOperator() == Operator.isNotNull) {
					restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).isNotNull());
				}
			}
		}
		criteriaQuery.where(restrictions);
	}
	
	/**
	 * 根据List<Order>增加排序
	 * @param criteriaQuery 查询
	 * @param orders 排序对象
	 */
	private void addOrders(CriteriaQuery<T> criteriaQuery, List<QueryOrder> orders) {
		if (criteriaQuery == null || orders == null || orders.isEmpty()) {
			return;
		}
		Root<T> root = getRoot(criteriaQuery);
		if (root == null) {
			return;
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		List<javax.persistence.criteria.Order> orderList = new ArrayList<javax.persistence.criteria.Order>();
		if (!criteriaQuery.getOrderList().isEmpty()) {
			orderList.addAll(criteriaQuery.getOrderList());
		}
		for (QueryOrder order : orders) {
			if (order.getDirection() == Direction.asc) {
				orderList.add(criteriaBuilder.asc(root.get(order.getProperty())));
			} else if (order.getDirection() == Direction.desc) {
				orderList.add(criteriaBuilder.desc(root.get(order.getProperty())));
			}
		}
		criteriaQuery.orderBy(orderList);
	}
	
	/**
	 * 根据分页(pageable)增加排序
	 * @param criteriaQuery 查询
	 * @param pageable 分页
	 */
	private void addOrders(CriteriaQuery<T> criteriaQuery,Pageable pageable){
		if (criteriaQuery == null || pageable == null) {
			return;
		}
		Root<T> root = getRoot(criteriaQuery);
		if (root == null) {
			return;
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		List<javax.persistence.criteria.Order> orderList = new ArrayList<javax.persistence.criteria.Order>();
		if (!criteriaQuery.getOrderList().isEmpty()) {
			orderList.addAll(criteriaQuery.getOrderList());
		}
		if (StringUtils.isNotEmpty(pageable.getOrderProperty()) && pageable.getOrderDirection() != null) {
			if (pageable.getOrderDirection() == Direction.asc) {
				orderList.add(criteriaBuilder.asc(root.get(pageable.getOrderProperty())));
			} else if (pageable.getOrderDirection() == Direction.desc) {
				orderList.add(criteriaBuilder.desc(root.get(pageable.getOrderProperty())));
			}
		}
		if (pageable.getOrders() != null) {
			for (QueryOrder order : pageable.getOrders()) {
				if (order.getDirection() == Direction.asc) {
					orderList.add(criteriaBuilder.asc(root.get(order.getProperty())));
				} else if (order.getDirection() == Direction.desc) {
					orderList.add(criteriaBuilder.desc(root.get(order.getProperty())));
				}
			}
		}
		criteriaQuery.orderBy(orderList);
	}
	
	/**
	 * 取得记录个数.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param table		表名
	 * @param where		条件，不包括where关键字
	 * @return 记录个数
	 */
	public int getNativeRecordCount(String table, String where){
		int recordCount = 0;
		
		try {
			String strSQL = "select count(*) from " + table + " where (1=1) " + where;
			
			//取得记录个数
			Query query = this.entityManager.createNativeQuery(strSQL);
			Object o = query.getSingleResult();
			if(null != o) {
				try {
					recordCount = Integer.parseInt(o.toString());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			return recordCount;
		} catch (Exception e) {
			return 0;
		} 
	}
	
	/**
	 * 取得当前页.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2010-5-10 下午04:39:37<br>
	 * @param recordCount	记录个数
	 * @param currentPage	传入的当前页参数
	 * @param pageSize		一页显示个数
	 * @return	当前页码
	 */
	private int getCurrentPage(int recordCount, int currentPage, int pageSize){
		//计算总页数
		int totalPages = recordCount % pageSize > 0 ? (recordCount / pageSize) + 1 : recordCount / pageSize;
				
		//当前页大于总页数，则取为总页数
		currentPage = currentPage > totalPages ? totalPages : currentPage;

		if(currentPage <= 0) {
			currentPage = 1;
		}
		 
		return currentPage;
	}
	
	/**
	 * 根据条件从数据库中取得Bean列表对象.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2010-5-6 下午10:23:50<br>
	 * @param column		字段 ，以逗号分隔
	 * @param table			表名
	 * @param where			条件，不包括where关键字
	 * @param order			排序
	 * @param keyName		主键名称
	 * @param currentPage   当前页 
	 * @param pageSize 		每页几条 
	 * @return	Bean列表对象，没有返回null
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getNativeList(String column, String table, String where, String order, 
		int currentPage, int pageSize) {
		//取得查询字串
		String strSQL = "select " + column + " from " + table  
			+ " where (1=1) " + where 
			+ " " + order;

		List<T> resultList = null;
		//查询模块数据
		try {
			Query query = this.entityManager.createNativeQuery(strSQL);
			query.setFirstResult((currentPage - 1) * pageSize);
			query.setMaxResults(pageSize);
			resultList = (List<T>)query.getResultList();
			
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 取得SQL分页.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月4日 下午1:49:07<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月4日 下午1:49:07<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param column		字段 ，以逗号分隔
	 * @param table			表名
	 * @param where			条件，不包括where关键字
	 * @param order			排序
	 * @param keyName		主键名称
	 * @param currentPage   当前页 
	 * @param pageSize 		每页几条 
	 * @return Page<T> 		分页包装对象，rows中保存的是数据，需要自己转换成bean
	 */
	public Page<T> findNativeSQLPage(String column, String table, String where, String order, 
		int currentPage, int pageSize) {
		//根据条件取得总记录数
		int recordCount = this.getNativeRecordCount(table, where);
		
		//取得当前页
		currentPage = this.getCurrentPage(recordCount, currentPage, pageSize);
		
		//取得列表
		List<T> beanList = (List<T>) this.getNativeList(column, table, where, order, 
			currentPage, pageSize);
		
		Page<T> page = new Page<T>();
		page.setRows(beanList);
		page.setTotalCount(pageSize);
		page.setPage(currentPage);
		page.setTotal(recordCount);
		
		return page;
	}
	
	/**
	 * 取得记录个数.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年11月4日 下午1:33:48<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param entityName	实体名称
	 * @param where		条件，不包括where关键字
	 * @return 记录个数
	 */
	public int getEntityRecordCount(String where){
		int recordCount = 0;
		
		try {
			String strSQL = "select count(t) from " + entityClass.getName() 
				+ " t where (1=1) " + where;
			
			//取得记录个数
			Query query = this.entityManager.createQuery(strSQL);
			Object o = query.getSingleResult();
			if(null != o) {
				try {
					recordCount = Integer.parseInt(o.toString());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			return recordCount;
		} catch (Exception e) {
			return 0;
		} 
	}
	
	/**
	 * 根据条件从数据库中取得Bean列表对象.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2010-5-6 下午10:23:50<br>
	 * @param where			条件，不包括where关键字
	 * @param order			排序
	 * @param keyName		主键名称
	 * @param currentPage   当前页 
	 * @param pageSize 		每页几条 
	 * @return	Bean列表对象，没有返回null
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<T> getEntityList(String where, String order, int currentPage, int pageSize) {
		//取得查询字串
		String jpql = "select t from " + entityClass.getName()  
			+ " t where (1=1) " + where 
			+ " " + order;
		
		List<T> resultList = null;
		//查询模块数据
		try {
			TypedQuery query = this.entityManager.createQuery(jpql, entityClass);
			query.setFirstResult((currentPage - 1) * pageSize);
			query.setMaxResults(pageSize);
			resultList = (List<T>)query.getResultList();
			
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
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
	public Page<T> findPage(String where, String order, int currentPage, int pageSize) {
		//根据条件取得总记录数
		int recordCount = this.getEntityRecordCount(where);
		
		//取得当前页
		currentPage = this.getCurrentPage(recordCount, currentPage, pageSize);
		
		//取得列表
		List<T> beanList = (List<T>) this.getEntityList(where, order, currentPage, pageSize);
		
		Page<T> page = new Page<T>();
		page.setRows(beanList);
		page.setTotalCount(pageSize);
		page.setPage(currentPage);
		page.setTotal(recordCount);
		
		return page;
	}
	
	/**
     * 查询求和
     * 
     * @param jpql
     *            jpql查询语句
     * @return 求和
     */
	public BigDecimal sum(String jpql) {	
		BigDecimal sum = new BigDecimal(0);
		try {			
			//取得记录
			Query query = this.entityManager.createQuery(jpql);
			Object o = query.getSingleResult();
			if(null != o) {
				try {
					sum = new BigDecimal(o.toString());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			return sum;
		} catch (Exception e) {
			return new BigDecimal(0);
		} 
	}
	
	/**
	 * 直接查询数据库
	 * 
	 * @param jpql查询语句
	 * @return 查询结果
	 */
	@SuppressWarnings("rawtypes")
	public List findList(String jpql) {
		try {			
			//取得记录
			Query query = this.entityManager.createNativeQuery(jpql);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 执行存储过程 增删改
	 * 
	 * @param jpql查询语句
	 * @return 查询结果
	 */
	public int execProcedure(String jpql) {
		try {			
			//取得记录
			Query query = this.entityManager.createNativeQuery(jpql);
			query.executeUpdate();
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}
	
	public int max(String jpql){
		int max = 0;
		try{
			Query query = this.entityManager.createQuery(jpql);
			Object o = query.getSingleResult();
			if(null!=o){
				try{
					max = new Integer(o.toString());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return max;
		}catch(Exception e){
			e.printStackTrace();
			return max;
		}
	}
}