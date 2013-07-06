package com.weixin.app.orm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 升序标注
 * @author ShiZhenning
 * @since  2008-12-16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SimpleQueryOrderItemAsc {
	String propertyName();
}
