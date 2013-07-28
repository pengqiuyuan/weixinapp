package com.weixin.app.util;

public enum DateQueryIndex {

	
	/**
	 * 所有日期
	 */
	Custom("6", "所有日期"),
	/**
	 * 当天
	 */
	Today("1", "当天"),
	/**
	 * 两天内
	 */
	LastTwoDay("2", "2天内"),
	/**
	 * 3天内
	 */
	LastThreeDay("3", "3天内"),
	/**
	 * 一周内
	 */
	LastOneWeek("4", "一周内"),
	/**
	 * 一月内
	 */
	LastOneMonth("5", "一月内");
	
	

	private String code;
	private String description;
	DateQueryIndex(String code, String description) { this.code = code; this.description = description; }
	DateQueryIndex(String code) { this.code = code; }
	public String getCode() { return code; }
	public String getDescription() { return description; }
	public String toString() { return description; }
}
