package com.weixin.app.orm;

import java.util.Calendar;

/**
 * 对齐到起始时间的转换器类
 */
public class RoundToStartTimeConvertor implements ConditionPropertyConvertor {
    public Object convert(Object conditionProperty) {
		return DateUtils.roundDate((java.util.Date) conditionProperty,
				Calendar.DATE);
	}

}
