package com.weixin.app.model.weixin;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.DateSerializer;

/**
 * 
 * @author pengqiuyuan
 * 服饰的实体类
 *
 */
@Entity
@javax.persistence.Table(name = "t_dresses")
public class Dress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 商家名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 地点   华林店  五四店
	 * 先用list，一个商家 可能有连锁店 ，  用对象关联
	 */
	@Column(name = "address")
	private String address;
	
	/**
	 * 推荐服饰
	 */
	@Column(name = "dress_recommend")
	private String dressRecommend;
	
	/**
	 * 活动开始时间
	 */
	@Column(name = "start_date")
	@JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	/**
	 * 活动结束时间
	 */
	@Column(name = "over_date")
	@JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	private Date overDate;
	
	/**
	 * 优惠描述
	 */
	@Column(name = "discount",length = 100)
	private String discount;
	
	/**
	 * 优惠细则
	 */
	@Column(name = "discount_rules")
	@Lob
	private String discountRules;
	
	/**
	 * 经度
	 */
	@Column(name = "longitude", precision = 15, scale = 10)
	private BigDecimal longitude;
	/**
	 * 纬度
	 */
	@Column(name = "latitude", precision = 15, scale = 10)
	private BigDecimal latitude;
	
	/**
	 * 评分
	 */
	@Column(name = "rating")
	private BigDecimal rating;
	
	
	/**
	 * 缩略图
	 */
	@Column(name = "thumbail")
	private String thumbail;
	
	/**
	 * 缩略图，用于PC端展示
	 */
	@Column(name = "large_thumbail")
	private String largeThumbail;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDressRecommend() {
		return dressRecommend;
	}


	public void setDressRecommend(String dressRecommend) {
		this.dressRecommend = dressRecommend;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getOverDate() {
		return overDate;
	}


	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}


	public String getDiscountRules() {
		return discountRules;
	}


	public void setDiscountRules(String discountRules) {
		this.discountRules = discountRules;
	}


	public BigDecimal getLongitude() {
		return longitude;
	}


	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}


	public BigDecimal getLatitude() {
		return latitude;
	}


	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}


	public BigDecimal getRating() {
		return rating;
	}


	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}


	public String getThumbail() {
		return thumbail;
	}


	public void setThumbail(String thumbail) {
		this.thumbail = thumbail;
	}


	public String getLargeThumbail() {
		return largeThumbail;
	}


	public void setLargeThumbail(String largeThumbail) {
		this.largeThumbail = largeThumbail;
	}
	
	
}
