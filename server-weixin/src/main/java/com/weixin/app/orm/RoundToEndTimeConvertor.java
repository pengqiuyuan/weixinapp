package com.weixin.app.orm;

import java.util.Calendar;
import java.util.Date;

/**
 * 对齐到截止时间的转换器类
 */
public class RoundToEndTimeConvertor implements ConditionPropertyConvertor {
    public Object convert(Object conditionProperty) {
        Date d = DateUtils.roundDate((java.util.Date) conditionProperty,
				Calendar.DATE);
		return DateUtils.rollDate(d, Calendar.DATE, 1);
    }

}
