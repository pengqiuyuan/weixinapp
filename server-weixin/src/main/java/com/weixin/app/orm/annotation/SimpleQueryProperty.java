package com.weixin.app.orm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 简单查询属性定义注释
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface SimpleQueryProperty {
	/**
	 * 持久化对象属性
	 * @return
	 */
	public String property();
	
	/**
	 * 值为空时是否在SQL中出现IsNull
	 * @return
	 */
	boolean absenceWhenNull() default true;
	
	/**
	 * 格式化对象类名
	 * @return
	 */
	String convertClass() default "";
	
	/**
	 * 操作名称 eq、lt、le、ge、gt、like
	 * @return
	 */
	OperatorType operator();
	
	/**
	 * 顺序（主要是索引的问题）
	 * @return
	 */
	int index()default -1;
	
	/**
	 * 包含关联查询，将之转换为createAlias
	 * @return
	 */
	String subMapping() default "";
	
}
