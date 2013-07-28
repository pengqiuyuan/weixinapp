package com.weixin.app.model.conditions;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.weixin.app.model.weixin.Movie;
import com.weixin.app.orm.SimpleQueryCondition;
import com.weixin.app.orm.annotation.OperatorType;
import com.weixin.app.orm.annotation.SimpleQueryProperty;
/**
 * 电影查询条件
 * @author pengqiuyuan
 *
 */
@SuppressWarnings("serial")
public class MovieCondtions extends SimpleQueryCondition{

	public MovieCondtions() {
		super(Movie.class);
	}
	
	/**
	 * 影片名称
	 */
	private String name;
	
	/*
	 * 地点
	 */
	private String address;
	
	
	/**
	 * 优惠描述
	 */
	private String discount;
	
	/**
	 * 优惠细则
	 */
	private String discountRules;
	
	/**
	 * 经度
	 */
	private BigDecimal longitude;
	/**
	 * 纬度
	 */
	private BigDecimal latitude;
	
	/**
	 * 评分
	 */
	private BigDecimal rating;
	
	/**
	 * 看点
	 */
	private String focus;
	
	/**
	 * 导演
	 */
	private String director;
	
	/**
	 * 演员
	 * 先用list来从名字
	 */
	private String actor;
	
	/**
	 * 缩略图<规格, 地址>
	 */
	private String thumbail;
	
	/**
	 * 缩略图，用于PC端展示
	 */
	private String largeThumbail;
	
	

	@SimpleQueryProperty(operator = OperatorType.LIKE, property = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@SimpleQueryProperty(operator = OperatorType.LIKE, property = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "discount")
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "discountRules")
	public String getDiscountRules() {
		return discountRules;
	}

	public void setDiscountRules(String discountRules) {
		this.discountRules = discountRules;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "longitude")
	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "latitude")
	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	@SimpleQueryProperty(operator = OperatorType.LIKE, property = "rating")
	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	@SimpleQueryProperty(operator = OperatorType.LIKE, property = "focus")
	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "director")
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "actor")
	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "thumbail")
	public String getThumbail() {
		return thumbail;
	}

	public void setThumbail(String thumbail) {
		this.thumbail = thumbail;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "largeThumbail")
	public String getLargeThumbail() {
		return largeThumbail;
	}

	public void setLargeThumbail(String largeThumbail) {
		this.largeThumbail = largeThumbail;
	}
	
	
}
