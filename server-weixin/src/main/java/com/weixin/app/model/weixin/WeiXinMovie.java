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
 * @author pengqiuyuanfj@gmail.com
 * 电影的实体类
 *
 */
@Entity
@javax.persistence.Table(name = "t_movies")
public class WeiXinMovie implements Serializable{

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
	 * 影片名称
	 */
	@Column(name = "name")
	private String name;
	
	/*
	 * 地点
	 */
	@Column(name = "address")
	private String address;
	
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
	 * 看点
	 */
	@Column(name = "focus" ,length = 200)
	private String focus;
	
	/**
	 * 导演
	 */
	@Column(name = "director")
	private String director;
	
	/**
	 * 演员
	 * 先用list来从名字
	 */
	@Column(name = "actor" , length = 100)
	private String actor;
	
	/**
	 * 缩略图<规格, 地址>
	 */
	@Column(name = "thumbail")
	private String thumbail;
	
	/**
	 * 上映日期，区分国内外上映时间
	 */
	@Column(name = "pub_date")
	@JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	private Date pubDate;
	
	/**
	 * 语言,FIXED:这里不作数据字典转换.
	 */
	@Column(name = "language")
	private String language;
	
	/**
	 * 国家/地区
	 */
	@Column(name = "country")
	private String country;
	
	/**
	 * 时长
	 */
	@Column(name = "duration")
	private String duration;
	
	/**
	 * 影片类型
	 */
	@Column(name = "type")
	private String type;
	

	/**
	 * 影片简介
	 */
	@Column(name = "summary")
	@Lob
	private String summary;

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

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getThumbail() {
		return thumbail;
	}

	public void setThumbail(String thumbail) {
		this.thumbail = thumbail;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getOverDate() {
		return overDate;
	}

	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}
	
}
