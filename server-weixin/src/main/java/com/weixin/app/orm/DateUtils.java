/*
 * File DateUtil.java
 * Created on 2004-6-25
 *
 */
package com.weixin.app.orm;

import java.util.Calendar;
import java.util.Date;

/**
 * @description 日期工具类
 * @author seabao
 * @project Jasine.WADK
 * @date 2004-6-25
 */
public class DateUtils {
	private static final int[] TIME_FIELD_LEVELS =
		{
			Calendar.YEAR,
			Calendar.MONTH,
			Calendar.DATE,
			Calendar.HOUR_OF_DAY,
			Calendar.MINUTE,
			Calendar.SECOND,
			Calendar.MILLISECOND };

	/**
	 * 对齐日期对象到指定精度
	 * @param date 日期对象
	 * @param field 要对齐的时间域，参考Calendar中field的定义
	 * @return 对齐后的日期
	 */
	public static Date roundDate(Date date, int field) {
		if (date == null) {
			return date;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());

		boolean clearFlag = false;
		for (int i = 0; i < TIME_FIELD_LEVELS.length; i++) {
			if (clearFlag) {
				cal.set(TIME_FIELD_LEVELS[i], cal.getMinimum(TIME_FIELD_LEVELS[i]));
			} else if (TIME_FIELD_LEVELS[i] == field) {
				clearFlag = true;
			}
		}

		return cal.getTime();
	}

	/**
	 * 调整日期对象
	 * @param date 日期对象
	 * @param field 时间域，参考Calendar中field的定义
	 * @param amount 调整数量
	 * @return 调整后的日期对象
	 */
	public static Date rollDate(Date date, int field, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(field, amount);
		return cal.getTime();
	}

	/**
	 * 获得日期对象的时间域值
	 * @param field 时间域，参考Calendar中field的定义
	 * @return 对应时间域的值
	 */
	public static int getDateField(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}

	/**
	 * 获得修改时间域值后的日期对象
	 * @param date 日期对象
	 * @param field 时间域，参考Calendar中field的定义
	 * @param value 时间域的值
	 * @return 修改后的日期对象
	 */
	public static Date setDateField(Date date, int field, int value) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(field, value);
		return cal.getTime();
	}

	public static boolean isToday ( java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(date);
		if (year == calendar.get(Calendar.YEAR)
			&& dayOfYear == calendar.get(Calendar.DAY_OF_YEAR)) 
			return true;
		else return false;
	}
	
	public static boolean isBoforeToday(java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(date);
		if (year > calendar.get(Calendar.YEAR)) return true;
		if (year < calendar.get(Calendar.YEAR)) return false;
		if (dayOfYear > calendar.get(Calendar.DAY_OF_YEAR)) return true;
		return false;		
	}
	
	public static boolean isAfterToday(java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(date);
		if (year < calendar.get(Calendar.YEAR)) return true;
		if (year > calendar.get(Calendar.YEAR)) return false;
		if (dayOfYear < calendar.get(Calendar.DAY_OF_YEAR)) return true;
		return false;		
	}
	
	/**
	 * 获得上一天的日期
	 */
	public static Date lastDay()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	public static void main(String[] args) {
		
        System.out.println(DateUtils.roundDate(new Date(),Calendar.DATE));
    }
	
}