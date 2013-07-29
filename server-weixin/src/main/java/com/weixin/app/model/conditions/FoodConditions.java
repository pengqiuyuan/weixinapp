package com.weixin.app.model.conditions;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.weixin.app.model.weixin.Food;
import com.weixin.app.orm.annotation.OperatorType;
import com.weixin.app.orm.SimpleQueryCondition;
import com.weixin.app.orm.annotation.SimpleQueryProperty;

/**
 * 美食查询条件
 * @author pengqiuyuan
 *
 */
@SuppressWarnings("serial")
public class FoodConditions extends SimpleQueryCondition{

	public FoodConditions() {
		super(Food.class);
	}

private Integer id;
	
	/**
	 * 商家名称
	 */
	private String name;
	
	/**
	 * 地点   华林店  五四店
	 * 先用list，一个商家 可能有连锁店 ，  用对象关联
	 */
	private String address;
	
	/**
	 * 推荐服饰
	 */
	private String foodRecommend;
	
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
	 * 缩略图
	 */
	private String thumbail;
	
	/**
	 * 缩略图，用于PC端展示
	 */
	private String largeThumbail;
	
	@SimpleQueryProperty(operator=OperatorType.EQ,property = "id")
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@SimpleQueryProperty(operator = OperatorType.LIKE, property = "name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "address")
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "dressRecommend")
	public String getFoodRecommend() {
		return foodRecommend;
	}


	public void setFoodRecommend(String foodRecommend) {
		this.foodRecommend = foodRecommend;
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

	@SimpleQueryProperty(operator=OperatorType.EQ,property = "rating")
	public BigDecimal getRating() {
		return rating;
	}


	public void setRating(BigDecimal rating) {
		this.rating = rating;
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
