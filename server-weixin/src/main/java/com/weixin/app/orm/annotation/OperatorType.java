package com.weixin.app.orm.annotation;

/**
 * 查询条件枚举{eq、lt、le、ge、gt、like}
 * @author AsOne
 *
 */
public enum OperatorType {
	/**
	 * 相等
	 */
	EQ,
	/**
	 * 小于
	 */
	LT,
	/**
	 * 小等
	 */
	LE,
	/**
	 * 大等
	 */
	GE,
	/**
	 * 大于
	 */
	GT,
	/**
	 * 在列表中
	 */
	IN,
	/**
	 * 相似
	 */
	LIKE,
	/**
	 * 为空
	 */
	NOTNULL,
	/**
	 * 不为空
	 */
	NULL
}
