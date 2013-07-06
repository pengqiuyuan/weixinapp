package com.weixin.app.orm;

/**
 * 属性格式化
 */
public interface ConditionPropertyConvertor {
	/**
	 * 转换查询条件属性
	 */
	public Object convert(Object conditionProperty);
}
