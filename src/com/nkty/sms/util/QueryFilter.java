package com.nkty.sms.util;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
/**
 * 
 * Base Framework - 条件查询.筛选
 * <p><br>
 * @author 陈荣盛
 * @version 1.0.0, 2013-9-4
 */
public class QueryFilter implements Serializable {
    /**
     * 序列化唯一标识
     */
	private static final long serialVersionUID = -8712382358441065075L;
	/**
	 * 运算符
	 */
	public enum Operator {

		/** 等于 */
		eq,

		/** 不等于 */
		ne,

		/** 大于 */
		gt,

		/** 小于 */
		lt,

		/** 大于等于 */
		ge,

		/** 小于等于 */
		le,
		/** 在两者之间 */
		
		between,
		
		/** 在两者之间 */
		and,

		/** 相似 */
		like,

		/** 包含 */
		in,

		/** 为Null */
		isNull,

		/** 不为Null */
		isNotNull;

		/**
		 * 从String中获取Operator
		 * 
		 * @param value
		 *            值
		 * @return String对应的operator
		 */
		public static Operator fromString(String value) {
			return Operator.valueOf(value.toLowerCase());
		}
	}

	/** 默认是否忽略大小写 */
	private static final boolean DEFAULT_IGNORE_CASE = false;

	/** 属性 */
	private String property;

	/** 运算符 */
	private Operator operator;

	/** 值 */
	private Object value;

	/** 是否忽略大小写 */
	private Boolean ignoreCase = DEFAULT_IGNORE_CASE;

	/**
	 * 初始化一个新创建的Filter对象
	 */
	public QueryFilter() {
	}

	/**
	 * 初始化一个新创建的Filter对象
	 * 
	 * @param property
	 *            属性
	 * @param operator
	 *            运算符
	 * @param value
	 *            值
	 */
	public QueryFilter(String property, Operator operator, Object value) {
		this.property = property;
		this.operator = operator;
		this.value = value;
	}

	/**
	 * 初始化一个新创建的Filter对象
	 * 
	 * @param property
	 *            属性
	 * @param operator
	 *            运算符
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 */
	public QueryFilter(String property, Operator operator, Object value, boolean ignoreCase) {
		this.property = property;
		this.operator = operator;
		this.value = value;
		this.ignoreCase = ignoreCase;
	}

	/**
	 * 返回等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 等于筛选
	 */
	public static QueryFilter eq(String property, Object value) {
		return new QueryFilter(property, Operator.eq, value);
	}

	/**
	 * 返回等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 * @return 等于筛选
	 */
	public static QueryFilter eq(String property, Object value, boolean ignoreCase) {
		return new QueryFilter(property, Operator.eq, value, ignoreCase);
	}

	/**
	 * 返回不等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 不等于筛选
	 */
	public static QueryFilter ne(String property, Object value) {
		return new QueryFilter(property, Operator.ne, value);
	}

	/**
	 * 返回不等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 * @return 不等于筛选
	 */
	public static QueryFilter ne(String property, Object value, boolean ignoreCase) {
		return new QueryFilter(property, Operator.ne, value, ignoreCase);
	}

	/**
	 * 返回大于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 大于筛选
	 */
	public static QueryFilter gt(String property, Object value) {
		return new QueryFilter(property, Operator.gt, value);
	}

	/**
	 * 返回小于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 小于筛选
	 */
	public static QueryFilter lt(String property, Object value) {
		return new QueryFilter(property, Operator.lt, value);
	}

	/**
	 * 返回大于等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 大于等于筛选
	 */
	public static QueryFilter ge(String property, Object value) {
		return new QueryFilter(property, Operator.ge, value);
	}

	/**
	 * 返回小于等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 小于等于筛选
	 */
	public static QueryFilter le(String property, Object value) {
		return new QueryFilter(property, Operator.le, value);
	}

	/**
	 * 返回相似筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 相似筛选
	 */
	public static QueryFilter like(String property, Object value) {
		return new QueryFilter(property, Operator.like, value);
	}

	/**
	 * 返回包含筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 包含筛选
	 */
	public static QueryFilter in(String property, Object value) {
		return new QueryFilter(property, Operator.in, value);
	}

	/**
	 * 返回为Null筛选
	 * 
	 * @param property
	 *            属性
	 * @return 为Null筛选
	 */
	public static QueryFilter isNull(String property) {
		return new QueryFilter(property, Operator.isNull, null);
	}

	/**
	 * 返回不为Null筛选
	 * 
	 * @param property
	 *            属性
	 * @return 不为Null筛选
	 */
	public static QueryFilter isNotNull(String property) {
		return new QueryFilter(property, Operator.isNotNull, null);
	}
	
	/**
     * 返回不为Null筛选
     * 
     * @param property
     *            属性
     * @return 不为Null筛选
     */
	public static QueryFilter between(String property) {
	    return new QueryFilter(property, Operator.between, null);
	}
	
	/**
     * 返回不为Null筛选
     * 
     * @param property
     *            属性
     * @return 不为Null筛选
     */
	public static QueryFilter and(String property) {
	    return new QueryFilter(property, Operator.and, null);
	}

	/**
	 * 返回忽略大小写筛选
	 * 
	 * @return 忽略大小写筛选
	 */
	public QueryFilter ignoreCase() {
		this.ignoreCase = true;
		return this;
	}

	/**
	 * 获取属性
	 * 
	 * @return 属性
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * 设置属性
	 * 
	 * @param property
	 *            属性
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * 获取运算符
	 * 
	 * @return 运算符
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * 设置运算符
	 * 
	 * @param operator
	 *            运算符
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * 设置值
	 * 
	 * @param value
	 *            值
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * 获取是否忽略大小写
	 * 
	 * @return 是否忽略大小写
	 */
	public Boolean getIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * 设置是否忽略大小写
	 * 
	 * @param ignoreCase
	 *            是否忽略大小写
	 */
	public void setIgnoreCase(Boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}
	
	/**
     * 重写equals方法
     * @param obj Object
     * @return true or false
     */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		QueryFilter other = (QueryFilter) obj;
		return new EqualsBuilder().append(getProperty(), 
		        other.getProperty()).append(getOperator(),
		                other.getOperator()).append(getValue(), 
		                        other.getValue()).isEquals();
	}
	
	/**
	 * 生成哈希值
	 * @return 哈希值
	 */
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(getProperty()).append(getOperator())
		.append(getValue()).toHashCode();
	}
}