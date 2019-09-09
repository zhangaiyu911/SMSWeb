package com.nkty.sms.service.impl;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.nkty.sms.dao.BaseDao;
import com.nkty.sms.service.BaseService;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.QueryFilter;
import com.nkty.sms.util.QueryOrder;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
/**
 * Service基类
 * @author 奚志敏
 * @param <T> 实体
 * @param <ID> 主键
 */
@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
	
	/** 
	 * baseDao 
	 * */
	private BaseDao<T, ID> baseDao;
	
	/**
	 * 注入dao
	 * @param baseDao 
	 *             基础dao
	 */
	public void setBaseDao(BaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}
	
	/**
     * 查找实体对象
     * 
     * @param id
     *            ID
     * @return 实体对象，若不存在则返回null
     */
	@Transactional(readOnly = true)
	public T find(ID id) {
		return baseDao.find(id);
	}
	
	/**
     * 查找所有实体对象集合
     * 
     * @return 所有实体对象集合
     */
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return findList(null, null, null, null);
	}
	
	/**
     * 查找实体对象集合
     * 
     * @param ids
     *            ID
     * @return 实体对象集合
     */
	@Transactional(readOnly = true)
	public List<T> findList(ID... ids) {
		List<T> result = new ArrayList<T>();
		if (ids != null) {
			for (ID id : ids) {
				T entity = find(id);
				if (entity != null) {
					result.add(entity);
				}
			}
		}
		return result;
	}
	
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
	@Transactional(readOnly = true)
	public List<T> findList(Integer count, List<QueryFilter> filters, List<QueryOrder> orders) {
		return findList(null, count, filters, orders);
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
	@Transactional(readOnly = true)
	public List<T> findList(Integer first, Integer count, List<QueryFilter> filters, List<QueryOrder> orders) {
		return baseDao.findList(first, count, filters, orders);
	}
	
	/**
     * 查找实体对象分页
     * 
     * @param pageable
     *            分页信息
     * @return 实体对象分页
     */
	@Transactional(readOnly = true)
	public Page<T> findPage(Pageable pageable) {
		return baseDao.findPage(pageable);
	}
	
	/**
	 * 查找分页的实体对象(无主键或多主键).
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 奚志敏 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年9月16日 下午1:27:46<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param page
	 *            分页信息
	 * @return 实体对象分页
	 */
	@Transactional(readOnly = true)
	public Page<T> findNoPKPage(Pageable pageable) {
		return baseDao.findNoPKPage(pageable);
	}
	
	/**
     * 查询实体对象总数
     * 
     * @return 实体对象总数
     */
	@Transactional(readOnly = true)
	public long count() {
		return count(new QueryFilter[] {});
	}
	
	/**
     * 查询实体对象数量
     * 
     * @param filters
     *            筛选
     * @return 实体对象数量
     */
	@Transactional(readOnly = true)
	public long count(QueryFilter... filters) {
		return baseDao.count(filters);
	}
	
	/**
     * 判断实体对象是否存在
     * 
     * @param id
     *            ID
     * @return 实体对象是否存在
     */
	@Transactional(readOnly = true)
	public boolean exists(ID id) {
		return baseDao.find(id) != null;
	}
	
	/**
     * 判断实体对象是否存在
     * 
     * @param filters
     *            筛选
     * @return 实体对象是否存在
     */
	@Transactional(readOnly = true)
	public boolean exists(QueryFilter... filters) {
		return baseDao.count(filters) > 0;
	}
	
	/**
     * 保存实体对象
     * 
     * @param entity
     *            实体对象
     */
	@Transactional
	public void save(T entity) {
		baseDao.persist(entity);
	}
	
	/**
     * 更新实体对象
     * 
     * @param entity
     *            实体对象
     * @return 实体对象
     */
	@Transactional
	public T update(T entity) {
		return baseDao.merge(entity);
	}
	
	/**
     * 更新实体对象
     * 
     * @param entity
     *            实体对象
     * @param ignoreProperties
     *            忽略属性
     * @return 实体对象
     */
	@Transactional
	public T update(T entity, String... ignoreProperties) {
		Assert.notNull(entity);
		if (baseDao.isManaged(entity)) {
			throw new IllegalArgumentException("Entity must not be managed");
		}
		T persistant = baseDao.find(baseDao.getIdentifier(entity));
		if (persistant != null) {
			copyProperties(entity, persistant, (String[]) ArrayUtils.addAll(ignoreProperties,null));
			return update(persistant);
		} else {
			return update(entity);
		}
	}
	
	/**
     * 删除实体对象
     * 
     * @param id
     *            ID
     */
	@Transactional
	public void delete(ID id) {
		delete(baseDao.find(id));
	}
	
	/**
     * 删除实体对象
     * 
     * @param ids
     *            ID
     */
	@Transactional
	public void delete(ID... ids) {
		if (ids != null) {
			for (ID id : ids) {
				delete(baseDao.find(id));
			}
		}
	}
	
	/**
     * 删除实体对象
     * 
     * @param list 
     *             主键集
     */
	@Transactional
	public void delete(List<ID> list){
		if(list!=null&&list.size()>0){
			for(ID id:list){
				delete(baseDao.find(id));
			}
		}
	}
	
	/**
     * 删除实体对象
     * 
     * @param entity
     *            实体对象
     */
	@Transactional
	public void delete(T entity) {
		baseDao.remove(entity);
	}
	
	/**
	 * 复制对象属性
	 * 
	 * @param source
	 *               源对象
	 * @param target
	 *               目标对象
	 * @param ignoreProperties
	 *                        需忽略的属性
	 * @throws BeansException
	 *                         实体异常
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void copyProperties(Object source, Object target, String[] ignoreProperties) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(target.getClass());
		List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
				PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object sourceValue = readMethod.invoke(source);
						Object targetValue = readMethod.invoke(target);
						if (sourceValue != null && targetValue != null && targetValue instanceof Collection) {
							Collection collection = (Collection) targetValue;
							collection.clear();
							collection.addAll((Collection) sourceValue);
						} else {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, sourceValue);
						}
					} catch (Throwable ex) {
						throw new FatalBeanException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
	}
}