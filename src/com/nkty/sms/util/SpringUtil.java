package com.nkty.sms.util;

import java.util.Locale;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 
 * Spring 操作工具类 Base Framework
 * <p><br>
 * @author 陈荣盛
 * @version 1.0.0, 2014-10-4
 */
@Component("springUtils")
@Lazy(false)
public final class SpringUtil implements ApplicationContextAware, DisposableBean {

	/** 
	 * 上下文对象 
	 * */
	private static ApplicationContext applicationContext;

	/**
	 * 不可实例化
	 */
	private SpringUtil() {
	}
	/**
	 *  设置上下文.
	 *  @param applicationContext 上下文
	 *  @see org.springframework.context
	 *  .ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtil.applicationContext = applicationContext;
	}
	/**
	 *  销毁方法.
	 *  @throws Exception 异常
	 *  @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	public void destroy() throws Exception {
		applicationContext = null;
	}

	/**
	 * 获取上下文对象
	 * 
	 * @return 上下文对象
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取实例
	 * 
	 * @param name
	 *            Bean名称
	 * @return 实例
	 */
	public static Object getBean(String name) {
		Assert.hasText(name);
		return applicationContext.getBean(name);
	}

	/**
	 * 获取实例
	 * 
	 * @param name
	 *            Bean名称
	 * @param type
	 *            Bean类型
	 * @param <T> 实体
	 * @return 实例
	 */
	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);
		return applicationContext.getBean(name, type);
	}

	/**
	 * 获取国际化消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 国际化消息
	 */
	public static String getMessage(String code, Object... args) {
		LocaleResolver localeResolver = getBean("localeResolver", LocaleResolver.class);
		Locale locale = localeResolver.resolveLocale(null);
		return applicationContext.getMessage(code, args, locale);
	}

}